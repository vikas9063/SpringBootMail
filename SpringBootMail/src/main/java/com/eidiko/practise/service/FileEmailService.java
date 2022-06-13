package com.eidiko.practise.service;

import java.io.File;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.com.eidiko.practise")
public class FileEmailService {

	@Autowired
	private JavaMailSender mailsender;

	public void sendMailWithAtttachment(String toemail, String subject, String body, File file, String filename) {

		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				mimeMessage.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(toemail));
				mimeMessage.setFrom(new InternetAddress("vikaskumar14333@gmail.com"));
				mimeMessage.setSubject(subject);
				mimeMessage.setText(body);

				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

				helper.addAttachment(filename, file);
			}
		};
		try {

			mailsender.send(messagePreparator);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
