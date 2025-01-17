package com.mysite.ProjectA;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.ProjectA.DTO.ResponseDTO;
import com.mysite.ProjectA.board.BoardDAO;
import com.mysite.ProjectA.board.BoardRepository;
import com.mysite.ProjectA.test.JsonDTO;


@SpringBootTest
class ProjectAApplicationTests {
	
	@Value("${file.upload-dir}")
	String uploadPath;
	
	@Value("${test.jihoon}")
	String test;
	
	
	@Test
	void contextLoads() {
		System.out.println(uploadPath);
		System.out.println(test);
		
	}
	
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsertAndRetrieveData() {
        // 테스트 데이터 삽입
        for (int i = 1; i <= 5; i++) {
            BoardDAO board = new BoardDAO();
            board.setTitle("Test Title " + i);
            board.setName("test" + i);
            board.setContents("This is the content for test post " + i);
        	LocalDateTime date = LocalDateTime.now();
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        	String now = date.format(formatter);
            board.setTime(now);
            boardRepository.save(board);
        };

}
}
