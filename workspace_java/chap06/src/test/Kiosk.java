package test;

import java.util.Scanner;

public class Kiosk {
	
	Scanner scan = new Scanner(System.in);
	Counter c = new Counter();

	void run() { // 주문 받기
		while(true) {
			System.out.println("1. 주문하기 2. 종료");
			int select1 = scan.nextInt();
			
			if(select1 == 1) { // 1을 선택하면
				order(); // 주문 받기
				break; // 일단 영수증 나오면 terminated 되게 해놓음
			} else if(select1 == 2) { // 2를 선택하면
				System.out.println("종료합니다");
				break; // 종료
			} else { // 딴거 입력하면
				System.out.println("다시 입력해주세요");
			}
			
		}
	}
	
	void order() {
		while(true) {
			order1(); // 메뉴 고르기
			
			System.out.println("1. 추가 주문 2. 결제하기 0. 주문취소");
			int p = scan.nextInt();
			
			if(p == 2) {
				c.receipt();
				c.clearCart();
				break; 
			} else if(p == 0) {
				c.clearCart();
				break;
			}
		}
	}
	
	void order1() { // 메뉴 고르기
		System.out.println("Menu: 1. 아메리카노(3,000) 2. 카페라떼(3,500) 3. 스무디(4,000) 0. 주문취소");
		System.out.print("메뉴를 선택하세요: ");
		int select2 = scan.nextInt();
		
		if(select2 == 0) { // 주문 취소
			System.out.println("종료합니다");
			return;
		} 
		
		Menu item = null;
		
		if(select2 == 1) {
			item = new Menu("아메리카노", 3000); // item 생성자에 전달인자 넣기
			order2_1(item); // 받은 전달 인자로 2_1 호출
		} else if(select2 == 2) {
			item = new Menu("카페라떼", 3500); // item 생성자에 전달인자 넣기
			order2_2(item); // 받은 전달 인자로 2_2 호출
		} else if(select2 == 3) {
			item = new Menu("스무디", 4000); // item 생성자에 전달인자 넣기
			order2_3(item); // 받은 전달 인자로 2_3 호출
		} else {
			System.out.println("다시 선택해주세요");
		}
		
		if(item != null) {
			c.addMenu(item); // 메뉴 선택을 하면 list에 넣기
		}
		
	}
	
	void order2_1(Menu item) { // order1에서 받은 전달인자 item은 Menu의 객체
		System.out.println("Option: 1. 따뜻하게 2. 차갑게(+500)");
		System.out.println("옵션을 선택하세요: ");
		int select2_1 = scan.nextInt();
		if(select2_1 == 2) {
			item.price += 500; 
			item.name += "(ICE)";
		}
		
	}
	
	void order2_2(Menu item) { // order1에서 받은 전달인자 item은 Menu의 객체
		System.out.println("Option: 1. 우유 많이(+300) 2. 우유 조금");
		System.out.println("옵션을 선택하세요: ");
		int select2_2 = scan.nextInt();
		if(select2_2 == 1) {
			item.price += 300;
			item.name += "(우유추가)";
		}
	}
	void order2_3(Menu item) { // order1에서 받은 전달인자 item은 Menu의 객체
		System.out.println("Option: 1. 딸기(+500) 2. 수박(+1000) 3. 망고(+1500)");
		System.out.println("옵션을 선택하세요: ");
		int select2_3 = scan.nextInt();
		if(select2_3 == 1) {
			item.price += 500;
			item.name += "(딸기)";
		} else if(select2_3 == 2) {
			item.price += 1000;
			item.name += "(수박)";
		} else if(select2_3 == 3) {
			item.price += 1500;
			item.name += "(망고)";
		}
	}
	
}
