package com.clinicamedica.entity;

import java.io.Serializable;

public class perfilAcesso implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idprestador;
	private String perfil;
		
	public perfilAcesso() {
		super();
	}
	public perfilAcesso(int idprestador, String perfil) {
		super();
		this.idprestador = idprestador;
		this.perfil = perfil;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idprestador;
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
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
		perfilAcesso other = (perfilAcesso) obj;
		if (idprestador != other.idprestador)
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		return true;
	}
	public int getIdprestador() {
		return idprestador;
	}
	public void setIdprestador(int idprestador) {
		this.idprestador = idprestador;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
