package com.gn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/receive/data")
// filter를 사용할 때 별명과 url을 같이 쓴다.
@WebServlet(name="receiveDataServlet",urlPatterns="/receive/data")
public class ReceiveDataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public ReceiveDataServlet() {}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=== 확인 ===");
		String testData = req.getParameter("test_data");
		System.out.println("데이터 : "+testData);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
	
	
	
}
