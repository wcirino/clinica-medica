package com.clinicamedica.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="especialidademedico")
public class EspecialistaDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idespecialidade")
	private int idespecialidade;
	
	@Column(name = "especialidade")
	private String especialidade;
	
	@Column(name = "ativa")
	private String ativa;

	public EspecialistaDTO(int idespecialidade, String especialidade, String ativa) {
		super();
		this.idespecialidade = idespecialidade;
		this.especialidade = especialidade;
		this.ativa = ativa;
	}

	public EspecialistaDTO() {
		super();
	}

	public int getIdespecialidade() {
		return idespecialidade;
	}

	public void setIdespecialidade(int idespecialidade) {
		this.idespecialidade = idespecialidade;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getAtiva() {
		return ativa;
	}

	public void setAtiva(String ativa) {
		this.ativa = ativa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativa == null) ? 0 : ativa.hashCode());
		result = prime * result + ((especialidade == null) ? 0 : especialidade.hashCode());
		result = prime * result + idespecialidade;
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
		EspecialistaDTO other = (EspecialistaDTO) obj;
		if (ativa == null) {
			if (other.ativa != null)
				return false;
		} else if (!ativa.equals(other.ativa))
			return false;
		if (especialidade == null) {
			if (other.especialidade != null)
				return false;
		} else if (!especialidade.equals(other.especialidade))
			return false;
		if (idespecialidade != other.idespecialidade)
			return false;
		return true;
	}
	
	
	
	

}
