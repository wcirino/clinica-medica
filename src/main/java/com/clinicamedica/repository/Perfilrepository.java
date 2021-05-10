package com.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicamedica.dto.PerfilDTO;

public interface Perfilrepository extends JpaRepository<PerfilDTO, Integer> {

	PerfilDTO findById(int id);
	PerfilDTO save(int id);
	
}
