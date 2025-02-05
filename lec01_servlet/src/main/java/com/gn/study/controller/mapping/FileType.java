package com.gn.study.controller.mapping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileType extends HttpServlet {
	
	// 특정 클래스를 외부에서 읽기 쉽게 시리얼 번호를 달아줌
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		System.out.println("요청 전달 확인");
		String userName = req.getParameter("user_name");
		System.out.println(userName);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println();
	}
	
}
