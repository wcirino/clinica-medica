package com.clinicamedica.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="prestador")
public class PrestadorLoginDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private int idprestador;
		
	@Column(name="nome_comp")
	private String nome_comp;
	
	@Column(name="cpf")
	private String 	cpf;
	
	@Column(name="data_nasc")
	private Date data_nasc;
	
	@Column(name="data_admissao")
	private Date data_admissao;
	
	@Column(name="sexo")
	private int sexo;
	
	@Column(name="idsetor")
	private int idsetor;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="idestado")
	private int idestado;
	
	@Column(name="ativo")
	private String ativo; 
	
	@Column(name="idlogin")
	private int idlogin;

	public int getIdprestador() {
		return idprestador;
	}

	public void setIdprestador(int idprestador) {
		this.idprestador = idprestador;
	}

	public String getNome_comp() {
		return nome_comp;
	}

	public void setNome_comp(String nome_comp) {
		this.nome_comp = nome_comp;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public Date getData_admissao() {
		return data_admissao;
	}

	public void setData_admissao(Date data_admissao) {
		this.data_admissao = data_admissao;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public int getIdsetor() {
		return idsetor;
	}

	public void setIdsetor(int idsetor) {
		this.idsetor = idsetor;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public int getIdlogin() {
		return idlogin;
	}

	public void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((data_admissao == null) ? 0 : data_admissao.hashCode());
		result = prime * result + ((data_nasc == null) ? 0 : data_nasc.hashCode());
		result = prime * result + idestado;
		result = prime * result + idlogin;
		result = prime * result + idprestador;
		result = prime * result + idsetor;
		result = prime * result + ((nome_comp == null) ? 0 : nome_comp.hashCode());
		result = prime * result + sexo;
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		PrestadorLoginDTO other = (PrestadorLoginDTO) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (data_admissao == null) {
			if (other.data_admissao != null)
				return false;
		} else if (!data_admissao.equals(other.data_admissao))
			return false;
		if (data_nasc == null) {
			if (other.data_nasc != null)
				return false;
		} else if (!data_nasc.equals(other.data_nasc))
			return false;
		if (idestado != other.idestado)
			return false;
		if (idlogin != other.idlogin)
			return false;
		if (idprestador != other.idprestador)
			return false;
		if (idsetor != other.idsetor)
			return false;
		if (nome_comp == null) {
			if (other.nome_comp != null)
				return false;
		} else if (!nome_comp.equals(other.nome_comp))
			return false;
		if (sexo != other.sexo)
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	
}
