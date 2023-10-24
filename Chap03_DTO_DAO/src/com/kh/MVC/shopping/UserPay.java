package com.kh.MVC.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPay {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khbank";
	String password = "khbank";
	
	ShoppingCart cart;
	
	public UserPay(ShoppingCart cart) {
		this.cart = cart;
	}
	
	//결제 메서드 (결제 성공 여부 반환)
	public boolean payment() {
		Connection connection = null;
		//짜빠구니 총 금액
		//ShoppingCart에 최종 결제 금액 메서드 추가해서 이용.. 메서드 만들러 총총..
		double cartTotalPrice = cart.cartTotalPrice();
		
		try {
			connection = DriverManager.getConnection(url, user, password);
			//김칸쵸 계좌 잔액 가져오기
			String selectSQL = "SELECT balance FROM bank WHERE account_name = '김칸쵸'";
			PreparedStatement selectState = connection.prepareStatement(selectSQL);
			ResultSet result = selectState.executeQuery();
			
			if(result.next()) {
				//잔액 조회
				double balance = result.getDouble("balance");
				
				//잔액이 부족할 경우
				if(balance < cartTotalPrice) {
					System.out.println("잔액이 부족합니다.");
					return false;
				}
				
				//잔액에서 장바구니 총액을 빼주기
				double new_balance = balance - cartTotalPrice;
				
				//잔액 업데이트
				String updateSQL = "UPDATE bank SET balance = ? WHERE account_name = '김칸쵸'";
				PreparedStatement updateState = connection.prepareStatement(updateSQL);
				updateState.setDouble(1, new_balance);
				updateState.executeUpdate();
				
				System.out.println("결제 완료\n잔액 : " + new_balance);
				return true;
			
			} else {
				System.out.println("계좌를 찾을 수 없습니다.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
