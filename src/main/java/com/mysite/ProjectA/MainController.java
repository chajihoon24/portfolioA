package com.mysite.ProjectA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mysite.ProjectA.DTO.ResponseWrapperDTO;
import com.mysite.ProjectA.service.Mainservice;

@Controller
public class MainController {
	
	@Autowired
	Mainservice mainservice;
	
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
	@GetMapping("lab/jsWork")
	public String jsWork() {
		mainservice.WeatherService();
		return "generalPage/jsWork";
	}
	@GetMapping("/lab/weather")
	public String weather(Model model) {
		ResponseWrapperDTO weatherData=mainservice.WeatherService();
		model.addAttribute("weatherDataList", weatherData.getResponse().getBody().getItems().getItem());
		
		return"generalPage/weather";
	}
	//test
}
