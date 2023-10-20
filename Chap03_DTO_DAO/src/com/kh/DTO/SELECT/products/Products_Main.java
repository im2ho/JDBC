package com.kh.DTO.SELECT.products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Products_Main {

	public static void main(String[] args) {
		
		//Connection 구현
		String jdbc_oralcle_url = "jdbc:oracle:thin:@localhost:1521:xe"; //나중에 다른 DBMS를 쓸 수도 잇으니까..
		String user = "khcafe";
		String password = "khcafe";
		
		try {
			
			Connection con = DriverManager.getConnection(jdbc_oralcle_url, user, password);
			
			//인스턴스 생성
			Products_View v = new Products_View();
			Products_Controller c = new Products_Controller(con,v);
			
			c.displayAllProducts();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} //main()

}