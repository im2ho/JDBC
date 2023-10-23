package com.kh.DAO.SELECT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class User_Main {
	
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String db_user = "khcafe";
	String dv_password = "khcafe";

	public static void main(String[] args) {
		User_Main um = new User_Main();
		//um.selectAll(); //SELECT * FROM user_info;
		um.selectScanner(); //SELECT * FROM user_info WHERE ~
	} //main()
	
	public void selectScanner() {
		
		try {
			Connection cc = DriverManager.getConnection(jdbcUrl, db_user, dv_password);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("����� ������ ��ȸ�ϰڽ��ϰ�? [Y/N]");
				String choice = sc.next();
				
				if("Y".equalsIgnoreCase(choice)) { //��ҹ��� ���� X
					
					System.out.print("User ID : ");
					String input = sc.next();
					System.out.print("E-mail : ");
					sc.nextLine();
					String input2 = sc.nextLine();
			
					
					int user_id = Integer.parseInt(input);
					String email = input2;
					
					//select�� ����ϱ�
					String selectSQL = "SELECT * FROM user_info WHERE user_id =? AND email = ?";
					PreparedStatement ps = cc.prepareStatement(selectSQL);
					
					ps.setInt(1, user_id);
					ps.setString(2, email);
					
					ResultSet result = ps.executeQuery();
					
					//selectOne if��----------------------------------------------------
					if(result.next()) { //result.next() ���� ���� ���
						
						System.out.println("[��ȸ ���]");
						System.out.println("\nUser ID : " + result.getInt("user_id"));
						System.out.println("User Name : " + result.getString("user_name"));
						System.out.println("E-mail : " + result.getString("email"));
						System.out.println("Registered Date : " + result.getDate("reg_date"));
						System.out.println();
						
					} else { 
						boolean id_true = check_id(user_id);
						boolean email_true = check_email(email);
						
						if(!id_true && email_true) { // id��ġ X
							System.out.println("�Է��Ͻ� �̸��ϰ� ��ġ���� �ʴ� id�Դϴ�");
						} else if(id_true && !email_true) { // email ��ġ X
							System.out.println("�Է��Ͻ� id�� ��ġ���� �ʴ� �̸����Դϴ�");
						} else { //�����ϴ� ���� X
						System.out.println("�Է��Ͻ� ������ ��ġ�ϴ� ����ڸ� ã�� �� �����ϴ�.");
						} 
						
					} //if(result.next())
					//-------------------------------------------------------------------
				} else if("N".equalsIgnoreCase(choice)) {
					System.out.println("���� ��ȸ�� ����Ǿ����ϴ�");
					break;
				} else {
					System.out.println("�������� ���� �Է��Դϴ�. �ٽ� �����ϼ���.");
				}
			} //while()
			
			cc.close();
			sc.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	} //selectScanner()
		
	public boolean check_id (int user_id) {
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, db_user, dv_password);
			String id_SQL = "SELECT * FROM user_info WHERE user_id = ?";
			PreparedStatement ps = con.prepareStatement(id_SQL);
			ps.setInt(1, user_id);
			ResultSet result = ps.executeQuery();
			return result.isBeforeFirst(); //�о�� ���� �ִٸ� true
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	} //check_id()
	
	public boolean check_email (String email) {
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, db_user, dv_password);
			String id_SQL = "SELECT * FROM user_info WHERE email = ?";
			PreparedStatement ps = con.prepareStatement(id_SQL);
			ps.setString(1, email);
			ResultSet result = ps.executeQuery();
			return result.isBeforeFirst(); //�о�� ���� �ִٸ� true
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	} //check_email()
	
	//result.next() > 0���ε� boolean�� ���� �� ����~~~
	//rs.next() rs.getInt(1) :ù��° ��� ���� ��ȯ�ϼ���
	//������ ����� ����
	
	public void selectAll() {
		
		try {
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_user = "khcafe";
			String dv_password = "khcafe";
			
			Connection connection = DriverManager.getConnection(jdbcUrl, db_user, dv_password);
			
			//List<User_VO> users = getAllUsers(); ��������
			User_DAO ud = new User_DAO(connection);
			List<User_VO> users = ud.getAllUsers();
			
			for(User_VO user_info : users) {
				System.out.println("User ID : "+ user_info.getUser_id());
				System.out.println("User name: "+ user_info.getUser_name());
				System.out.println("E-mail : "+ user_info.getEmail());
				System.out.println("Registered Date : "+ user_info.getReg_date());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} //selectAll()

}