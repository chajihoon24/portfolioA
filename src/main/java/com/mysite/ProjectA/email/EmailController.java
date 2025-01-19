package com.mysite.ProjectA.email;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.internet.InternetAddress;


@RestController
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@PostMapping("/lab/emailForm")
	public EmailResponseDTO emailForm(@RequestBody EmailDTO emaildto, BindingResult result, Model model) {
		System.out.println("controller 진입");
		
		if (isValidEmail(emaildto.getEmail())){
			
		
		model.addAttribute("email", emaildto.getEmail());
		emailService.sendEmail(emaildto.getEmail());
		System.out.println("로직 성공");
	
		EmailResponseDTO emailResponseDTO = new EmailResponseDTO();
		emailResponseDTO.setUrl("/lab/emailResult?email=" + emaildto.getEmail());
		return emailResponseDTO;
		}else {
			EmailResponseDTO emailResponseDTO = new EmailResponseDTO();
			emailResponseDTO.setUrl("/lab/emailResult?email=" + "error");
			return emailResponseDTO;
			
		}

	};
	
	public boolean isValidEmail(String email) {
	    try {
	        InternetAddress emailAddr = new InternetAddress(email);
	        emailAddr.validate();  // 유효성 검사
	        return true;
	    } catch (Exception ex) {
	        return false;
	    }
	}
}
	


