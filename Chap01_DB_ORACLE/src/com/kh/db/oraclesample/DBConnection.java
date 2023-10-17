package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class DBConnection {

	public static void main(String[] args) {
		//DBConnection d = new DBConnection();
		//d.SelectKHCAFE();
		intsertBank();
	} //main()
	
	static void SelectBank() {
		//1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
		//String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ORACLE �� ��ǻ�� ���� : ������ ���̽� ���� ����
									  //����IP�ּ�:port��ȣ:SID
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //thin : 100% �ڹ� Ŭ���̾�Ʈ ����̹�
		String user = "khbank";
		String password = "khbank";
		Connection con = null;
		try { //100% DB���� ���� �Ұ����ϱ� ������ ����ó�� �ʼ�
			//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� �Ϸ�\n"); 
					
			//SELECT ���� ����
			String selectQuery = "SELECT * FROM bank";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery(); //����� ���� ���� (������ ������ �� ��ü)
			//result.next() : result ��ü���� ���� ��(row)���� �̵�. ���� ���� ������ true, �׷��� ������ false
			//khbank�� �ִ� bank ���̺� ������տ��� ������ �������� (SELECT * FROM bank;)
			while(result.next()) {
				int accountID = result.getInt("account_id"); //result ������ �����̿��� account_id�� ������
				String accountName = result.getString("account_name"); //account_name�� ������
				double balance = result.getDouble("balance"); //balance�� ������
				int accountNumber = result.getInt("account_number"); //1.���¹�ȣ ��������
				String branchName = result.getString("branch_name"); //2.���� ��������
				Date lastTransactionDate = result.getDate("last_transaction_date"); //3. ��¥ ��������
				System.out.println("ACCOUNT_ID : " + accountID + ", ACCOUNT_NAME : " + accountName + ", Balance : " + balance);
				System.out.println("ACCOUNT_NUMBER : " + accountNumber + ", BRANCHNAME : " + branchName);
				System.out.println("LAST_TRANSACTION_DATE : " + lastTransactionDate + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	} //SelectBank()
	
	static void SelectKHCAFE() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "khcafe";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� �Ϸ� ~.~\n");
			
			String selectQuery = "SELECT menu_id, mname, price, description FROM menu WHERE price > 10"; //menu ���̺� ��ü ����
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
				//int cafeID = result.getInt("cafe_id");
				int menuID = result.getInt("menu_id");
				String menuName = result.getString("mname");
				double price = result.getDouble("price");
				String description = result.getString("description");
				
				//System.out.println("CAFE_ID : " + cafeID);
				System.out.println("MENU_ID : " + menuID + ", MENU_NAME : " + menuName + ", PRICE : " + price);
				System.out.println("MENU_DESCRIPTION : " + description +"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //SelectKHCAFE()
	
	static void SelectWhile() {
		String driver = "oracle.jdbc.driver.OracleDriver";

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "khbank";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String selectQuery = "SELECT * FROM BANK WHERE ACCOUNT_NUMBER IN(?,?)" ; //������ ��
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			String[] targetAN = {"333302123542","644644644644"};
			selectState.setString(1,targetAN[0]); //targetAN[0]: 1��° ?�� �� ��
			selectState.setString(2,targetAN[1]); //targetAN[0]: 2��° ?�� �� ��
			ResultSet result = selectState.executeQuery();
			
			//���� ���� ���� �Ǵ�
			if(!result.isBeforeFirst()) { //�����Ͱ� ���� ��츦 ��Ÿ���� ���� ������ false�� ����
				System.out.println("�����ϴ� �����Ͱ� �����ϴ�.");
			}
			while(result.next()) {
				int aid = result.getInt("account_id");
				String anum = result.getString("account_number");
				String aname = result.getString("account_name");
				int balance = result.getInt("balance");
				String bname = result.getString("branch_name");
				Date ltd = result.getDate("last_transaction_date");
				
				System.out.println("Account_ID : " + aid + ", ACCOUNT_NAME : " + aname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void SelectIf() {
		String driver = "oracle.jdbc.driver.OracleDriver";

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "khbank";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("ORACLE DB ���� �Ϸ�\n");
			
			//WHERE�� ����Ͽ� ���� �߰�
			String selectQuery = "SELECT * FROM BANK WHERE balance=? AND account_number=?"; //������ ��
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			
			//���ϴ� ������ account_id ����
			int targetBalance = 1500;
	
			//���� ����
			selectState.setInt(1,targetBalance); //targetBalance: 1��° ?�� �� ��
			selectState.setString(2,"1002159226496"); //"1002159226496" : 2��° ?�� �� ��
			ResultSet result = selectState.executeQuery();
			
			//while���� �޸�, ���ǿ� �����ϴ� �����Ͱ� ���� �� ���� ����� �����ϴ�
			if(result.next()) {
				int aid = result.getInt("account_id");
				String anum = result.getString("account_number");
				String aname = result.getString("account_name");
				int balance = result.getInt("balance");
				String bname = result.getString("branch_name");
				Date ltd = result.getDate("last_transaction_date");
				
				System.out.println("Account_ID : " + aid + ", ACCOUNT_NAME : " + aname);
			} else {
				System.out.println("���ǿ� �ش��ϴ� �����Ͱ� �����ϴ�;;");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void intsertBank() {
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
	}
}