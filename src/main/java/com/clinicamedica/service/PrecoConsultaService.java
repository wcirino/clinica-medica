package com.clinicamedica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicamedica.dto.PrecoConsultaDTO;
import com.clinicamedica.exception.ServiceBaseException;
import com.clinicamedica.repository.PrecoConsultaRepository;

@Service
public class PrecoConsultaService {

	@Autowired
	private PrecoConsultaRepository proxyPreco;
	
	public PrecoConsultaDTO findByIDService(int id) {
		Optional<PrecoConsultaDTO> obj = Optional.ofNullable(proxyPreco.findById(id));
		return obj.orElseThrow(() -> new ServiceBaseException(
				"Erro com o ID: "+id+", tipo : "+PrecoConsultaService.class.getName()));  
	}
	
	public PrecoConsultaDTO alteraPrecoService(PrecoConsultaDTO obj) {
		try {
			if (!proxyPreco.existsById(obj.getIdpreco())) {
				PrecoConsultaDTO prec = proxyPreco.save(obj);
				return prec;
			} else
				throw new ServiceBaseException("Erro ao tentar alterar preço");
		} catch (Exception e) {
			throw new ServiceBaseException("Erro ao tentar alterar preço");
		}
	}
	
}
