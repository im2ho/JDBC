package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class DBConnection {

	public static void main(String[] args) {
		//1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ORACLE 내 컴퓨터 연결 : 데이터 베이스 연결 정보
									  //나의IP주소:port번호:SID
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
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
	}

}