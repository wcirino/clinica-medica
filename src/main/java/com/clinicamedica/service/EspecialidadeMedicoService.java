package com.clinicamedica.service;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicamedica.controller.MedicoController;
import com.clinicamedica.dto.EspecialistaDTO;
import com.clinicamedica.exception.ServiceBaseException;
import com.clinicamedica.repository.EspecialidadeMedicoRepository;

@Service
public class EspecialidadeMedicoService {
	
	@Autowired
	private EspecialidadeMedicoRepository proxyEspec;
	
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(MedicoController.class);
	
	public EspecialistaDTO findByIdService(int id) {
		Optional<EspecialistaDTO> obj = Optional.ofNullable(proxyEspec.findById(id));
		return obj.orElseThrow(() -> new ServiceBaseException(
				"Erro com o ID: "+id+", tipo : "+EspecialistaDTO.class.getName()));  
	}
	
	public List<EspecialistaDTO> findAllService(){
		Optional<List<EspecialistaDTO>> obj = Optional.ofNullable(proxyEspec.findAll());
		return obj.orElseThrow(() -> new ServiceBaseException("Erro  na importação dos beneficiario"));
	}
	
	public List<EspecialistaDTO> findlikeService(String nome){
		Optional<List<EspecialistaDTO>> obj =Optional.ofNullable(proxyEspec.buscaPorLike(nome));
		return obj.orElseThrow(() -> new ServiceBaseException("Erro no FindlikeService parametro :" +nome));
	}
	
	public EspecialistaDTO InserirEspec(EspecialistaDTO dto) {
		try {
			log.info("Inserir Beneficiario");
			EspecialistaDTO esp = proxyEspec.save(dto);
			return esp;
		}catch (Exception e) {
			log.info("Erro : "+e.getMessage());
			throw new ServiceBaseException("Ocorreu um erro no InserirClientePart");
		}
		
	}
	
	public EspecialistaDTO UpdateEsp(EspecialistaDTO dto) {
		try {
			log.info("update UpdateBeneficiario");
			if(!proxyEspec.existsById(dto.getIdespecialidade())) {
				EspecialistaDTO esp = proxyEspec.save(dto);
				return esp;
			}
			else
			  throw new ServiceBaseException("Ocorreu um erro no InserirClientePart");
				
		} catch (Exception e) {
			log.info("Erro : "+e.getMessage());
			throw new ServiceBaseException("Ocorreu um erro no UpdateClientePart");
		}
	}
	
	public void DesativaAtiva(int id, Integer status) {
		try {
			log.info("update DesativaAtivaBeneficiario");
			if (status.equals(1))
				proxyEspec.desativarAtiva(id, "A");
			else if (status.equals(2))
				proxyEspec.desativarAtiva(id, "D");
		} catch (Exception e) {
			log.info("Erro : " + e.getMessage());
			throw new ServiceBaseException("Ocorreu um erro no DesativaAtivaBeneficiario");
		}
	}

}
