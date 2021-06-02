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
@Table(name = "consulta")
public class ConsultaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idconsulta")
	private int idconsulta;
	
	@Column(name="idmedico")
	private int idmedico;
	
	@Column(name="idbeneficiario")
	private Integer idbeneficiario;
	
	@Column(name="idclienteparticular")
	private Integer idclienteparticular;
	
	@Column(name="data_consulta")
	private Date data_consulta;
	
	@Column(name = "statusConsulta")
	private String statusConsulta;
	
	public ConsultaDTO(int idconsulta, int idmedico, int idbeneficiario, int idclienteparticular, Date data_consulta,
			String statusConsulta) {
		super();
		this.idconsulta = idconsulta;
		this.idmedico = idmedico;
		this.idbeneficiario = idbeneficiario;
		this.idclienteparticular = idclienteparticular;
		this.data_consulta = data_consulta;
		this.statusConsulta = statusConsulta;
	}

	public ConsultaDTO() {
		super();
	}

	public int getIdconsulta() {
		return idconsulta;
	}

	public void setIdconsulta(int idconsulta) {
		this.idconsulta = idconsulta;
	}

	public int getIdmedico() {
		return idmedico;
	}

	public void setIdmedico(int idmedico) {
		this.idmedico = idmedico;
	}

	public Integer getIdbeneficiario() {
		return idbeneficiario;
	}

	public void setIdbeneficiario(Integer idbeneficiario) {
		this.idbeneficiario = idbeneficiario;
	}

	public Integer getIdclienteparticular() {
		return idclienteparticular;
	}

	public void setIdclienteparticular(Integer idclienteparticular) {
		this.idclienteparticular = idclienteparticular;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_consulta == null) ? 0 : data_consulta.hashCode());
		result = prime * result + idbeneficiario;
		result = prime * result + idclienteparticular;
		result = prime * result + idconsulta;
		result = prime * result + idmedico;
		result = prime * result + ((statusConsulta == null) ? 0 : statusConsulta.hashCode());
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
		ConsultaDTO other = (ConsultaDTO) obj;
		if (data_consulta == null) {
			if (other.data_consulta != null)
				return false;
		} else if (!data_consulta.equals(other.data_consulta))
			return false;
		if (idbeneficiario != other.idbeneficiario)
			return false;
		if (idclienteparticular != other.idclienteparticular)
			return false;
		if (idconsulta != other.idconsulta)
			return false;
		if (idmedico != other.idmedico)
			return false;
		if (statusConsulta == null) {
			if (other.statusConsulta != null)
				return false;
		} else if (!statusConsulta.equals(other.statusConsulta))
			return false;
		return true;
	}

}
