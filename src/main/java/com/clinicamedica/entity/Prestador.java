package com.clinicamedica.entity;

import java.io.Serializable;

public class Prestador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idprestador;;
	private String nome_comp;
	private String 	cpf;
	private int idestado;
	private String ativo;
	private Login idlogin;
	
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
	
	public Login getIdlogin() {
		return idlogin;
	}
	public void setIdlogin(Login idlogin) {
		this.idlogin = idlogin;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
