package com.kh.MVC.INSERT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class INSERT_model {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "khcafe";
	
	//Connection�� �޼��� �ۿ� ����� �ϳ��� try catch�� ���� ���� ������.. ������ �ڵ尡 �� ������ ���� �� �ձ� ������ �޼��帶�� �߰�������
	//�޼��帶�� �Ű����� �ʼ�
	
	public void insertCafe(/*int cafe_id, */String cname, String address, String phone_number, String operating_hours) {
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			String insertSQL = "INSERT INTO cafes(cname, address, phone_number, operating_hours)"
									+ "VALUES(?,?,?,?)";
			
			PreparedStatement insertState = con.prepareStatement(insertSQL);
			//insertState.setInt(1,cafe_id);
			insertState.setString(1, cname);
			insertState.setString(2,address);
			insertState.setString(3, phone_number);
			insertState.setString(4, operating_hours);
			
			insertState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}