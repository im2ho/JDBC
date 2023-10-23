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
				System.out.println("사용자 정보를 조회하겠습니가? [Y/N]");
				String choice = sc.next();
				
				if("Y".equalsIgnoreCase(choice)) { //대소문자 구분 X
					
					System.out.print("User ID : ");
					String input = sc.next();
					System.out.print("E-mail : ");
					sc.nextLine();
					String input2 = sc.nextLine();
			
					
					int user_id = Integer.parseInt(input);
					String email = input2;
					
					//select문 출력하기
					String selectSQL = "SELECT * FROM user_info WHERE user_id =? AND email = ?";
					PreparedStatement ps = cc.prepareStatement(selectSQL);
					
					ps.setInt(1, user_id);
					ps.setString(2, email);
					
					ResultSet result = ps.executeQuery();
					
					//selectOne if문----------------------------------------------------
					if(result.next()) { //result.next() 값이 있을 경우
						
						System.out.println("[조회 결과]");
						System.out.println("\nUser ID : " + result.getInt("user_id"));
						System.out.println("User Name : " + result.getString("user_name"));
						System.out.println("E-mail : " + result.getString("email"));
						System.out.println("Registered Date : " + result.getDate("reg_date"));
						System.out.println();
						
					} else { 
						boolean id_true = check_id(user_id);
						boolean email_true = check_email(email);
						
						if(!id_true && email_true) { // id일치 X
							System.out.println("입력하신 이메일과 일치하지 않는 id입니다");
						} else if(id_true && !email_true) { // email 일치 X
							System.out.println("입력하신 id와 일치하지 않는 이메일입니다");
						} else { //존재하는 정보 X
						System.out.println("입력하신 정보와 일치하는 사용자를 찾을 수 없습니다.");
						} 
						
					} //if(result.next())
					//-------------------------------------------------------------------
				} else if("N".equalsIgnoreCase(choice)) {
					System.out.println("정보 조회가 종료되었습니다");
					break;
				} else {
					System.out.println("적합하지 않은 입력입니다. 다시 선택하세요.");
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
			return result.isBeforeFirst(); //읽어올 값이 있다면 true
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
			return result.isBeforeFirst(); //읽어올 값이 있다면 true
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	} //check_email()
	
	//result.next() > 0으로도 boolean값 구할 수 있음~~~
	//rs.next() rs.getInt(1) :첫번째 결과 값을 반환하세용
	//선생님 깃허브 참고
	
	public void selectAll() {
		
		try {
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_user = "khcafe";
			String dv_password = "khcafe";
			
			Connection connection = DriverManager.getConnection(jdbcUrl, db_user, dv_password);
			
			//List<User_VO> users = getAllUsers(); 가져오기
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