package com.clinicamedica.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConsultaStatusDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private int Status;
	
	public ConsultaStatusDTO(int id, int status) {
		super();
		this.id = id;
		Status = status;
	}

	public ConsultaStatusDTO() {
		super();
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
 
	
	
	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Status;
		result = prime * result + id;
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
		ConsultaStatusDTO other = (ConsultaStatusDTO) obj;
		if (Status != other.Status)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
	
	
	
}
