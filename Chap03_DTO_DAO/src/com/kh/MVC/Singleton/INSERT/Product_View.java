package com.kh.MVC.Singleton.INSERT;

import java.sql.SQLException;
import java.util.Scanner;

public class Product_View {
	
	public void addProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ��ǰ ������ �Է��ϼ���");
		
		System.out.print("��ǰ ID : ");
		int product_id = sc.nextInt();
		
		System.out.print("\n��ǰ�� : ");
		sc.nextLine();
		String product_name = sc.nextLine();
		
		System.out.print("\n��ǰ �з� : ");
		String category = sc.nextLine();
		
		System.out.print("\n���� : ");
		double price = sc.nextDouble();
		
		System.out.print("\n��� ���� : ");
		int stock_quantity = sc.nextInt();
		
		//Scanner�� ���� ��ǰ ������ ���� �߰��ϱ�
		Product_DTO new_Product = new Product_DTO(product_id, product_name, category, price, stock_quantity);
		Product_Model product_Model;
		
		boolean success = false;
		
		try {
			//�Ʊ� Model Ŭ�������� �� �̱��� ��ü ���� static�����ؼ� �� ����� �� �� �ձ�
			product_Model = Product_Model.getInstance(); //�ν��Ͻ��� �� ��ü ���� ���� �����
			success = product_Model.insertProduct(new_Product); //���⼭ ���� ��ü ����ֱ�
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(success) {
			System.out.println("��ǰ�� ���������� �߰��Ǿ����ϴ�.");
		} else {
			System.out.println("��ǰ �߰� �� ������ �߻��߽��ϴ�.");
		}
		
		//��ĳ�� �ݱ�
		sc.close();
		
	} //addProduct()
	
}