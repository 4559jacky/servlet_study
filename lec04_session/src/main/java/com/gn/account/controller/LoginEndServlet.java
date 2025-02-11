package com.gn.account.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gn.account.vo.Account;

@WebServlet("/loginEnd")
public class LoginEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginEndServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountId = request.getParameter("account_id");
		String accountPw = request.getParameter("account_pw");
		String rememberId = request.getParameter("remember_id");
		
		System.out.println("아이디 : "+accountId);
		System.out.println("비밀번호 : "+accountPw);
		System.out.println("아이디 저장 유무 : "+rememberId);
		
		// 1. 아이디, 비밀번호 일치하는 데이터 있는지 확인
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account account = null;
		try {
			// Select
			// 기준 아이디와 비밀번호 일치(like X)
			// 전체 정보 조회 -> account 객체에 담기
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/login_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			String sql = "select * from account where account_id = ? and account_pw = ?";
			
			// PreparedStatement
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountId);
			pstmt.setString(2, accountPw);
			
			// ResultSet
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				account = new Account();
				account.setAccountNo(rs.getInt("account_no"));
				account.setAccountId(rs.getString("account_id"));
				account.setAccountPw(rs.getString("account_pw"));
				account.setAccountName(rs.getString("account_name"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null && !rs.isClosed()) rs.close();
				if(pstmt != null && !pstmt.isClosed()) rs.close();
				if(conn != null && !conn.isClosed()) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(account != null) {
			// 2-1. O
			// 		-> 사용자의 정보(번호, 아이디, 비밀번호, 이름) 담고 있는 객체 Session에 저장
			HttpSession session = request.getSession();
			if(session.isNew()
					|| session.getAttribute("account") == null) {
				session.setAttribute("account", account);
				session.setMaxInactiveInterval(10);
			}
			//		-> 아이디 정보 저장 O : Cookie에 아이디 저장
			String value = "";
			int time = 0;
			if(rememberId != null) {
				value = account.getAccountId();
				time = 60*60*24*7;
			}
//	 		-> 				X : 저장X
//			else {
//				Cookie cookie
//				= new Cookie("remember_id","");
//				cookie.setMaxAge(0);
//				response.addCookie(cookie);
//			}
			Cookie cookie
			= new Cookie("remember_id",value);
			cookie.setMaxAge(time);
			response.addCookie(cookie);

			// 		-> 홈화면 이동 : 로그인한 사용자 정보 노출
			response.sendRedirect("/");
			System.out.println(account);
		} else {
			// 2-2. X
			// 		-> 로그인 페이지 다시 요청
			response.sendRedirect("/login");
			System.out.println("로그인 실패");
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// get방식으로 보내면 url에 아이디와 비밀번호가 노출이 된다.
		doGet(request, response);
	}

}
