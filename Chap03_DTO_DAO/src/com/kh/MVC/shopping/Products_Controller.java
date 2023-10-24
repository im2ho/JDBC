package com.kh.MVC.shopping;

import java.util.List;

public class Products_Controller {

	private Products_DAO dao;
	
	public Products_Controller(Products_DAO dao) {
		this.dao = dao;
	}
	
	//��� ��ǰ �� ���� ��� �޼���
	public double calculate_TotlaPrice(List<Products_DTO> products) {
		
		//���� for���� Ȱ���Ͽ� ������ ������ ���̱� ������ ���� 0���� �ʱ�ȭ
		double total_price = 0;
		
		for(Products_DTO total_p : products) {
			total_price += total_p.getPrice();
		}
		
		return total_price;
	} //calculate_TotlaPrice()
	
	//��ٱ��� ��ǰ ����Ʈ �޼���
	public List<Products_DTO> getAllProducts(){
		return dao.getAllProducts();
	} //getAllProducts()
	
	
}
