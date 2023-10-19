package com.kh.MVC;

import java.util.Scanner;

public class Cafe_View {
	
	
	//cafeModel Ŭ������ �������� ���� ��������� ī�� �� �߰�
	public Cafe_Model model;
	
	//model �Ű������� ���� �� �ִ� ������
	public Cafe_View(Cafe_Model model) {
		this.model = model;
	}
	
	public void addCafeName() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�߰��� ī�� ������ �Է��ϼ���..");
		System.out.print("ī�� ��ȣ : ");
		int view_id = sc.nextInt();
		System.out.print("��ȣ�� : ");
		sc.nextLine(); //enteró�� �� ��¾��
		String view_cname = sc.nextLine();
		System.out.print("ī�� �ּ� : ");
		String view_address = sc.nextLine();
		System.out.print("ī�� ����ó : ");
		String view_phone_number = sc.nextLine();
		System.out.print("� �ð� : ");
		String view_operating_hours = sc.nextLine();
		
		//Cafe_Model Ŭ�������� insertCafe �޼��带 ��������
		model.insertCafe(view_id, view_cname, view_address, view_phone_number, view_operating_hours);
		System.out.println("ī�� �߰� �Ϸ�\n");
		//sc.close(); //���⼭ �ݾƹ�����.. Controller������ Scanner�� ��������..
	} //addCafeName()
	
	public void updateOperatingHours() {
		
		Scanner sc = new Scanner(System.in);
		 
		System.out.println("��ð��� ������Ʈ �ϼ���..");
		System.out.print("ī�� �̸� : ");
		String view_cname = sc.nextLine();
		System.out.print("����� � �ð�: ");
		String view_operating_hours=sc.nextLine();
		
		//Cafe_Model Ŭ�������� updateOperatinghours �޼��� ��������
		model.updateCafeOper(view_operating_hours, view_cname);
		System.out.println("���� ���� �Ϸ�\n");
		//sc.close();
	} //updateOperatingHours()
	
	public void updateAddress() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ī�� �ּҸ� ������Ʈ �ϼ���..");
		System.out.print("ī�� �̸� : ");
		String view_cname = sc.nextLine();
		System.out.print("����� ī�� �ּ�: ");
		String view_address = sc.nextLine();
		
		model.updateCafeAdd(view_address, view_cname);
		System.out.println("���� ���� �Ϸ�\n");
		//sc.close();
	} // updateAddress()

	public void deleteCafeRecord() { //�ڽķ��ڵ� �߰� ��¼�� ������ ����
		//�ڽ�Ű�� �߰ߵǸ� ������ �ȵ�.. CASCADE ���ܾߵ� ��
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ī���� ID�� �Է��ϼ��� : ");
		//int view_cafe_id = Integer.parseInt(sc.nextLine()); //String������ �־��� �� ���ڷ� ��ȯ ���� ���
		int view_cafe_id = sc.nextInt();
		
		model.deleteCafe(view_cafe_id);
		System.out.println("ī�� ���� �Ϸ�\n");
		
	} //deleteCafeRecord()
	
	
}