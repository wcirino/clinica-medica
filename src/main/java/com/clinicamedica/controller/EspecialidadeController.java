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

import com.clinicamedica.dto.DesativaAtivaBenefDTO;
import com.clinicamedica.dto.EspecialistaDTO;
import com.clinicamedica.service.EspecialidadeMedicoService;

@RestController
@RequestMapping(value = "/api-especialidade")
public class EspecialidadeController {
	
	@Autowired
	private EspecialidadeMedicoService ProxyEsp;
	
	@Autowired
	private static Logger log = LoggerFactory.getLogger(beneficiarioController.class);
	
	@GetMapping(value = "/busca-especialidade-id/{id}")
	public ResponseEntity<?> buscaBeneficiarioid(@PathVariable int id) {
	  log.info("busca id");
	  EspecialistaDTO esp	= ProxyEsp.findByIdService(id);
	  return new ResponseEntity<>(esp,HttpStatus.OK);
	}
	
	@GetMapping(value = "/busca-especialidade-esp/{nome}")
	public ResponseEntity<?> buscaespecialidadeId(@PathVariable String nome) {
	List<EspecialistaDTO> esp	= ProxyEsp.findlikeService(nome);
	  return new ResponseEntity<>(esp,HttpStatus.OK);
	}
	
	@GetMapping(value = "/busca-todos-especialidade")
	public ResponseEntity<?> bustodosEspecialidade(){
		 List<EspecialistaDTO> esp	= ProxyEsp.findAllService();
		  return new ResponseEntity<>(esp,HttpStatus.OK);	
	}
	
	@PostMapping(value = "/inserir-especialidade")
	public ResponseEntity<?> inserirEspecialidade(@RequestBody EspecialistaDTO obj){
		EspecialistaDTO esp = ProxyEsp.InserirEspec(obj);
		  return new ResponseEntity<>(esp,HttpStatus.CREATED);	
	}
		
	@PutMapping(value = "/update-especialidade")
	public ResponseEntity<?> updateEspecialidade(@RequestBody EspecialistaDTO obj){
		EspecialistaDTO esp = ProxyEsp.UpdateEsp(obj);
		return new ResponseEntity<>(esp,HttpStatus.OK);
	}
	
	@PutMapping(value = "/desativa-ativa-especialidade")
	public ResponseEntity<?> updateEsp(@RequestBody DesativaAtivaBenefDTO obj){
		ProxyEsp.DesativaAtiva(obj.getId(),obj.getStatus());
		return new ResponseEntity<>("OK",HttpStatus.OK);
	}
	
	
	
}
