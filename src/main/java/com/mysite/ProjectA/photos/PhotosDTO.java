package com.mysite.ProjectA.photos;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PhotosDTO {
	
	private Long id;
	
	private String title;
	
	private String imageUrl;
	
	private LocalDateTime uploadDate;

}
