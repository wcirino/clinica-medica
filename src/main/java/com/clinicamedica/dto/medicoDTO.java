package com.clinicamedica.dto;

import java.io.Serializable;
import  javax.persistence.Column ;
import  javax.persistence.Entity ;
import  javax.persistence.GeneratedValue ;
import  javax.persistence.GenerationType ;
import  javax.persistence.Id ;
import  javax.persistence.Table ;

import org.apache.logging.log4j.message.AsynchronouslyFormattable;

@Entity
@Table(name = "medico")
public class medicoDTO implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="idmedico")
	private int idmedico;
	
	@Column(name="nome_comp")
    private String nomeCompleto;
	
	@Column(name="idespecialidade")
	private int Especialidade;
	
	@Column(name="ativo")
	private String ativo;

	public int getIdmedico() {
		return idmedico;
	}

	public void setIdmedico(int idmedico) {
		this.idmedico = idmedico;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public int getEspecialidade() {
		return Especialidade;
	}

	public void setEspecialidade(int especialidade) {
		Especialidade = especialidade;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Especialidade;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + idmedico;
		result = prime * result + ((nomeCompleto == null) ? 0 : nomeCompleto.hashCode());
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
		medicoDTO other = (medicoDTO) obj;
		if (Especialidade != other.Especialidade)
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (idmedico != other.idmedico)
			return false;
		if (nomeCompleto == null) {
			if (other.nomeCompleto != null)
				return false;
		} else if (!nomeCompleto.equals(other.nomeCompleto))
			return false;
		return true;
	}

	
}
