package com.kh.MVC.ProductsAdd;

import java.util.List;
import java.util.Scanner;


public class Products_View {

	Scanner sc = new Scanner(System.in);
	
	//선택한 제품의 리스트를 뽑는 메서드
	public void showCart(List<Products_DTO> products) {
		
		System.out.println("<현재 장바구니 목록>");
		
		for(Products_DTO p : products) {
			System.out.println("제품명 : " + p.getProduct_name());
			System.out.println("가격 : " + p.getPrice());
			System.out.println("--------------------");
		}
		
	} // showCart()
	
	//--------------------------------------------------------
	
	//제품들의 가격을 계산하는 메서드
	public void showTotalPrice(double total_price) {
		
		System.out.println("총 가격 : " + total_price);
		
	} //showTotalPrice()
	

}