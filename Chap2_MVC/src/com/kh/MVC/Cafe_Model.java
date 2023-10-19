package com.kh.MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cafe_Model {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "khcafe";
	
	//Connection�� �޼��� �ۿ� ����� �ϳ��� try catch�� ���� ���� ������.. ������ �ڵ尡 �� ������ ���� �� �ձ� ������ �޼��帶�� �߰�������
	//�޼��帶�� �Ű����� �ʼ�
	
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
	
	
	public void updateCafeOper(String operating_hours, String cname) { //ī���� ��ð��� �ٲܷ���
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String updateSQL = "UPDATE cafes SET operating_hours=? WHERE cname=?";
			PreparedStatement updateState = con.prepareStatement(updateSQL);
			
			updateState.setString(1, operating_hours);
			updateState.setString(2, cname);
			
			int resultRows = updateState.executeUpdate();
			
			if(resultRows==0) {
				System.out.println("��ȸ���� �ʴ� ī�� �����Դϴ�\n");
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
				System.out.println("��ȸ���� �ʴ� ī�� �����Դϴ�\n");
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