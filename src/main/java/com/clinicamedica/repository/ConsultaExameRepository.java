package com.clinicamedica.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinicamedica.dto.ConsultaExameDTO;

@Repository
public interface ConsultaExameRepository extends JpaRepository<ConsultaExameDTO, Integer> {

	ConsultaExameDTO findById(int id);
	ConsultaExameDTO save(int id);
	
	@Query(value = "SELECT c from ConsultaExameDTO c")
    List<ConsultaExameDTO> buscaConsulta();
	
//	@Query(value = "SELECT b from ConsultaDTO b WHERE b.data_consulta BETWEEN :inicial and :fim order by b.data_consulta")
//    public List<ConsultaDTO> buscaData(Date inicial, Date fim);
	
	@Query(value = "SELECT c from ConsultaExameDTO c INNER JOIN c.clienteparticular p "
			+ "WHERE c.clienteparticular.idclienteparticular = :id and c.data_consulta BETWEEN :inicial and :fim order by c.data_consulta")
    List<ConsultaExameDTO> buscaConsultaData(int id,Date inicial, Date fim);
	
	@Query(value = "SELECT c from ConsultaExameDTO c INNER JOIN c.medico m INNER JOIN c.beneficiario b "
			+ "WHERE b.idbenef = :id")
    List<ConsultaExameDTO> buscaConsultaID(int id);
	
	@Query(value = "SELECT c from ConsultaExameDTO c INNER JOIN c.medico m INNER JOIN c.beneficiario b "
			+ "WHERE c.data_consulta BETWEEN :dtinicio AND :dtfim order by c.data_consulta")
    List<ConsultaExameDTO> buscaConsultaIdDate(@Param("dtinicio") Date dtinicio,@Param("dtfim") Date dtfim);
	
	@Query(value = "SELECT c from ConsultaExameDTO c INNER JOIN c.medico m INNER JOIN c.clienteparticular p "
			+ "WHERE p.idclienteparticular = :id")
    List<ConsultaExameDTO> buscaConsultaIDParticular(int id);
	
}
