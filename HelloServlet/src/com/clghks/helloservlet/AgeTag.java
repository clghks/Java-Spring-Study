package com.clghks.helloservlet;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class AgeTag implements Tag{
	private PageContext pageContext;
	private Tag parentTag;
	private Date birthday;
	
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
			Calendar calendar = new GregorianCalendar();
			Calendar birthDay = new GregorianCalendar();
			birthDay.setTime(birthday);
			
			int age = calendar.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
			
			JspWriter jspWriter = pageContext.getOut();
			jspWriter.println(age + 1);
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
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
