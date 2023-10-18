package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class INSERT_all {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO products( product_id, product_name, category, price, stock_quantity)"
								+ "VALUES(?,?,?,?,?)";
			PreparedStatement pss = con.prepareStatement(insertSQL); //insertProducts의 ps와 다른 변수
			
			//Products 테이블에 데이터 삽입
			insertProducts(pss,10,"랩노쉬","음료",2800.99,10); //메서드를 만들좌
			insertProducts(pss,11,"크런키","초콜릿가공품",1000,5);
			insertProducts(pss,12,"감동란","신선식품",2300,3);
			
			pss.close(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//실행해보면 print를 쓰지 않아서 콘솔에는 나오지 않지만 db에는 업데이트 되어잇음
	}

	//매개변수: product_id, product_name, category, price, stock_quantity
	static void insertProducts(PreparedStatement ps, int product_id, String product_name, String category, double price, int stock_quantity) throws SQLException{
		ps.setInt(1, product_id);
		ps.setString(2, product_name);
		ps.setString(3, category);
		ps.setDouble(4, price);
		ps.setInt(5, stock_quantity);
		ps.executeUpdate();
	}
}
