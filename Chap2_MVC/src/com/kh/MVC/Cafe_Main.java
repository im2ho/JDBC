package com.kh.MVC;

public class Cafe_Main {

	public static void main(String[] args) {
		
		Cafe_Model m = new Cafe_Model();
		Cafe_View v = new Cafe_View(m);
		
		//Controller »ý¼º
		Cafe_Controller c = new Cafe_Controller(m,v);

		c.run();
	}

}