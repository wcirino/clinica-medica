package com.clinicamedica.entity;

import java.io.Serializable;

public class Login implements Serializable {

	private  String login;
	private  String email;
	
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
