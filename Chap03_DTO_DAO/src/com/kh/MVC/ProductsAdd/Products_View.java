package com.kh.MVC.ProductsAdd;

import java.util.List;
import java.util.Scanner;


public class Products_View {

	Scanner sc = new Scanner(System.in);
	
	//������ ��ǰ�� ����Ʈ�� �̴� �޼���
	public void showCart(List<Products_DTO> products) {
		
		System.out.println("<���� ��ٱ��� ���>");
		
		for(Products_DTO p : products) {
			System.out.println("��ǰ�� : " + p.getProduct_name());
			System.out.println("���� : " + p.getPrice());
			System.out.println("--------------------");
		}
		
	} // showCart()
	
	//--------------------------------------------------------
	
	//��ǰ���� ������ ����ϴ� �޼���
	public void showTotalPrice(double total_price) {
		
		System.out.println("�� ���� : " + total_price);
		
	} //showTotalPrice()
	

}