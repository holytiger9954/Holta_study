package chap04;

import java.util.Scanner;

public class BreakExam_05 {

	public static void main(String[] args) {

//		int count = 0;
//		while(true) {
//			int num = (int)((Math.random() * 6) + 1);
//			System.out.println("주사위: " + num);
//			count++;
//			if(num == 6) {
//				break;
//			}
//		}
//		System.out.println("프로그램 종료: " + "총 " + count + "번");
//		
//		// 총 5명이 순차적으로 주사위를 던져서
//		// 각자 6이 나올 때 까지, 6이 나오면 다음사람
//		for(int i = 1; i <= 5; i++) {
//			
//			while(true) {
//				int num = (int)((Math.random() * 6) + 1);
//				System.out.println("주사위: " + num);
//				
//				if(num == 6) {
//					break; // while 소속이어서 while 중단
//				}
//			}
//		}
//		
//		// 총 4층의 주차건물
//		// 각 층에는 10대의 자리가 있음
//		// 내 차는 1층 첫번째부터 17번째에 있음
//		int count2 = 0;
//		boolean flag = false;
//		for(int i = 1; i <= 4; i++) {
//			
//			for(int j = 1; j <= 10; j++) {
//				count2++;
//				System.out.println(i + "," + j);
//				
//				if(count2 >= 17) {
//					System.out.println("!!!!!!!!!!!");
//					flag = true;
//					break;
//				}
//				
//			}
//			if(flag) {
//				break;
//			}
//		}
//		
//		for(int i = 1; i <= 10; i++) {
//			if(i % 2 == 1) {
//				continue;
//			}
//			System.out.println(i);
//		}
		
		/*
		System.out.println("------문제1-1------");
		
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("---------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("---------------------------------");
			System.out.print("선택> ");
			int menu = scanner.nextInt();
			
			if(menu == 1) {
				System.out.print("예금액> ");
				int money = scanner.nextInt();
				balance += money;
			} else if(menu == 2) {
				System.out.print("출금액> ");
				int money = scanner.nextInt();
				balance -= money;
			} else if(menu == 3) {
				System.out.println("잔고> " + balance);
			} else {
				break;
			}
		}
		System.out.println("프로그램 종료");
		*/
		
		Scanner scan1 = new Scanner(System.in);
		int balance = 0;
		int menu = -1;
		do {
			System.out.println("---------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("---------------------------------");
			System.out.print("선택> ");
			menu = scan1.nextInt();
			
			if(menu == 1) {
				System.out.println("입금액 : ");
				balance += 1000;
				Scanner scan2 = new Scanner(System.in);
				int money = scan2.nextInt();
				if (money < 0) {
					System.out.println("입금액을 확인해주세요");
				} else {
					balance += money;
				}
			} else if(menu == 2) {
				System.out.println("출금액 : ");
				Scanner scan2 = new Scanner(System.in);
				int money = scan2.nextInt();
				if (money < 0) {
					System.out.println("출금액을 확인해주세요");				
				} else if(balance < money) {
					System.out.println("잔액이 부족합니다");									
				} else {
					balance -= money;
				}
			} else if(menu == 3) {
				System.out.println("잔고 : " + balance);
			} else if(menu == 4) {
				System.out.println("종료합니다");
			} else {
				System.out.println("다시 입력하세요");
			}
			
		} while(menu != 4);
		
		System.out.println("------문제1-2------");
		
		boolean run = true;
		balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("---------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("---------------------------------");
			System.out.print("선택> ");
			menu = scanner.nextInt();
			
			if(menu == 1) {
				System.out.print("예금액> ");
				int money = scanner.nextInt();
				if(money < 0) {
					System.out.println("음수 입력은 불가합니다");
				} else {
					balance += money;
					System.out.println("잔고> " + balance);
				}
			} else if(menu == 2) {
				System.out.print("출금액> ");
				int money = scanner.nextInt();
				if(money < 0) {
					System.out.println("음수 입력은 불가합니다");
				} else if(balance < money){
					if(balance - money >= -10000) {
						balance -= money;
						System.out.println("잔고(마이너스 통장)> " + balance);
					} else {
						System.out.println("한도 초과");
					}
				}
			} else if(menu == 3) {
				System.out.println("잔고> " + balance);
			} else if(menu == 4){
				break;
			} else {
				System.out.println("메뉴 내에서만 선택해주세요");
			}
		}
		System.out.println("프로그램 종료");
		
	}

}
