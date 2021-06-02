package com.clinicamedica.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinicamedica.dto.ConsultaDTO;
import com.clinicamedica.dto.ConsultaStatusDTO;
import com.clinicamedica.service.ConsultaService;

@RestController
@RequestMapping(value="/api-consulta")
public class ConsultaController {

	@Autowired
	private ConsultaService proxyConsulta;
	
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(ConsultaController.class);
	
	@GetMapping(value = "/busca-por-id/{id}")
	public ResponseEntity<?> buscaConsultaID(@PathVariable int id){
		log.info("Busca por id");
		return new ResponseEntity<>(proxyConsulta.buscaConsultaServiceId(id),HttpStatus.OK);
	}
	
	@PostMapping(value = "/busca-todas-consultas")
	public ResponseEntity<?> buscaConsultaAll(){
		log.info("Busca por todas  as consultas");
		return new ResponseEntity<>(proxyConsulta.buscaConsultaServiceAll(),HttpStatus.OK); 
	}
	
	@PutMapping(value = "/alterarStatusConsultas")
	public ResponseEntity<?> alterarStatusConsul(@RequestBody ConsultaStatusDTO obj){
		proxyConsulta.statusConsultaService(obj.getId(),obj.getStatus());
		return new ResponseEntity<>("OK",HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/inserir-consulta")
	public ResponseEntity<?> InserirConsul(@RequestBody ConsultaDTO obj){
		return new ResponseEntity<>(proxyConsulta.inserirServiceConsulta(obj),HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/alterarConsultas")
	public ResponseEntity<?> alterarStatusConsul(@RequestBody ConsultaDTO obj){
		return new ResponseEntity<>(proxyConsulta.AlterarConsultaService(obj),HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscadata")
	public ResponseEntity<?> buscadataConsulta(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date dataInicio,@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date dataFim){
		return new ResponseEntity<>(proxyConsulta.BuscarPorDataInicialFim(dataInicio, dataFim),HttpStatus.OK);
	}
	
}
