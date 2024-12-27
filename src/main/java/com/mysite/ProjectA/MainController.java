package com.mysite.ProjectA;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String root() {
		return"generalPage/main";
	}
	@GetMapping("/main")
	public String Home(){		
		return "generalPage/main";
	}
	@GetMapping("/introduce")
	public String Introduce() {
		return "generalPage/introduce";
	}
	@GetMapping("/portfolio")
	public String Portfolio() {
		return"generalPage/portfolio";
	}
	@GetMapping("/about")
	public String About() {
		return"generalPage/about";
	}
	@GetMapping("/contact")
	public String Contact() {
		return"generalPage/contact";
	}
	@GetMapping("/lab")
	public String lab() {
		return"generalPage/lab";
	}
	//test
	
	
}
