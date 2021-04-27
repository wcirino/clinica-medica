package com.clinicamedica.repository;

import com.clinicamedica.dto.medicoDTO;
import  org.springframework.data.jpa.repository.JpaRepository ;
import  org.springframework.stereotype.Repository ;
import  org.springframework.web.bind.annotation.RestController ;

public interface medicoRepository extends JpaRepository<medicoDTO,Integer> {
	
	medicoDTO findById(int id);
    medicoDTO save(int id);
}
