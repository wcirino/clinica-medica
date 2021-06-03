package com.clinicamedica.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consulta")
public class ConsultaExameDTO {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idconsulta")
	private int idconsulta;
	
	@OneToOne
	@JoinColumn(name = "idmedico")
	private medicoDTO medico;
	
	@OneToOne
	@JoinColumn(name = "idbeneficiario")
	private BeneficiarioDTO beneficiario;
	
	@OneToOne
	@JoinColumn(name = "idclienteparticular")
	private clienteparticularDTO clienteparticular;
	
	@Column(name="data_consulta")
	private Date data_consulta;
	
	@Column(name = "statusConsulta")
	private String statusConsulta;

	public int getIdconsulta() {
		return idconsulta;
	}

	public void setIdconsulta(int idconsulta) {
		this.idconsulta = idconsulta;
	}

	public medicoDTO getMedico() {
		return medico;
	}

	public void setMedico(medicoDTO medico) {
		this.medico = medico;
	}

	public BeneficiarioDTO getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(BeneficiarioDTO beneficiario) {
		this.beneficiario = beneficiario;
	}

	public clienteparticularDTO getClienteparticular() {
		return clienteparticular;
	}

	public void setClienteparticular(clienteparticularDTO clienteparticular) {
		this.clienteparticular = clienteparticular;
	}

	public Date getData_consulta() {
		return data_consulta;
	}

	public void setData_consulta(Date data_consulta) {
		this.data_consulta = data_consulta;
	}

	public String getStatusConsulta() {
		return statusConsulta;
	}

	public void setStatusConsulta(String statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	
	
	
	
}
