package com.clinicamedica.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicamedica.controller.MedicoController;
import com.clinicamedica.dto.BeneficiarioDTO;
import com.clinicamedica.dto.DadosParaEmailDTO;
import com.clinicamedica.email.EmailService;
import com.clinicamedica.exception.ServiceBaseException;
import com.clinicamedica.repository.BeneficiarioRepository;

@Service
public class BeneficiarioService {
	
	@Autowired
	private BeneficiarioRepository proxyBenef;
	
	@Autowired
	private EmailService emailProxy;
	
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(MedicoController.class);
	
	@Autowired
	EmailService proxyEmail;
	//15,10,8,18,21,19,
	public BeneficiarioDTO findByIdService(int id) {
		Optional<BeneficiarioDTO> obj = Optional.ofNullable(proxyBenef.findById(id));
		return obj.orElseThrow(() -> new ServiceBaseException(
				"Erro com o ID: "+id+", tipo : "+BeneficiarioDTO.class.getName()));  
	}
	
	public List<BeneficiarioDTO> findAllService(){
		Optional<List<BeneficiarioDTO>> obj = Optional.ofNullable(proxyBenef.findAll());
		return obj.orElseThrow(() -> new ServiceBaseException("Erro  na importação dos beneficiario"));
	}
	
	public List<BeneficiarioDTO> findlikeService(String nome){
		Optional<List<BeneficiarioDTO>> obj =Optional.ofNullable(proxyBenef.buscaPorLike(nome));
		return obj.orElseThrow(() -> new ServiceBaseException("Erro no FindlikeService parametro :" +nome));
	}
	
	public BeneficiarioDTO InserirBeneficiario(BeneficiarioDTO dto) {
		try {
			DadosParaEmailDTO email = new DadosParaEmailDTO();
			log.info("Inserir Beneficiario");
			dto.setData_cadas(new Date(System.currentTimeMillis()));
			BeneficiarioDTO benef = proxyBenef.save(dto);
			if(benef != null) {
				email.setAssunto("Cadastro Beneficiario");
				email.setCarteirinha("000000000000000");
				email.setDate(new Date(System.currentTimeMillis()));
				email.setMsg("Enviando os email ai ok");
				email.setNome(benef.getNome_comp());
				email.setEmail("wf.cirino@bol.com.br");//benef.getEmail());
				emailProxy.sendOrderConfirmationHtmlEmail(email,"email/CriacaoBeneficiario");
			}
			return benef;
		}catch (Exception e) {
			log.info("Erro : "+e.getMessage());
			throw new ServiceBaseException("Ocorreu um erro no InserirBeneficiario");
		}
		
	}
	
	public void DesativaAtivaBeneficiario(int id, Integer status) {
		try {
			log.info("update DesativaAtivaBeneficiario");
			if (status.equals(1))
				proxyBenef.desativarAtivaBeneficiario(id, "A");
			else if (status.equals(2))
				proxyBenef.desativarAtivaBeneficiario(id, "D");
		} catch (Exception e) {
			log.info("Erro : " + e.getMessage());
			throw new ServiceBaseException("Ocorreu um erro no DesativaAtivaBeneficiario");
		}
	}
	
	public BeneficiarioDTO UpdateBeneficiario(BeneficiarioDTO dto) {
		try {
			log.info("update UpdateBeneficiario");
			BeneficiarioDTO benef = proxyBenef.save(dto);
			return benef;
		} catch (Exception e) {
			log.info("Erro : "+e.getMessage());
			throw new ServiceBaseException("Ocorreu um erro no UpdateBeneficiario");
		}
	}
		
	
}
