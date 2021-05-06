package com.clinicamedica.dto;

public enum perfilEnum {

	ADMIN(1, "ROLE_ADMIN"),
	PERFIL_PRESTADOR_1(2, "PERFIL_PRESTADOR_1"),
	PERFIL_PRESTADOR_2(3, "PERFIL_PRESTADOR_2"),
	PERFIL_PRESTADOR_3(4, "PERFIL_PRESTADOR_3"),
	PERFIL_BENEFICIARIO(5, "PERFIL_BENEFICIARIO"),
	PERFIL_CONSULTA(6, "PERFIL_CONSULTA"),
	PERFIL_PRESTADOR_4(7, "PERFIL_BENEFICIARIO"),
	PERFIL_PRESTADOR_5(8, "PERFIL_BENEFICIARIO");
	
	private int idperfil;
	private String perfil;
	
	private perfilEnum(int idperfil, String perfil) {
		this.idperfil = idperfil;
		this.perfil = perfil;
	}

	public int getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(int idperfil) {
		this.idperfil = idperfil;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
}
