package com.kh.DTO.SELECT.cafes;

//Cafe_DTO : 데이터 전송 객체
public class Cafe_DTO {

	//model sql 열 형식에 맞춰 데이터를 캡슐화하고 getter setter를 활용하여 데이터를 저장하고 내보내는 공간
	
	//필드 멤버변수 작성
	private int cafe_id;
	private String cafe_name;
	private String address;
	private String phone_number;
	private String operating_hours;
	
	//디폴트 생성자
	public Cafe_DTO() {}

	//매개변수 값 받는 리폼(?) 생성자
	public Cafe_DTO(int cafe_id, String cafe_name, String address, String phone_number, String operating_hours) {
		this.cafe_id = cafe_id;
		this.cafe_name = cafe_name;
		this.address = address;
		this.phone_number = phone_number;
		this.operating_hours = operating_hours;
	}
	
	//getter-----------------------------------
	
	public int getCafe_id() {
		return cafe_id;
	}
	
	public String getCafe_name() {
		return cafe_name;
	}
	
	public String getAddress() {
		return address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public String getOperating_hours() {
		return operating_hours;
	}

	//setter------------------------------------
	
	public void setCafe_id(int cafe_id) {
		this.cafe_id = cafe_id;
	}

	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public void setOperating_hours(String operating_hours) {
		this.operating_hours = operating_hours;
	}

	//Override를 활용한 toString 메서드 추가---------
	@Override
	public String toString() {
		return "Cafe_DTO";
	}
	

}
