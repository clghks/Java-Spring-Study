package com.clghks.spring.dto;

public class Contact {
	private int contactId;
	private String lastName;
	private String firstName;
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getContactId() {
		return contactId;
	}
	
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
}
