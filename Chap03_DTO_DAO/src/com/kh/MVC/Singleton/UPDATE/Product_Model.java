package com.kh.MVC.Singleton.UPDATE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Product_Model {
	
	private static Connection connection;
	
	//클래스의 인스턴스를 저장하는 싱글톤 객체
	private static Product_Model pm = null;
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "khcafe";
	private static String password = "khcafe";
	
	//외부에서 디폴트 생성자 맘대로 못만지게 캡슐화
	private Product_Model() {}
	
	//getInstance(): 클래스의 인스턴스를 반환하는 메서드
	// 	> public static Product_Model getInstance() : Product_Model 클래스의 인스턴스를 반환
	
	public static Product_Model getInstance() throws SQLException{
		//처음 호출될 때 데이터베이스에 연결을 설정하고 이후 호출에서는 이미 생성된 인스턴스를 반환
		//싱글톤 패턴을 구현하는 방식 (클래스가 단 하나의 인스턴스만 생성하도록..)
		if(pm==null) {
			pm = new Product_Model();
			connection = DriverManager.getConnection(url,user,password);
		}
		return pm;
	} //getInstance()
	
								//Product_DTO 클래스의 객체를 매개변수로 받궛어요
	public boolean updateProduct(Product_DTO product) {
		
		//제품명을 받고 가격을 수정하는 쿼리
		String updateSQL = "UPDATE products SET price=? WHERE product_name=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(updateSQL);
			ps.setDouble(1, product.getPrice());
			ps.setString(2, product.getProduct_name());
			
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0; //수정된 열이 존재하면 true반환
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		//return false;
		
	} //updateProduct()
}
