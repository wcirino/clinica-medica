package com.clinicamedica.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="perfil_prestador")
public class PerfilAcessoDTO {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private int idper_prest;
	
	@OneToOne
	@JoinColumn(name = "idperfil")
	private PerfilDTO perfil;
	
	@ManyToOne
	@JoinColumn(name = "idprestador")
	private PrestadorDTO prestador;
	
	public int getIdper_prest() {
		return idper_prest;
	}
	
	public void setIdper_prest(int idper_prest) {
		this.idper_prest = idper_prest;
	}
		
	public PrestadorDTO getPrestador() {
		return prestador;
	}
	
	public void setPrestador(PrestadorDTO prestador) {
		this.prestador = prestador;
	}

	public PerfilDTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}
	
	
	
}
