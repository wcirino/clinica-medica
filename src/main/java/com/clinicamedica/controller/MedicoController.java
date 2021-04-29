package com.clinicamedica.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clinicamedica.dto.medicoDTO;
import com.clinicamedica.exception.ExceptionBase;
import com.clinicamedica.service.medicoService;

@RestController
@RequestMapping(value="medico")
public class MedicoController {

	@Autowired
	medicoService proxymedicoService;
	
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(MedicoController.class);
	
	@GetMapping(value = "/buscar-medico")
	public List<medicoDTO> buscarMedico() {
		log.info("Chamando controller buscar-medico all");
		List<medicoDTO> dto = new ArrayList<>();
		dto = proxymedicoService.BuscaMedico();
	 return dto;
	}
	
	@GetMapping(value="/v2/buscar-medico")
	public List<medicoDTO> busrMedico(){
		log.info("chamando controller com um novo versonamento");
		List<medicoDTO> dto = proxymedicoService.BuscaMedico();
		return dto;
	}
	
	@GetMapping(value = "/v2/buscar-medico/{id}")
	public medicoDTO buscaMedicoId(@PathVariable int id) {
		log.info("Chamando controller busca medico por id");
		medicoDTO dto = proxymedicoService.buscaMedicoById(id);
		return dto;
	}
		
	@PostMapping(value = "/inserir-medico")
	@ResponseStatus(HttpStatus.CREATED)
	public medicoDTO inserirMedico(@RequestBody medicoDTO obj) {
		log.info("Chamando controller cria medico");
		return proxymedicoService.buscaSalvar(obj);				
	}
	
	@PutMapping(value = "/alterar-medico")
	@ResponseStatus(HttpStatus.OK)
	public medicoDTO alterarMedico(@Valid @RequestBody medicoDTO obj, BindingResult br) {
	 if(br.hasErrors())
		throw new ExceptionBase(br.getAllErrors().get(0).toString());
	else
		log.info("Chamando controller alterar medico por id");
	 
		return proxymedicoService.alterarMedico(obj);
	}
	
	@DeleteMapping(value = "delete-medico")
	public ResponseEntity<String> deleteMedico(@RequestBody medicoDTO obj) {
		log.info("Chamando controller deletar medico por id");
		if (proxymedicoService.deleteMedica(obj.getIdmedico()) == 1)
			return new ResponseEntity<String>("Medico excluido",HttpStatus.OK);
		else
			return new ResponseEntity<>("Ocorreu um erro", HttpStatus.FOUND);
	}
	
	
}
