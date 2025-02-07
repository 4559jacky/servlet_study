package com.gn.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import com.gn.common.wrapper.StringUpperWrapper;

public class UpperCaseFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public UpperCaseFilter() {
        super();
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		StringUpperWrapper suw = new StringUpperWrapper((HttpServletRequest)request);
		chain.doFilter(suw, response);
	}

}
