package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DELETE_sample {

	public static void main(String[] args) {
		String jdbcurl= "jdbc:oracle:thin:@localhost:1521:xe";
		String user= "khbank";
		String passoword = "khbank";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl, user, passoword);
			String deleteQuery = "DELETE FROM bank WHERE account_number = ?";
			PreparedStatement deleteState = con.prepareStatement(deleteQuery);
			
			deleteState.setString(1, "8888999000");
			
			int rowsUpdate = deleteState.executeUpdate();
			System.out.println(rowsUpdate + "삭제 되었습니다.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}