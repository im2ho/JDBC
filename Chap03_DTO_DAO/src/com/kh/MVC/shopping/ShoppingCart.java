package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	//ArrayList
	private List<Products_DTO> shopping_cart;
	
	//����īƮ ������
	public ShoppingCart() {
		shopping_cart = new ArrayList<>();
	}
	
	//��ٱ��� ��� �������� get�޼��� ����
	public List<Products_DTO> get_cart_lsit(){
		return shopping_cart;
	}
	
	//��ٱ��Ͽ� ��ǰ �߰��ϴ� �޼���
	public void addCart(Products_DTO product) {
		shopping_cart.add(product);
		System.out.println(product.getProduct_name() + "��(��) ��ٱ��Ͽ� �߰�");
	}
	
	//��ٱ��� ��ǰ �����ϴ� �޼���
	public void removeProduct(Products_DTO product) {
		if(shopping_cart.remove(product)) {
			System.out.println("��ٱ��Ͽ��� �����߽��ϴ�");
		} else {
			System.out.println("�ش� ��ǰ�� �������� �ʽ��ϴ�");
		}
	}
	
	//��ٱ��� ���� ���� �ݾ� �޼���
	public double cartTotalPrice() {
		//��ٱ��� ��ǰ �����ݾ� ��ȯ�ؾߵż� ���� ���� �� 0���� �ʱ�ȭ
		double total_price = 0;
		//���� for���� �̿��ؼ� ���� �߰�
		for(Products_DTO c : shopping_cart) {
			total_price += c.getPrice();
		}
		
		return total_price;
	}
}