package com.kh.TRANSACTION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bank {
	
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "khbank";
	static String password = "khbank";
	
	public static void main(String[] args) {
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String selectSQL = "SELECT balance FROM bank WHERE account_name = ?";
			PreparedStatement selectState = con.prepareStatement(selectSQL);
		
			
			con.setAutoCommit(false);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //main()
}
