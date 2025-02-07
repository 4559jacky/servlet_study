package com.gn.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import com.gn.common.wrapper.MsgRequestWrapper;


public class MsgFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public MsgFilter() {
        super();
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("[MsgFilter]요청 가로챔");
		MsgRequestWrapper mrw
			= new MsgRequestWrapper((HttpServletRequest)request);
		chain.doFilter(mrw, response);
		System.out.println("[MsgFilter]응답 가로챔");
	}

}
