package com.kh.MVC.DELETE;

import java.util.Scanner;

public class DELETE_controller {
	
	DELETE_model m = new DELETE_model();
	DELETE_view v = new DELETE_view();
	
	//생성자
	public DELETE_controller(DELETE_model m, DELETE_view v) {
		
	}
	
	
	public static void main(String[] args) {
		DELETE_model m = new DELETE_model();
		DELETE_view v = new DELETE_view();
		DELETE_controller c = new DELETE_controller(m,v);
		c.deleteCafeRecord();
	}
	
	//model, view 연동(?) 실행 메서드
	public void deleteCafeRecord() {
		Scanner sc = new Scanner(System.in);
		v.showStartMsg();
		int cafe_id = sc.nextInt();
		
		v.showCheckMsg();
		
		m.deleteCafe(cafe_id);
		v.showResultMsg();
		sc.close();
		
	}
}
