package com.clinicamedica.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clinicamedica.dto.PrestadorDTO;
import com.clinicamedica.service.PrestadorService;

@RestController
@RequestMapping(value = "/api-prestador")
public class PrestadorController {
	
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(MedicoController.class);
	
	@Autowired
	private PrestadorService proxyPrestador;
	
	@GetMapping(value = "/busca-todos-usuario")
	public ResponseEntity<?> buscaPrestadoresService() {
		log.info("Iniciando controller busca-todos-usuario");
		List<PrestadorDTO> lista = proxyPrestador.buscaPrestadoresService();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}

	@GetMapping(value = "/buscaId/{id}")
	public ResponseEntity<?> buscarPorIDService(@PathVariable int id) {
		log.info("iniciando controller metodo buscarPorIDService busca por id");
		return new ResponseEntity<>(proxyPrestador.buscarPorIDService(id),HttpStatus.OK);
	}

	@PostMapping(value = "/inserir-prestador")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> inserirPrestador(@RequestBody PrestadorDTO obj) {
		log.info("iniciando controller metodo inserirPrestador");
		if (obj != null) {
			proxyPrestador.InserirPrestadorService(obj);
			return new ResponseEntity<>("Usuário cadastrad com sucesso!!",HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/upodate-prestador")
	public ResponseEntity<?> updatePrestador(@RequestBody PrestadorDTO obj) {
		log.info("Iniciando controller de alterar prestador upodate-prestador");
		proxyPrestador.alterarPrestadorService(obj);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete-prestador")
	public ResponseEntity<?> deletePrestador(@RequestBody PrestadorDTO obj) {
		log.info("Deletando usuario da base");
		proxyPrestador.deletePrestadorService(obj);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscarPrestadorLogin/{login}")
	public ResponseEntity<?> buscarPrestadorANDLogin(@PathVariable String login){
		log.info("iniciando a busca por login na tabela de login");
		return new ResponseEntity<>(proxyPrestador.buscaPrestadorLoginService(login),HttpStatus.OK);
	}
	 
	
	@PostMapping(value = "/prestador-upload-arquivo")
	public ResponseEntity<Void> uploadPrestadorFile(@RequestParam(name="file") MultipartFile file){
		URI uri = proxyPrestador.uploadPrestador(file);
		return ResponseEntity.created(uri).build();
	}

}
