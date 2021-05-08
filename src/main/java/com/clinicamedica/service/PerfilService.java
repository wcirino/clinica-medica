package com.clinicamedica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicamedica.dto.PerfilDTO;
import com.clinicamedica.repository.Perfilrepository;

@Service
public class PerfilService {

	@Autowired
	Perfilrepository proxyperfil;
	
	public PerfilDTO perfilBuscaIDService(int id) {
		return proxyperfil.findById(id);
	}
	
	
}
