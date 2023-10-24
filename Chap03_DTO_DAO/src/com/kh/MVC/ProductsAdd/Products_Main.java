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
		
		//장바구니 제품 리스트 가져오기
		List<Products_DTO> cart_products = controller.getCartProducts();
		
		view.showCart(cart_products);
		
		//장바구니 가격 체크
		double total_price = controller.calculate_TotlaPrice(cart_products);
		view.showTotalPrice(total_price);
		
		//이름으로 잔액조회
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주문자의 성함을 입력해주세요 : ");
		String name = sc.next();
		bank.show_balance(name);
		//계산 후
		System.out.println();
		bank.update_balance(name,total_price);
	}
}
