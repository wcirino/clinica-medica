package com.clinicamedica.dto;

import java.io.Serializable;
import java.util.Date;

public class DadosParaEmailDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String carteirinha;
	private String email;
	private Date date;
	private String assunto;
	private String msg;
	
	public DadosParaEmailDTO() {
		super();
	}
	
	public DadosParaEmailDTO(String nome, String carteirinha, String email, Date date, String assunto, String msg) {
		super();
		this.nome = nome;
		this.carteirinha = carteirinha;
		this.email = email;
		this.date = date;
		this.assunto = assunto;
		this.msg = msg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCarteirinha() {
		return carteirinha;
	}
	public void setCarteirinha(String carteirinha) {
		this.carteirinha = carteirinha;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carteirinha == null) ? 0 : carteirinha.hashCode());
		result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadosParaEmailDTO other = (DadosParaEmailDTO) obj;
		if (carteirinha == null) {
			if (other.carteirinha != null)
				return false;
		} else if (!carteirinha.equals(other.carteirinha))
			return false;
		if (assunto == null) {
			if (other.assunto != null)
				return false;
		} else if (!assunto.equals(other.assunto))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
	
}
