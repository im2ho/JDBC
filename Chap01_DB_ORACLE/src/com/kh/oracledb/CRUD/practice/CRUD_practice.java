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
	
	//1. ��� ī�� ��� ��������
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
	
	//2. Ư�� ī���� �޴� ��������
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
				
				System.out.println(cafe_id + "�� ī�� �ñ״�ó �޴� : " + mname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//3. ���ο� ī�� �߰��ϱ�
	static void cafeInsert() {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String insertSQL = "INSERT INTO cafes(cafe_id, cname, address, phone_number, operating_hours)"
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			ps.setInt(1, 42);
			ps.setString(2, "����149");
			ps.setString(3, "��⵵ ���ν� ó���� ����³� ��ư");
			ps.setString(4, "031-994-8534");
			ps.setString(5, "����!");
			
			int rowsInsert = ps.executeUpdate();
			System.out.println("�߰��Ϸ�");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//4. Ư�� ī���� �޴����� ����
	static void updatePrice() {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String updateSQL = "UPDATE menu SET price=? WHERE cafe_id=?";
			PreparedStatement ps = con.prepareStatement(updateSQL);
			
			ps.setDouble(1, 200); //cafe_id = 8
			ps.setInt(2, 16);
			int rowsUpdate = ps.executeUpdate();
			System.out.println("������Ʈ �Ϸ�");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//5. Ư�� ī���� ���� �����ϱ�
	static void updateCafe() {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String updateSQL = "UPDATE cafes SET operating_hours = ? WHERE operating_hours LIKE ?";
			PreparedStatement ps = con.prepareStatement(updateSQL);
			
			ps.setString(1, "24�ð� ���߹���");
			ps.setString(2, "��-��%");
			
			int rowsUpdate = ps.executeUpdate();
			System.out.println("������");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//6. Ư�� ī���� ���� �����ϱ� (CASCADE)
	static void deleteCafe() {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String deleteSQL = "DELETE FROM cafes WHERE address LIKE ? ";
			PreparedStatement ps = con.prepareStatement(deleteSQL);
			
			ps.setString(1, "�뱸%");
			
			int rowsUpdate = ps.executeUpdate();
			System.out.println(rowsUpdate + "�� �� ���� ��");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//7. Ư�� ī���� �޴� �� ��������
	static void selectMenu() {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String selectSQL = "SELECT count(mname) AS �޴� �� FROM menu WHERE cafe_id=2";
			PreparedStatement ps = con.prepareStatement(selectSQL);
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				int num = result.getInt("count(mname)");
				System.out.println(num + "��");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//8. Ư������ �������� ��� �޴�
	static void selectRange() {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String selectSQL = "SELECT mname, price FROM menu WHERE price BETWEEN 20 AND 100";
			PreparedStatement ps = con.prepareStatement(selectSQL);
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				String mname = result.getString("mname");
				double price = result.getDouble("price");
				System.out.println(mname + ": " + price + "�޼�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//9. Ư�� �޴� ���� ��������
	static void menuInfo() {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String selectSQL = "SELECT * FROM menu WHERE mname LIKE ?";
			PreparedStatement ps = con.prepareStatement(selectSQL);
			
			ps.setString(1, "%����%");
			
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
	
	//10. ��� ī���� �̸��� �ּ� ��������
	static void nameAddress() {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String selectSQL = "SELECT cname, address FROM cafes";
			PreparedStatement ps = con.prepareStatement(selectSQL);
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				String cname = result.getString("cname");
				String address = result.getString("address");
				System.out.println(cname + " �ּ�: " + address);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//11. Ư�� ī���� � �ð� ���� �� ��� Ȯ��
	static void updateOperatinghours() {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String updateSQL = "UPDATE cafes SET operating_hours = ? WHERE cname =?";
			PreparedStatement updateState = con.prepareStatement(updateSQL);
			updateState.setString(1, "24�ð� ���߹���");
			updateState.setString(2, "����149");
			
			int rowsUpdate = updateState.executeUpdate();
			System.out.println("�����Ϸ�");
			
			String selectSQL = "SELECT cname, operating_hours FROM cafes WHERE cname=?";
			PreparedStatement selectState = con.prepareStatement(selectSQL);
			selectState.setString(1,"����149");
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
				String cname = result.getString("cname");
				String operating_hours = result.getString("operating_hours");
				System.out.println(cname + " ��ð� : " + operating_hours);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//12. Ư�� ī���� ��ȭ��ȣ ���� �� ��� Ȯ��
	static void updatePhonenum() {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String updateSQL = "UPDATE cafes SET phone_number = ? WHERE cname =?";
			PreparedStatement updateState = con.prepareStatement(updateSQL);
			updateState.setString(1, "031-759-1681");
			updateState.setString(2, "����149");
			
			int rowsUpdate = updateState.executeUpdate();
			System.out.println("�����Ϸ�");
			
			String selectSQL = "SELECT cname, phone_number FROM cafes WHERE cname=?";
			PreparedStatement selectState = con.prepareStatement(selectSQL);
			selectState.setString(1,"����149");
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
				String cname = result.getString("cname");
				String phone_number = result.getString("phone_number");
				System.out.println(cname + " ��ȭ��ȣ : " + phone_number);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
