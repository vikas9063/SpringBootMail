package com.eidiko.practise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
@ComponentScan(basePackages = "com.eidiko.practtise")
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private SimpleMailMessage configuration;

	public void sendMail(String to, String subject, String body) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);

		this.javaMailSender.send(mailMessage);

	}

	public void sendPreConfiguredMail(String message) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage(configuration);
		
		mailMessage.setText(message);
		
		javaMailSender.send(mailMessage);
		
	}
	
}
