package com.kh.MVC.INSERT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class INSERT_model {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "khcafe";
	
	//Connection을 메서드 밖에 만들고 하나의 try catch로 묶을 수는 있으나.. 당장은 코드가 넘 복잡해 보일 수 잇기 때문에 메서드마다 추가해주자
	//메서드마다 매개변수 필수
	
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