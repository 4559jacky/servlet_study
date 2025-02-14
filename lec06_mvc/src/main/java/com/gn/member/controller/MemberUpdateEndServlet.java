package com.gn.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.gn.member.service.MemberService;
import com.gn.member.vo.Member;


@WebServlet(name = "memberUpdateEndServlet", urlPatterns = "/memberUpdateEnd")
public class MemberUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberUpdateEndServlet() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("member_no"));
		String pw = request.getParameter("member_pw");
		String name = request.getParameter("member_name");
		
		System.out.println(pw);
		
		Member m = new Member(no,pw,name);
		
		// Service에 데이터 전달
		int result = new MemberService().updateMember(m);
		JSONObject obj = new JSONObject();
		obj.put("res_code", "500");
		obj.put("res_msg", "개인정보 수정 중 오류가 발생하였습니다.");
		
		if(result > 0) {
			
			// Session 재설정
			// 1. member_no정보를 기준으로 단일 회원 정보(Member)조회
			// 2. 새롭게 조회된 Member 정보를 Session에 재설정
			Member member = new MemberService().updateSession(m);
			System.out.println(member);
			
			if(member != null) {
//				HttpSession session = request.getSession(false);
//				if(session != null && session.getAttribute("member") != null) {
//					session.setAttribute("member", member);
//					session.setMaxInactiveInterval(60*30);
//				} else {
//					session = request.getSession();
//					session.setAttribute("member", member);
//					session.setMaxInactiveInterval(60*30);
//				}
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				session.setMaxInactiveInterval(60*30);
			}

			obj.put("res_code", "200");
			obj.put("res_msg", "개인정보가 정상적으로 수정되었습니다.");
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
