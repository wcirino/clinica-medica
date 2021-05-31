package com.clinicamedica.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinicamedica.dto.BeneficiarioDTO;

@Repository
public interface BeneficiarioRepository extends JpaRepository<BeneficiarioDTO,Integer> {

	BeneficiarioDTO findById(int id);
	BeneficiarioDTO save(int id);
		
    @Query(value = "SELECT b from BeneficiarioDTO b WHERE b.nome_comp like %:nomeCompleto%")
    public List<BeneficiarioDTO> buscaPorLike(String nomeCompleto);
	
    @Transactional
    @Modifying
	@Query(value = "update BeneficiarioDTO b set b.ativo = :flag where b.idbenef = :id")
	public void desativarAtivaBeneficiario(@Param("id") int id, @Param("flag") String flag);
	
}
