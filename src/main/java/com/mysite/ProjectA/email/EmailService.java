package com.mysite.ProjectA.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	
    public void sendEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        
        String subject = "이메일 보내기 예제";
        String body = "이메일을 보내기 성공";
        
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        
        mailSender.send(message);
    }	
	
	
	

}
