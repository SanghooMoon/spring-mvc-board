package com.mycom.soloProject.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.mycom.soloProject.board.model.dto.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	private SqlSessionTemplate sqlSession;
	
	public BoardDaoImpl(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Board> retireveAllBoard() {
		return sqlSession.selectList("boardMapper.retireveAllBoard");
	}

	@Override
	public Board findById(int bNo) {
		return sqlSession.selectOne("boardMapper.findById", bNo);
	}

	@Override
	public int createBoard(Board board) {
		return sqlSession.insert("boardMapper.createBoard", board);
	}

	@Override
	public int deleteBoard(int bNo) {
		return sqlSession.delete("boardMapper.deleteBoard", bNo);
	}

}
