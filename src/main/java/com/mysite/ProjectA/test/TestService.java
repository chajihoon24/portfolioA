package com.mysite.ProjectA.test;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TestService {
	
	public JsonDTO jsonService() {
		
		String jsonData ="""
				{
					"name" : "jihoon",
					"age" : 12
				}
				
				""";
		JsonDTO data = new JsonDTO();
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			data = objectMapper.readValue(jsonData, JsonDTO.class);
			System.out.println("name :" + data.getName());
			System.out.println("age :" + data.getAge());
		}catch(Exception e) {
			System.out.println("error :"+ e);
		}
		
		return data;		
	}
}
