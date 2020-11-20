package com.mycom.soloProject.board.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.mycom.soloProject.board.model.dao.BoardDAO;

@Service
public class BoardService {
	
	private SqlSessionTemplate sqlSession;
	private BoardDAO boardDAO;
	
	public BoardService(SqlSessionTemplate sqlSession, BoardDAO boardDAO) {
		this.sqlSession = sqlSession;
		this.boardDAO = boardDAO;
	}

	public Map<Object, Object> test() {
		boardDAO.insert(sqlSession);
		System.out.println("완료?");
		return null;
	}

	
	
	
	
}
