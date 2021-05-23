package com.clinicamedica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.clinicamedica.email.EmailService;
import com.clinicamedica.email.MockEmailService;
import com.clinicamedica.email.SmtpEmailService;

@Configuration
public class EmailConfig {

	//@Bean
	//public EmailService emailService() {
		//return new MockEmailService();
	//}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
	
	
}
