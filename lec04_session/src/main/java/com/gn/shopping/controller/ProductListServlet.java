package com.gn.shopping.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.shopping.vo.Product;

@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int prodCode = Integer.parseInt(request.getParameter("prod_code"));
		String prodName = request.getParameter("prod_name");
		int prodPrice = Integer.parseInt(request.getParameter("prod_price"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		
		try {
			
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
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
