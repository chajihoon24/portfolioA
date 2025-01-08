package com.mysite.ProjectA;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.ProjectA.DAO.TestDAO;
import com.mysite.ProjectA.DTO.FinalDTO;
import com.mysite.ProjectA.service.TestCRUDService;
import com.mysite.ProjectA.test.TestService;
@RestController
@RequestMapping("lab/api")
public class ApiController {
	
	@Autowired
	TestService testService;
	@Autowired
	TestCRUDService testCRUDService;
	
	@GetMapping("/test")
	public List<FinalDTO> testAPI(@RequestParam(name = "count", defaultValue = "10") int count){
		
		List<FinalDTO> data2 = testService.jsonService2();
		
		List<FinalDTO> subList = data2.stream()
                 .limit(count) 
                 .collect(Collectors.toList());
				
		return subList;
	}
	
	@GetMapping("/basicCRUD")
	public List<TestDAO> basicCRUD(Model model) {
		List<TestDAO> data=testCRUDService.getAll();
		
		return data;
	}
	@DeleteMapping("/basicCRUD/indi_del/{id}")
	public ResponseEntity<String> indi_del(@PathVariable(name="id") long id) {
	    testCRUDService.deleteById(id);
	    return ResponseEntity.status(HttpStatus.CREATED).body("User deleted successfully");
	}
	@DeleteMapping("/basicCRUD/all_del")
	public ResponseEntity<String> all_del() {
	    testCRUDService.deleteAll();
	    return ResponseEntity.status(HttpStatus.CREATED).body("User deletedAll successfully");
	}
	
}