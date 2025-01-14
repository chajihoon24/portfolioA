package com.mysite.ProjectA.photos;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PhotosDTO {
	
	private Long id;
	
	private String title;
	
	private String imageUrl;
	
	private Date uploaddate;

}
