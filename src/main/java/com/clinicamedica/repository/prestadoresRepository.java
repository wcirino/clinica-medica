package com.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.clinicamedica.dto.PrestadorAcessoDTO;
import com.clinicamedica.dto.PrestadorDTO;
import com.clinicamedica.dto.medicoDTO;


public interface prestadoresRepository extends JpaRepository<PrestadorDTO,Integer> {
	
	PrestadorDTO findById(int id);
    PrestadorDTO save(int id);
    PrestadorDTO findByLogin(String login);
    
    @Query(value = "SELECT p from PrestadorAcessoDTO p INNER JOIN p.login l WHERE l.login.login = :login ")
    List<PrestadorAcessoDTO> findByLoginPrestador(@Param("login") String login);
    
    //"SELECT u from PerfilAcessoDTO u WHERE u.prestador.idprestador = :id")
    //SELECT c, p.name FROM Country c JOIN c.capital p
    //SELECT c1, c2 FROM Country c1 INNER JOIN c1.neighbors c2
    //SELECT c1, c2 FROM Country c1, Country c2 WHERE c2 MEMBER OF c1.neighbors
    //SELECT c.name, p.name FROM Country c JOIN c.capital p
    //SELECT a, p FROM Author a JOIN a.publications p ON p.publishingDate > ?1

}
