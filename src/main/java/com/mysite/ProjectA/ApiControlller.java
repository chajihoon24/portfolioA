package com.mysite.ProjectA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.ProjectA.DTO.FinalDTO;
import com.mysite.ProjectA.test.TestService;

@RestController
@RequestMapping("lab/api")
public class ApiControlller {
	
	@Autowired
	TestService testService;
	
	@GetMapping("/test")
	public List<FinalDTO> testAPI(){
		
		List<FinalDTO> data2 = testService.jsonService2();
				
		return data2;
	}
	

}
