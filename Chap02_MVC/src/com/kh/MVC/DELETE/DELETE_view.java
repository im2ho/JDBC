package com.kh.MVC.DELETE;

public class DELETE_view {
	
	public void showStartMsg() {
		System.out.print("삭제하고싶은 카페의 id번호를 입력하세요\ncafe_id : ");
	}
	
	public void showQuestion() {
		System.out.println("정말 삭제하시겠습니까? (Y/N)");
	}
	
	public void showCheckMsg() {
		System.out.println("정말 삭제하시겠습니까?");
	}
	
	public void showResultMsg() {
		System.out.println("삭제 되었습니다"); 
	}
	
	public void showResultMsg2() {
		System.out.println("삭제를 취소했습니다.");
	}
	
	public void showResultMsg3() {
		System.out.println("잘못된 선택입니다.");
	}
}
