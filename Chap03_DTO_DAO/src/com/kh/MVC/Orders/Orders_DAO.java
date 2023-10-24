package com.kh.MVC.Orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orders_DAO {
	
	//멤버변수
	private Connection connection;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "khcafe";
	
	//생성자
	public Orders_DAO() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//주문 목록을 반환하는 메서드
	public List<Orders_DTO> allOrders(){
		
		List<Orders_DTO> orders = new ArrayList<>();
		String selectSQL = "SELECT * FROM orders";
		try {
			PreparedStatement ps = connection.prepareStatement(selectSQL);
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				int order_id = result.getInt("order_id");
				int cafe_id = result.getInt("cafe_id");
				int menu_id  = result.getInt("menu_id");
				Date order_date = result.getDate("order_date");
				int quantity = result.getInt("quantity");
				double total_price = result.getDouble("total_price");
				String mname = result.getString("mname");
				
				Orders_DTO order = new Orders_DTO(order_id, cafe_id, menu_id, order_date, quantity, total_price, mname);
				
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
		
	} //allOrders()
	

}
