package com.mycom.soloProject.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.soloProject.board.service.BoardService;

@RestController
public class BoardController {
	
	private BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("/boards")
	public String allBoard() {
		
		return "home";
	}
	
}
