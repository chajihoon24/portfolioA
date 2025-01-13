package com.mysite.ProjectA.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@PostMapping("/lab/emailForm")
	public String emailForm(String to,Model model) {
		
		emailService.sendEmail(to);
		model.addAttribute("to",to);

		
		return "emailResult";
	};
	

}
