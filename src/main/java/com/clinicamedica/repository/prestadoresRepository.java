package com.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicamedica.dto.PrestadorDTO;
import com.clinicamedica.dto.medicoDTO;


public interface prestadoresRepository extends JpaRepository<PrestadorDTO,Integer> {
	
	PrestadorDTO findById(int id);
    PrestadorDTO save(int id);
    PrestadorDTO findByLogin(String login);
}
