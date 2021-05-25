package com.clinicamedica.dto;

import java.io.Serializable;

import javax.persistence.Id;

public class DesativarPrestadorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String flag;
	
	public DesativarPrestadorDTO() {
		super();
	}
	
	public DesativarPrestadorDTO(int id, String flag) {
		super();
		this.id = id;
		this.flag = flag;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
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
		DesativarPrestadorDTO other = (DesativarPrestadorDTO) obj;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
