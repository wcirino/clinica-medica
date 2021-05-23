package com.clinicamedica.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicamedica.dto.DadosParaEmailDTO;
import com.clinicamedica.dto.LoginDTO;
import com.clinicamedica.email.EmailService;
import com.clinicamedica.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository proxyLogin;
	
	@Autowired
	EmailService proxyEmail;
	
	@Autowired
	EmailService proxyEmailSmtp;
	
	public LoginDTO buscaLoginService(String login) {
		LoginDTO dto = proxyLogin.findByLogin(login);
		return dto;
	}
	
	public LoginDTO buscaLoginIdService(int id) {
		LoginDTO dto = proxyLogin.findById(id);
		return dto;
	}
	
	public LoginDTO buscaEmailService(String email) {
		LoginDTO dto = proxyLogin.findByEmail(email);
		return dto;
	}
	
	public LoginDTO alterarLgin(LoginDTO dto) {
		return proxyLogin.save(dto);
	}
	
	public LoginDTO inserirLogin(LoginDTO dto) {
		return proxyLogin.save(dto);
	}
	
	public void EnviarEmailLogin() {
		DadosParaEmailDTO email = new DadosParaEmailDTO();
		email.setAssunto("O assunto");
		email.setCarteirinha("000000000000000");
		email.setDate(new Date(System.currentTimeMillis()));
		email.setMsg("Enviando os email ai ok");
		email.setNome("Willyan");
		email.setEmail("wf.cirino@bol.com.br");
		proxyEmail.sendorderConfirmationEmail(email);
		
	}
	
	
	
}
