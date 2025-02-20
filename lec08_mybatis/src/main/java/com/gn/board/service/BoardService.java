package com.gn.board.service;

import static com.gn.common.sql.SqlSessionTemplate.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Board;

public class BoardService {
	
	BoardDao boardDao = new BoardDao();

	public List<Board> selectBoardList() {
		SqlSession session = getSqlSession();
		List<Board> resultList = boardDao.selectBoardList(session);
		session.close();
		return resultList;
	}

}
