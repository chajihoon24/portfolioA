package com.mysite.ProjectA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.ProjectA.DTO.ResponseDTO;
import com.mysite.ProjectA.test.JsonDTO;


@SpringBootTest
class ProjectAApplicationTests {
	
	@Value("${file.upload-dir}")
	String uploadPath;
	
	@Value("${test.jihoon}")
	String test;
	
	
	@Test
	void contextLoads() {
		System.out.println(uploadPath);
		System.out.println(test);
		
	}
	
	@Test
	void test2() {

	}

}
