package com.clinicamedica.controller;

import java.net.Authenticator.RequestorType;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.realm.MessageDigestCredentialHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.clinicamedica.dto.medicoDTO;

import com.clinicamedica.service.medicoService;

@RestController
@RequestMapping(value="medico")
public class MedicoController {

	@Autowired
	medicoService proxymedicoService;
	
	@GetMapping(value = "/buscar-medico")
	public List<medicoDTO> buscarMedico() {
		List<medicoDTO> dto = new ArrayList<>();
		dto = proxymedicoService.BuscaMedico();
	 return dto;
	}
	
	@GetMapping(value="/v2/buscar-medico")
	public List<medicoDTO> busrMedico(){
		List<medicoDTO> dto = proxymedicoService.BuscaMedico();
		return dto;
	}
	
	@GetMapping(value = "/v2/buscar-medico/{id}")
	public medicoDTO buscaMedicoId(@PathVariable int id) {
		medicoDTO dto = proxymedicoService.buscaMedicoById(id);
		return dto;
	}
		
	@PostMapping(value = "/inserir-medico")
	@ResponseStatus(HttpStatus.CREATED)
	public medicoDTO inserirMedico(@RequestBody medicoDTO obj) {
		return proxymedicoService.buscaSalvar(obj);				
	}
	
	@PutMapping(value = "/alterar-medico")
	@ResponseStatus(HttpStatus.OK)
	public medicoDTO alterarMedico(@RequestBody medicoDTO obj) {
		return proxymedicoService.alterarMedico(obj);
	}
	
	@DeleteMapping(value = "delete-medico")
	public ResponseEntity<String> deleteMedico(@RequestBody medicoDTO obj) {
		if (proxymedicoService.deleteMedica(obj.getIdmedico()) == 1)
			return new ResponseEntity<String>("Medico excluido",HttpStatus.OK);
		else
			return new ResponseEntity<>("Ocorreu um erro", HttpStatus.FOUND);
	}
	
	
}
