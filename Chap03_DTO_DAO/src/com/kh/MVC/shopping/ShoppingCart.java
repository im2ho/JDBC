package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	//ArrayList
	private List<Products_DTO> shopping_cart;
	
	//쇼핑카트 생성자
	public ShoppingCart() {
		shopping_cart = new ArrayList<>();
	}
	
	//장바구니 목록 전달해줄 get메서드 생성
	public List<Products_DTO> get_cart_lsit(){
		return shopping_cart;
	}
	
	//장바구니에 제품 추가하는 메서드
	public void addCart(Products_DTO product) {
		shopping_cart.add(product);
		System.out.println(product.getProduct_name() + "을(를) 장바구니에 추가");
	}
	
	//장바구니 제품 제거하는 메서드
	public void removeProduct(Products_DTO product) {
		if(shopping_cart.remove(product)) {
			System.out.println("장바구니에서 제거했습니다");
		} else {
			System.out.println("해당 제품이 존재하지 않습니다");
		}
	}
	
	//장바구니 최종 결제 금액 메서드
	public double cartTotalPrice() {
		//장바구니 상품 누적금액 반환해야돼서 변수 설정 후 0으로 초기화
		double total_price = 0;
		//향상된 for문을 이용해서 가격 추가
		for(Products_DTO c : shopping_cart) {
			total_price += c.getPrice();
		}
		
		return total_price;
	}
}