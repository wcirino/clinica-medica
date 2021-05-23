package com.clinicamedica.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clinicamedica.dto.LoginDTO;
import com.clinicamedica.entity.perfil_acesso;
import com.clinicamedica.security.UusuarioSecurity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private LoginService proxyLogin; 
	
	@Autowired
	private PrestadorService proxyPrestador;
	
	//Vai buscar pelo login
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<perfil_acesso> objList = new ArrayList<>();
		LoginDTO dto = proxyLogin.buscaLoginService(login);
		if(dto == null) 
			throw new UsernameNotFoundException(login);
		else {
		  // objList  = proxyPrestador.buscaPrestadorLoginParaPerfilService(login);
		}
		  
		return  new UusuarioSecurity(dto.getIdlogin(), dto.getEmail(),dto.getSenha(),dto.getLogin(),objList);
	}

}
