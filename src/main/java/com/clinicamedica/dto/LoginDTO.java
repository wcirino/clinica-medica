package com.clinicamedica.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import javassist.SerialVersionUID;

@Entity
@Table(name="login")
public class LoginDTO implements Serializable {
	
	public static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private  int idlogin;
	
	@Column(name="login")
	private  String login;
	
	@Column(name="senha")
	//@Size(min = 8, max = 25)
	private  String senha; 
	
	//@Column(name="email")
	@Email(message = "Por favor, validar o email")
	private  String email;
	
	@Column(name="senhainicial")
	private  String senhainicial;
	
	@Column(name="ativo")
	private  String ativo;
	
	@Column(name="ultimologin")
	private  String ultimologin;
		
	public LoginDTO(LoginDTO dto) {
		this.login = dto.login;
		this.senha = dto.senha;
		this.email = dto.email;
		this.senhainicial = "S";
	}
	
	public LoginDTO(int idlogin, String login, String senha, String email, String senhainicial, String ativo, String ultimologin) {
		super();
		this.idlogin = idlogin;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.senhainicial = senhainicial;
		this.ativo = ativo;
		this.ultimologin = ultimologin;
	}
	
	
	
	public LoginDTO() {
		super();
	}



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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenhainicial() {
		return senhainicial;
	}
	public void setSenhainicial(String senhainicial) {
		this.senhainicial = senhainicial;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public String getUltimologin() {
		return ultimologin;
	}
	public void setUltimologin(String ultimologin) {
		this.ultimologin = ultimologin;
	}
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	@Override
	public String toString() {
		return "LoginDTO [idlogin=" + idlogin + ", login=" + login + ", senha=" + senha + ", email=" + email
				+ ", senhainicial=" + senhainicial + ", ativo=" + ativo + ", ultimologin=" + ultimologin + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDTO other = (LoginDTO) obj;
		if (ativo != other.ativo)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idlogin != other.idlogin)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (senhainicial == null) {
			if (other.senhainicial != null)
				return false;
		} else if (!senhainicial.equals(other.senhainicial))
			return false;
		if (ultimologin == null) {
			if (other.ultimologin != null)
				return false;
		} else if (!ultimologin.equals(other.ultimologin))
			return false;
		return true;
	}
		
	
}
