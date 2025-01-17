package com.mysite.ProjectA.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	// 기본 페이지
	@GetMapping("/list")
	public String boardList(@RequestParam(name="page" ,defaultValue = "0") int page,@RequestParam(name="size",defaultValue = "7") int size,Model model) {

		Long Listsize = boardService.size();
		Page<BoardDAO> boardPage = boardService.getBoards(page, size);
		model.addAttribute("size", Listsize);
		model.addAttribute("boardPage", boardPage);

		return "generalPage/boardList";
	}

	// 개별 페이지
	@GetMapping("/detail/{id}")
	public String board_detail(@PathVariable("id") Long id,Model model) {
		BoardDAO boardDAO = boardService.getById(id);
		model.addAttribute("data", boardDAO);
		
		return "generalPage/boardDetail";
	}

	@GetMapping("/edit/{id}")
	public String getMethodName(@PathVariable("id") Long id,Model model) {
		BoardDAO boardDAO = boardService.getById(id);
		model.addAttribute("data", boardDAO);
		return "generalPage/boardEditForm";
	}
	@PostMapping("/edit/{id}")
	public String editBoard(@PathVariable("id") Long id,@RequestParam("title") String title,@RequestParam("name") String name,@RequestParam("contents") String contents) {
		
		boardService.update(id, title, name, contents);
		return "redirect:/board/list";
		
		
	}

	@GetMapping("/addForm")
	public String add() {

		return "generalPage/boardAddForm";
	}
	@PostMapping("/add")
	public String addBoard(@RequestBody BoardDAO boardDAO) {
		boardService.save(boardDAO);
		
		
		return "redirect:/board/list";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		boardService.deleteDetail(id);
		
		return "redirect:/board/list";
	}

}
