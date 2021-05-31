package com.clinicamedica.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinicamedica.dto.EspecialistaDTO;
@Repository
public interface EspecialidadeMedicoRepository extends JpaRepository<EspecialistaDTO, Integer> {

	EspecialistaDTO findById(int id);
	EspecialistaDTO save(int id);
	
	 @Query(value = "SELECT b from EspecialistaDTO b WHERE b.especialidade like %:nomeCompleto%")
	 public List<EspecialistaDTO> buscaPorLike(String nomeCompleto);
	 
	 @Transactional
	 @Modifying
     @Query(value = "update EspecialistaDTO b set b.ativa = :flag where b.idespecialidade = :id")
	 public void desativarAtiva(@Param("id") int id, @Param("flag") String flag);
		
}
