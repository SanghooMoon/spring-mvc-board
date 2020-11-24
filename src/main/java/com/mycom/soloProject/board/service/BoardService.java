package com.mycom.soloProject.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.soloProject.board.model.dao.BoardDao;
import com.mycom.soloProject.board.model.dto.Board;

@Service
public class BoardService {

	private BoardDao bDao;
	
	// 생성자를 통한 의존성 주입(DI)
	public BoardService(BoardDao bDao) {
		this.bDao = bDao;
	}

	public List<Board> retireveAllBoard() {
		return bDao.retireveAllBoard();
	}


	

}
