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
	
	//필드 멤버변수 connection, 그리고 DB연결 위한 기타 등등..
	private Connection connection;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "khcafe";
	
	//생성자
	public Products_DAO() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//주문 목록을 반환하는 메서드
	public List<Products_DTO> getAllProducts(){
		
		List<Products_DTO> products = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		boolean a = true;
		
		while(a) {
		
			System.out.println("원하는 서비스를 선택하세요");
			System.out.println("1: 장바구니 추가 / 2: 장바구니 삭제 / 3: 장바구니 목록 조회");
			
			int choice = sc.nextInt();
			
			switch(choice) {
				
				case 1:
					sc.nextLine();
					while(true) {
						
						String selectSQL = "SELECT * FROM products WHERE product_name = ?";
						System.out.println("장바구니에 담을 상품명을 입력하세요 (선택 취소 q) : ");
						String select_product = sc.nextLine();
						
						if(select_product.equals("q")) {
							break;
						}
						
						try {
							PreparedStatement ps = connection.prepareStatement(selectSQL);
							ps.setString(1, select_product); //입력받은 제품명 삽입
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
						System.out.println("삭제를 원하시는 상품번호를 선택하세요 (선택취소 q): ");
						
						String select_num = sc.next();
						
						if(select_num.equals("q")) {
							break;
						}
						
						if(Integer.parseInt(select_num) <= products.size()) {
							products.remove(Integer.parseInt(select_num));
						} else {
							System.out.println("님 숫자 잘못 입력하셧어요");
						}
					} //while
					
					break;
					
				case 3:
					System.out.println("<장바구니 목록>");
					for(Products_DTO p : products) {
						System.out.println("제품명 : " + p.getProduct_name());
						System.out.println("제품 가격 : " + p.getPrice());
						System.out.println("-----------------------------");
					}
					break;
					
				case 4:
					System.out.println("장바구니 서비스를 종료합니다");
					a = false;
					break;
					
				default:
					System.out.println("잘못된 입력값 입니다 다시 입력해주세요");
				
			} //switch()
		
		} //while()
		
		return products;
		
	} // getAllProducts()
	
}