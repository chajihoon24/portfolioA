package com.mysite.ProjectA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.ProjectA.DAO.TestDAO;
import com.mysite.ProjectA.DTO.TestDTO;

public interface TestDTORepository extends JpaRepository<TestDAO, Long>{
	
	TestDAO findByNameB(String name);

}