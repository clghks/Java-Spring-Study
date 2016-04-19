package com.clghks.spring;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="", propOrder={"name", "logo"})
@XmlRootElement(name="Team")
public class TeamJaxb {
	private String name;
	private String logo;
	
	public String getLogo() {
		return logo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
