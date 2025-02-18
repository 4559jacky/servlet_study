package com.gn.board.service;


import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.commit;
import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Attach;
import com.gn.board.vo.Board;

public class BoardService {
	
	private BoardDao boardDao = new BoardDao();
	
	public Board selectBoardOne(int boardNo) {
		Connection conn = getConnection();
		Board board = boardDao.selectBoardOne(conn, boardNo);
		close(conn);
		return board;
	}
	
	public int selectBoardCount(Board option) {
		Connection conn = getConnection();
		int result = boardDao.selectBoardCount(conn, option);
		close(conn);
		return result;
	}
	
	public List<Board> selectBoardList(Board option) {
		Connection conn = getConnection();
		List<Board> resultList = new ArrayList<Board>();
		resultList = boardDao.selectBoardList(conn, option);
		close(conn);
		return resultList;
	}
	
	// 트랜잭션 처리(게시글 작성)
	public int createBoard(Board b, Attach a) {
		Connection conn = getConnection();
		int result = 0;
//		bd.createBoard(b, a, conn);
		try {
			// 기본이 AutoCommit이 true이기 때문에 꺼준다.
			// 바로 반영을 시키지않고 전부 다 끝까지 성공적으로가면 처리를 해준다.
			// 하나라도 잘못되서 롤백이 일어나면 나머지도 반영시키지않는다.
			conn.setAutoCommit(false);
			int boardNo = boardDao.insertBoard(b,conn);
			a.setBoardNo(boardNo);
			int attachNo = boardDao.insertAttach(a, conn);
			
			if(boardNo != 0 && attachNo != 0) {
				result = 1;
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch(Exception e) {
			rollback(conn);
			e.printStackTrace();
		}
		close(conn);
		return result;
	}

}
