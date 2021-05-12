package com.clinicamedica.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clinicamedica.dto.PrestadorAcessoDTO;
import com.clinicamedica.dto.PrestadorDTO;
import com.clinicamedica.entity.PrestadorAcessoPerfil;
import com.clinicamedica.service.PrestadorService;

@RestController
@RequestMapping(value = "/api-prestador")
public class PrestadorController {
	
	
	@Autowired
	private PrestadorService proxyPrestador;
	
	@GetMapping(value = "/busca-todos-usuario")
	public List<PrestadorDTO> buscaPrestadoresService() {
		return proxyPrestador.buscaPrestadoresService();
	}

	@GetMapping(value = "/buscaId/{id}")
	public PrestadorDTO buscarPorIDService(@PathVariable int id) {
		return proxyPrestador.buscarPorIDService(id);
	}

	@PostMapping(value = "/inserir-prestador")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> inserirPrestador(@RequestBody PrestadorDTO obj) {
		if (obj == null) {
			proxyPrestador.InserirPrestadorService(obj);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/upodate-prestador")
	public ResponseEntity<?> updatePrestador(@RequestBody PrestadorDTO obj) {
		proxyPrestador.alterarPrestadorService(obj);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete-prestador")
	public ResponseEntity<?> deletePrestador(@RequestBody PrestadorDTO obj) {
		proxyPrestador.deletePrestadorService(obj);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscarPrestadorLogin/{login}")
	public List<PrestadorAcessoPerfil> buscarPrestadorANDLogin(@PathVariable String login){
		return proxyPrestador.buscaPrestadorLoginService(login);
	}
	 

}
