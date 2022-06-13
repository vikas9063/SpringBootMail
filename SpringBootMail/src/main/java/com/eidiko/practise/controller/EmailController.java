package com.eidiko.practise.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eidiko.practise.service.EmailService;
import com.eidiko.practise.service.FileEmailService;

@Controller
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private FileEmailService fileEmailService;

	@GetMapping("/")
	public String sendMail() {

		return "index";
	}

	@PostMapping("/send-mail")
	public String sendMailJava(@RequestParam("toemail") String toemail, @RequestParam("subject") String subject,
			@RequestParam("body") String body, HttpSession httpSession) {

		// check values are coming or not
		System.out.println(toemail + " " + subject + " " + body);
		try {

			if (toemail == null) {
				throw new Exception("email is not entered....!");
			}

			this.emailService.sendMail(toemail, subject, body);

			httpSession.setAttribute("message", "message sent successfully.....!");

			System.out.println("sent.........!");

		} catch (Exception e) {

			httpSession.setAttribute("message", "Oops something went wrong try again....!" + e.getMessage());

		}

		return "index";
	}

	@PostMapping("/send-mailwithfile")
	public String sendEmailWithFile(@RequestParam("toemail") String toemail, @RequestParam("subject") String subject,
			@RequestParam("body") String body, @RequestParam("attachedfile") File file) {

		System.out.println(file);
		//here we are gettting the file from html
		
		this.fileEmailService.sendMailWithAtttachment(toemail, subject, body, file, file.getName());
		
		System.out.println("sent");
		
		return "index";
	}

}
