package com.clinicamedica.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Length;

import com.clinicamedica.dto.LoginDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PrestadorAcessoPerfil {

	private int idprestador;
	
	private String nome_comp;
	private String 	cpf;
	private int idsetor;
	private int idestado;
	private String ativo;
	private LoginAcessoPerfil login;
	
	public int getIdprestador() {
		return idprestador;
	}
	public void setIdprestador(int idprestador) {
		this.idprestador = idprestador;
	}
	public String getNome_comp() {
		return nome_comp;
	}
	public void setNome_comp(String nome_comp) {
		this.nome_comp = nome_comp;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getIdsetor() {
		return idsetor;
	}
	public void setIdsetor(int idsetor) {
		this.idsetor = idsetor;
	}
	public int getIdestado() {
		return idestado;
	}
	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public LoginAcessoPerfil getLogin() {
		return login;
	}
	public void setLogin(LoginAcessoPerfil login) {
		this.login = login;
	}	
	
	
	
}
