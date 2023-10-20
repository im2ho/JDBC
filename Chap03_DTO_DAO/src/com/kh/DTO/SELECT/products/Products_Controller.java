package com.kh.DTO.SELECT.products;

import java.sql.Connection;
import java.util.List;

//모델과 뷰를.. 연결해주겟어요
public class Products_Controller {

	//필드 멤버변수
	private Products_Model m;
	private Products_View v;
	
	//생성자 (파라미터 두 개)
	public Products_Controller(Connection c, Products_View v) {
		this.m = new Products_Model(c);
		this.v = v;
	}
	
	//출력 메서드
	public void displayAllProducts() {
		List<Products_DTO> products = m.getProducts();
		v.displayProducts(products);
	} //displayAllProducts()
}