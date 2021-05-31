package com.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clinicamedica.dto.clienteparticularDTO;

@Repository
public interface ClienteParticularRepository extends JpaRepository<clienteparticularDTO, Integer> {

	clienteparticularDTO findById(int id);
	clienteparticularDTO save(int id);
	
	 @Query(value = "SELECT b from clienteparticularDTO b WHERE b.nome_comp like %:nomeCompleto%")
	 public List<clienteparticularDTO> buscaPorLike(String nomeCompleto);
}
