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
			PreparedStatement pss = con.prepareStatement(insertSQL); //insertProducts�� ps�� �ٸ� ����
			
			//Products ���̺� ������ ����
			insertProducts(pss,10,"���뽬","����",2800.99,10); //�޼��带 ������
			insertProducts(pss,11,"ũ��Ű","���ݸ�����ǰ",1000,5);
			insertProducts(pss,12,"������","�ż���ǰ",2300,3);
			
			pss.close(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//�����غ��� print�� ���� �ʾƼ� �ֿܼ��� ������ ������ db���� ������Ʈ �Ǿ�����
	}

	//�Ű�����: product_id, product_name, category, price, stock_quantity
	static void insertProducts(PreparedStatement ps, int product_id, String product_name, String category, double price, int stock_quantity) throws SQLException{
		ps.setInt(1, product_id);
		ps.setString(2, product_name);
		ps.setString(3, category);
		ps.setDouble(4, price);
		ps.setInt(5, stock_quantity);
		ps.executeUpdate();
	}
}
