package com.kh.MVC.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPay {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khbank";
	String password = "khbank";
	
	ShoppingCart cart;
	
	public UserPay(ShoppingCart cart) {
		this.cart = cart;
	}
	
	//���� �޼��� (���� ���� ���� ��ȯ)
	public boolean payment() {
		Connection connection = null;
		//¥������ �� �ݾ�
		//ShoppingCart�� ���� ���� �ݾ� �޼��� �߰��ؼ� �̿�.. �޼��� ���鷯 ����..
		double cartTotalPrice = cart.cartTotalPrice();
		
		try {
			connection = DriverManager.getConnection(url, user, password);
			//��ĭ�� ���� �ܾ� ��������
			String selectSQL = "SELECT balance FROM bank WHERE account_name = '��ĭ��'";
			PreparedStatement selectState = connection.prepareStatement(selectSQL);
			ResultSet result = selectState.executeQuery();
			
			if(result.next()) {
				//�ܾ� ��ȸ
				double balance = result.getDouble("balance");
				
				//�ܾ��� ������ ���
				if(balance < cartTotalPrice) {
					System.out.println("�ܾ��� �����մϴ�.");
					return false;
				}
				
				//�ܾ׿��� ��ٱ��� �Ѿ��� ���ֱ�
				double new_balance = balance - cartTotalPrice;
				
				//�ܾ� ������Ʈ
				String updateSQL = "UPDATE bank SET balance = ? WHERE account_name = '��ĭ��'";
				PreparedStatement updateState = connection.prepareStatement(updateSQL);
				updateState.setDouble(1, new_balance);
				updateState.executeUpdate();
				
				System.out.println("���� �Ϸ�\n�ܾ� : " + new_balance);
				return true;
			
			} else {
				System.out.println("���¸� ã�� �� �����ϴ�.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
