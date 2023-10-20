package com.kh.MVC.Singleton.UPDATE;

//제품명을 입력받고, 해당하는 제품의 가격을 수정하는 패턴을 구현하겟습니다
public class Product_DTO {

	//멤버변수
	private String product_name;
	private double price;
	
	//기본 & 파라미터 생성자
	
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