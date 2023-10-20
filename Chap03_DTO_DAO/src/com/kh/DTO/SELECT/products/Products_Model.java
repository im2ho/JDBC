package com.kh.DTO.SELECT.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Products_Model {

	//�������
	private Connection con; //main���� �����Ұ�..
	
	//������
	public Products_Model(Connection con) { //Ŀ�ؼ��� �Ű������� ����
		this.con = con;
	}
	
	//getProducts() :��ǰ���� ��ȯ �޴� �޼��� 
	//				> ��� ���� ���� ���� ��ȯ ���� ���ΰ�? 
	//				> List�� �������!
	public List<Products_DTO> getProducts() { 
		//�ȴ�.. ����Ʈ ���鷯 �ӿ���.. try�ȿ� ����� ���������ż� X
		//										   <>:� ������ Ư������ ����.. ��� ������ Ÿ��OK
		List<Products_DTO> products = new ArrayList<>();
		
		String selectSQL = "SELECT * FROM products ORDER BY product_id";
		try {
			PreparedStatement selectState = con.prepareStatement(selectSQL);
			ResultSet result = selectState.executeQuery();
			
			//while() : select all vs if() : select one
			while(result.next()) {
				Products_DTO product = new Products_DTO(); //����Ʈ �����ڷ� �ν��Ͻ� ������ܿ�
				
				product.setProduct_id(result.getInt("product_id"));
				product.setProduct_name(result.getString("product_name"));
				product.setCategory(result.getString("category"));
				product.setPrice(result.getDouble("price"));
				product.setStock_quantity(result.getInt("stock_quantity"));
				
				//��� ���ڵ带 �о�� ������ ���� ���� �༮�� �ʿ��ѵ�..
				//����Ʈ�� ������! ������ ����� �ðԿ� ����..
				products.add(product); //����Ʈ��.add(��ü);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//get�޼���� ��ȯ �� �ʿ���..
		return products;
	}//getProducts()
}
