package com.kh.MVC.Singleton.INSERT;

public class Product_DTO {
	
	//필드 멤버변수
	private int product_id;
	private String product_name;
	private String category;
	private double price;
	private int stock_quantity;

	//기본 생성자
	public Product_DTO() {}
	
	//파라미터 생성자
	public Product_DTO(int productId, String product_name, String category, double price, int stockQuantity) {
		this.product_id = productId;
		this.product_name = product_name;
		this.category = category;
		this.price = price;
		this.stock_quantity = stockQuantity;
	}
	
	//Getter---------------------------------

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
	
	//Setter---------------------------------
	
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public void setProductName(String product_name) {
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
	
}