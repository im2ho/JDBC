package com.kh.MVC.Orders;

import java.util.List;

public class Orders_View {
	
	//전체 주문 리스트 출력
	public void showOrderList(List<Orders_DTO> orders) {
		for(Orders_DTO order : orders) {
			System.out.println("주문 번호 : " + order.getOrder_id());
			System.out.println("주문 메뉴 번호 : " + order.getMenu_id());
			System.out.println("수량 : " + order.getQuantity());
			System.out.println("------------------------------");
		}
	} //showOrderList()
	
	//전체 주문 가격 합산
	public void showTotalPrice(double total_price) {
		System.out.println("총 가격 : " + total_price);
	} //showTotalPrice()
}
