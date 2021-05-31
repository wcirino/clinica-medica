package com.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicamedica.dto.PrecoConsultaDTO;

@Repository
public interface PrecoConsultaRepository extends JpaRepository<PrecoConsultaDTO, Integer>{

	PrecoConsultaDTO findById(int id);
	PrecoConsultaDTO save(int id);
	
}
