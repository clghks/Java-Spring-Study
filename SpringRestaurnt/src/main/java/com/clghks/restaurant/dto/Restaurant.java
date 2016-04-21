package com.clghks.restaurant.dto;

public class Restaurant {
	// 레스토랑 ID
	private int resturantId;
	// 레스토랑 명
	private String resturantName;
	// 위도
	private double lat;
	// 경도
	private double lon;
	// 소개말
	private String pr;
	// 레스토랑 이미지
	private byte[] image;
	
	public int getResturantId() {
		return resturantId;
	}
	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}
	public String getResturantName() {
		return resturantName;
	}
	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getPr() {
		return pr;
	}
	public void setPr(String pr) {
		this.pr = pr;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
}
