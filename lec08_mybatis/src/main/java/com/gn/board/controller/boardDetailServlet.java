package com.gn.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Board;

@WebServlet("/boardDetail")
public class boardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardService();
       
    public boardDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp = request.getParameter("board_no");
		int boardNo = 0;
		if(temp != null) {
			boardNo = Integer.parseInt(temp);
		}
		Board b1 = boardService.selectBoardOne(boardNo);
		System.out.println("b1 : "+b1);
		///////////////////////////////////////////////////
		String boardTitle = request.getParameter("board_title");
		String boardContent = request.getParameter("board_content");
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("board_title", boardTitle);
		paramMap.put("board_content", boardContent);
		Board b2 = boardService.selectBoardTwo(paramMap);
		System.out.println("b2 : "+b2);
		///////////////////////////////////////////////////
		Board option = new Board();
		option.setBoardTitle(boardTitle);
		option.setBoardContent(boardContent);
		Board b3 = boardService.selectBoardThree(option);
		System.out.println("b3 : "+b3);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
