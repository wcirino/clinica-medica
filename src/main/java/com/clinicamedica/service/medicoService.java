package com.clinicamedica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicamedica.dto.medicoDTO;
import com.clinicamedica.repository.medicoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.plaf.metal.MetalDesktopIconUI;

@Service
public class medicoService {

	@Autowired
	private medicoRepository proxyMedico;

	public List<medicoDTO> BuscaMedico() {
		List<medicoDTO> dto = new ArrayList<>();
		dto = proxyMedico.findAll();
		return dto;
	}
	
	public medicoDTO buscaMedicoById(int id) {
		medicoDTO dto = proxyMedico.findById(id);
		return dto;
	}
	
	public medicoDTO buscaSalvar(medicoDTO dto) {
		medicoDTO obj = proxyMedico.save(dto);
		return obj;
	}
	
	public medicoDTO alterarMedico(medicoDTO obj) {
		return proxyMedico.save(obj);
	}

	public int deleteMedica(int id) {
		try {
			proxyMedico.deleteById(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
