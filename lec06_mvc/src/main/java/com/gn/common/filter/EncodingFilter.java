package com.gn.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/*")
public class EncodingFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public EncodingFilter() {
        super();
    }
	
	// 시작
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	// 종료
	public void destroy() {
		System.out.println();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}


}
