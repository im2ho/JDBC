package com.kh.MVC.Orders;

import java.util.List;

public class Orders_Controller {
	//DAO와 View 연결
	Orders_DAO dao;
	//Orders_View view;
	
	public Orders_Controller(Orders_DAO dao) {
		this.dao = dao;
	}
	
	//메뉴 목록 총 가격 계산 메서드
	public double cal_totalPrice(List<Orders_DTO> orders) {
		
		double total_price = 0;
		
		for(Orders_DTO total_p : orders) {
			total_price += total_p.getTotal_price();
		}
		
		return total_price;
	} // cal_totalPrice()
	
	//모든 주문 리스트 메서드
	public List<Orders_DTO> getAllOrders(){
		return dao.allOrders();
	} // getAllOrders()
}
