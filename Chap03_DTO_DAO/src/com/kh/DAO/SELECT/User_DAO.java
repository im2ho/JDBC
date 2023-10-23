package com.kh.DAO.SELECT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User_DAO {

	//�������
	private Connection connection;
	
	//������
	private User_DAO() {} //�⺻ ������ �����
	
	public User_DAO(Connection connection) {
		this.connection = connection;
	}
	

	//���� ������ �����ִ� �޼���
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
				
			users.add(user); //����Ʈ�� ���� ���
		}
		
		return users;
		
	} //getUserInfo()
}
