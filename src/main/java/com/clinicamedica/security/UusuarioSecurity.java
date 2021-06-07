package com.clinicamedica.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.clinicamedica.dto.PerfilDTO;
import com.clinicamedica.entity.perfilAcesso;
import com.clinicamedica.entity.perfil_acesso;

public class UusuarioSecurity implements UserDetails{


	private static final long serialVersionUID = 1L;
	
	private int id;
	private String email;
	private String senha;
	private String login;
	private  Collection<? extends GrantedAuthority> authorities;
	
	
	
	public UusuarioSecurity() {
		super();
	}

	public UusuarioSecurity(int id, String email, String senha, String login, List<perfil_acesso> perfis ){
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.login = login;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getPerfil().getPerfil())).collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
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
		return true;
	}

    // valida se não está liberado 
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/*
	 * public boolean hasRole(Perfil perfil) { return getAuthorities().contains(new
	 * SimpleGrantedAuthority(perfil.getDescricao())); }
	 */
	public boolean hasRole(String perfil) {
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil));
	}

}
