package com.kh.MVC;

import java.util.Scanner;

public class Cafe_View {
	
	
	//cafeModel 클래스를 가져오기 위해 멤버변수로 카페 모델 추가
	public Cafe_Model model;
	
	//model 매개변수를 받을 수 있는 생성자
	public Cafe_View(Cafe_Model model) {
		this.model = model;
	}
	
	public void addCafeName() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("추가할 카페 정보를 입력하세요..");
		System.out.print("카페 번호 : ");
		int view_id = sc.nextInt();
		System.out.print("상호명 : ");
		sc.nextLine(); //enter처리 오 개쩐다
		String view_cname = sc.nextLine();
		System.out.print("카페 주소 : ");
		String view_address = sc.nextLine();
		System.out.print("카페 연락처 : ");
		String view_phone_number = sc.nextLine();
		System.out.print("운영 시간 : ");
		String view_operating_hours = sc.nextLine();
		
		//Cafe_Model 클래스에서 insertCafe 메서드를 가져오기
		model.insertCafe(view_id, view_cname, view_address, view_phone_number, view_operating_hours);
		System.out.println("카페 추가 완료\n");
		//sc.close(); //여기서 닫아버리면.. Controller에서도 Scanner가 닫혀버림..
	} //addCafeName()
	
	public void updateOperatingHours() {
		
		Scanner sc = new Scanner(System.in);
		 
		System.out.println("운영시간을 업데이트 하세요..");
		System.out.print("카페 이름 : ");
		String view_cname = sc.nextLine();
		System.out.print("변경된 운영 시간: ");
		String view_operating_hours=sc.nextLine();
		
		//Cafe_Model 클래스에서 updateOperatinghours 메서드 가져오기
		model.updateCafeOper(view_operating_hours, view_cname);
		System.out.println("정보 수정 완료\n");
		//sc.close();
	} //updateOperatingHours()
	
	public void updateAddress() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("카페 주소를 업데이트 하세요..");
		System.out.print("카페 이름 : ");
		String view_cname = sc.nextLine();
		System.out.print("변경된 카페 주소: ");
		String view_address = sc.nextLine();
		
		model.updateCafeAdd(view_address, view_cname);
		System.out.println("정보 수정 완료\n");
		//sc.close();
	} // updateAddress()

	public void deleteCafeRecord() { //자식레코드 발견 어쩌구 때문에 쩝스
		//자식키가 발견되면 삭제가 안됨.. CASCADE 갈겨야됨 ㅠ
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 카페의 ID를 입력하세요 : ");
		//int view_cafe_id = Integer.parseInt(sc.nextLine()); //String값으로 넣었을 때 숫자로 변환 원할 경우
		int view_cafe_id = sc.nextInt();
		
		model.deleteCafe(view_cafe_id);
		System.out.println("카페 삭제 완료\n");
		
	} //deleteCafeRecord()
	
	
}