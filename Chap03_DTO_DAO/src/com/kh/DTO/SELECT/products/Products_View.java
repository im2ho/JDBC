package com.kh.DTO.SELECT.products;

import java.util.List;

public class Products_View {
	
	//������ �����ִ� �޼��带 ����ڴ�?
	//List�� ��� ���� �о��ִ� �޼��带 ����پ�� > �׷� ���� for���� �������
	//View��ü�δ� �𵨰� ������� �ʾƼ� ��� ���� ����
	public void displayProducts(List<Products_DTO> productslist) {
		//Products_DTO ������ Ÿ����, productslist�� �ִ� ��� ���� product_info��� �̸����� ����ϰپ�� 
		for(Products_DTO product_info : productslist) {
			System.out.println("��ǰ ��ȣ : " + product_info.getProduct_id());
			System.out.println("��ǰ �� : " + product_info.getProduct_name());
			System.out.println("��ǰ �з� : " + product_info.getCategory());
			System.out.println("��ǰ ���� : " + product_info.getPrice());
			System.out.println("��� : " + product_info.getStock_quantity());
			System.out.println();	
		}
	} //displayProducts()
}