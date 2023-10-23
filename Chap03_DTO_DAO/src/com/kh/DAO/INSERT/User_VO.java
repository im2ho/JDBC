package com.kh.DAO.INSERT;

import java.util.Date;

//user_info 테이블에 데이터 추가를 해주궛어요

public class User_VO {
	
	//멤버변수
	private int user_id; 
	private String user_name;
	private String email;
	private Date reg_date;
	
	//생성자
	public User_VO() {}
	
	//public User_VO() {}

	//Getter-----------------------------------
	
	public int getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getEmail() {
		return email;
	}

	public Date getReg_date() {
		return reg_date;
	}
	
	//Setter-----------------------------------
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
}
