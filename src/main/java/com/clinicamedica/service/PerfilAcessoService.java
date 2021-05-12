package com.clinicamedica.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicamedica.dto.MedicoResponseDTO;
import com.clinicamedica.dto.PerfilAcessoDTO;
import com.clinicamedica.dto.medicoDTO;
import com.clinicamedica.entity.perfil_acesso;
import com.clinicamedica.repository.PerfilAcessoRepository;

@Service
public class PerfilAcessoService {

	@Autowired
	private PerfilAcessoRepository proxyPerfil;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<PerfilAcessoDTO> buscaPerfilAcessoAll(int id){
		List<PerfilAcessoDTO> dto = proxyPerfil.findAll();
		return dto;
	}
	
	public  List<PerfilAcessoDTO> buscaPerfilAcessoId(int id){
		List<PerfilAcessoDTO> dto = proxyPerfil.findByPrestadorId(id);
		return dto;
	}
	
	public List<perfil_acesso> buscaNivelAcessoList(int id){
		List<perfil_acesso> lista = this.PerfilAcessoModelMapperList(proxyPerfil.findByPrestadorId(id));
		return lista;
	}
	
	private perfil_acesso PerfilAcessoModelMapperOne(PerfilAcessoDTO perfilAcesso){
		return  modelMapper.map(perfilAcesso, perfil_acesso.class);
	}
		
	private List<perfil_acesso> PerfilAcessoModelMapperList(List<PerfilAcessoDTO> perfilAcesso){
		return perfilAcesso.stream().map(obj -> PerfilAcessoModelMapperOne(obj)).collect(Collectors.toList());
	}
	
}
