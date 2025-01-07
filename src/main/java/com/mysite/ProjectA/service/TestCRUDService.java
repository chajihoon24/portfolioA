package com.mysite.ProjectA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mysite.ProjectA.DAO.TestDAO;
import com.mysite.ProjectA.DTO.TestDTO;
import com.mysite.ProjectA.repository.TestDTORepository;

import jakarta.annotation.PostConstruct;

@Service
public class TestCRUDService {

	@Autowired
	TestDTORepository testDTORepository;

	public void add(TestDTO testDTO) {

		TestDAO testDAO = new TestDAO(testDTO);
		testDTORepository.save(testDAO);

	}

	@PostConstruct
	public void init() {

		TestDAO testDAO = new TestDAO();
		// 기본 샘플 데이터가 존재하지 않으면 추가
		if (testDTORepository.count() == 0) {

			testDAO.setNameB("sample");
			testDAO.setAgeB(24);

			testDTORepository.save(testDAO);
		}

	}

	public List<TestDAO> getAll() {

		List<TestDAO> data = testDTORepository.findAll();
		return data;
	}
	
	public void deleteAll() {
		testDTORepository.deleteAll();
	}
	public void deleteById(long id) {
		testDTORepository.deleteById(id);
	}

}
