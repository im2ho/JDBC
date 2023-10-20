package com.kh.DTO.SELECT.cafes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cafe_Model {
	
	//멤버변수
	private Connection con;
	
	//생성자
	public Cafe_Model(Connection con) {
		this.con = con;
	}
	
	//리스트를 반환하겟어... (값 여러개를 한번에 반환할 수 있는 대박 개쩌는 방법!!!)
	public List<Cafe_DTO> getCafes() {
		//2.리스트 만들기
		List<Cafe_DTO> cafes = new ArrayList<>();
		
		String query = "SELECT * FROM cafes";
		try {	
			PreparedStatement st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				//기존에는 예약어나 참조어를 사용해서 넣어줄 값을 작성했지만..예를 들어 int cafe_id = result.getInt("cafe_id");
				//이제는 DTO를 활용하여 예약어나 참조어를 캡슐화하여 따로 DTO로 작성해준다
				//그리고 DTO로 작성해준 객체를 인스턴스화 하여 객체 안에있는 멤버 변수를 호출한다
				Cafe_DTO cafe = new Cafe_DTO();
				
				cafe.setCafe_id(result.getInt("cafe_id"));
				cafe.setCafe_name(result.getString("cname"));
				cafe.setAddress(result.getString("address"));
				cafe.setPhone_number(result.getString("phone_number"));
				cafe.setOperating_hours(result.getString("operating_hours"));
				
				
				//1. 리스트 만들고 올게요 총총...
				cafes.add(cafe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cafes; //3.리스트 내용 우다다 전달 가능해용~
	} //getCafes()
}
