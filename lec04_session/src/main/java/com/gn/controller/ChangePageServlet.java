package com.gn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changePage")
public class ChangePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ChangePageServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면 전환
		RequestDispatcher view
//			= request.getRequestDispatcher("/views/countPage.jsp");
		// 절대 경로로 접근을 해야한다. 어디에서 문제가 생겼는지 찾으려면 getServletContext() 사용
			= getServletContext().getRequestDispatcher("/views/countPage.jsp");
		view.forward(request, response);
		// 속성 정보를 넘겨줄 떄 setAttribute();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
