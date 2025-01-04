package com.mysite.ProjectA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.ProjectA.DTO.CustomData;
import com.mysite.ProjectA.service.Mainservice;
import com.mysite.ProjectA.test.JsonDTO;
import com.mysite.ProjectA.test.TestService;

import groovyjarjarantlr4.v4.codegen.model.TestSetInline;

@Controller
public class MainController {
	
	@Autowired
	Mainservice mainservice;
	@Autowired
	TestService testService;
	
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
	
	//========================================================================
	@GetMapping("/lab")
	public String lab() {
		return"generalPage/lab";
	}
	@GetMapping("lab/jsWork")
	public String jsWork() {
		return "generalPage/jsWork";
	}
	@GetMapping("/lab/weather")
	public String weather(@RequestParam("city") String city, Model model) {
		List<CustomData> weatherDataList=mainservice.WeatherService(city);
		model.addAttribute("weatherData", weatherDataList);
		
		return"generalPage/weather";
	}
	@GetMapping("/lab/jsonPractice")
	public String jsonPractice() {
		return "generalPage/jsonPractice";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		JsonDTO data =testService.jsonService();
		model.addAttribute("data",data);
		return "generalPage/test";
	}
	//test
}
