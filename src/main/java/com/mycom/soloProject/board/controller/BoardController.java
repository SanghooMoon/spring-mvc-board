package com.mycom.soloProject.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BoardController {
	
	@GetMapping("/board")
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/board");
		
		return mav;
	}
	
}