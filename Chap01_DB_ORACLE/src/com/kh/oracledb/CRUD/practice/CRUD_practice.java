package com.kh.oracledb.CRUD.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD_practice {

	public static void main(String[] args) {
		updatePhonenum();
	}
	
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "khcafe";
	static String password = "khcafe";
	
	//1. 모든 카페 목록 가져오기
	static void selectAllcafe() {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String selectSQL = "SELECT cafe_id, cname FROM cafes";
			PreparedStatement ps = con.prepareStatement(selectSQL);
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				int cafe_id = result.getInt("cafe_id");
				String cname = result.getString("cname");
				System.out.println(cafe_id + ": " + cname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//2. 특정 카페의 메뉴 가져오기
	static void selectOnecafemenu() {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String selectSQL = "SELECT mname, cafe_id FROM menu WHERE cafe_id =?";
			PreparedStatement ps = con.prepareStatement(selectSQL);
			
			ps.setInt(1, 2);
			
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				String mname = result.getString("mname");
				int cafe_id = result.getInt("cafe_id");
				
				System.out.println(cafe_id + "번 카페 시그니처 메뉴 : " + mname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//3. 새로운 카페 추가하기
	static void cafeInsert() {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String insertSQL = "INSERT INTO cafes(cafe_id, cname, address, phone_number, operating_hours)"
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			ps.setInt(1, 42);
			ps.setString(2, "묵리149");
			ps.setString(3, "경기도 용인시 처인읍 여기맞나 암튼");
			ps.setString(4, "031-994-8534");
			ps.setString(5, "매일!");
			
			int rowsInsert = ps.executeUpdate();
			System.out.println("추가완료");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//4. 특정 카페의 메뉴가격 변경
	static void updatePrice() {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String updateSQL = "UPDATE menu SET price=? WHERE cafe_id=?";
			PreparedStatement ps = con.prepareStatement(updateSQL);
			
			ps.setDouble(1, 200); //cafe_id = 8
			ps.setInt(2, 16);
			int rowsUpdate = ps.executeUpdate();
			System.out.println("업데이트 완료");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//5. 특정 카페의 정보 수정하기
	static void updateCafe() {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String updateSQL = "UPDATE cafes SET operating_hours = ? WHERE operating_hours LIKE ?";
			PreparedStatement ps = con.prepareStatement(updateSQL);
			
			ps.setString(1, "24시간 연중무휴");
			ps.setString(2, "월-금%");
			
			int rowsUpdate = ps.executeUpdate();
			System.out.println("업뎃완");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//6. 특정 카페의 정보 삭제하기 (CASCADE)
	static void deleteCafe() {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String deleteSQL = "DELETE FROM cafes WHERE address LIKE ? ";
			PreparedStatement ps = con.prepareStatement(deleteSQL);
			
			ps.setString(1, "대구%");
			
			int rowsUpdate = ps.executeUpdate();
			System.out.println(rowsUpdate + "개 행 삭제 완");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//7. 특정 카페의 메뉴 수 가져오기
	static void selectMenu() {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String selectSQL = "SELECT count(mname) AS 메뉴 수 FROM menu WHERE cafe_id=2";
			PreparedStatement ps = con.prepareStatement(selectSQL);
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				int num = result.getInt("count(mname)");
				System.out.println(num + "개");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//8. 특정가격 범위내의 모든 메뉴
	static void selectRange() {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String selectSQL = "SELECT mname, price FROM menu WHERE price BETWEEN 20 AND 100";
			PreparedStatement ps = con.prepareStatement(selectSQL);
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				String mname = result.getString("mname");
				double price = result.getDouble("price");
				System.out.println(mname + ": " + price + "메소");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//9. 특정 메뉴 정보 가져오기
	static void menuInfo() {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String selectSQL = "SELECT * FROM menu WHERE mname LIKE ?";
			PreparedStatement ps = con.prepareStatement(selectSQL);
			
			ps.setString(1, "%우유%");
			
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				int menu_id = result.getInt("menu_id");
				int cafe_id = result.getInt("cafe_id");
				String mname = result.getString("mname");
				double price = result.getDouble("price");
				String description = result.getString("description");
				System.out.println(menu_id + "/" + cafe_id + "/" + mname + "/" + price + "/" + description);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//10. 모든 카페의 이름과 주소 가져오기
	static void nameAddress() {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String selectSQL = "SELECT cname, address FROM cafes";
			PreparedStatement ps = con.prepareStatement(selectSQL);
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				String cname = result.getString("cname");
				String address = result.getString("address");
				System.out.println(cname + " 주소: " + address);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//11. 특정 카페의 운영 시간 변경 및 결과 확인
	static void updateOperatinghours() {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String updateSQL = "UPDATE cafes SET operating_hours = ? WHERE cname =?";
			PreparedStatement updateState = con.prepareStatement(updateSQL);
			updateState.setString(1, "24시간 연중무휴");
			updateState.setString(2, "묵리149");
			
			int rowsUpdate = updateState.executeUpdate();
			System.out.println("업뎃완료");
			
			String selectSQL = "SELECT cname, operating_hours FROM cafes WHERE cname=?";
			PreparedStatement selectState = con.prepareStatement(selectSQL);
			selectState.setString(1,"묵리149");
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
				String cname = result.getString("cname");
				String operating_hours = result.getString("operating_hours");
				System.out.println(cname + " 운영시간 : " + operating_hours);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//12. 특정 카페의 전화번호 변경 및 결과 확인
	static void updatePhonenum() {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String updateSQL = "UPDATE cafes SET phone_number = ? WHERE cname =?";
			PreparedStatement updateState = con.prepareStatement(updateSQL);
			updateState.setString(1, "031-759-1681");
			updateState.setString(2, "묵리149");
			
			int rowsUpdate = updateState.executeUpdate();
			System.out.println("업뎃완료");
			
			String selectSQL = "SELECT cname, phone_number FROM cafes WHERE cname=?";
			PreparedStatement selectState = con.prepareStatement(selectSQL);
			selectState.setString(1,"묵리149");
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
				String cname = result.getString("cname");
				String phone_number = result.getString("phone_number");
				System.out.println(cname + " 전화번호 : " + phone_number);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
