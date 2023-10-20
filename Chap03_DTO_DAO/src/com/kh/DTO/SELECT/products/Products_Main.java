package com.kh.DTO.SELECT.products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Products_Main {

	public static void main(String[] args) {
		
		//Connection ����
		String jdbc_oralcle_url = "jdbc:oracle:thin:@localhost:1521:xe"; //���߿� �ٸ� DBMS�� �� ���� �����ϱ�..
		String user = "khcafe";
		String password = "khcafe";
		
		try {
			
			Connection con = DriverManager.getConnection(jdbc_oralcle_url, user, password);
			
			//�ν��Ͻ� ����
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