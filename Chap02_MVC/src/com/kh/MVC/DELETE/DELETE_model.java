package com.kh.MVC.DELETE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DELETE_model {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe"; 
	String password = "khcafe";
	
	public void deleteCafe(int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String deleteSQL = "DELETE FROM cafes WHERE cafe_id=?";
			PreparedStatement deleteState = con.prepareStatement(deleteSQL);
			deleteState.setInt(1, cafe_id);
			deleteState.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
