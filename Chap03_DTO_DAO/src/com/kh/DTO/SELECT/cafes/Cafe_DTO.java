package com.kh.DTO.SELECT.cafes;

//Cafe_DTO : ������ ���� ��ü
public class Cafe_DTO {

	//model sql �� ���Ŀ� ���� �����͸� ĸ��ȭ�ϰ� getter setter�� Ȱ���Ͽ� �����͸� �����ϰ� �������� ����
	
	//�ʵ� ������� �ۼ�
	private int cafe_id;
	private String cafe_name;
	private String address;
	private String phone_number;
	private String operating_hours;
	
	//����Ʈ ������
	public Cafe_DTO() {}

	//�Ű����� �� �޴� ����(?) ������
	public Cafe_DTO(int cafe_id, String cafe_name, String address, String phone_number, String operating_hours) {
		this.cafe_id = cafe_id;
		this.cafe_name = cafe_name;
		this.address = address;
		this.phone_number = phone_number;
		this.operating_hours = operating_hours;
	}
	
	//getter-----------------------------------
	
	public int getCafe_id() {
		return cafe_id;
	}
	
	public String getCafe_name() {
		return cafe_name;
	}
	
	public String getAddress() {
		return address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public String getOperating_hours() {
		return operating_hours;
	}

	//setter------------------------------------
	
	public void setCafe_id(int cafe_id) {
		this.cafe_id = cafe_id;
	}

	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public void setOperating_hours(String operating_hours) {
		this.operating_hours = operating_hours;
	}

	//Override�� Ȱ���� toString �޼��� �߰�---------
	@Override
	public String toString() {
		return "Cafe_DTO";
	}
	

}
