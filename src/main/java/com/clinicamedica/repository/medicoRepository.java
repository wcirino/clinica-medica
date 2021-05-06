package com.clinicamedica.repository;

import com.clinicamedica.dto.medicoDTO;
import  org.springframework.data.jpa.repository.JpaRepository ;
import org.springframework.stereotype.Repository;

@Repository
public interface medicoRepository extends JpaRepository<medicoDTO,Integer> {
	
	medicoDTO findById(int id);
    medicoDTO save(int id);
}
