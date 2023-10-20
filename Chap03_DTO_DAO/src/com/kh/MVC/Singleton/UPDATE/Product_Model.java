package com.kh.MVC.Singleton.UPDATE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Product_Model {
	
	private static Connection connection;
	
	//Ŭ������ �ν��Ͻ��� �����ϴ� �̱��� ��ü
	private static Product_Model pm = null;
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "khcafe";
	private static String password = "khcafe";
	
	//�ܺο��� ����Ʈ ������ ����� �������� ĸ��ȭ
	private Product_Model() {}
	
	//getInstance(): Ŭ������ �ν��Ͻ��� ��ȯ�ϴ� �޼���
	// 	> public static Product_Model getInstance() : Product_Model Ŭ������ �ν��Ͻ��� ��ȯ
	
	public static Product_Model getInstance() throws SQLException{
		//ó�� ȣ��� �� �����ͺ��̽��� ������ �����ϰ� ���� ȣ�⿡���� �̹� ������ �ν��Ͻ��� ��ȯ
		//�̱��� ������ �����ϴ� ��� (Ŭ������ �� �ϳ��� �ν��Ͻ��� �����ϵ���..)
		if(pm==null) {
			pm = new Product_Model();
			connection = DriverManager.getConnection(url,user,password);
		}
		return pm;
	} //getInstance()
	
								//Product_DTO Ŭ������ ��ü�� �Ű������� �ނ����
	public boolean updateProduct(Product_DTO product) {
		
		//��ǰ���� �ް� ������ �����ϴ� ����
		String updateSQL = "UPDATE products SET price=? WHERE product_name=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(updateSQL);
			ps.setDouble(1, product.getPrice());
			ps.setString(2, product.getProduct_name());
			
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0; //������ ���� �����ϸ� true��ȯ
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		//return false;
		
	} //updateProduct()
}
