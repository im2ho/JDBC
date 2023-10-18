package com.kh.oracledb.CRUD.practice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//cafes insert �ۼ��ؼ� ���� ī�� �߰��ϱ�

public class INSERTexam {

	public static void main(String[] args) {
		bookcafe();
	} //main()
	
	static void cafes() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "khcafe";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String insertSQL = "INSERT INTO cafes(cafe_id, cname, address, phone_number, operating_hours)"
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			//�޼��� ����� �ͼ� cafes���̺� ������ ����
			insertCafes(ps, 42, "������ �����ʹ�", "������ ��ȱ� ������", "031-765-9181","����: 11:00-21:00");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//����ó�� �ʼ�
	static void insertCafes(PreparedStatement ps, int cafe_id, String cname, String address, String phone_number, String operating_hours) throws SQLException {
		ps.setInt(1, cafe_id);
		ps.setString(2, cname);
		ps.setString(3, address);
		ps.setString(4, phone_number);
		ps.setString(5, operating_hours);
		ps.executeUpdate();
	} //insertCafes()

	static void bookcafe() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "khcafe";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("���� �Ϸ�");
			
			String insertQuery =
					"INSERT INTO bookcafe(book_id, title, author, publication_year, isbn, genre, description, price, publication_date, created_date, updated_date, is_available)"
							+ "VALUES(?,?,?,?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),TO_DATE(?,'YYYY-MM-DD'),TO_DATE(?,'YYYY-MM-DD'),?)";
			
			PreparedStatement ps = con.prepareStatement(insertQuery);
			
			//��ο� 2007�̾��׿� �˼�!
			insertBookcafe(ps, 27, "ååå", "±��", 1980, "978-8932030982", "Novle", "����", 10.99, "2023-4-15", "1946-11-30", "2023-03-31", "Y");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//bookcafe()
	
	//����ó�� �ʼ�
	static void insertBookcafe(PreparedStatement ps, int book_id, String title, String author, int publication_year, String isbn, String genre, String description, double price, String publication_date, String created_date, String updated_date, String is_available) throws SQLException{
		ps.setInt(1, book_id); 
		ps.setString(2, title); 
		ps.setString(3, author);
		ps.setInt(4, publication_year); 
		ps.setString(5, isbn); 
		ps.setString(6, genre); //genre
		ps.setString(7, description); //description
		ps.setDouble(8, price); //price
		ps.setString(9, publication_date); //publication_Date
		ps.setString(10, created_date); //created_date
		ps.setString(11, updated_date); //updated_date
		ps.setString(12, is_available); //is_available
		ps.executeUpdate();
	}
	
} //class
