package com.mycom.soloProject.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.soloProject.board.model.dto.Board;
import com.mycom.soloProject.board.service.BoardService;

@RestController
public class BoardController {
	
	private BoardService bService;
	
	// 생성자를 통한 의존성주입(DI)
	public BoardController(BoardService bService) {
		this.bService = bService;
	}
	
	// 게시판 전체 목록
	@GetMapping("/board")
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boards", bService.retireveAllBoard());
		mav.setViewName("/board/board");
		
		return mav;
	}
	
	// 상세 보기
	@GetMapping("/board/{bNo}")
	public Board findById(@PathVariable int bNo) {
		return bService.findById(bNo);
	}
	
	// 글 작성
	@PostMapping("/board/new")
	public int createBoard(@RequestBody Board board) {
		return bService.createBoard(board);
	}
	
}
