package com.kh.DAO.INSERT;

import java.sql.Connection;
import java.sql.Date; //java.util�� ���������� �װɷ� import
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User_DAO {
	
	//�������
	private Connection connection;
	
	//������
	private User_DAO() {}
	
	public User_DAO(Connection connection) {
		this.connection = connection;
	}
	
	//user�� �����ϴ� �޼���
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
			
		} catch (SQLException e) {// ���� ����� ������ ���� �� �۵��ϴ� ����
			e.printStackTrace();
			return false;
		}
	} //createUser()
}
