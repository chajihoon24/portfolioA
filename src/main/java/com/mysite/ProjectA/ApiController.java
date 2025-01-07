package com.mysite.ProjectA;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mysite.ProjectA.DTO.FinalDTO;
import com.mysite.ProjectA.test.TestService;
@RestController
@RequestMapping("lab/api")
public class ApiController {
	
	@Autowired
	TestService testService;
	
	@GetMapping("/test")
	public List<FinalDTO> testAPI(@RequestParam(name = "count", defaultValue = "10") int count){
		
		List<FinalDTO> data2 = testService.jsonService2();
		
		List<FinalDTO> subList = data2.stream()
                 .limit(count) 
                 .collect(Collectors.toList());
				
		return subList;
	}
	
}