package com.kh.oracledb.CRUD.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SELECTexam {

	public static void main(String[] args) {
		select_ex();
	}
	
	public static void select_ex() {
		//1. ����̹� ����
		//String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ORACLE�� ��ǻ�� ���� : DB ���� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //thin : 100% �ڹ� Ŭ���̾�Ʈ ����̹�
		String user = "say";
		String password = "say";
		Connection con = null; //Connection : java.sql �⺻ ����
		
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("ORACLE DB ���� �Ϸ�\n");
			
			//SELECT ���� ����
			String selectQuery = 
					"SELECT * FROM nationalpokedex WHERE type=? AND base_stats=?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			
			selectState.setString(1,"�巡��");
			selectState.setInt(2, 600);		
			
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
				String name = result.getString("name");
				int bs = result.getInt("base_stats");
				System.out.println("�̸�: " + name + " / ����ġ: " + bs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
