package com.kh.MVC.Singleton.INSERT;

import java.sql.SQLException;
import java.util.Scanner;

public class Product_View {
	
	public void addProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("새 제품 정보를 입력하세요");
		
		System.out.print("제품 ID : ");
		int product_id = sc.nextInt();
		
		System.out.print("\n제품명 : ");
		sc.nextLine();
		String product_name = sc.nextLine();
		
		System.out.print("\n제품 분류 : ");
		String category = sc.nextLine();
		
		System.out.print("\n정가 : ");
		double price = sc.nextDouble();
		
		System.out.print("\n재고 수량 : ");
		int stock_quantity = sc.nextInt();
		
		//Scanner로 받은 제품 내용을 새로 추가하기
		Product_DTO new_Product = new Product_DTO(product_id, product_name, category, price, stock_quantity);
		Product_Model product_Model;
		
		boolean success = false;
		
		try {
			//아까 Model 클래스에서 그 싱글톤 객체 ㅎㅋ static지정해서 걍 끌어다 쓸 수 잇긔
			product_Model = Product_Model.getInstance(); //인스턴스로 새 객체 저장 공간 만들고
			success = product_Model.insertProduct(new_Product); //여기서 ㄹㅇ 객체 집어넣기
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(success) {
			System.out.println("제품이 성공적으로 추가되었습니다.");
		} else {
			System.out.println("제품 추가 중 오류가 발생했습니다.");
		}
		
		//스캐너 닫기
		sc.close();
		
	} //addProduct()
	
}