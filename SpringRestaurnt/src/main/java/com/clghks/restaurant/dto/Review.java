package com.clghks.restaurant.dto;

import java.util.Date;

public class Review {
	// 리뷰 ID
	private int resturantId;
	// 평점
	private int rate;
	// 내용
	private String body;
	// 등록일(수정일)
	private Date update;
	// 리뷰 ID
	private int rid;
	// 사용자 ID
	private String uid;
	
	public int getResturantId() {
		return resturantId;
	}
	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
}