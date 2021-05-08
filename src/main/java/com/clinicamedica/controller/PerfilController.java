package com.clinicamedica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicamedica.dto.PerfilDTO;
import com.clinicamedica.service.PerfilService;

@RestController
@RequestMapping(value = "/api-perfil")
public class PerfilController {

	@Autowired
	PerfilService proxyPerfil;
	
	@GetMapping(value =  "/buscaperfil/{id}")
	public PerfilDTO buscaPerfil(@PathVariable int id) {
		return proxyPerfil.perfilBuscaIDService(id);
	}
	
}
