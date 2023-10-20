package com.kh.MVC;

import java.util.Scanner;

public class Cafe_Controller {
	
	public Cafe_Model m;
	public Cafe_View v;
	
	//모델이랑 뷰 가져오는 생성자
	public Cafe_Controller(Cafe_Model m, Cafe_View v) {
		this.m = m;
		this.v = v;
	}
	
	//run()
	public void run() {
		//Scanner sc = new Scanner(System.in);
		boolean isTrue = false;
		
		while(!isTrue) {
			Scanner sc = new Scanner(System.in);
			//선택할 번호 출력 메서드로 입력
			System.out.println("1. 새로운 카페 등록");
			System.out.println("2. 운영 시간 수정");
			System.out.println("3. 카페 주소 수정");
			System.out.println("4. 카페 삭제");
			System.out.println("5. 프로그램 종료");
			System.out.print("\n원하는 작업을 선택해주세요 : ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				v.addCafeName();
				break;
			case 2:
				v.updateOperatingHours();
				break;
			case 3:
				v.updateAddress();
				break;
			case 4:
				v.deleteCafeRecord();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다");
				isTrue = true;
				break;
			default:
				System.out.println("적합하지 않은 번호입니다 다시 선택해주세요\n");
				break;
			}//switch()
			
		} //while()
		
	} //run()

}