package com.mycom.soloProject.board.model.dao;

import java.util.List;

import com.mycom.soloProject.board.model.dto.Board;

public interface BoardDao {

	List<Board> retireveAllBoard();

	Board findById(int bNo);

	int createBoard(Board board);

	int deleteBoard(int bNo);

	int updateById(Board board);

	void addReply(Board board);

	void updateParentsBoards(Board board);

}
