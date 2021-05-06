package com.clinicamedica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicamedica.repository.prestadoresRepository;
import com.clinicamedica.dto.PrestadorDTO;

@Service
public class PrestadorService {


	@Autowired
	private prestadoresRepository proxyPrestador;
	
	public List<PrestadorDTO> buscaPrestadoresService() {
		return proxyPrestador.findAll();
	}

	public PrestadorDTO buscarPorIDService(int id) {
		PrestadorDTO dto = proxyPrestador.findById(id);
		return dto;
	}

	public int alterarPrestadorService(PrestadorDTO obj) {
		if (!proxyPrestador.existsById(obj.getIdprestador())) {
			proxyPrestador.save(obj);
			return 1;
		} else
			return 0;
	}

	public int InserirPrestadorService(PrestadorDTO obj) {
		proxyPrestador.save(obj);
		return 1;
	}

	public void deletePrestadorService(PrestadorDTO obj) {
		proxyPrestador.delete(obj);
	}  
	 

}
