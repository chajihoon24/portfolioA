package com.mysite.ProjectA.board;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardDAO,Long> {

	Page<BoardDAO> findAll(Pageable pageable);
	
}
