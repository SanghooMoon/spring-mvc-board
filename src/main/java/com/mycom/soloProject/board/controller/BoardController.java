package com.mycom.soloProject.board.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
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
	
	// 글 작성 화면
	@GetMapping("/board/new")
	public ModelAndView createBoardView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/write");
		return mav;
	}
	
	// 글 작성(Json)
	@PostMapping(value = "/board/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView createBoardForJson(@Valid @RequestBody Board board) {
		logger.info("called createBoard()");	
		
		bService.createBoard(board);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board");
		return mav;
	}
	// 글 작성(Form)
	@PostMapping(value = "/board/new", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView createBoardForForm(@Valid Board board) {
		logger.info("called createBoard()");	
		
		bService.createBoard(board);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board");
		return mav;
	}
	
	// 글 삭제
	@DeleteMapping("/board/{bNo}")
	public ModelAndView deleteBoard(@PathVariable int bNo) {
		logger.info("called deleteBoard()");	
		
		bService.deleteBoard(bNo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board");
		return mav;
	}
	
	// 글 수정(화면)
	@GetMapping("/board/edit/{bNo}")
	public ModelAndView updateByIdView(@PathVariable int bNo) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", bService.findById(bNo));
		mav.setViewName("/board/write");
		return mav;
	}
	
	// 글 수정(Json)
	@PutMapping(value="/board/{bNo}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView updateByIdForJson(@PathVariable int bNo, @Valid @RequestBody Board board) {
		logger.info("called updateById()");	
		
		bService.updateById(bNo, board);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board");
		return mav;
	}
	// 글 수정(Form)
	@PutMapping(value="/board/{bNo}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView updateByIdForForm(@PathVariable int bNo, @Valid Board board) {
		logger.info("called updateById()");	
		
		bService.updateById(bNo, board);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board");
		return mav;
	}
	
}
