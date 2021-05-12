package com.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinicamedica.dto.LoginDTO;
import com.clinicamedica.dto.PerfilAcessoDTO;

@Repository
public interface PerfilAcessoRepository extends JpaRepository<PerfilAcessoDTO, Integer> {

	PerfilAcessoDTO findById(int id);
	
    PerfilAcessoDTO save(int id);
    
    @Query(value = "SELECT u from PerfilAcessoDTO u WHERE u.prestador.idprestador = :id")
    List<PerfilAcessoDTO> findByPrestadorId(@Param("id") int id);  
    
 

	
}
