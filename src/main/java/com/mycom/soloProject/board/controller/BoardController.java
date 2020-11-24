package com.mycom.soloProject.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.soloProject.board.service.BoardService;

@RestController
public class BoardController {
	
	private BoardService bService;
	
	// 생성자를 통한 의존성주입(DI)
	public BoardController(BoardService bService) {
		this.bService = bService;
	}

	@GetMapping("/board")
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boards", bService.retireveAllBoard());
		mav.setViewName("/board/board");
		
		System.out.println(bService.retireveAllBoard().get(0));
		
		return mav;
	}
	
}
