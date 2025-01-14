package com.mysite.ProjectA.photos;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/photos")
public class PhotosController {
	
	@Value("${file.upload-dir}")
	String upload_dir;
	
	@Autowired
	PhotosService photosService;
	
	@Autowired
	PhotosRepository photosRepository;
	
	@GetMapping("/list")
	public String getAllPhotos(Model model) {
		
		List<PhotosDAO> photosLIst = photosService.photosGetAll();
		model.addAttribute("photosList", photosLIst);
		
		return "generalPage/photosList";
	}
	
	@GetMapping("addForm")
	public String addForm() {
		return "generalPage/photosAdd";
	}
	
	@PostMapping("/add")
	public String addPhoto(@RequestParam("file") MultipartFile file,@RequestParam("title")String title) {
		String fileName = file.getOriginalFilename();
		
            File directory = new File(upload_dir);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File destinationFile = new File(directory, fileName);
            try {
				file.transferTo(destinationFile);
			} catch (IllegalStateException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}

            // 데이터베이스에 파일 정보 저장
            PhotosDAO photosDAO = new PhotosDAO();
            photosDAO.setFileName(fileName);
            photosDAO.setTitle(title);
            photosDAO.setImageUrl(destinationFile.getAbsolutePath());
            photosDAO.setUploadDate(LocalDateTime.now());
            photosRepository.save(photosDAO);
		
		return "redirect:/photos/list";
	}
	@DeleteMapping("/delete/{id}")
	public String deletePhoto(@RequestParam int id) {	
		return "redirect:/photos/list";
	}


}
