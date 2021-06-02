package com.clinicamedica.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicamedica.dto.ConsultaDTO;
import com.clinicamedica.exception.ServiceBaseException;
import com.clinicamedica.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository proxyConsulta;
	
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(ConsultaService.class);
	
	public ConsultaDTO buscaConsultaServiceId(int id) {
		Optional<ConsultaDTO> obj = Optional.ofNullable(proxyConsulta.findById(id));
		return obj.orElseThrow(() -> new ServiceBaseException(
				"Erro com o ID: "+id+", tipo : "+ConsultaDTO.class.getName()));  
	}
	
	public List<ConsultaDTO> buscaConsultaServiceAll() {
		Optional<List<ConsultaDTO>> obj = Optional.ofNullable(proxyConsulta.findAll());
		return obj.orElseThrow(() -> new ServiceBaseException("Erro  na importação dos beneficiario"));
	}
	
	
	public ConsultaDTO AlterarConsultaService(ConsultaDTO obj) {
		if(!proxyConsulta.existsById(obj.getIdconsulta())) {
			return proxyConsulta.save(obj);
		}
		else {
			throw new ServiceBaseException("Erro na alteração da consulta;");
		}
	}
	
	public ConsultaDTO inserirServiceConsulta(ConsultaDTO obj) {
		return proxyConsulta.save(obj);
	}
	
	public List<ConsultaDTO> BuscarPorDataInicialFim(Date inicial, Date fim){
		Optional<List<ConsultaDTO>> obj = Optional.ofNullable(proxyConsulta.buscaData(inicial,fim));
		return obj.orElseThrow(() -> new ServiceBaseException("Erro  na importação dos beneficiario"));
	}
	
	public void statusConsultaService(int idconsulta, Integer status) {
			try {
				log.info("update DesativaAtivaBeneficiario");
				if (status.equals(1))
					proxyConsulta.statusDaConsultaDTO(idconsulta, "1");
				else if (status.equals(2))
					proxyConsulta.statusDaConsultaDTO(idconsulta, "2");
			} catch (Exception e) {
				log.info("Erro : " + e.getMessage());
				throw new ServiceBaseException("Ocorreu um erro no statusConsultaService");
			}
		}
	
}
