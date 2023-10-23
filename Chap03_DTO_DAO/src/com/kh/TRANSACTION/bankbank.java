package com.kh.TRANSACTION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class bankbank {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khbank";
	String password = "khbank";

	public static void main(String[] args) throws SQLException {
		
		bankbank bank = new bankbank();
		
		bank.select(5000, 4, 1);
	}
	
	public void select(double money, int account_id, int account_id2) throws SQLException {
		Connection con = DriverManager.getConnection(url,user,password);
		
		String updateSQL1 = "UPDATE bank SET balance = balance - ? WHERE account_id =?";
		String updateSQL2 = "UPDATE bank SET balance = balance + ? WHERE account_id =?";
		
		PreparedStatement ps1 = con.prepareStatement(updateSQL1);
		PreparedStatement ps2 = con.prepareStatement(updateSQL2);
		
		ps1.setDouble(1, money);
		ps1.setInt(2, account_id);
		ps1.executeUpdate();
		
		ps2.setDouble(1, money);
		ps2.setInt(2,account_id2);
		ps2.executeUpdate();
		
		
		System.out.println("송금완료");
	}
}
