package com.kh.DTO.SELECT.products;

import java.sql.Connection;
import java.util.List;

//�𵨰� �並.. �������ְپ��
public class Products_Controller {

	//�ʵ� �������
	private Products_Model m;
	private Products_View v;
	
	//������ (�Ķ���� �� ��)
	public Products_Controller(Connection c, Products_View v) {
		this.m = new Products_Model(c);
		this.v = v;
	}
	
	//��� �޼���
	public void displayAllProducts() {
		List<Products_DTO> products = m.getProducts();
		v.displayProducts(products);
	} //displayAllProducts()
}