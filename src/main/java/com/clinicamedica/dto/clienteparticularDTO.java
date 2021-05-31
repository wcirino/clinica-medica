package com.clinicamedica.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="clienteparticular")
public class clienteparticularDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idclienteparticular")
	private int idclienteparticular;

	@NotBlank
	@Column(name = "nome_comp")
	private String nome_comp;

	@Size(min = 11, max = 20)
	@NotBlank
	@Column(name = "cpfcnpj")
	private String cpfcnpj;

	@Size(min = 11, max = 20)
	@NotBlank
	@Column(name = "RG")
	private String RG;

	@Column(name = "data_nasc")
	private Date data_nasc;

	@Column(name = "idestado")
	private int idestado;

	@Column(name = "cidade")
	private int cidade;

	@Size(max = 15)
	@Column(name = "telefone")
	private String telefone;

	@Size(max = 15)
	@Column(name = "celular")
	private String celular;
		
	@Column(name="data_cadas")
	private Date data_cadas;
	
	@Column(name="email")
	private String email;
	
	@Column(name="ativo")
	private String ativo;

	public clienteparticularDTO() {
		super();
	}

	public clienteparticularDTO(int idclienteparticular, @NotBlank String nome_comp,
			@Size(min = 11, max = 20) @NotBlank String cpfcnpj, @Size(min = 11, max = 20) @NotBlank String rG,
			Date data_nasc, int idestado, int cidade, @Size(max = 15) String telefone, @Size(max = 15) String celular,
			Date data_cadas, String email, String ativo) {
		super();
		this.idclienteparticular = idclienteparticular;
		this.nome_comp = nome_comp;
		this.cpfcnpj = cpfcnpj;
		RG = rG;
		this.data_nasc = data_nasc;
		this.idestado = idestado;
		this.cidade = cidade;
		this.telefone = telefone;
		this.celular = celular;
		this.data_cadas = data_cadas;
		this.email = email;
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((RG == null) ? 0 : RG.hashCode());
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + cidade;
		result = prime * result + ((cpfcnpj == null) ? 0 : cpfcnpj.hashCode());
		result = prime * result + ((data_cadas == null) ? 0 : data_cadas.hashCode());
		result = prime * result + ((data_nasc == null) ? 0 : data_nasc.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idclienteparticular;
		result = prime * result + idestado;
		result = prime * result + ((nome_comp == null) ? 0 : nome_comp.hashCode());
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
		clienteparticularDTO other = (clienteparticularDTO) obj;
		if (RG == null) {
			if (other.RG != null)
				return false;
		} else if (!RG.equals(other.RG))
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cidade != other.cidade)
			return false;
		if (cpfcnpj == null) {
			if (other.cpfcnpj != null)
				return false;
		} else if (!cpfcnpj.equals(other.cpfcnpj))
			return false;
		if (data_cadas == null) {
			if (other.data_cadas != null)
				return false;
		} else if (!data_cadas.equals(other.data_cadas))
			return false;
		if (data_nasc == null) {
			if (other.data_nasc != null)
				return false;
		} else if (!data_nasc.equals(other.data_nasc))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idclienteparticular != other.idclienteparticular)
			return false;
		if (idestado != other.idestado)
			return false;
		if (nome_comp == null) {
			if (other.nome_comp != null)
				return false;
		} else if (!nome_comp.equals(other.nome_comp))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	public int getIdclienteparticular() {
		return idclienteparticular;
	}

	public void setIdclienteparticular(int idclienteparticular) {
		this.idclienteparticular = idclienteparticular;
	}

	public String getNome_comp() {
		return nome_comp;
	}

	public void setNome_comp(String nome_comp) {
		this.nome_comp = nome_comp;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public int getCidade() {
		return cidade;
	}

	public void setCidade(int cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getData_cadas() {
		return data_cadas;
	}

	public void setData_cadas(Date data_cadas) {
		this.data_cadas = data_cadas;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
