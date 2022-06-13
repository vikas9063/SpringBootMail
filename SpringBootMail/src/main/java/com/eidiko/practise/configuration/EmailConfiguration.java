package com.eidiko.practise.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class EmailConfiguration {

	
//	we are creating one bean that is returning SimpleMail message and takes the following input
	
	
	@Bean
	public SimpleMailMessage emailTemplate() {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo("rvickyyy@gmail.com");
		mailMessage.setFrom("rvickyyy@gmail.com");
		mailMessage.setSubject("Important Email");
		mailMessage.setText("kya huaaa kaam ho gaya kyaaa");

		return mailMessage;

	}

}
