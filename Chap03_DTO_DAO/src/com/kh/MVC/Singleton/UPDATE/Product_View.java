package com.kh.MVC.Singleton.UPDATE;

import java.sql.SQLException;
import java.util.Scanner;

public class Product_View {
	
	public void updateProduct() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ ������ ��ǰ���� �Է��ϼ��� : ");
		String product_name = sc.nextLine();
		
		System.out.println("������ ������ �Է��ϼ��� : ");
		double price = sc.nextDouble();
		
		//Product_DTO �ν��Ͻ� ����
		Product_DTO new_Product = new Product_DTO(product_name, price);
		//Product_Model ��ü ����
		Product_Model product_Model;
		
		boolean success = false; //���� ���� �� �ʱ�ȭ
		//�� �ʱ�ȭ�� �Ǿ���ϴ°�?
		//���� success�� true�� �ƴ� ��� success�� ���� �������� �����Ƿ�..!
		//catch���� success = false;�� �����ؼ� ��� ��쿡�� ���� �������� ����� �ʱ�ȭ �� �ʿ� X
		//boolean success;
		
		try {
			product_Model = Product_Model.getInstance(); //product_Model�̶�� ��ü ��ȯ��
			success = product_Model.updateProduct(new_Product); //success = true
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false;
		}
		
		if(success==true) {
			System.out.println("��ǰ�� ���������� �����Ǿ����ϴ�.");
		} else {
			System.out.println("��ǰ ���� �� ������ �߻��߽��ϴ�.");
		}
		
		sc.close();
		
	} //updateProduct()
}
