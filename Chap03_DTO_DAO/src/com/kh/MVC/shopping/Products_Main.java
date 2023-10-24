package com.kh.MVC.shopping;

import java.util.List;
import java.util.Scanner;

public class Products_Main {
	
	public static void main(String[] args) {
		
		Products_DAO dao = new Products_DAO();
		Products_Controller controller = new Products_Controller(dao);
		Products_View view = new Products_View();
		
		List<Products_DTO> products = controller.getAllProducts();
		Scanner sc = new Scanner(System.in);
		
		//����īƮ �ν��Ͻ� ����
		ShoppingCart cart = new ShoppingCart();
		int choice = sc.nextInt();
		
		switch(choice) {
		
			case 1:
				//��� ��ǰ ����Ʈ ��������
				//List<Products_DTO> cart_products = controller.getAllProducts();
				view.showCart(products);
			
			case 2:
				//��ٱ��� ���� üũ
				double total_price = controller.calculate_TotlaPrice(products);
				view.showTotalPrice(total_price);
			
			case 3:
				//��ٱ��� ��ǰ �߰�
				System.out.print("��ٱ��Ͽ� �߰��� ��ǰ�� ID�� �Է��ϼ���");
				int product_id = sc.nextInt();
				//���� for���� if�� Ȱ���ؼ� ��ǰ ���
				for(Products_DTO product : products) {
					if(product.getProduct_id() == product_id) {
						//īƮ�� �߰�
						cart.addCart(product);
						System.out.println(product.getProduct_name() + "��(��) ��ٱ��Ͽ� ��ҽ��ϴ�.");
						break;
					}
				}
				
			case 4:
				//��ٱ��� ��ǰ ����
				System.out.print("��ٱ��Ͽ��� ������ ��ǰ�� ID�� �Է��ϼ��� : ");
				int remove_product_id = sc.nextInt();
				for(Products_DTO r : cart.get_cart_lsit()) {
					if(r.getProduct_id() == remove_product_id) {
						cart.removeProduct(r);
						break;
					}
				}
			case 5:
				//����
				UserPay pay = new UserPay(cart);
				boolean payResult = pay.payment();
				
				if(payResult) {
					//cart ����
					products.clear();
				}
				break;
				
			default:
				System.out.println("�߸��� �����Դϴ�");
		}
	}
}
