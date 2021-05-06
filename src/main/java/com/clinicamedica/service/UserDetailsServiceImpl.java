package com.clinicamedica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.clinicamedica.dto.LoginDTO;
import com.clinicamedica.repository.LoginRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private LoginService proxyLogin; 
	
	//Vai buscar pelo login
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LoginDTO dto = proxyLogin.buscaEmailService(login);
		if(dto == null) {
			throw new UsernameNotFoundException(login);
		}
		return null;
	}

}
