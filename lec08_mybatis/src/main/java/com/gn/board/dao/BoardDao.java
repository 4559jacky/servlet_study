package com.gn.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.board.vo.Board;

public class BoardDao {

	public List<Board> selectBoardList(SqlSession session) {
		// 매개변수 : mapper의 namespace.쿼리문의 id
		return session.selectList("boardMapper.boardList");
	}

}
