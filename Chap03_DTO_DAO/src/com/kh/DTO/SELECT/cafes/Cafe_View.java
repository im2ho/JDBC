package com.kh.DTO.SELECT.cafes;

import java.util.List;

//view에는 주로 void 메서드만 사용해주자...
public class Cafe_View {
	
	public void displayCafes(List<Cafe_DTO> cafes) {
		for(Cafe_DTO cafe_info : cafes) {
			System.out.println("Cafe_id : " + cafe_info.getCafe_id());
			System.out.println("Cafe_name : " + cafe_info.getCafe_name());
			System.out.println("Address : " + cafe_info.getAddress());
			System.out.println("Phone_number : " + cafe_info.getPhone_number());
			System.out.println("Operating_hours : " + cafe_info.getOperating_hours());
			System.out.println();
		}
	} //displayCafes()
}
