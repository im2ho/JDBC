package com.kh.MVC.INSERT;

import java.util.Scanner;

public class INSERT_control {

		
		public INSERT_model m;
		public INSERT_view v;
		
		//���̶� �� �������� ������
		public INSERT_control(INSERT_model m, INSERT_view v) {
			this.m = m; 
			this.v = v;
		}
	
	public void addCafe() {
		
		Scanner sc = new Scanner(System.in);
		
		v.showStartMsg();
		//int view_id = sc.nextInt();
		v.showGetName();
		//sc.nextLine(); //enteró�� �� ��¾��
		String view_cname = sc.nextLine();
		v.showGetAddress();
		String view_address = sc.nextLine();
		v.showGetPhoneNumber();
		String view_phone_number = sc.nextLine();
		v.showGetOperatingHours();
		String view_operating_hours = sc.nextLine();
		
		//insert_MODEL Ŭ�������� insertCafe �޼��带 ��������
		m.insertCafe(/*view_id, */view_cname, view_address, view_phone_number, view_operating_hours);
		v.showResultMsg();
		sc.close();
	}
	
}