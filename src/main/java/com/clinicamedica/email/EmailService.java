package com.clinicamedica.email;

import org.springframework.mail.SimpleMailMessage;

import com.clinicamedica.dto.DadosParaEmailDTO;

public interface EmailService {

	void sendorderConfirmationEmail(DadosParaEmailDTO obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
