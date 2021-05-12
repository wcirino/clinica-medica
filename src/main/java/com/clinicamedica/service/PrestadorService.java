package com.clinicamedica.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.clinicamedica.repository.prestadoresRepository;
import com.clinicamedica.dto.MedicoResponseDTO;
import com.clinicamedica.dto.PrestadorAcessoDTO;
import com.clinicamedica.dto.PrestadorDTO;
import com.clinicamedica.dto.medicoDTO;
import com.clinicamedica.entity.PrestadorAcessoPerfil;
import com.clinicamedica.entity.perfil_acesso;

@Service
public class PrestadorService {


	@Autowired
	private prestadoresRepository proxyPrestador;
	
	@Autowired
	private PerfilAcessoService proxyPerfilAcesso;
	
	@Autowired
	private ModelMapper modelMapper;
	
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
	 
	public List<PrestadorAcessoPerfil> buscaPrestadorLoginService(String login){
		return PrestadorModelMapperList(proxyPrestador.findByLoginPrestador(login));
	}
	
	public List<perfil_acesso> buscaPrestadorLoginParaPerfilService(String login){
		int id;
		List<PrestadorAcessoPerfil> lista = PrestadorModelMapperList(proxyPrestador.findByLoginPrestador(login));
		if(lista != null) {
			id = lista.get(0).getIdprestador();
			return proxyPerfilAcesso.buscaNivelAcessoList(id);
		}
		return null;
	}
	
	private PrestadorAcessoPerfil PrestadormodelMapperOne(PrestadorAcessoDTO dto) {
		PrestadorAcessoPerfil pap = modelMapper.map(dto, PrestadorAcessoPerfil.class);
		return pap;
	}
	
	private List<PrestadorAcessoPerfil> PrestadorModelMapperList(List<PrestadorAcessoDTO> dto){
		  return dto.stream().map(obj -> PrestadormodelMapperOne(obj)).collect(Collectors.toList());
	}

}
