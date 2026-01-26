package test;

import java.util.ArrayList;

public class Counter {

	ArrayList<Menu> list = new ArrayList<Menu>();
	int total;
	
	void addMenu(Menu menu) {
		list.add(menu); // 선택한 메뉴 정보 list에 추가
		System.out.println(menu.name + "이(가) 추가되었습니다");
	}
	
	void receipt() {
		System.out.println("------영수증------");
		this.total = 0; // 총 결제 금액 초기화
		for(int i = 0; i < this.list.size(); i++) {
			System.out.println("- " + list.get(i).name + " : " + list.get(i).price);
			this.total += list.get(i).price; // 총 결제 금액 더하기
		}
		System.out.println("-------------------");
		System.out.println("총 결제 금액: " + this.total + "원");
	}
	
	void clearCart() {
		this.list.clear(); // 주문이 끝나면 장바구니 비우기
		this.total = 0; // 총 결제 금액 혹시 몰라 한 번 더 초기화
//		System.out.println("장바구니 초기화");
	}
	
}
