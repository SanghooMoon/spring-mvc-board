package com.mycom.soloProject.board.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.soloProject.board.model.dto.Board;
import com.mycom.soloProject.board.service.BoardService;

@RestController
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private BoardService bService;
	
	// 생성자를 통한 의존성주입(DI)
	public BoardController(BoardService bService) {
		this.bService = bService;
	}
	
	// 게시판 전체 목록
	@GetMapping("/board")
	public ModelAndView index() {
		logger.info("called index()");	// 콘솔에 로그 남기기
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boards", bService.retireveAllBoard());
		mav.setViewName("/board/board");
		
		return mav;
	}
	
	// 상세 보기
	@GetMapping("/board/{bNo}")
	public ModelAndView findById(@PathVariable int bNo) {
		logger.info("called findById()");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board",  bService.findById(bNo));
		mav.setViewName("/board/view");
		return mav;
	}
	
	// 글 작성
	@PostMapping("/board/new")
	public int createBoard(@Valid @RequestBody Board board) {
		logger.info("called createBoard()");	
		return bService.createBoard(board);
	}
	
	// 글 삭제
	@DeleteMapping("/board/{bNo}")
	public int deleteBoard(@PathVariable int bNo) {
		logger.info("called deleteBoard()");	
		return bService.deleteBoard(bNo);
	}
	
	// 글 수정
	@PutMapping("/board/{bNo}")
	public int updateById(@PathVariable int bNo, @Valid @RequestBody Board board) {
		logger.info("called updateById()");	
		return bService.updateById(bNo, board);
	}
	
}
