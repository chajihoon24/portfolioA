package com.mysite.ProjectA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mysite.ProjectA.DAO.TestDAO;
import com.mysite.ProjectA.DTO.TestDTO;
import com.mysite.ProjectA.repository.TestDTORepository;

@Service
public class TestCRUDService {

	@Autowired
	TestDTORepository testDTORepository;
	
	
	public void add(TestDTO testDTO) {
		
		TestDAO testDAO = new TestDAO(testDTO);
		testDTORepository.save(testDAO);
		
		
	}
	
	
}
