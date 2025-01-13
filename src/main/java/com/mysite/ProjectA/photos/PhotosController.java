package com.mysite.ProjectA.photos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/photos")
public class PhotosController {
	
	@Autowired
	PhotosService photosService;
	
	@GetMapping("/list")
	public String getMethodName() {
		
		
		
		return "generalPage/photosList";
	}
	

}
