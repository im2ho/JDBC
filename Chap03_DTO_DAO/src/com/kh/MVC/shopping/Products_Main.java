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
		
		//쇼핑카트 인스턴스 생성
		ShoppingCart cart = new ShoppingCart();
		int choice = sc.nextInt();
		
		switch(choice) {
		
			case 1:
				//모든 제품 리스트 가져오기
				//List<Products_DTO> cart_products = controller.getAllProducts();
				view.showCart(products);
			
			case 2:
				//장바구니 가격 체크
				double total_price = controller.calculate_TotlaPrice(products);
				view.showTotalPrice(total_price);
			
			case 3:
				//장바구니 제품 추가
				System.out.print("장바구니에 추가할 제품의 ID를 입력하세요");
				int product_id = sc.nextInt();
				//향상된 for문과 if문 활용해서 제품 담기
				for(Products_DTO product : products) {
					if(product.getProduct_id() == product_id) {
						//카트에 추가
						cart.addCart(product);
						System.out.println(product.getProduct_name() + "을(를) 장바구니에 담았습니다.");
						break;
					}
				}
				
			case 4:
				//장바구니 제품 제거
				System.out.print("장바구니에서 제거할 제품의 ID를 입력하세요 : ");
				int remove_product_id = sc.nextInt();
				for(Products_DTO r : cart.get_cart_lsit()) {
					if(r.getProduct_id() == remove_product_id) {
						cart.removeProduct(r);
						break;
					}
				}
			case 5:
				//결제
				UserPay pay = new UserPay(cart);
				boolean payResult = pay.payment();
				
				if(payResult) {
					//cart 비우기
					products.clear();
				}
				break;
				
			default:
				System.out.println("잘못된 선택입니다");
		}
	}
}
