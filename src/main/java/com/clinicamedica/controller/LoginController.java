package com.clinicamedica.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clinicamedica.dto.LoginDTO;
import com.clinicamedica.service.LoginService;

@RestController
@RequestMapping(value = "/api-login")
public class LoginController {
	
	@Autowired
	private BCryptPasswordEncoder criptografia;
	
	@Autowired
	private LoginService proxyLogin;
	
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(MedicoController.class);
		
	@GetMapping(value = "/criptografia")
	public String GerarSenha(){
		String senha;
	//	String senhaDecodificada;
		senha = criptografia.encode("123456");
		return senha;
	}
	
	// ---------------------- Busca usuarios por id , login ou email ---------------------------------
	
	@GetMapping(value = "/busca-login/{login}")
	public LoginDTO buscaLogin(@PathVariable String login) {
		log.info("Buscando por login");
		LoginDTO dto = proxyLogin.buscaLoginService(login);
		return dto;
	}
	
	@GetMapping(value = "/busca-loginid/{id}")
	public LoginDTO buscaLogin(@PathVariable int id) {
		log.info("Buscando login por id");
		LoginDTO dto = proxyLogin.buscaLoginIdService(id);
		return dto;
	}
	
	@GetMapping(value = "/busca-loginEmail/{email}")
	public LoginDTO buscaLoginEmail(@PathVariable String email) {
		log.info("Buscando login pelo email");
		LoginDTO dto = proxyLogin.buscaEmailService(email);
		return dto;
	}
	
	//------------------------Altera usuarios e a senha-------------------------------------------------------
	
	@PutMapping(value = "/update-login]")
	public LoginDTO updateLogin(@RequestBody LoginDTO dto) {
		String senha;
		//String senhaDecodificada;
		senha = criptografia.encode(dto.getSenha());
		dto.setSenha(senha);
		return proxyLogin.alterarLgin(dto);
	}	
	
	
	
	
	//------------------------------Inserer Login---------------------------------------------------------------
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/enviarMail")
	public void enviarMail() {
	  proxyLogin.EnviarEmailLogin();		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/enviarMail-html")
	public void enviarMail2() {
	  proxyLogin.EnviarEmailLoginhtml();		
	}
	//------------------------------------------------------------------------------------------------------
	
	
}
