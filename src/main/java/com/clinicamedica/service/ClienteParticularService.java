package com.clinicamedica.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicamedica.controller.MedicoController;
import com.clinicamedica.dto.DadosParaEmailDTO;
import com.clinicamedica.dto.clienteparticularDTO;
import com.clinicamedica.email.EmailService;
import com.clinicamedica.exception.ServiceBaseException;
import com.clinicamedica.repository.ClienteParticularRepository;

@Service
public class ClienteParticularService {
	
	@Autowired
	ClienteParticularRepository proxyClientePart;
	
	@Autowired
	private EmailService emailProxy;
	
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(MedicoController.class);
	
	@Autowired
	EmailService proxyEmail;
	
	public clienteparticularDTO findByIdService(int id) {
		Optional<clienteparticularDTO> obj = Optional.ofNullable(proxyClientePart.findById(id));
		return obj.orElseThrow(() -> new ServiceBaseException(
				"Erro com o ID: "+id+", tipo : "+clienteparticularDTO.class.getName()));  
	}
	
	public List<clienteparticularDTO> findAllService(){
		Optional<List<clienteparticularDTO>> obj = Optional.ofNullable(proxyClientePart.findAll());
		return obj.orElseThrow(() -> new ServiceBaseException("Erro  na importação dos beneficiario"));
	}
	
	public List<clienteparticularDTO> findlikeService(String nome){
		Optional<List<clienteparticularDTO>> obj =Optional.ofNullable(proxyClientePart.buscaPorLike(nome));
		return obj.orElseThrow(() -> new ServiceBaseException("Erro no FindlikeService parametro :" +nome));
	}
	
	public clienteparticularDTO InserirClientePart(clienteparticularDTO dto) {
		try {
			DadosParaEmailDTO email = new DadosParaEmailDTO();
			log.info("Inserir Beneficiario");
			dto.setData_cadas(new Date(System.currentTimeMillis()));
			clienteparticularDTO benef = proxyClientePart.save(dto);
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
			throw new ServiceBaseException("Ocorreu um erro no InserirClientePart");
		}
		
	}
	
	public clienteparticularDTO UpdateClientePart(clienteparticularDTO dto) {
		try {
			log.info("update UpdateBeneficiario");
			clienteparticularDTO clientPar = proxyClientePart.save(dto);
			return clientPar;
		} catch (Exception e) {
			log.info("Erro : "+e.getMessage());
			throw new ServiceBaseException("Ocorreu um erro no UpdateClientePart");
		}
	}

}
