package com.clinicamedica.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="prestador")
public class PrestadorDTO {
	
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
	@Length(max=1)
	private int sexo;
	
	@Column(name="idsetor")
	private int idsetor;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="idestado")
	private int idestado;
	
	@Column(name="ativo")
	private String ativo;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "idlogin", referencedColumnName="idlogin")
	private LoginDTO login;

	public int getIdprestador() {
		return idprestador;
	}

	public void setIdprestador(int idprestador) {
		this.idprestador = idprestador;
	}

	public LoginDTO getLogin() {
		return login;
	}

	public void setLogin(LoginDTO login) {
		this.login = login;
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
	

}
