package com.mysite.ProjectA.DAO;




import com.mysite.ProjectA.DTO.TestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TestDAO {
	
	
		public TestDAO(TestDTO testDTO ){
			
			this.nameB = testDTO.getNameB();
			this.ageB = testDTO.getAgeB();
			
		};

	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    @Column(name = "nameB")
	    private String nameB;
	 
	    @Column(name = "ageB")
	    private int ageB;
	 
	    // 생성자, getter, setter 등 생략
	
}
