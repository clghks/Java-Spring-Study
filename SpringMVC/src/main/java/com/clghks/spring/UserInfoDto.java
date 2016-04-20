package com.clghks.spring;

public class UserInfoDto {
	private String cd;		// 부서번호
	private String name;	// 사원명
	
	public UserInfoDto(){}
	
	public UserInfoDto(String cd, String name){
		this.cd = cd;
		this.name = name;
	}
	
	public String getCd() {
		return cd;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCd(String cd) {
		this.cd = cd;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
