package com.kh.MVC.Singleton.UPDATE;

public class Product_DTO {

	//�������
	private String product_name;
	private double price;
	
	//�⺻ & �Ķ���� ������
	
	public Product_DTO() {}


	public Product_DTO(String product_name, double price) {
		this.product_name = product_name;
		this.price = price;
	}
	
	//Getter-----------------------------------


	public String getProduct_name() {
		return product_name;
	}



	public double getPrice() {
		return price;
	}


	//Setter-----------------------------------

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
