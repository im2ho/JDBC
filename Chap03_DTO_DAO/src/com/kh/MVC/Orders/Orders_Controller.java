package com.kh.MVC.Orders;

import java.util.List;

public class Orders_Controller {
	//DAO�� View ����
	Orders_DAO dao;
	//Orders_View view;
	
	public Orders_Controller(Orders_DAO dao) {
		this.dao = dao;
	}
	
	//�޴� ��� �� ���� ��� �޼���
	public double cal_totalPrice(List<Orders_DTO> orders) {
		
		double total_price = 0;
		
		for(Orders_DTO total_p : orders) {
			total_price += total_p.getTotal_price();
		}
		
		return total_price;
	} // cal_totalPrice()
	
	//��� �ֹ� ����Ʈ �޼���
	public List<Orders_DTO> getAllOrders(){
		return dao.allOrders();
	} // getAllOrders()
}
