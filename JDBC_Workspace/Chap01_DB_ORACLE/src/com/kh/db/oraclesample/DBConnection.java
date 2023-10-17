package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class DBConnection {

	public static void main(String[] args) {
		//1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ORACLE �� ��ǻ�� ���� : ������ ���̽� ���� ����
									  //����IP�ּ�:port��ȣ:SID
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
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
	}

}