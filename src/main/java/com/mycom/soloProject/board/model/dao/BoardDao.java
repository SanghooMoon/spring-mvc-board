package com.mycom.soloProject.board.model.dao;

import java.util.List;

import com.mycom.soloProject.board.model.dto.Board;

public interface BoardDao {

	List<Board> retireveAllBoard();

	Board findById(int bNo);

}
