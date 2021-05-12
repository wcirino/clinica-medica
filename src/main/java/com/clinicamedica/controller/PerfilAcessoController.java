package com.clinicamedica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicamedica.dto.PerfilAcessoDTO;
import com.clinicamedica.entity.perfil_acesso;
import com.clinicamedica.service.PerfilAcessoService;

@RestController
@RequestMapping(value = "/api-perfil-acesso")
public class PerfilAcessoController {
	
	@Autowired
	private PerfilAcessoService proxyperfil;

	@GetMapping(value = "/buscaPerfilAcessoAll")
	public List<PerfilAcessoDTO> buscaPerfilAcessoAll(){
		return proxyperfil.buscaPerfilAcessoAll(1);
	}
	
	@GetMapping(value = "/buscaPerfilAcessoPrestador/{id}")
	public List<PerfilAcessoDTO> buscaPerfilAcessoPrestador(@PathVariable int id){
		return proxyperfil.buscaPerfilAcessoId(id);
	}
	
	@GetMapping(value = "/v2/buscaPerfilAcessoPrestador/{id}")
	public List<perfil_acesso> buscaPerfilAcessoPrestadorNew(@PathVariable int id){
		//perfil_acesso dto = dto.getPrestador().getIdlogin().getIdlogin()
		return proxyperfil.buscaNivelAcessoList(id);
	}
	

}
