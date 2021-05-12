package com.clinicamedica.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicamedica.dto.MedicoResponseDTO;
import com.clinicamedica.dto.medicoDTO;
import com.clinicamedica.repository.medicoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.plaf.metal.MetalDesktopIconUI;

@Service
public class medicoService {

	@Autowired
	private medicoRepository proxyMedico;
	
	@Autowired
	private ModelMapper modelMapper;

	public List<medicoDTO> BuscaMedico() {
		List<medicoDTO> dto = new ArrayList<>();
		dto = proxyMedico.findAll();
		return dto;
	}
	
	public List<MedicoResponseDTO> BuscaMedicoModelMapperListService() {
        List<MedicoResponseDTO> obj = this.MedicoModelMapperList(proxyMedico.findAll());
		return obj;
	}
	
	public MedicoResponseDTO buscaMedicoModelMapperOneService(int id) {
		MedicoResponseDTO obj = this.MedicoModelMapperOne(proxyMedico.findById(id));
		return obj;
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
	   if(proxyMedico.existsById(obj.getIdmedico())) {
		return proxyMedico.save(obj);
	   }
	   else
		   return null;
	}

	public int deleteMedica(int id) {
		try {
			proxyMedico.deleteById(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	private MedicoResponseDTO MedicoModelMapperOne(medicoDTO medico){
		return  modelMapper.map(medico, MedicoResponseDTO.class);
		
     }
	
	private List<MedicoResponseDTO> MedicoModelMapperList(List<medicoDTO> dto){

		  return dto.stream().map(obj -> MedicoModelMapperOne(obj)).collect(Collectors.toList());
	}
	
	
}
