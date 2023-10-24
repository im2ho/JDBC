package com.kh.MVC.ProductsAdd;

import java.util.List;
import java.util.Scanner;

public class Products_Main {

	static Join_bank bank = new Join_bank();
	
	public static void main(String[] args) {
		
		Products_DAO dao = new Products_DAO();
		Products_Controller controller = new Products_Controller(dao);
		Products_View view = new Products_View();
		
		//dao.getAllProducts();
		
		//��ٱ��� ��ǰ ����Ʈ ��������
		List<Products_DTO> cart_products = controller.getCartProducts();
		
		view.showCart(cart_products);
		
		//��ٱ��� ���� üũ
		double total_price = controller.calculate_TotlaPrice(cart_products);
		view.showTotalPrice(total_price);
		
		//�̸����� �ܾ���ȸ
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ֹ����� ������ �Է����ּ��� : ");
		String name = sc.next();
		bank.show_balance(name);
		//��� ��
		System.out.println();
		bank.update_balance(name,total_price);
	}
}
