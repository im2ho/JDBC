package com.kh.MVC.DELETE;

import java.util.Scanner;

public class DELETE_controller {
	
	public DELETE_model m;
	public DELETE_view v;
	
	//생성자
	public DELETE_controller(DELETE_model m, DELETE_view v) {
		this.m = m;
		this.v = v;
	}
	
	
	public static void main(String[] args) {
		
		DELETE_model m = new DELETE_model();
		DELETE_view v = new DELETE_view();
		DELETE_controller c = new DELETE_controller(m,v);
		
		c.run();
	}
	
	//model, view 연동(?) 실행 메서드
	public void run() {
		Scanner sc = new Scanner(System.in);
		v.showStartMsg();
		int cafe_id = sc.nextInt();
		
		v.showCheckMsg();
		char check = sc.next().charAt(0);
		if(check=='Y'||check=='y') {
			m.deleteCafe(cafe_id);
			v.showResultMsg();
		} else if(check=='N'||check=='n') {
			v.showResultMsg2();
		} else {
			v.showResultMsg3();
		}
		
		sc.close();
		
	}
}
