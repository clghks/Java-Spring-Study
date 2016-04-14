package com.clghks.helloservlet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloTag implements Tag{
	private PageContext pageContext;
	private Tag parentTag;
	private String message;
	
	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}
	
	@Override
	public void setParent(Tag parentTag) {
		this.parentTag = parentTag;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter jspWriter = pageContext.getOut();
			jspWriter.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public Tag getParent() {
		return parentTag;
	}

	@Override
	public void release() {
		
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
