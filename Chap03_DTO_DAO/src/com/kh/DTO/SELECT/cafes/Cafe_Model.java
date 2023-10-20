package com.kh.DTO.SELECT.cafes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cafe_Model {
	
	//�������
	private Connection con;
	
	//������
	public Cafe_Model(Connection con) {
		this.con = con;
	}
	
	//����Ʈ�� ��ȯ�ϰپ�... (�� �������� �ѹ��� ��ȯ�� �� �ִ� ��� ��¼�� ���!!!)
	public List<Cafe_DTO> getCafes() {
		//2.����Ʈ �����
		List<Cafe_DTO> cafes = new ArrayList<>();
		
		String query = "SELECT * FROM cafes";
		try {	
			PreparedStatement st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				//�������� ���� ����� ����ؼ� �־��� ���� �ۼ�������..���� ��� int cafe_id = result.getInt("cafe_id");
				//������ DTO�� Ȱ���Ͽ� ���� ����� ĸ��ȭ�Ͽ� ���� DTO�� �ۼ����ش�
				//�׸��� DTO�� �ۼ����� ��ü�� �ν��Ͻ�ȭ �Ͽ� ��ü �ȿ��ִ� ��� ������ ȣ���Ѵ�
				Cafe_DTO cafe = new Cafe_DTO();
				
				cafe.setCafe_id(result.getInt("cafe_id"));
				cafe.setCafe_name(result.getString("cname"));
				cafe.setAddress(result.getString("address"));
				cafe.setPhone_number(result.getString("phone_number"));
				cafe.setOperating_hours(result.getString("operating_hours"));
				
				
				//1. ����Ʈ ����� �ðԿ� ����...
				cafes.add(cafe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cafes; //3.����Ʈ ���� ��ٴ� ���� �����ؿ�~
	} //getCafes()
}
