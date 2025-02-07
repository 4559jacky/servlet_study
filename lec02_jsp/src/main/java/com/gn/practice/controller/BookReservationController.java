package com.gn.practice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/borrow")
public class BookReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public BookReservationController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("user_name");
		String userPhone = request.getParameter("user_phone");
		String userEmail = request.getParameter("user_email");
		String book = request.getParameter("book");
		int rentDate = Integer.parseInt(request.getParameter("rentDate"));
		
		int price = 0;
		String bookName = "";
		
		switch(book) {
			case "1" : price = 1500; bookName = "자바 프로그래밍 입문"; break;
			case "2" : price = 1800; bookName = "웹 개발의 기초"; break;
			case "3" : price = 2000; bookName = "데이터베이스의 시스템"; break;
		}
		
		if(rentDate > 1) {
			price = price + 500*(rentDate-1);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("views/bookConfirmation.jsp");
		request.setAttribute("name", userName);
		request.setAttribute("phone", userPhone);
		request.setAttribute("email", userEmail);
		request.setAttribute("bookName", bookName);
		request.setAttribute("rentDate", rentDate);
		request.setAttribute("price", price);
		view.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
