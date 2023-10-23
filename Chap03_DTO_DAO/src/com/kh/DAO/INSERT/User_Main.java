package com.kh.DAO.INSERT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date; //User_VO에서 java.util.Date사용했으므로 통일

import java.util.Scanner;

public class User_Main {

	public static void main(String[] args) {
		
		//1. DB 연결 url, user_name, password
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_user_name = "khcafe";
		String db_password = "khcafe";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, db_user_name, db_password);
			User_DAO ud = new User_DAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("User ID : ");
			int user_id = sc.nextInt();
			
			System.out.print("\n사용자 이름을 입력 해주세요 : ");
			String user_name = sc.next();
			
			System.out.print("\n사용자 이메일을 작성 해주세요 : ");
			String email = sc.next();
			
			Date reg_date = new Date(); //import java.util.Date -> 가입 일자로 현재 날짜와 시간을 사용
			
			//DB에 입력한 정보를 담기위해 인스턴스 생성 후 입력받은 정보 저장하기
			User_VO newUser = new User_VO();
			newUser.setUser_id(user_id);
			newUser.setUser_name(user_name);
			newUser.setEmail(email);
			newUser.setReg_date(reg_date);
			
			//데이터 들어갔는지 테스트
			if(ud.createUser(newUser)) { //true
				System.out.println("User " + user_id + "가(이) 성공적으로 등록되었습니다");
			} else { //false
				System.out.println("유저 등록에 실패하셨습니다");
			}
			
			//연결 닫기
			connection.close();
			sc.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
