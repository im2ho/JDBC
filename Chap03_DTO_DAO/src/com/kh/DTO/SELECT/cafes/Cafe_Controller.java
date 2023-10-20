package com.kh.DTO.SELECT.cafes;

import java.sql.Connection;
import java.util.List;

//�𵨰� �� ����
public class Cafe_Controller {
	
	//�ʵ� �������
	private Cafe_Model m;
	private Cafe_View v;
	
	//������
	public Cafe_Controller(Connection con, /*Cafe_Model m,*/ Cafe_View v) {
		this.m = new Cafe_Model(con);
		this.v = v;
	}
	
	//��¸޼���
	public void displayAllCafes() {
		List<Cafe_DTO> cafes = m.getCafes();
		v.displayCafes(cafes);	
	}
}
