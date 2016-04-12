package com.clghks.helloservlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		String requestUrl = ((HttpServletRequest)request).getRequestURL().toString();
		System.out.println("접속 URL : " + requestUrl + ", 접속 일시 : " + new Date());
		
		// 다음 필터를 호출, 다음 필터가 없으면 원래 호출한 서빌릿/JSP로 이동
		// 이 코드가 없으면 다음으로 이동이 안됨!!!!
		filterChain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {

	}

}
