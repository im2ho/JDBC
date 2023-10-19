package com.kh.MVC.INSERT;

public class INSERT_main {

	public static void main(String[] args) {
		
		INSERT_model m = new INSERT_model();
		INSERT_view v = new INSERT_view();
		INSERT_control c = new INSERT_control(m,v);
		
		c.addCafe();
 
	}

}
