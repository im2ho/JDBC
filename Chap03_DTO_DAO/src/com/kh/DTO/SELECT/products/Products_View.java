package com.kh.DTO.SELECT.products;

import java.util.List;

public class Products_View {
	
	//무엇을 보여주는 메서드를 만들겠니?
	//List의 모든 값을 읽어주는 메서드를 만들겟어요 > 그럼 향상된 for문을 사용하자
	//View자체로는 모델과 연결되지 않아서 상관 없음 주의
	public void displayProducts(List<Products_DTO> productslist) {
		//Products_DTO 데이터 타입의, productslist에 있는 모든 값을 product_info라는 이름으로 출력하겟어요 
		for(Products_DTO product_info : productslist) {
			System.out.println("제품 번호 : " + product_info.getProduct_id());
			System.out.println("제품 명 : " + product_info.getProduct_name());
			System.out.println("제품 분류 : " + product_info.getCategory());
			System.out.println("제품 가격 : " + product_info.getPrice());
			System.out.println("재고량 : " + product_info.getStock_quantity());
			System.out.println();	
		}
	} //displayProducts()
}