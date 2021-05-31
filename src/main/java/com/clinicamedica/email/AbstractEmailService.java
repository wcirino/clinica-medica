package com.clinicamedica.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.clinicamedica.dto.DadosParaEmailDTO;

public abstract class AbstractEmailService implements EmailService  {

	@Value("${default.sender}")
	String send;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javamailSender;
	
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
		sm.setText(obj.getMsg());
		return sm;
		
	}
	
	public void sendOrderConfirmationHtmlEmail(DadosParaEmailDTO obj,String pathHTML) {
		try {
			MimeMessage mm = prepareMimeMessageFromHTML(obj,pathHTML);
			sendHtmlEmail(mm);
		} catch (MessagingException e) {
			sendorderConfirmationEmail(obj);
		}
	}
	
	private MimeMessage prepareMimeMessageFromHTML(DadosParaEmailDTO obj,String pathHTML) throws MessagingException {
		MimeMessage mimeMessage = javamailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(obj.getEmail());
		mmh.setFrom(send);
		mmh.setSubject(obj.getAssunto());
		mmh.setSentDate(obj.getDate());
		mmh.setText(htmlFromTemplateHTML(obj,pathHTML),true);
		return mimeMessage;
	}

	protected String htmlFromTemplateHTML(DadosParaEmailDTO obj,String pathHTML) {
	
		Context context = new Context();
		context.setVariable("dadosEmail", obj);
		return templateEngine.process(pathHTML, context);
		
	}
}
