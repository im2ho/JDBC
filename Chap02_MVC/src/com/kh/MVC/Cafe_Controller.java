package com.kh.MVC;

import java.util.Scanner;

public class Cafe_Controller {
	
	public Cafe_Model m;
	public Cafe_View v;
	
	//���̶� �� �������� ������
	public Cafe_Controller(Cafe_Model m, Cafe_View v) {
		this.m = m;
		this.v = v;
	}
	
	//run()
	public void run() {
		//Scanner sc = new Scanner(System.in);
		boolean isTrue = false;
		
		while(!isTrue) {
			Scanner sc = new Scanner(System.in);
			//������ ��ȣ ��� �޼���� �Է�
			System.out.println("1. ���ο� ī�� ���");
			System.out.println("2. � �ð� ����");
			System.out.println("3. ī�� �ּ� ����");
			System.out.println("4. ī�� ����");
			System.out.println("5. ���α׷� ����");
			System.out.print("\n���ϴ� �۾��� �������ּ��� : ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				v.addCafeName();
				break;
			case 2:
				v.updateOperatingHours();
				break;
			case 3:
				v.updateAddress();
				break;
			case 4:
				v.deleteCafeRecord();
				break;
			case 5:
				System.out.println("���α׷��� �����մϴ�");
				isTrue = true;
				break;
			default:
				System.out.println("�������� ���� ��ȣ�Դϴ� �ٽ� �������ּ���\n");
				break;
			}//switch()
			
		} //while()
		
	} //run()

}