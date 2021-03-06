package com.clinicamedica.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.clinicamedica.dto.PrestadorAcessoDTO;
import com.clinicamedica.dto.PrestadorDTO;
import com.clinicamedica.dto.PrestadorLoginDTO;

public interface prestadoresRepository extends JpaRepository<PrestadorDTO,Integer> {
	
	PrestadorDTO findById(int id);
    PrestadorDTO save(int id);
    PrestadorDTO findByLogin(String login);
    PrestadorDTO findBycpf(String cpf);
    PrestadorLoginDTO save(PrestadorLoginDTO dto);
    
    @Query(value = "SELECT p from PrestadorAcessoDTO p INNER JOIN p.login l WHERE l.login.login = :login ")
    List<PrestadorAcessoDTO> findByLoginPrestador(@Param("login") String login);
    
    
    @Transactional
    @Modifying
    @Query(value = "update PrestadorDTO p set p.ativo = :flag where p.idprestador = :id")
    void DesativarPrestador(@Param("flag") String flag, @Param("id") int id);
    
   // @Modifying
   // @Query(value = "insert into PrestadorDTO  (idlogin,nome_comp, cpf, data_nasc,data_admissao,sexo,idsetor,telefone,idestado) values (:idlogin, :nome_comp, :cpf, :data_nasc,:data_admissao,:sexo,:idsetor,:telefone,:idestado)")
   // void inserirPrestador( @Param("idlogin") int idlogin,  @Param("nome_comp") String nome_comp,  @Param("cpf") String cpf, @Param("data_nasc") Date data_nasc, @Param("data_admissao") Date data_admissao,
    					  // @Param("sexo") int sexo, @Param("idsetor") int idsetor, @Param("telefone") String telefone, @Param("idestado") int idestado);
   
    //"SELECT u from PerfilAcessoDTO u WHERE u.prestador.idprestador = :id")
    //SELECT c, p.name FROM Country c JOIN c.capital p
    //SELECT c1, c2 FROM Country c1 INNER JOIN c1.neighbors c2
    //SELECT c1, c2 FROM Country c1, Country c2 WHERE c2 MEMBER OF c1.neighbors
    //SELECT c.name, p.name FROM Country c JOIN c.capital p
    //SELECT a, p FROM Author a JOIN a.publications p ON p.publishingDate > ?1

}
