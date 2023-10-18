package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class INSERT_sample {

	public static void main(String[] args) {
	
		insertBookcafe();
	
	} //main()
	
	static void insertOne() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //thin : 100% �ڹ� Ŭ���̾�Ʈ ����̹�
		String user = "khbank";
		String password = "khbank";
		//Connection con = null; //Connection : java.sql �⺻ ����
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = 
					"INSERT INTO bank (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
					+ "VALUES(?,?,?,?,?,?)";
			
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			
			insertState.setInt(1, 100);
			insertState.setString(2, "333302578912");
			insertState.setString(3, "ȣ����");
			insertState.setDouble(4, 500);
			insertState.setString(5, "����");
			insertState.setDate(6, Date.valueOf("2023-10-17"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row �߰� �Ϸ�");
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	} //insertOne()
	
	static void insertBookcafe() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //thin : 100% �ڹ� Ŭ���̾�Ʈ ����̹�
		String user = "khcafe";
		String password = "khcafe";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String insertQuery =
					"INSERT INTO bookcafe(book_id, title, author, publication_year, isbn, genre, description, price, publication_date, created_date, updated_date, is_available)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			System.out.println("����");
			
			//INSERT
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			
			insertState.setInt(1, 28); //book_id
			insertState.setString(2, "�ſ�����"); //title
			insertState.setString(3, "GameFreak"); //author
			insertState.setInt(4, 2008); //publication_year
			insertState.setString(5, "978-8930251973"); //isbn
			insertState.setString(6, "Dictionary"); //genre
			insertState.setString(7, "DP �� �÷�Ƽ�� ���� ����"); //description
			insertState.setDouble(8, 15.99); //price
			//Date.valueOf(): String ���� ��¥ �������� ��ȯ���ִ� �޼���(yyyy-mm-dd ���¿�����)
			insertState.setString(9, "2023-08-16"); //publication_Date �׳� String���� ������..
			insertState.setDate(10, Date.valueOf("2009-10-30")); //created_date
			insertState.setDate(11, Date.valueOf("2023-01-21")); //updated_date
			insertState.setString(12, "Y"); //is_available
			
			//INSERT�� ����
			int rowsInsert = insertState.executeUpdate();
			
			//PreparedStatement �� ���� �ݱ�
			insertState.close();
			con.close();
			
			System.out.println(rowsInsert + "row �߰� �Ϸ�");
			
			//INSERT������ ������ ������ �� ������ SELECT������ Ȯ���غ���
			String selectQuery = "SELECT * FROM bookcafe WHERE title =?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			selectState.setString(1, "Pokedex");
			
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
				int bookId = result.getInt("book_id");
				String bookTitle = result.getString("title");
				System.out.println("�߰��� å ���� : [" + bookId + "]" + bookTitle);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} //insertBookcafe()
}
