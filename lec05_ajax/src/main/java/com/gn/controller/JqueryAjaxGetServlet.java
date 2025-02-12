package com.gn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jQueryAjaxGet")
public class JqueryAjaxGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JqueryAjaxGetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().append("<p>아이디 "+userId+"의 길이는 "+userId.length()+"</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
