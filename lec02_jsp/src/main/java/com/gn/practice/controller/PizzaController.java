package com.gn.practice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order")
public class PizzaController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public PizzaController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String userName = req.getParameter("user_name");
		String userPhone = req.getParameter("user_phone");
		String userEmail = req.getParameter("user_email");
		int size = Integer.parseInt(req.getParameter("size"));
		String[] adds = req.getParameterValues("add");
		String deliveryTime = req.getParameter("delivery_time");
		
		int price = 0;
		// 1. size 기준
		// Small : 15900원
		// Medium : 21000원
		// Large : 27900원
		
		// 2. 토핑 추가
		// 새우 + 2000원
		// 고구마, 감자, 파인애플 + 1000원
		
		if(size == 1) {
			price = 15900;
		} else if(size == 2) {
			price = 21000;
		} else {
			price = 27900;
		}
		
		if(adds != null) {
			for(String a : adds) {
				if(a.equals("1")) price += 2000;
				else price += 1000;
			}
		}
		
		RequestDispatcher view = req.getRequestDispatcher("views/pizzaPayment.jsp");
		req.setAttribute("name", userName);
		req.setAttribute("phone", userPhone);
		req.setAttribute("email", userEmail);
		req.setAttribute("size", size);
		req.setAttribute("toppings", adds);
		req.setAttribute("price", price);
		req.setAttribute("time", deliveryTime);
		view.forward(req, resp);
		
		
		System.out.println("이름 : "+userName);
		System.out.println("전화번호 : "+userPhone);
		System.out.println("이메일 : "+userEmail);
		System.out.println("피자 사이즈 : "+size);
		for(String s : adds) {
			System.out.println("토핑 : "+s);
		}
		System.out.println("희망 배송 시간 : "+deliveryTime);
		System.out.println("가격 : "+price);
		
		
//		List<String> list = new ArrayList<>();
//				
//				for(String s : adds) {
//					if(s.equals("1")) {
//						list.add("새우");
//						price += 2000;
//					} else if(s.equals("2")) {
//						list.add("고구마");
//						price += 1000;
//					} else if(s.equals("3")) {
//						list.add("감자");
//						price += 1000;
//					} else if(s.equals("4")) {
//						list.add("파인애플");
//						price += 1000;
//					} 
//				}
//		
//		System.out.printf("이름 : %s\n전화번호 : %s\n이메일 : %s\n사이즈 : %s\n토핑 : %s\n배달시간 : %s\n가격 : %d\n"
//				,userName,userPhone,userEmail,size,list.toString(),deliveryTime,price);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	
	
}
