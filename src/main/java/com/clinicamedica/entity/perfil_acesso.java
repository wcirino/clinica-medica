package com.clinicamedica.entity;

import java.io.Serializable;

public class perfil_acesso implements Serializable {
  
	private static final long serialVersionUID = 1L;
	
	private int idper_prest;
	private Perfil idperfil;
	private Prestador prestador;
	

	public int getIdper_prest() {
		return idper_prest;
	}
	public void setIdper_prest(int idper_prest) {
		this.idper_prest = idper_prest;
	}
	public Perfil getPerfil() {
		return idperfil;
	}
	public void setPerfil(Perfil perfil) {
		this.idperfil = perfil;
	}
	public Prestador getPrestador() {
		return prestador;
	}
	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
