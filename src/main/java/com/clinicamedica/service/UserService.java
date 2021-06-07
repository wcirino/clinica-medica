package com.clinicamedica.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.clinicamedica.security.UusuarioSecurity;

public class UserService {
	
	public static UusuarioSecurity authenticated() {
		try {
			return (UusuarioSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch (Exception e) {
			return null;
		}  
	}

}
