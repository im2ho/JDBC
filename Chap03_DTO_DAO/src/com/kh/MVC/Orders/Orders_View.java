package com.kh.MVC.Orders;

import java.util.List;

public class Orders_View {
	
	//��ü �ֹ� ����Ʈ ���
	public void showOrderList(List<Orders_DTO> orders) {
		for(Orders_DTO order : orders) {
			System.out.println("�ֹ� ��ȣ : " + order.getOrder_id());
			System.out.println("�ֹ� �޴� ��ȣ : " + order.getMenu_id());
			System.out.println("���� : " + order.getQuantity());
			System.out.println("------------------------------");
		}
	} //showOrderList()
	
	//��ü �ֹ� ���� �ջ�
	public void showTotalPrice(double total_price) {
		System.out.println("�� ���� : " + total_price);
	} //showTotalPrice()
}
