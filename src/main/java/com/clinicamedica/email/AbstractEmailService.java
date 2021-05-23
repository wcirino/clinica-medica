package com.clinicamedica.email;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.clinicamedica.dto.DadosParaEmailDTO;

public abstract class AbstractEmailService implements EmailService  {

	@Value("${default.sender}")
	String send;
	
	@Override
	public void sendorderConfirmationEmail(DadosParaEmailDTO obj) {
		SimpleMailMessage sm = prepareSimplMailMessegeFromEmail(obj);
		sendEmail(sm);
	}
	
	protected SimpleMailMessage prepareSimplMailMessegeFromEmail(DadosParaEmailDTO obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(send);
		sm.setSubject(obj.getAssunto());
		sm.setSentDate(obj.getDate());
		sm.setText(obj.getAssunto());
		return sm;
		
	}
}
