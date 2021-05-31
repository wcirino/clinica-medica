package com.clinicamedica.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "precoconsulta")
public class PrecoConsultaDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idpreco")
	private int idpreco;
	
	@Column(name = "preco")
	private String preco;
	
	@Column(name = "idespecialidade")
	private String idespecialidade;

	public PrecoConsultaDTO(int idpreco, String preco, String idespecialidade) {
		super();
		this.idpreco = idpreco;
		this.preco = preco;
		this.idespecialidade = idespecialidade;
	}

	public PrecoConsultaDTO() {
		super();
	}

	public int getIdpreco() {
		return idpreco;
	}

	public void setIdpreco(int idpreco) {
		this.idpreco = idpreco;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getIdespecialidade() {
		return idespecialidade;
	}

	public void setIdespecialidade(String idespecialidade) {
		this.idespecialidade = idespecialidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idespecialidade == null) ? 0 : idespecialidade.hashCode());
		result = prime * result + idpreco;
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
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
		PrecoConsultaDTO other = (PrecoConsultaDTO) obj;
		if (idespecialidade == null) {
			if (other.idespecialidade != null)
				return false;
		} else if (!idespecialidade.equals(other.idespecialidade))
			return false;
		if (idpreco != other.idpreco)
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		return true;
	}
	
	

}
