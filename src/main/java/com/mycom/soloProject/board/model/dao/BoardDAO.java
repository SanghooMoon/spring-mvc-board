package com.mycom.soloProject.board.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	public int insert(SqlSessionTemplate sqlSession) {
		return sqlSession.insert("boardMapper.hello");
	}
	
}
