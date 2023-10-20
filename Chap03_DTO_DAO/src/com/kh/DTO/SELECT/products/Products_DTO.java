package com.kh.DTO.SELECT.products;

//DTO: 데이터를 전송하는 객체를 만들자!
public class Products_DTO {
	//필드 멤변 캡슐화
	private int product_id;
	private String product_name;
	private String category;
	private double price;
	private int stock_quantity;
	
	//디폴트 생성자
	public Products_DTO() {}
	
	//파라미터 추가 생성자
	public Products_DTO(int product_id, String product_name, String category, double price, int stock_quantity) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.category = category;
		this.price = price;
		this.stock_quantity = stock_quantity;
	}

	//Getter-----------------------------------
	
	public int getProduct_id() {
		return product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public int getStock_quantity() {
		return stock_quantity;
	}

	//Setter-----------------------------------
	
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	
	//Override-----------------없어도 굴러가는데?????
	@Override
	public String toString() {
		return "Products_DTO" + product_id ;
	}
	
}