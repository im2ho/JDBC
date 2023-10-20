package com.kh.DTO.SELECT.cafes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cafe_Main {

	public static void main(String[] args) {
		
		// Connection�� ������ ���� �ۼ�
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "khcafe";
		
		try {
			
			Connection con = DriverManager.getConnection(url, user, password);

			//�ν��Ͻ� �����Ͽ� �� �ʱ�ȭ
			Cafe_View v = new Cafe_View();
			
			//�ν��Ͻ� �����Ͽ� ��Ʈ�ѷ� �ʱ�ȭ
			Cafe_Controller c = new Cafe_Controller(con,v);
			
			//ī�� ���� ǥ���ϴ� �޼��� ��������
			c.displayAllCafes();
			
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} //main()

}
