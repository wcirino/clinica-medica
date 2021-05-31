package com.clinicamedica.email;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.clinicamedica.dto.DadosParaEmailDTO;

public interface EmailService {

	void sendorderConfirmationEmail(DadosParaEmailDTO obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(DadosParaEmailDTO obj, String pathHTML);
	
	void sendHtmlEmail(MimeMessage msg);
	
}
