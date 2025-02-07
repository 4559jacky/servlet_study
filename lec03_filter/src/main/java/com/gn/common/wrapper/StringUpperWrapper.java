package com.gn.common.wrapper;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class StringUpperWrapper extends HttpServletRequestWrapper {

	public StringUpperWrapper(HttpServletRequest request) {
        super(request);
    }

	@Override
	public String getParameter(String name) {
		return super.getParameter(name).toUpperCase();
	}


}
