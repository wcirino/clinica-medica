package com.clinicamedica.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.clinicamedica.dto.MedicoResponseDTO;
import com.clinicamedica.dto.medicoDTO;
import com.clinicamedica.exception.ExceptionBase;
import com.clinicamedica.service.medicoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="medico", description = "API de medicos", tags = {"EndPoint-medico"})
@RestController
@RequestMapping(value="medico")
public class MedicoController {

	@Autowired
	medicoService proxymedicoService;
	
	
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(MedicoController.class);
			
	@PostMapping(value = "/inserir-medico")
	@ApiOperation(value = "Inserindo medico")
	@ResponseStatus(HttpStatus.CREATED)
	public medicoDTO inserirMedico(@RequestBody medicoDTO obj) {
		log.info("Chamando controller cria medico");
		return proxymedicoService.buscaSalvar(obj);				
	}
	
   // @PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/alterar-medico")
	@ApiOperation(value = "Alterar medico")
	@ResponseStatus(HttpStatus.OK)
	public medicoDTO alterarMedico(@Valid @RequestBody medicoDTO obj, BindingResult br) {
	 if(br.hasErrors())
		throw new ExceptionBase(br.getAllErrors().get(0).toString());
	else
		log.info("Chamando controller alterar medico por id");
	 
		return proxymedicoService.alterarMedico(obj);
	}
	
	@DeleteMapping(value = "delete-medico")
	@ApiOperation(value = "deleta medico")
	public ResponseEntity<String> deleteMedico(@RequestBody medicoDTO obj) {
		log.info("Chamando controller deletar medico por id");
		if (proxymedicoService.deleteMedica(obj.getIdmedico()) == 1)
			return new ResponseEntity<String>("Medico excluido",HttpStatus.OK);
		else
			return new ResponseEntity<>("Ocorreu um erro", HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/buscar-medico")
	@ApiOperation(value = "Buscar todos os medicos")
	public List<medicoDTO> buscarMedico() {
		log.info("Chamando controller buscar-medico all");
		List<medicoDTO> dto = new ArrayList<>();
		dto = proxymedicoService.BuscaMedico();
	 return dto;
	}
	
	//-------------------------------------------------------------------------------------------------------------
	
	/*
	 *ALTERANDO E COLOCANDO VERSONAMENTO NAS URL  COM METODO GET
	 * */
	
	@GetMapping(value="/v2/buscar-medico")
	@ApiOperation(value = "Buscar todos os medicos com versonamento")
	public List<medicoDTO> busrMedico(){
		log.info("chamando controller com um novo versonamento");
		List<medicoDTO> dto = proxymedicoService.BuscaMedico();
		return dto;
	}
	
	@PreAuthorize("hasRole(ADMIN)")
	@GetMapping(value = "/v2/buscar-medico/{id}")
	@ApiOperation(value = "Buscar medico por id ")
	public medicoDTO buscaMedicoId(@PathVariable int id) {
		log.info("Chamando controller busca medico por id");
		medicoDTO dto = proxymedicoService.buscaMedicoById(id);
		return dto;
	}
	
	//-----------------------------------------------------------------------------------------
	//APENAS COLOCANDO MODELMAPPER
	
	@PreAuthorize("hasRole(ADMIN)")
	@GetMapping(value = "/v3/buscaMedico")
	@ApiOperation(value = "Buscar todos os medicos via modelMapper List")
	public List<MedicoResponseDTO> buscaMedicoModelMapper(){
		log.info("Chamando metodo via modelMapper List");
		return proxymedicoService.BuscaMedicoModelMapperListService();
	}
	
	@GetMapping(value = "/v3/buscaMedicoOne/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "Buscar todos os medicos modelMapper One")
	public MedicoResponseDTO buscaMedicoModelMapperone(@PathVariable int id){
		log.info("Chamando metodo via modelMapper One");
		return proxymedicoService.buscaMedicoModelMapperOneService(id);
	}
	
	
	
}
