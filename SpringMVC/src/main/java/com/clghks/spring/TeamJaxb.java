package com.clghks.spring;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="", propOrder={"name", "logi"})
@XmlRootElement(name="Team")
public class TeamJaxb {
	private String name;
	private String logi;
	
	public String getLogi() {
		return logi;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLogi(String logi) {
		this.logi = logi;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
