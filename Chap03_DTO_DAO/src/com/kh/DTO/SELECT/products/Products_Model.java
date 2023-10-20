package com.kh.DTO.SELECT.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Products_Model {

	//멤버변수
	private Connection con; //main가서 구현할것..
	
	//생성자
	public Products_Model(Connection con) { //커넥션을 매개변수로 받좌
		this.con = con;
	}
	
	//getProducts() :제품들을 반환 받는 메서드 
	//				> 어떻게 여러 개의 값을 반환 받을 것인가? 
	//				> List를 사용하자!
	public List<Products_DTO> getProducts() { 
		//안뇽.. 리스트 만들러 왓여요.. try안에 만들면 지역변수돼서 X
		//										   <>:어떤 값인지 특정하지 않음.. 모든 데이터 타입OK
		List<Products_DTO> products = new ArrayList<>();
		
		String selectSQL = "SELECT * FROM products ORDER BY product_id";
		try {
			PreparedStatement selectState = con.prepareStatement(selectSQL);
			ResultSet result = selectState.executeQuery();
			
			//while() : select all vs if() : select one
			while(result.next()) {
				Products_DTO product = new Products_DTO(); //디폴트 생성자로 인스턴스 만들어줌요
				
				product.setProduct_id(result.getInt("product_id"));
				product.setProduct_name(result.getString("product_name"));
				product.setCategory(result.getString("category"));
				product.setPrice(result.getDouble("price"));
				product.setStock_quantity(result.getInt("stock_quantity"));
				
				//모든 레코드를 읽어올 때마다 값을 담을 녀석이 필요한데..
				//리스트를 만들자! 위에서 만들고 올게요 히히..
				products.add(product); //리스트명.add(객체);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//get메서드라 반환 값 필요해..
		return products;
	}//getProducts()
}
