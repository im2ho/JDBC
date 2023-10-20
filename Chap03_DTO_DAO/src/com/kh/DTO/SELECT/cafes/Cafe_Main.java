package com.kh.DTO.SELECT.cafes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cafe_Main {

	public static void main(String[] args) {
		
		// Connection에 연결할 내용 작성
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "khcafe";
		
		try {
			
			Connection con = DriverManager.getConnection(url, user, password);

			//인스턴스 생성하여 뷰 초기화
			Cafe_View v = new Cafe_View();
			
			//인스턴스 생성하여 컨트롤러 초기화
			Cafe_Controller c = new Cafe_Controller(con,v);
			
			//카페 정보 표시하는 메서드 가져오기
			c.displayAllCafes();
			
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} //main()

}
