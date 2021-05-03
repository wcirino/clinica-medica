package com.clinicamedica.repository;

import com.clinicamedica.dto.medicoDTO;
import  org.springframework.data.jpa.repository.JpaRepository ;

public interface medicoRepository extends JpaRepository<medicoDTO,Integer> {
	
	medicoDTO findById(int id);
    medicoDTO save(int id);
}
