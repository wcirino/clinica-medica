package com.clinicamedica.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clinicamedica.dto.LoginDTO;
import com.clinicamedica.dto.PerfilDTO;
import com.clinicamedica.repository.LoginRepository;
import com.clinicamedica.security.UusuarioSecurity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private LoginService proxyLogin; 
	
	//Vai buscar pelo login
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LoginDTO dto = proxyLogin.buscaLoginService(login);
		if(dto == null) {
			throw new UsernameNotFoundException(login);
		}
		
		List<PerfilDTO> lista = new ArrayList<>();
		PerfilDTO  obj1 = new PerfilDTO();
		PerfilDTO  obj2 = new PerfilDTO();
		obj1.setIdperfil(1);
		obj1.setPerfil("ADMIN");
		obj2.setIdperfil(2);
		obj2.setPerfil("PERFIL PRESTADOR 1");
		lista.add(obj1);
		lista.add(obj2);
		
		return  new UusuarioSecurity(dto.getIdlogin(), dto.getEmail(),dto.getSenha(),dto.getLogin(),lista);
	}

}
