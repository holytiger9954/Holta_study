package chap04;

import java.util.Scanner;

public class TestExam_00 {

	public static void main(String[] args) {

		// 임의의 수를 입력받아
				// 문제1
				// "양수", 0,  "음수" 판단하여 출력
				
				
				Scanner scanner1 = new Scanner(System.in);
				System.out.print("숫자를 입력하세요(음수판독기): ");
				int num1 = scanner1.nextInt();
				if(num1 > 0) {
					System.out.println("양수");
				} else if(num1 == 0) {
					System.out.println("0");	
				} else {
					System.out.println("음수");
				}
				
				
				// 문제2
				// 홀수인지 짝수인지 판단하여 출력
				
				
				Scanner scanner2 = new Scanner(System.in);
				System.out.print("숫자를 입력하세요(홀짝판독기): ");
				int num2 = scanner2.nextInt();
				if(num2 % 2 == 0) {
					System.out.println("짝수");
				} else {
					System.out.println("홀수");
				}
				
				
				
				// 문제3
				// 임의의 두 수 x, y를 받아서
				// 둘 중에 큰 값 출력
				
				
				Scanner scanner3_1 = new Scanner(System.in);
				System.out.print("값1: ");
				int x1 = scanner3_1.nextInt();
				Scanner scanner3_2 = new Scanner(System.in);
				System.out.print("값2: ");
				int y1 = scanner3_2.nextInt();
				if(x1 > y1) {
					System.out.println("큰 값: " + x1);
				} else if(x1 < y1) {
					System.out.println("큰 값: " + y1);
				} else {
					System.out.println("값이 같아요.");
				}
				
				
				// 문제4
				// 임의의 money를 입력 받아서
				// 7000원 이상이면 "택시타자" 출력
				// 3000원 이상이면 "버스타자" 출력
				// 3000원 미만이면 "걸어가자" 출력
				
				
				Scanner scanner4 = new Scanner(System.in);
				System.out.print("얼마있나요: ");
				int money = scanner4.nextInt();
				if(money >= 7000) {
					System.out.println("택시타자");
				} else if(money >= 3000) {
					System.out.println("버스타자");
				} else {
					System.out.println("걸어가자");
				}
				
				
				// 문제5
				// '가위', '바위', '보' 입력 받아서 게임 완성
				// 5-1 컴퓨터는 항상 '바위'만 낼 경우
				
				
				Scanner scanner5_1 = new Scanner(System.in);
				System.out.print("가위바위보!: ");
				String rsp = scanner5_1.nextLine();
				if(rsp.equals("보")) {
					System.out.println("이겼다!");
				} else if(rsp.equals("바위")) {
					System.out.println("비겼다...");
				} else if(rsp.equals("가위")) {
					System.out.println("졌다ㅠ");
				} else {
					System.out.println("이거 가위바위보야");
				}
				
				
				// 5-2 컴퓨터도 random으로
				// '이겼다', '비겼다', '졌다' 출력
				
				
				int min = 1;
				int max = 3;
				Scanner scanner5_2 = new Scanner(System.in);
				System.out.print("가위바위보!: ");
				String rsp_me = scanner5_2.nextLine();
				double rsp_rand = Math.random();
				int rsp_data_i = (int)(rsp_rand * (max - min + 1)) + min;
				if(rsp_data_i == 1) {
					String rsp_data_s = "가위";
					if(rsp_me.equals(rsp_data_s)) {
						System.out.println("비겼어요...");				
					} else if(rsp_me.equals("바위")) {
						System.out.println("이겼다!");								
					} else if(rsp_me.equals("보")) {
						System.out.println("졌어요ㅠ");								
					} else {
						System.out.println("뭔가 잘못됨");												
					}
				} else if(rsp_data_i == 2) {
					String rsp_data_s = "바위";	
					if(rsp_me.equals(rsp_data_s)) {
						System.out.println("비겼어요...");				
					} else if(rsp_me.equals("보")) {
						System.out.println("이겼다!");								
					} else if(rsp_me.equals("가위")) {
						System.out.println("졌어요ㅠ");								
					} else {
						System.out.println("뭔가 잘못됨");												
					}
				} else if(rsp_data_i == 3) {
					String rsp_data_s = "보";
					if(rsp_me.equals(rsp_data_s)) {
						System.out.println("비겼어요...");				
					} else if(rsp_me.equals("가위")) {
						System.out.println("이겼다!");								
					} else if(rsp_me.equals("바위")) {
						System.out.println("졌어요ㅠ");								
					} else {
						System.out.println("뭔가 잘못됨");												
					}
				} else {
					System.out.println("뭔가 잘못됨");
				}
				
				
				// 문제6
				// 임의의 세 수 x, y, z를 받아서
				// z가 x ~ y 사이에 있는지 판단
				
				
				Scanner scanner6 = new Scanner(System.in);
				System.out.print("x: ");
				int xnum = scanner6.nextInt();
				System.out.print("y: ");
				int ynum = scanner6.nextInt();
				System.out.print("z: ");
				int znum = scanner6.nextInt();
				if(znum > xnum && znum < ynum) {
					System.out.println(xnum + "와(과) " + ynum + "사이에 있어요.");
				} else if(znum == xnum) {
					System.out.println(xnum + "와(과) 같아요.");
				} else if(znum == ynum) {
					System.out.println(ynum + "와(과) 같아요.");			
				} else {
					System.out.println(xnum + "와(과) " + ynum + "범위 밖에 있어요.");						
				}
				
				
				// 문제7
				// 몇 월인지 입력받아서 
				// 계절 출력
				// 13, -1 입력하면 "정확히 입력해주세요" 출력
				
				
				Scanner scanner7 = new Scanner(System.in);
				System.out.print("지금은 몇월?: ");
				int month = scanner7.nextInt();
				if(month >= 3 && month <= 5 ) {
					System.out.println(month + "월은 봄이에요.");			
				} else if(month >= 6 && month <= 8) {
					System.out.println(month + "월은 여름이에요.");						
				} else if(month >= 9 && month <= 11 ) {
					System.out.println(month + "월은 가을이에요.");									
				} else if((month >= 11 && month <= 12) || (month < 3 && month >= 1)) {
					System.out.println(month + "월은 겨울이에요.");												
				} else {
					System.out.println("정확히 입력해주세요");
				}
				
				
				// 문제8
				// 임의의 수를 입력받아서 다음과 같이 출력
				// 예: 125
				// 입력한 수는 100보다 크고, 양수이고, 홀수입니다.
				
				
				Scanner scanner8 = new Scanner(System.in);
				System.out.print("수를 입력하세요: ");
				int number8 = scanner8.nextInt();
				if(number8 > 100) {
					if(number8 % 2 == 0) {
						System.out.println(number8 + "은 100보다 크고, 양수이고, 짝수입니다.");
					} else {
						System.out.println(number8 + "은 100보다 크고, 양수이고, 홀수입니다.");				
					}
				} else if(number8 == 100) {
					System.out.println(number8 + "은 100이고, 양수이고, 짝수입니다.");			
				} else if(number8 < 100) {
					if(number8 >= 0) {
						if(number8 % 2 == 0) {
							System.out.println(number8 + "은 100보다 작고, 양수이고, 짝수입니다.");			
						} else {
							System.out.println(number8 + "은 100보다 작고, 양수이고, 홀수입니다.");								
						}
					} else {
						if(number8 % 2 == 0) {
							System.out.println(number8 + "은 100보다 작고, 음수이고, 짝수입니다.");			
						} else {
							System.out.println(number8 + "은 100보다 작고, 음수이고, 홀수입니다.");								
						}
					}
				}
				
				
				// 문제9
				// 온도를 입력받아서 다음과 같이 출력
				// 예 : -3
				// "영하 3도 입니다."
				// 예: 5
				// "영상 5도 입니다."
				
				
				Scanner scanner9 = new Scanner(System.in);
				System.out.print("온도를 입력하세요: ");
				int degree = scanner9.nextInt();
				if(degree >= 0) {
					System.out.println("영상 " + degree + "도 입니다.");
				} else {
					System.out.println("영하 " + (degree*(-1)) + "도 입니다.");			
				}
				
				
				// 응용문제
				// 문제10
				// 시, 분을 입력 받아서 35분 후의 시. 분을 출력
				// 3, 51을 입력받으면
				// "4시 26분" 출력
				
				
				Scanner scanner10 = new Scanner(System.in);
				System.out.print("몇시인가요?: ");
				int hour = scanner10.nextInt();
				System.out.print("몇분인가요?: ");
				int minute = scanner10.nextInt();
				int minuteData = minute + 35;
				if(hour < 24 && hour >= 1) {
					if(minute <= 24 && minute >= 0) {
						System.out.println("35분 뒤의 시간은 "+ hour + "시 " + minuteData + "분 입니다.");
					} else if(minute > 24) {
						System.out.println("35분 뒤의 시간은 "+ (hour + 1) + "시 " + (minuteData - 60) + "분 입니다.");			
					} else {
						System.out.println("정확한 분을 입력해주세요.");				
					}
				} else if(hour == 24) {
					if(minute <= 24 && minute >= 0) {
						System.out.println("35분 뒤의 시간은 "+ hour + "시 " + minuteData + "분 입니다.");
					} else if(minute > 24) {
						System.out.println("35분 뒤의 시간은 "+ (hour - 24 + 1) + "시 " + (minuteData - 60) + "분 입니다.");			
					} else {
						System.out.println("정확한 분을 입력해주세요.");
					}
				} else {
					System.out.println("정확한 시를 입력해주세요.");
				}
				
				
				
				// 문제11
				// 두 자리 숫자를 입력받아서
				// 10의 자리와 1의 자리가 같은지 판단
				// 예: 77 => 같음, 94 => 다름
				
				
				Scanner scanner11 = new Scanner(System.in);
				System.out.print("두 자리 숫자를 입력하세요: ");
				int inputNum = scanner11.nextInt();
				int inputNum10 = inputNum / 10;
				int inputNum1 = inputNum % 10;
				if(inputNum10 == inputNum1) {
					System.out.println("같음");
				} else if(inputNum10 != inputNum1) {
					System.out.println("다름");
				} else {
					System.out.println("두 자리 숫자만 입력하세요.");
				}
				
				
				// 문제12
				// 1~99까지 369게임
				// 임의의 수를 받아서 3, 6, 9 숫자가 있으면 "박수" 출력
				// 없으면 그 숫자 그대로 출력
				// 예: 33 => 박수, 31 => 박수, 12 => 12
				
				
				Scanner scanner12 = new Scanner(System.in);
				System.out.print("1 ~ 99 중 원하는 숫자를 입력하세요: ");
				int game369 = scanner12.nextInt();
				int game369_num10 = game369 / 10;
				int game369_num1 = game369 % 10;
				if((game369 <= 99) || (game369 > 0)) {
					if((game369_num1 == 3) || (game369_num1 == 6) || (game369_num1 == 9)) {
						System.out.println("박수");
					} else if((game369_num10 == 3) || (game369_num10 == 6) || (game369_num10 == 9)) {
						System.out.println("박수");				
					} else {
						System.out.println(game369);
					}
					
				} else {
					System.out.println("1 ~ 99까지의 숫자만 입력 가능합니다.");
				}
				
				
				// 문제13
				// 충돌검사
				// 사각형의 한쪽 모서리 : x1:10, y1:20
				// 반대편 모서리 : x2;90, y2:100
				// 입력받은 두 수를 좌표로 하는 점이 사각형에 겹치는가
				
				
				Scanner scanner13 = new Scanner(System.in);
				x1= 10;
				y1 = 20;
				int x2 = 90;
				int y2 = 100;
				System.out.print("x축: ");
				int xCood = scanner13.nextInt();
				System.out.print("y축: ");
				int yCood = scanner13.nextInt();
				if(((xCood >= x1) && (xCood <= x2))) {
					if(((yCood >= y1) && (yCood <= y2))) {
						System.out.println("사각형과 겹쳐요.");
					} else {
						System.out.println("x축만 겹쳐요");
					}
				} else {
					if(((yCood >= y1) && (yCood <= y2))) {
						System.out.println("y축만 겹쳐요.");
					}
					System.out.println("사각형과 겹치지 않아요.");
				}
				
		
	}

}
