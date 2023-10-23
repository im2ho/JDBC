package com.kh.DAO.SELECT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User_DAO {

	//멤버변수
	private Connection connection;
	
	//생성자
	private User_DAO() {} //기본 생성자 숨기기
	
	public User_DAO(Connection connection) {
		this.connection = connection;
	}
	

	//유저 정보를 보여주는 메서드
	public List<User_VO> getAllUsers() throws SQLException {
		
		List<User_VO> users = new ArrayList<>();
		
		String selectSQL = "SELECT * FROM user_info";
		//try - with - resources
	
		PreparedStatement selectState = connection.prepareStatement(selectSQL);
		ResultSet result = selectState.executeQuery();
			
		while(result.next()) {
			User_VO user = new User_VO();
				
			user.setUser_id(result.getInt("user_id"));
			user.setUser_name(result.getString("user_name"));
			user.setEmail(result.getString("email"));
			user.setReg_date(result.getDate("reg_date"));
				
			users.add(user); //리스트에 정보 담기
		}
		
		return users;
		
	} //getUserInfo()
}
