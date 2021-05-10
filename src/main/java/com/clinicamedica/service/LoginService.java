package com.clinicamedica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicamedica.dto.LoginDTO;
import com.clinicamedica.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository proxyLogin;
	
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
	
}
