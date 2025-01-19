package com.mysite.ProjectA.photos;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/photos")
public class PhotosController {
	
	@Value("${file.upload-dir}")
	String upload_dir;
	
	@Value("${spring.redis.host}")
	String host;
	
	@Autowired
	PhotosService photosService;
	
	@Autowired
	PhotosRepository photosRepository;
	
	@GetMapping("/list")
	public String getAllPhotos(Model model) {
		
		List<PhotosDAO> photosLIst = photosService.photosGetAll();
		List<PhotosDAO> photosList2 = new ArrayList<PhotosDAO>();
		
		for (PhotosDAO photo : photosLIst) {
			// 실제 파일 경로를 웹에서 접근할 수 있는 URL로 변환
			String imageUrl = "http://"+host+":8080/uploads/" + photo.getFileName();
			photo.setImageUrl(imageUrl);  // 이미지 URL을 데이터 객체에 설정
			
			photosList2.add(photo);
		}
		
		
		model.addAttribute("photosList", photosList2);
		
		return "generalPage/photosList";
	}
	
	@GetMapping("addForm")
	public String addForm() {
		return "generalPage/photosAdd";
	}
	
	@PostMapping("/add")
	public String addPhoto(@RequestParam("file") MultipartFile file,@RequestParam("title")String title,RedirectAttributes redirectAttributes) {
		String fileName = file.getOriginalFilename();
		
		String mimeType = file.getContentType();
		if(mimeType == null || mimeType.startsWith("image/")) {
			
		
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
            
            LocalDateTime today=LocalDateTime.now();
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String today1 =today.format(formatter);
            
            
            photosDAO.setUploadDate(today1);
            photosRepository.save(photosDAO);
            
		
		return "redirect:/photos/list";
		}else {
			
			
			
			
			redirectAttributes.addFlashAttribute("error", true);
			return "redirect:/photos/addForm";
		}
	}

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deletePhoto(@PathVariable("id") Long id) {
        try {
            photosService.deletePhoto(id);
            return ResponseEntity.ok("삭제 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 실패");
        }
    }

}
