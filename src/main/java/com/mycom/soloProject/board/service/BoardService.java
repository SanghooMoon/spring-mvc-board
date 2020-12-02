package com.mycom.soloProject.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public Board findById(int bNo) {
		return bDao.findById(bNo);
	}

	public int createBoard(Board board) {
		return bDao.createBoard(board);
	}

	public int deleteBoard(int bNo) {
		if(bDao.findById(bNo) == null)
			throw new IllegalArgumentException("해당 게시글이 존재하지 않습니다.[bNo : " + bNo + "]" );
		return bDao.deleteBoard(bNo);
	}

	public int updateById(int bNo, Board board) {
		if(bDao.findById(bNo) == null)
			throw new IllegalArgumentException("해당 게시글이 존재하지 않습니다.[bNo : " + bNo + "]" );
		board.setBno(bNo);
		return bDao.updateById(board);
	}

	@Transactional
	public void addReply(Board board) {
		bDao.updateParentsBoards(board);	// 부모글들 업데이트
		bDao.addReply(board);				// 댓글 추가
	}


	

}
