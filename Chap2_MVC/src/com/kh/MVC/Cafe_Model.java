package com.kh.MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cafe_Model {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "khcafe";
	
	//Connection을 메서드 밖에 만들고 하나의 try catch로 묶을 수는 있으나.. 당장은 코드가 넘 복잡해 보일 수 잇기 때문에 메서드마다 추가해주자
	//메서드마다 매개변수 필수
	
	public void insertCafe(int cafe_id, String cname, String address, String phone_number, String operating_hours) {
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			String insertSQL = "INSERT INTO cafes(cafe_id, cname, address, phone_number, operating_hours)"
									+ "VALUES(?,?,?,?,?)";
			
			PreparedStatement insertState = con.prepareStatement(insertSQL);
			insertState.setInt(1,cafe_id);
			insertState.setString(2, cname);
			insertState.setString(3,address);
			insertState.setString(4, phone_number);
			insertState.setString(5, operating_hours);
			
			insertState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} //insertCafe()
	
	
	public void updateCafeOper(String operating_hours, String cname) { //카페의 운영시간을 바꿀래요
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String updateSQL = "UPDATE cafes SET operating_hours=? WHERE cname=?";
			PreparedStatement updateState = con.prepareStatement(updateSQL);
			
			updateState.setString(1, operating_hours);
			updateState.setString(2, cname);
			
			int resultRows = updateState.executeUpdate();
			
			if(resultRows==0) {
				System.out.println("조회되지 않는 카페 정보입니다\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} //updateCafeOper()
	
	public void updateCafeAdd(String address, String cname) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String updateSQL = "UPDATE cafes SET address = ? WHERE cname =?";
			PreparedStatement updateState = con.prepareStatement(updateSQL);
			
			updateState.setString(1, address);
			updateState.setString(2, cname);
			
			int resultRows = updateState.executeUpdate();
			
			if(resultRows==0) {
				System.out.println("조회되지 않는 카페 정보입니다\n");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
	} //updateCafeAdd()
	
	public void deleteCafe(int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String deleteSQL = "DELETE FROM cafes WHERE cafe_id=?";
			PreparedStatement deleteState = con.prepareStatement(deleteSQL);
			deleteState.setInt(1, cafe_id);
			
			deleteState.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
	} //deleteCafe()
	

}