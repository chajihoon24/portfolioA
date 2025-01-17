package com.mysite.ProjectA.board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	// 전체 목록 가져오기
	public List<BoardDAO> getAll(){
		List<BoardDAO> boardList = boardRepository.findAll();
		return boardList;
	}
	//개별 목록 가져오기
    public BoardDAO getById(Long id) {

        Optional<BoardDAO> boardDAOOptional = boardRepository.findById(id);
        
        return boardDAOOptional.orElse(null);
    }
    //개별 삭제 
    public void deleteDetail(Long id) {
    	
    	boardRepository.deleteById(id);

    }
    public Long size() {
    	Long size = boardRepository.count();
    	return size;
    }
    
    public void save(BoardDAO data) {
    	BoardDAO boardDAO = new BoardDAO();
    	boardDAO.setName(data.getName());
    	boardDAO.setTitle(data.getTitle());
    	boardDAO.setContents(data.getContents());
    	
    	LocalDateTime date = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	
    	String now = date.format(formatter);
    	
    	boardDAO.setTime(now);
    	
    	boardRepository.save(boardDAO);
    	System.out.println("저장 완료");
    }
    public Page<BoardDAO> getBoards(int page, int size) {
        
        PageRequest pageRequest = PageRequest.of(page, size,Sort.by(Sort.Order.desc("id")));  // id로 오름차순 정렬
        return boardRepository.findAll(pageRequest);
    }
    public void update(Long id, String title,String name,String contents) {
    	BoardDAO boardDAO = boardRepository.getById(id);
    	boardDAO.setTitle(title);
    	boardDAO.setName(name);
    	LocalDateTime date = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	
    	String now = date.format(formatter);
    	
    	boardDAO.setTime(now);
    	boardDAO.setContents(contents);
    	boardRepository.save(boardDAO);
    }
   

}
