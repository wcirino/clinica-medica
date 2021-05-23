package com.clinicamedica.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.clinicamedica.repository.prestadoresRepository;
import com.clinicamedica.controller.MedicoController;
import com.clinicamedica.dto.LoginDTO;
import com.clinicamedica.dto.MedicoResponseDTO;
import com.clinicamedica.dto.PrestadorAcessoDTO;
import com.clinicamedica.dto.PrestadorDTO;
import com.clinicamedica.dto.PrestadorLoginDTO;
import com.clinicamedica.dto.medicoDTO;
import com.clinicamedica.entity.PrestadorAcessoPerfil;
import com.clinicamedica.entity.perfil_acesso;

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
	private static final Logger log = LoggerFactory.getLogger(MedicoController.class);
	
	
	public List<PrestadorDTO> buscaPrestadoresService() {
		log.info("Class PrestadorService chamando buscaPrestadoresService");
		return proxyPrestador.findAll();
	}

	public PrestadorDTO buscarPorIDService(int id) {
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
		
		log.info("Class PrestadorService chamando InserirPrestadorService");
		PrestadorLoginDTO dto = new PrestadorLoginDTO();
		LoginDTO lg = proxyLogin.inserirLogin(obj.getLogin());
		dto = prestadorLoginMapperOne(obj);
		dto.setIdlogin(lg.getIdlogin());
		proxyPrestador.save(dto);
		return 1;
	}

	public void deletePrestadorService(PrestadorDTO obj) {
		log.info("Class PrestadorService chamando deletePrestadorService");
		proxyPrestador.delete(obj);
	}  
	 
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
