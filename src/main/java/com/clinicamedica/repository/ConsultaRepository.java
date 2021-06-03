package com.clinicamedica.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinicamedica.dto.ConsultaDTO;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaDTO, Integer> {

	ConsultaDTO findById(int id);
	ConsultaDTO save(int id);
			
	@Transactional
	@Modifying
	@Query(value = "update ConsultaDTO b set b.statusConsulta = :flag where b.idconsulta = :id")
	public void statusDaConsultaDTO(@Param("id") int id, @Param("flag") String flag);
	
	@Query(value = "SELECT b from ConsultaDTO b WHERE b.data_consulta BETWEEN :inicial and :fim order by b.data_consulta")
    public List<ConsultaDTO> buscaData(Date inicial, Date fim);
	
}
