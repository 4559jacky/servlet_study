package com.gn.board.service;

import static com.gn.common.sql.SqlSessionTemplate.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Board;

public class BoardService {
	
	BoardDao boardDao = new BoardDao();
	
	
	// 게시글 리스트 가져오기
	public List<Board> selectBoardList(Board option) {
		SqlSession session = getSqlSession();
		List<Board> resultList = boardDao.selectBoardList(session, option);
		session.close();
		return resultList;
	}
	
	// 게시글 하나 가져오기 : boardNo를 이용
	public Board selectBoardOne(int boardNo) {
		SqlSession session = getSqlSession();
		Board board = boardDao.selectBoardOne(session, boardNo);
		session.close();
		return board;
	}
	
	// 게시글 하나 가져오기 : Map을 활용하여 boardTitle, boardContent로
	public Board selectBoardTwo(Map<String,String> paramMap) {
		SqlSession session = getSqlSession();
		Board board = boardDao.selectBoardTwo(session, paramMap);
		session.close();
		return board;
	}
	
	// 게시글 하나 가져오기 : Board 객체에 정보를 담아서 가져오기
	public Board selectBoardThree(Board option) {
		SqlSession session = getSqlSession();
		Board board = boardDao.selectBoardThree(session, option);
		session.close();
		return board;
	}

	public int updateBoard(Board board) {
		SqlSession session = getSqlSession();
		int result = boardDao.updateBoard(session, board);
		// session.commit(true);
		// session.rollback();
		session.close();
		return result;
	}

	public int deleteBoard(int board_no) {
		SqlSession session = getSqlSession();
		int result = boardDao.deleteBoard(session, board_no);
		session.close();
		return result;
	}

	public int createBoard(Board option) {
		SqlSession session = getSqlSession();
		int result = boardDao.createBoard(session, option);
		session.close();
		return result;
	}

	public int insertMany(List<Board> list) {
		SqlSession session = getSqlSession();
		int result = boardDao.insertMany(session,list);
		session.close();
		return result;
	}

}
