package com.kh.MVC.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Products_DAO {
	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "kh1234";
	public Products_DAO() {
		try {
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Products_DTO> getAllProducts(){
		List<Products_DTO> products = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM products ");
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				int product_id = result.getInt("product_id");
				String product_name = result.getString("product_name");
				String category = result.getString("category");
				double price = result.getDouble("price");
				int stock_quantitiy = result.getInt("stock_quantity");
				
				Products_DTO product = new Products_DTO(product_id, product_name, category, price,stock_quantitiy);
				products.add(product);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
}








