package com.kh.MVC.shopping;

import java.util.List;

public class Products_Controller {

	private Products_DAO dao;
	
	public Products_Controller(Products_DAO dao) {
		this.dao = dao;
	}
	
	//모든 제품 총 가격 계산 메서드
	public double calculate_TotlaPrice(List<Products_DTO> products) {
		
		//향상된 for문을 활용하여 가격을 더해줄 것이기 때문에 값을 0으로 초기화
		double total_price = 0;
		
		for(Products_DTO total_p : products) {
			total_price += total_p.getPrice();
		}
		
		return total_price;
	} //calculate_TotlaPrice()
	
	//장바구니 제품 리스트 메서드
	public List<Products_DTO> getAllProducts(){
		return dao.getAllProducts();
	} //getAllProducts()
	
	
}
