package com.clinicamedica.repository;

import com.clinicamedica.dto.medicoDTO;

import java.util.List;

import javax.transaction.Transactional;

import  org.springframework.data.jpa.repository.JpaRepository ;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface medicoRepository extends JpaRepository<medicoDTO,Integer> {
	
	medicoDTO findById(int id);
    medicoDTO save(int id);
    List<medicoDTO> findBynomeCompletoLike(String nomeCompleto);
    
    @Query(value = "SELECT u from medicoDTO u WHERE u.nomeCompleto like %:nomeCompleto%")
    List<medicoDTO> buscaPorLike(String nomeCompleto);
    
    @Transactional
    @Modifying
    @Query(value = "update medicoDTO p set p.ativo = :flag where p.idmedico = :id")
    void desativarAtivaMedico(@Param("id") int id, @Param("flag") String flag);
    
}
