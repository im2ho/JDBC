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
		//1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
		//String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ORACLE 내 컴퓨터 연결 : 데이터 베이스 연결 정보
									  //나의IP주소:port번호:SID
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //thin : 100% 자바 클라이언트 드라이버
		String user = "khbank";
		String password = "khbank";
		Connection con = null;
		try { //100% DB연결 보장 불가능하기 때문에 예외처리 필수
			//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 완료\n"); 
					
			//SELECT 쿼리 예제
			String selectQuery = "SELECT * FROM bank";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery(); //결과에 대한 집합 (데이터 뭉텅이 그 자체)
			//result.next() : result 객체에서 다음 행(row)으로 이동. 다음 행이 있으면 true, 그렇지 않으면 false
			//khbank에 있는 bank 테이블 결과집합에서 데이터 가져오기 (SELECT * FROM bank;)
			while(result.next()) {
				int accountID = result.getInt("account_id"); //result 데이터 뭉텅이에서 account_id를 가져옴
				String accountName = result.getString("account_name"); //account_name을 가져옴
				double balance = result.getDouble("balance"); //balance를 가져옴
				int accountNumber = result.getInt("account_number"); //1.계좌번호 가져오기
				String branchName = result.getString("branch_name"); //2.지점 가져오기
				Date lastTransactionDate = result.getDate("last_transaction_date"); //3. 날짜 가져오기
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
			System.out.println("데이터베이스 연결 완료 ~.~\n");
			
			String selectQuery = "SELECT menu_id, mname, price, description FROM menu WHERE price > 10"; //menu 테이블 전체 선택
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
			
			String selectQuery = "SELECT * FROM BANK WHERE ACCOUNT_NUMBER IN(?,?)" ; //미지의 수
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			String[] targetAN = {"333302123542","644644644644"};
			selectState.setString(1,targetAN[0]); //targetAN[0]: 1번째 ?에 들어갈 값
			selectState.setString(2,targetAN[1]); //targetAN[0]: 2번째 ?에 들어갈 값
			ResultSet result = selectState.executeQuery();
			
			//값의 존재 여부 판단
			if(!result.isBeforeFirst()) { //데이터가 없을 경우를 나타내기 위해 조건을 false로 설정
				System.out.println("존재하는 데이터가 없습니다.");
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
			System.out.println("ORACLE DB 연결 완료\n");
			
			//WHERE절 사용하여 조건 추가
			String selectQuery = "SELECT * FROM BANK WHERE balance=? AND account_number=?"; //미지의 수
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			
			//원하는 조건의 account_id 설정
			int targetBalance = 1500;
	
			//조건 설정
			selectState.setInt(1,targetBalance); //targetBalance: 1번째 ?에 들어갈 값
			selectState.setString(2,"1002159226496"); //"1002159226496" : 2번째 ?에 들어갈 값
			ResultSet result = selectState.executeQuery();
			
			//while문과 달리, 조건에 부합하는 데이터가 없을 때 문구 출력이 가능하다
			if(result.next()) {
				int aid = result.getInt("account_id");
				String anum = result.getString("account_number");
				String aname = result.getString("account_name");
				int balance = result.getInt("balance");
				String bname = result.getString("branch_name");
				Date ltd = result.getDate("last_transaction_date");
				
				System.out.println("Account_ID : " + aid + ", ACCOUNT_NAME : " + aname);
			} else {
				System.out.println("조건에 해당하는 데이터가 없습니다;;");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void intsertBank() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //thin : 100% 자바 클라이언트 드라이버
		String user = "khbank";
		String password = "khbank";
		//Connection con = null; //Connection : java.sql 기본 제공
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = 
					"INSERT INTO bank (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
					+ "VALUES(?,?,?,?,?,?)";
			
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			
			insertState.setInt(1, 100);
			insertState.setString(2, "333302578912");
			insertState.setString(3, "호랑이");
			insertState.setDouble(4, 500);
			insertState.setString(5, "역삼");
			insertState.setDate(6, Date.valueOf("2023-10-17"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row 추가 완료");
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}