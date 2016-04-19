package com.clghks.spring;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.InternalResourceView;

public class BaseBallView extends InternalResourceView{
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// prefix + viewName + suffix
		// /WEB-INF/views/baseball.jsp
		String dispatcherPath = prepareForRendering(request, response);

		// baseball.jsp
		request.setAttribute("partial", dispatcherPath.substring(dispatcherPath.lastIndexOf("/")+1));
		request.setAttribute("model", model);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/baseball/template.jsp");
		dispatcher.include(request, response);
		
	}
	
}
