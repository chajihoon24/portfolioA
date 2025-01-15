package com.mysite.ProjectA.photos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotosService {
	@Autowired
	PhotosRepository photosRepository;
	
	public List<PhotosDAO> photosGetAll(){
		
		List<PhotosDAO> PhotosList = photosRepository.findAll();
		
		return PhotosList;
		
	}
	public void deletePhoto(Long id) {
		
		photosRepository.deleteById(id);
		
	}
	
	
}
