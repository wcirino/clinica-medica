package com.clinicamedica.entity;

import java.io.Serializable;

public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  int idlogin;
	private  String login;
	private  String email;
	
	public int getIdlogin() {
		return idlogin;
	}
	public void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
