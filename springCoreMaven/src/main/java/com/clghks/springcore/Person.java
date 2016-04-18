package com.clghks.springcore;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
	private String name;
	private SmartPhone phone;
	private SmartPhone[] phones;
	private Set<SmartPhone> phoneSet;
	private Map<String, SmartPhone> phoneMap;
	private Properties properties;
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	public void setPhoneMap(Map<String, SmartPhone> phoneMap) {
		this.phoneMap = phoneMap;
	}
	
	public void setPhoneSet(Set<SmartPhone> phoneSet) {
		this.phoneSet = phoneSet;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(SmartPhone phone) {
		this.phone = phone;
	}
	
	public void setPhones(SmartPhone[] phones) {
		this.phones = phones;
	}
	
	public void result(){
		System.out.println("이름 : " + name);
		System.out.println("폰 : " + phone.getName());
		System.out.println("가격 : " + phone.getPrice());
	}
	
	public void result2(){
		for(SmartPhone phone : phones){
			System.out.printf("폰 이름 : %s, 가격 : %d\n", phone.getName(), phone.getPrice());
		}
	}

	public void result3() {
		for(SmartPhone phone : phoneSet){
			System.out.printf("폰 이름 : %s, 가격 : %d\n", phone.getName(), phone.getPrice());
		}
	}
	
	public void result4() {
		for(String key : phoneMap.keySet()){
			System.out.printf("key : %s, 폰 이름 : %s, 가격 : %d\n", key, phoneMap.get(key).getName(), phoneMap.get(key).getPrice());
		}
	}

	public void result5() {
		for(String key : properties.keySet().toArray(new String[0])){
			System.out.println("폰 이름 : " + properties.getProperty(key));
		}
	}
}
