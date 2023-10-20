package com.kh.DTO.SELECT.cafes;

import java.sql.Connection;
import java.util.List;

//모델과 뷰 연결
public class Cafe_Controller {
	
	//필드 멤버변수
	private Cafe_Model m;
	private Cafe_View v;
	
	//생성자
	public Cafe_Controller(Connection con, /*Cafe_Model m,*/ Cafe_View v) {
		this.m = new Cafe_Model(con);
		this.v = v;
	}
	
	//출력메서드
	public void displayAllCafes() {
		List<Cafe_DTO> cafes = m.getCafes();
		v.displayCafes(cafes);	
	}
}
