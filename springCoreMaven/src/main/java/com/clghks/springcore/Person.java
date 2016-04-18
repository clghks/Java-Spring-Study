package com.clghks.springcore;

public class Person {
	private String name;
	private SmartPhone phone;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(SmartPhone phone) {
		this.phone = phone;
	}
	
	public void result(){
		System.out.println("이름 : " + name);
		System.out.println("폰 : " + phone.getName());
		System.out.println("가격 : " + phone.getPrice());
	}
}
