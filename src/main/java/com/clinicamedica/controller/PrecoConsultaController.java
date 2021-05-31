package com.clinicamedica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicamedica.dto.PrecoConsultaDTO;
import com.clinicamedica.service.PrecoConsultaService;

@RestController
@RequestMapping(value = "/api-preco-consulta")
public class PrecoConsultaController {

	@Autowired
	private PrecoConsultaService proxyPreco;
	
	@GetMapping(value = "/busca-preco/{id}")
	public ResponseEntity<?> buscaPreco(@PathVariable int id){
		return new ResponseEntity<>(proxyPreco.findByIDService(id),HttpStatus.OK);
	}
	
	@PutMapping(value = "/altera-Preco")
	public ResponseEntity<?> alterarPreco(PrecoConsultaDTO obj){
		return new ResponseEntity<>(proxyPreco.alteraPrecoService(obj),HttpStatus.CREATED);
	}
	
}
