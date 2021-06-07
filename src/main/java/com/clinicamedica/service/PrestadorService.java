package com.clinicamedica.service;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.clinicamedica.repository.prestadoresRepository;
import com.clinicamedica.security.UusuarioSecurity;
import com.clinicamedica.controller.MedicoController;
import com.clinicamedica.dto.LoginDTO;
import com.clinicamedica.dto.PrestadorAcessoDTO;
import com.clinicamedica.dto.PrestadorDTO;
import com.clinicamedica.dto.PrestadorLoginDTO;
import com.clinicamedica.entity.PrestadorAcessoPerfil;
import com.clinicamedica.entity.perfil_acesso;
import com.clinicamedica.exception.AuthorizationException;
import com.clinicamedica.exception.ServiceBaseException;
import com.clinicamedica.file.ImageService;
import com.clinicamedica.file.S3Service;

@Service
public class PrestadorService {


	@Autowired
	private prestadoresRepository proxyPrestador;
	
	@Autowired
	private PerfilAcessoService proxyPerfilAcesso;
	
	@Autowired
	private LoginService proxyLogin;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private S3Service s3Service;
	
	@Autowired
	private ImageService imageService;
	
	@Value("${img.prefix.client.profile}")
	private String prefix;
	
	@Value("${img.profile.size}")
	private int size;
	
	@Autowired
	private BCryptPasswordEncoder criptografia;
	
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(MedicoController.class);
	
	
	public List<PrestadorDTO> buscaPrestadoresService() {
		log.info("Class PrestadorService chamando buscaPrestadoresService");
		return proxyPrestador.findAll();
	}

	public PrestadorDTO buscarPorIDService(int id) {
		
		UusuarioSecurity user = UserService.authenticated();
		if(user == null || !user.hasRole("ADMIN"))
			throw new AuthorizationException("Acesso negado, sem permissão");
		
				
		log.info("Class PrestadorService chamando buscarPorIDService");
		PrestadorDTO dto = proxyPrestador.findById(id);
		return dto;
	}

	public int alterarPrestadorService(PrestadorDTO obj) {
		log.info("Class PrestadorService chamando alterarPrestadorService");
		if (!proxyPrestador.existsById(obj.getIdprestador())) {
			proxyPrestador.save(obj);
			return 1;
		} else
			return 0;
	}

	public int InserirPrestadorService(PrestadorDTO obj) {
		try {
			log.info("Class PrestadorService chamando InserirPrestadorService");
			PrestadorLoginDTO dto = new PrestadorLoginDTO();
			LoginDTO lg = new LoginDTO(obj.getLogin());
			String senha = criptografia.encode(obj.getLogin().getSenha());
			lg.setSenha(senha);
			LoginDTO lgn = proxyLogin.inserirLogin(lg);
			dto = prestadorLoginMapperOne(obj);
			dto.setIdlogin(lgn.getIdlogin());
			proxyPrestador.save(dto);
			return 1;
		} catch (Exception e) {
          throw new ServiceBaseException("Erro no insert Prestador", e);
		}
	}

	public void deletePrestadorService(PrestadorDTO obj) {
		log.info("Class PrestadorService chamando deletePrestadorService");
		proxyPrestador.delete(obj);
	}  
	
	public void DesativarPrestadorService(String flag, int id) {
		try {

			log.info("Class PrestadorService chamando DesativaPrestadorService");
			proxyPrestador.DesativarPrestador(flag, id);
		} catch (Exception e) {
			log.info("Class PrestadorServiceException : \n "+e.getMessage() );
			throw new ServiceBaseException("Erro DesativarPrestador", e);
		}
	}
	 
	/*
	 * public void InserirPrestadorJPA(PrestadorDTO prest) {
	 * log.info("Class PrestadorService chamando InserirPrestadorJPA"); //:idlogin,
	 * :nome_comp, :cpf,
	 * :data_nasc,:data_admissao,:sexo,:idsetor,:telefone,:idestado int idlogin;
	 * LoginDTO lg = new LoginDTO(prest.getLogin()); String senha =
	 * criptografia.encode(prest.getLogin().getSenha()); lg.setSenha(senha);
	 * LoginDTO lgn = proxyLogin.inserirLogin(lg); idlogin = lgn.getIdlogin();
	 * proxyPrestador.inserirPrestador(lgn.getIdlogin(),prest.getNome_comp()
	 * ,prest.getCpf(),prest.getData_nasc(),prest.getData_admissao(),
	 * prest.getSexo(), prest.getIdsetor(), prest.getTelefone(),
	 * prest.getIdestado()); log.info("Finalizando class InserirPrestadorJPA");
	 * 
	 * }
	 */
	
	public List<PrestadorAcessoPerfil> buscaPrestadorLoginService(String login){
		log.info("Class PrestadorService chamando buscaPrestadorLoginService");
		return PrestadorModelMapperList(proxyPrestador.findByLoginPrestador(login));
	}
	
	public List<perfil_acesso> buscaPrestadorLoginParaPerfilService(String login){
		log.info("Class PrestadorService chamando buscaPrestadorLoginParaPerfilService");
		int id;
		List<PrestadorAcessoPerfil> lista = PrestadorModelMapperList(proxyPrestador.findByLoginPrestador(login));
		if(lista != null) {
			id = lista.get(0).getIdprestador();
			return proxyPerfilAcesso.buscaNivelAcessoList(id);
		}
		return null;
	}
	
	public URI uploadPrestador(MultipartFile multipartFile) {
		return s3Service.uploadFile(multipartFile);
	}
	
	public URI uploadPrestadorImgHTML(MultipartFile multipartFile) {
		return s3Service.uploadFileHTML(multipartFile);
	}
	
	public URI uploadPrestadorFormat(MultipartFile file,int id) {
		log.info("Class PrestadorService  upload com  format");
		BufferedImage jpgImage = imageService.getJpgImageFromFile(file);
		jpgImage = imageService.cropSquare(jpgImage);
		jpgImage = imageService.resize(jpgImage, id);
		String filename = prefix + id + ".jpg";
		return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"),filename,"image");
	
	}
	
	//----------------------ModelMapper--------------------------------------------------
	
	private PrestadorAcessoPerfil PrestadormodelMapperOne(PrestadorAcessoDTO dto) {
		PrestadorAcessoPerfil pap = modelMapper.map(dto, PrestadorAcessoPerfil.class);
		return pap;
	}
	
	private List<PrestadorAcessoPerfil> PrestadorModelMapperList(List<PrestadorAcessoDTO> dto){
		  return dto.stream().map(obj -> PrestadormodelMapperOne(obj)).collect(Collectors.toList());
	}

	private PrestadorLoginDTO prestadorLoginMapperOne(PrestadorDTO dto) {
		 PrestadorLoginDTO obj = modelMapper.map(dto,PrestadorLoginDTO.class);
		 return obj;
	}
	
}
