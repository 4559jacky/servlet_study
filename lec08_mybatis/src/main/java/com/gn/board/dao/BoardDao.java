package com.gn.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.gn.board.vo.Board;

public class BoardDao {

	public List<Board> selectBoardList(SqlSession session) {
		// 매개변수 : mapper의 namespace.쿼리문의 id
		return session.selectList("boardMapper.boardList");
	}

	public Board selectBoardOne(SqlSession session, int boardNo) {
		
		return session.selectOne("boardMapper.boardOne", boardNo);
	}

	public Board selectBoardTwo(SqlSession session, Map<String, String> paramMap) {
		
		return session.selectOne("boardMapper.boardTwo", paramMap);
	}

	public Board selectBoardThree(SqlSession session, Board option) {

		return session.selectOne("boardMapper.boardThree",option);
	}

}
