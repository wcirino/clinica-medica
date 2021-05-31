package com.clinicamedica.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clinicamedica.dto.clienteparticularDTO;
import com.clinicamedica.service.ClienteParticularService;

@RestController
@RequestMapping(value = "/api-beneficiario")
public class ClienteParticularController {

	@Autowired
	private ClienteParticularService proxyParticular;
	
	@Autowired
	private static Logger log = LoggerFactory.getLogger(beneficiarioController.class);
	
	@GetMapping(value = "/busca-clienteparticular-id/{id}")
	public ResponseEntity<?> buscaclienteparticularId(@PathVariable int id) {
	  log.info("busca id");
	  clienteparticularDTO clientePar	= proxyParticular.findByIdService(id);
	  return new ResponseEntity<>(clientePar,HttpStatus.OK);
	}
	
	@GetMapping(value = "/busca-clienteparticular-nome/{nome}")
	public ResponseEntity<?> buscaBeneficiarioid(@PathVariable String nome) {
	List<clienteparticularDTO> benef	= proxyParticular.findlikeService(nome);
	  return new ResponseEntity<>(benef,HttpStatus.OK);
	}
	
	@GetMapping(value = "/busca-todos-clienteparticular")
	public ResponseEntity<?> bustodosclienteparticular(){
		 List<clienteparticularDTO> clientePar	= proxyParticular.findAllService();
		  return new ResponseEntity<>(clientePar,HttpStatus.OK);	
	}
	
	@PostMapping(value = "/inserir-clienteparticular")
	public ResponseEntity<?> inserirclienteparticular(@RequestBody clienteparticularDTO obj){
		clienteparticularDTO clientePar = proxyParticular.InserirClientePart(obj);
		  return new ResponseEntity<>(clientePar,HttpStatus.CREATED);	
	}
		
	@PutMapping(value = "/update-clienteparticular")
	public ResponseEntity<?> updateclienteparticular(@RequestBody clienteparticularDTO obj){
		clienteparticularDTO clientePar = proxyParticular.UpdateClientePart(obj);
		return new ResponseEntity<>(clientePar,HttpStatus.OK);
	}
	
	
}
