package com.clinicamedica.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSecurity implements UserDetails{


	private static final long serialVersionUID = 1L;
	
	private int id;
	private String email;
	private String senha;
	private String login;
	private  Collection<? extends GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	//Valida Se o usuario não ta expirado
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//Valida se não esta  bloqueado
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	//Se as credenciais não estão bloqueadas
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

    // valida se não está liberado 
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
