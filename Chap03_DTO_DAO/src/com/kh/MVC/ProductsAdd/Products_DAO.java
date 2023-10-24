package com.kh.MVC.ProductsAdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Products_DAO {
	
	//�ʵ� ������� connection, �׸��� DB���� ���� ��Ÿ ���..
	private Connection connection;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "khcafe";
	
	//������
	public Products_DAO() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//�ֹ� ����� ��ȯ�ϴ� �޼���
	public List<Products_DTO> getAllProducts(){
		
		List<Products_DTO> products = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		boolean a = true;
		
		while(a) {
		
			System.out.println("���ϴ� ���񽺸� �����ϼ���");
			System.out.println("1: ��ٱ��� �߰� / 2: ��ٱ��� ���� / 3: ��ٱ��� ��� ��ȸ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
				
				case 1:
					sc.nextLine();
					while(true) {
						
						String selectSQL = "SELECT * FROM products WHERE product_name = ?";
						System.out.println("��ٱ��Ͽ� ���� ��ǰ���� �Է��ϼ��� (���� ��� q) : ");
						String select_product = sc.nextLine();
						
						if(select_product.equals("q")) {
							break;
						}
						
						try {
							PreparedStatement ps = connection.prepareStatement(selectSQL);
							ps.setString(1, select_product); //�Է¹��� ��ǰ�� ����
							ResultSet result = ps.executeQuery();
							
							while(result.next()) {
								
								String product_name = result.getString("product_name");
								double price = result.getDouble("price");
								
								Products_DTO product = new Products_DTO(product_name, price);
								
								products.add(product);
								
							} // while(result.next())
						} catch (SQLException e) {
							e.printStackTrace();
						} //try-catch
					
					} //while()
					
					break;
					
				case 2: 
					while(true) {
						System.out.println("������ ���Ͻô� ��ǰ��ȣ�� �����ϼ��� (������� q): ");
						
						String select_num = sc.next();
						
						if(select_num.equals("q")) {
							break;
						}
						
						if(Integer.parseInt(select_num) <= products.size()) {
							products.remove(Integer.parseInt(select_num));
						} else {
							System.out.println("�� ���� �߸� �Է��ϼ˾��");
						}
					} //while
					
					break;
					
				case 3:
					System.out.println("<��ٱ��� ���>");
					for(Products_DTO p : products) {
						System.out.println("��ǰ�� : " + p.getProduct_name());
						System.out.println("��ǰ ���� : " + p.getPrice());
						System.out.println("-----------------------------");
					}
					break;
					
				case 4:
					System.out.println("��ٱ��� ���񽺸� �����մϴ�");
					a = false;
					break;
					
				default:
					System.out.println("�߸��� �Է°� �Դϴ� �ٽ� �Է����ּ���");
				
			} //switch()
		
		} //while()
		
		return products;
		
	} // getAllProducts()
	
}