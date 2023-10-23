package com.kh.DAO.INSERT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date; //User_VO���� java.util.Date��������Ƿ� ����

import java.util.Scanner;

public class User_Main {

	public static void main(String[] args) {
		
		//1. DB ���� url, user_name, password
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_user_name = "khcafe";
		String db_password = "khcafe";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, db_user_name, db_password);
			User_DAO ud = new User_DAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("User ID : ");
			int user_id = sc.nextInt();
			
			System.out.print("\n����� �̸��� �Է� ���ּ��� : ");
			String user_name = sc.next();
			
			System.out.print("\n����� �̸����� �ۼ� ���ּ��� : ");
			String email = sc.next();
			
			Date reg_date = new Date(); //import java.util.Date -> ���� ���ڷ� ���� ��¥�� �ð��� ���
			
			//DB�� �Է��� ������ ������� �ν��Ͻ� ���� �� �Է¹��� ���� �����ϱ�
			User_VO newUser = new User_VO();
			newUser.setUser_id(user_id);
			newUser.setUser_name(user_name);
			newUser.setEmail(email);
			newUser.setReg_date(reg_date);
			
			//������ ������ �׽�Ʈ
			if(ud.createUser(newUser)) { //true
				System.out.println("User " + user_id + "��(��) ���������� ��ϵǾ����ϴ�");
			} else { //false
				System.out.println("���� ��Ͽ� �����ϼ̽��ϴ�");
			}
			
			//���� �ݱ�
			connection.close();
			sc.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
