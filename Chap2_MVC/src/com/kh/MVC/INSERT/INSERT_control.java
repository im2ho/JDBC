package com.kh.MVC.INSERT;

import java.util.Scanner;

public class INSERT_control {

		
		public INSERT_model m;
		public INSERT_view v;
		
		//모델이랑 뷰 가져오는 생성자
		public INSERT_control(INSERT_model m, INSERT_view v) {
			this.m = m; 
			this.v = v;
		}
	
	public void addCafe() {
		
		Scanner sc = new Scanner(System.in);
		
		v.showStartMsg();
		//int view_id = sc.nextInt();
		v.showGetName();
		//sc.nextLine(); //enter처리 오 개쩐다
		String view_cname = sc.nextLine();
		v.showGetAddress();
		String view_address = sc.nextLine();
		v.showGetPhoneNumber();
		String view_phone_number = sc.nextLine();
		v.showGetOperatingHours();
		String view_operating_hours = sc.nextLine();
		
		//insert_MODEL 클래스에서 insertCafe 메서드를 가져오기
		m.insertCafe(/*view_id, */view_cname, view_address, view_phone_number, view_operating_hours);
		v.showResultMsg();
		sc.close();
	}
	
}