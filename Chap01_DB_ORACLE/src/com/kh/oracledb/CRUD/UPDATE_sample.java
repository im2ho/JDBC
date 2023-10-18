package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UPDATE_sample {

	public static void main(String[] args) {
		String jdbcurl= "jdbc:oracle:thin:@localhost:1521:xe";
		String user= "khbank";
		String passoword = "khbank";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl, user, passoword);
			String updateQuery = "UPDATE bank SET balance=? WHERE account_number=?";
			PreparedStatement updateState = con.prepareStatement(updateQuery);
			
			updateState.setDouble(1, 2000);
			updateState.setString(2, "63220255853");
			
			int rowsUpdate = updateState.executeUpdate();
			System.out.println(rowsUpdate + "업데이트 되었습니다.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
