package com.kh.MVC.Singleton.UPDATE;

import java.sql.SQLException;
import java.util.Scanner;

public class Product_View {
	
	public void updateProduct() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가격을 수정할 제품명을 입력하세요 : ");
		String product_name = sc.nextLine();
		
		System.out.println("수정할 가격을 입력하세요 : ");
		double price = sc.nextDouble();
		
		//Product_DTO 인스턴스 생성
		Product_DTO new_Product = new Product_DTO(product_name, price);
		//Product_Model 객체 선언
		Product_Model product_Model;
		
		boolean success = false; //변수 선언 및 초기화
		//왜 초기화가 되어야하는가?
		//만약 success가 true가 아닐 경우 success의 값은 정해지지 않으므로..!
		//catch문에 success = false;를 선언해서 어느 경우에도 값이 정해지게 만들면 초기화 할 필요 X
		//boolean success;
		
		try {
			product_Model = Product_Model.getInstance(); //product_Model이라는 객체 반환됨
			success = product_Model.updateProduct(new_Product); //success = true
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false;
		}
		
		if(success==true) {
			System.out.println("제품이 성공적으로 수정되었습니다.");
		} else {
			System.out.println("제품 수정 중 오류가 발생했습니다.");
		}
		
		sc.close();
		
	} //updateProduct()
}
