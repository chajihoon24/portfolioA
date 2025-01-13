package com.mysite.ProjectA.photos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/photos")
public class PhotosController {
	
	@Autowired
	PhotosService photosService;
	
	@GetMapping("/list")
	public String getAllPhotos() {
		return "generalPage/photosList";
	}
	@GetMapping("addForm")
	public String addForm() {
		return "generalPage/photosAdd";
	}
	
	@PostMapping("/add")
	public String addPhoto() {
		return "redirect:/photos/list";
	}
	@DeleteMapping("/delete/{id}")
	public String deletePhoto(@RequestParam int id) {	
		return "redirect:/photos/list";
	}


}
