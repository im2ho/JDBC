package com.kh.MVC.Singleton.INSERT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Product_Model {
	
	private static Connection connection;
	
	//Ŭ������ �ν��Ͻ��� �����ϴ� �̱��� ��ü
	private static Product_Model pm = null;
	
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "khcafe";
	
	//�⺻�����ڷκ��� �ܺο��� �ν��Ͻ��� ���� �����ϴ� ���� �����ϱ� ���� private ����
	private Product_Model() {}

	//Product_Model Ŭ������ �ν��Ͻ��� ��ȯ�ϴ� �޼���
	//ó�� ȣ��� �� �����ͺ��̽��� ������ �����ϰ� ���� ȣ�⿡���� �̹� ������ �ν��Ͻ��� ��ȯ
	//�̱��� ������ �����ϴ� ���
	public static Product_Model getInstance() throws SQLException{
		if(pm == null) {
			pm = new Product_Model();
			connection = DriverManager.getConnection(DB_URL, ID, PW);
		}
		return pm;
	} //getInstance()
	
	public boolean insertProduct(Product_DTO product) {
		
		String insertSQL = "INSERT INTO products (product_id, product_name, category, price, stock_quantity)"
							+ "VALUES(?, ?, ? , ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(insertSQL);
			ps.setInt(1, product.getProduct_id());
			ps.setString(2, product.getProduct_name());
			ps.setString(3, product.getCategory());
			ps.setDouble(4, product.getPrice());
			ps.setInt(5, product.getStock_quantity());
			
			int rowsAffected = ps.executeUpdate();
			
			return rowsAffected > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} //insertProduct()
}
