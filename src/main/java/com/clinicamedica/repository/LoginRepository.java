package com.clinicamedica.repository;

import com.clinicamedica.dto.LoginDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginDTO, Integer> {
	
	LoginDTO findById(int id);
    LoginDTO save(int id);
    LoginDTO findByLogin(String login);
    LoginDTO findByEmail(String email);
}
