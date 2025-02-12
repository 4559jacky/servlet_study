package com.guestbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/guestBook")
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GuestBook() {
        super();
    }
    
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String guestName = request.getParameter("guestName");
		String guestMessage = request.getParameter("guestMessage");
		
		JSONObject g1 = new JSONObject();
		g1.put("guestName", guestName);
		g1.put("guestMessage", guestMessage);
		
		response.setContentType("applictaion/json; charset=utf-8");
		response.getWriter().print(g1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
