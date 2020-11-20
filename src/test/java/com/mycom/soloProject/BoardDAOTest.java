package com.mycom.soloProject;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mycom.soloProject.board.model.dao.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class BoardDAOTest {

    private BoardDAO boardDAO = new BoardDAO();
    @Inject
    private SqlSessionTemplate sqlSession;
	
	@Test
	public void 데이터테스트() {
		boardDAO.insert(sqlSession);
	}
	
	
}
