package com.clinicamedica.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DesativaAtivaMedicoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	private String AD;
	
	private Integer status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAD() {
		return AD;
	}

	public void setAD(String aD) {
		AD = aD;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DesativaAtivaMedicoDTO(int id, String aD, int status) {
		super();
		this.id = id;
		AD = aD;
		this.status = status;
	}
	
	
}
