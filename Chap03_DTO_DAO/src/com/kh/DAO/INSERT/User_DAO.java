package com.kh.DAO.INSERT;

import java.sql.Connection;
import java.sql.Date; //java.util로 가져왔으면 그걸로 import
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User_DAO {
	
	//멤버변수
	private Connection connection;
	
	//생성자
	private User_DAO() {}
	
	public User_DAO(Connection connection) {
		this.connection = connection;
	}
	
	//user를 생성하는 메서드
	public boolean createUser(User_VO user) {
		
		String insertSQL = "INSERT INTO user_info(user_id, user_name, email, reg_date)"
							+ "VALUES(?,?,?,?)";
		
		try {
			
			PreparedStatement insertState = connection.prepareStatement(insertSQL);
			
			insertState.setInt(1, user.getUser_id());
			insertState.setString(2, user.getUser_name());
			insertState.setString(3, user.getEmail());
			insertState.setDate(4, new Date(user.getReg_date().getTime())); //import java.sql.Date
			
			int rows = insertState.executeUpdate();
			return rows > 0; //true
			
		} catch (SQLException e) {// 값이 제대로 들어오지 않을 때 작동하는 공간
			e.printStackTrace();
			return false;
		}
	} //createUser()
}
