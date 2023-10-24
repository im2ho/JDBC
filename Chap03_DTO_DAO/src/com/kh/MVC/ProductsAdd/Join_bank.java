package com.kh.MVC.ProductsAdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Join_bank {

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khbank";
	String password = "khbank";
	Connection con = null;
	private Products_DAO dao;
	
	//생성자
	public Join_bank() {}
	
	//인스턴스..
	static Join_bank bank = new Join_bank();
	Products_Controller pc = new Products_Controller(dao);
	
	//잔액조회 메서드
	public void show_balance(String name) {
		try {
			con = DriverManager.getConnection(url, user, password);
			String selectSQL = "SELECT balance FROM bank WHERE account_name = ?";
			PreparedStatement ps = con.prepareStatement(selectSQL);
			
			ps.setString(1, name);
			
			ResultSet result = ps.executeQuery();
			result.next();
			double balance = result.getDouble("balance");
			System.out.println(name + "님의 계산 전 잔액은 " + balance + "원 입니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	} //show_balance()
	
	//계산 후 잔액 업데이트 메서드
	public void update_balance(String name, double pay) {
		try {
			con = DriverManager.getConnection(url, user, password);
			String updateSQL = "UPDATE bank SET balance = balance - ? WHERE account_name =?";
			PreparedStatement ps = con.prepareStatement(updateSQL);
			
			ps.setDouble(1, pay);
			ps.setString(2, name);
			
			ps.executeUpdate();
			
			String selectSQL = "SELECT balance FROM bank WHERE account_name = ?";
			PreparedStatement selectState = con.prepareStatement(selectSQL);
			selectState.setString(1, name);
			
			ResultSet result = selectState.executeQuery();
			result.next();
			double balance = result.getDouble("balance");
			System.out.println("계산 후 " + name + "님의 잔액은 " + balance + "원 입니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //pay_bank()
	
}