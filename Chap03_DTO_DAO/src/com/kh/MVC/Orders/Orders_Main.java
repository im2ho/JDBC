package com.kh.MVC.Orders;

import java.util.List;

public class Orders_Main {

	public static void main(String[] args) {
		
		Orders_DAO dao = new Orders_DAO();
		Orders_Controller controller = new Orders_Controller(dao);
		Orders_View view = new Orders_View();
		
		List<Orders_DTO> orders = controller.getAllOrders();
		view.showOrderList(orders);
		
		double total_price = controller.cal_totalPrice(orders);
		view.showTotalPrice(total_price);
	}

}
