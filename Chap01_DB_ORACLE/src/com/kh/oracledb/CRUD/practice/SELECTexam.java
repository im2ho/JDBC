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
		//1. 드라이버 연결
		//String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ORACLE과 컴퓨터 연결 : DB 연결 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //thin : 100% 자바 클라이언트 드라이버
		String user = "say";
		String password = "say";
		Connection con = null; //Connection : java.sql 기본 제공
		
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("ORACLE DB 연결 완료\n");
			
			//SELECT 쿼리 예제
			String selectQuery = 
					"SELECT * FROM nationalpokedex WHERE type=? AND base_stats=?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			
			selectState.setString(1,"드래곤");
			selectState.setInt(2, 600);		
			
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
				String name = result.getString("name");
				int bs = result.getInt("base_stats");
				System.out.println("이름: " + name + " / 종족치: " + bs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
