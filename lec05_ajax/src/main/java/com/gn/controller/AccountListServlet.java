package com.gn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/accountList")
public class AccountListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AccountListServlet() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject o1 = new JSONObject();
		o1.put("no", 1);
		o1.put("name", "관리자");
		// "{"no":1,"name":"관리자"}"
		JSONObject o2 = new JSONObject();
		o2.put("no", 2);
		o2.put("name", "김철수");
		
		JSONArray arr = new JSONArray();
		arr.add(o1);
		arr.add(o2);
		
		JSONObject obj = new JSONObject();
		obj.put("accountList", arr);
		// "{"accountList" : [{"no":1,"name":"관리자"},{"no":2,"name":"김철수"}]}"
		
		response.setContentType("applictaion/json; charset=utf-8");
		response.getWriter().print(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
