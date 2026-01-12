package chap04;

import java.util.Scanner;

public class IfExam_01 {

	public static void main(String[] args) {

		int score = 85;
		
		boolean over90 = score >= 90;
		
		{
			System.out.println("항상 실행되는 블럭");
		}
		
		
		if(over90) {
			System.out.println("90 이상입니다.");			
		}
		
		if(score < 90) {
			System.out.println("90 미만입니다.");
		}
		
		// 정 반대일 경우 !를 적극 활용한다.
		if(!(score >= 90)) {			
			System.out.println("90 미만입니다.");			
		}
		
		if(score >= 90) {
			System.out.println("90 이상입니다.");						
		} else { // 그렇지 않으면
			System.out.println("90 미만입니다.");						
		}
		// else가 있으면 무조건 하나는 실행이 보장된다.
		System.out.println("--------------");
		
		score = 95;
		if(score >= 90) {
			System.out.println("90 이상");
		}
		// 위의 if 문과는 독립적으로 실행된다
		if(score < 100 && score >= 80) {
			System.out.println("80 ~ 99");
		}
		System.out.println("--------------");
		
		if(score >= 90) {
			System.out.println("A");
		} else if((score < 90) && (score >= 80)) {
			System.out.println("B");		
		}
		System.out.println("--------------");
		
		// 97점이면
		// 	90 이상
		// 	95 이상
		// 92점이면
		// 	90 이상
		if(score >= 95) {
			System.out.println("90 이상");
			System.out.println("95 이상");
		} else if(score >= 90) {
			System.out.println("90 이상");			
		}
		
		if(score >= 90) {
//			System.out.println("90 이상");
			if(score >= 95) {
				System.out.println("95 이상");				
			}
		}
		
		if(score >= 90 && score >= 95) {
			System.out.println("95 이상");							
		}
		System.out.println("--------------");
		
		if(score >= 90) {
			System.out.println("90 이상");
//		} else if(score < 100 && score >= 80) {
//		} else if(score < 90 && score >= 80) {
		} else if(score >= 80) {
			System.out.println("90 미만 80 이상");
		} else if(score >= 70) {
			System.out.println("80 미만 70 이상");			
		} else {
			System.out.println("70 미만");						
		}
		System.out.println("--------------");
		
		// 홀짝
		int x = 3;
		
		if(x % 2 == 0) {
			System.out.println(x + "은(는) 짝수입니다.");
		} else {
			System.out.println(x + "은(는) 홀수입니다.");			
		}
		System.out.println("--------------");
		
		// 랜덤
		double random1 = Math.random();
		System.out.println("random1: " + random1);
		System.out.println("--------------");
		
		// Math.random()
		// 0 <= Math.random() < 1
		// 0 ~ 0.99999999999
		
		// 이해하고 만들어가기
		// 1. 홀짝
		// 0과 1
		// 두개의 케이스로 만들기
		// 0 <= Math.random() * 10 < 10
		// int로 형변환
		// 0 ~ 9
		// if(Math.random() * 10 % 2 == 0)
		
		// 0과 1을 구하는
		// 정교한 방식
		// 0 * 2 <= Math.random() * 2 < 1 * 2
		// 0 ~ 1.99999999999
		// int로 형 변환해서 정수만 남기기
		double rand2 = Math.random();
		double temp1 = rand2 * 2; // 0 ~ 1.999999999
		int result = (int)temp1;
		System.out.println("랜덤 홀짝");
		if(result == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		System.out.println("--------------");
		
		// 1 ~ 6까지 구하기 (주사위)
		// 0 * 6 <= Math.random() * 6 < 1 * 6
		// int로 형변환
		// +1 하면 1 ~ 6
		rand2 = Math.random();
		double temp2 = rand2 * 6; // 0 ~ 5.99999999
		int result0 = (int)temp2; // 0 ~ 5
		result = result0 + 1; // 1 ~ 6
		System.out.println("주사위 결과: " + result);
		System.out.println("--------------");
		
		// 5 ~ 10까지 구하기
		// 0 ~ 5까지 구해서 +5
		rand2 = Math.random();
		temp2 = rand2 * 6; // 0 ~ 5.99999999
		int result5 = (int)temp2; // 0 ~ 5
		result = result5 + 5; // 5 ~ 10
		System.out.println("결과(5 ~ 10): " + result);
		
		// 변수로 범위를 잡아서 보편화
		int min = 5;
		int max = 10;
		rand2 = Math.random();
		temp2 = (int)(rand2 * (max - min + 1)) + min;
		result = (int)temp2;
		System.out.println("결과(5 ~ 10): " + result);
		
		// 쉬운 방식
		rand2 = Math.random();
		temp2 = rand2 * 100000;
		result0 = (int)temp2;
		result = (result0 % 6) + 1;
		System.out.println("결과(5 ~ 10): " + result);
		System.out.println("--------------");
		
		// 로또 번호
		// 1 ~ 45까지 6개의 숫자를 랜덤으로 뽑아서 제출하시오
		// 단, 중복 없이
		min = 1;
		max = 45;
		double rand2_1 = Math.random();
		double rand2_2 = Math.random();
		double rand2_3 = Math.random();
		double rand2_4 = Math.random();
		double rand2_5 = Math.random();
		double rand2_6 = Math.random();
		int lotto_num1 = (int)(rand2_1 * (max - min + 1)) + min;
		int lotto_num2 = (int)(rand2_2 * (max - min + 1)) + min;
		int lotto_num3 = (int)(rand2_3 * (max - min + 1)) + min;
		int lotto_num4 = (int)(rand2_4 * (max - min + 1)) + min;
		int lotto_num5 = (int)(rand2_5 * (max - min + 1)) + min;
		int lotto_num6 = (int)(rand2_6 * (max - min + 1)) + min;
		int result_no1 = (int)lotto_num1;
		int result_no2 = (int)lotto_num2;
		int result_no3 = (int)lotto_num3;
		int result_no4 = (int)lotto_num4;
		int result_no5 = (int)lotto_num5;
		int result_no6 = (int)lotto_num6;
		System.out.println("로또 번호 1번 자리: " + result_no1);
		System.out.println("로또 번호 2번 자리: " + result_no2);
		System.out.println("로또 번호 3번 자리: " + result_no3);
		System.out.println("로또 번호 4번 자리: " + result_no4);
		System.out.println("로또 번호 5번 자리: " + result_no5);
		System.out.println("로또 번호 6번 자리: " + result_no6);
		System.out.println("--------------");
		
		// 임의의 수를 입력받아
		// 문제1
		// "양수", 0,  "음수" 판단하여 출력
		
		/*
		Scanner scanner1 = new Scanner(System.in);
		System.out.print("숫자를 입력하세요(음수판독기): ");
		int num1 = scanner1.nextInt();
		if(num1 > 0) {
			System.out.println("양수");
		} else if(num1 == 0) {
			System.out.println("0");	
		} else if(num1 < 0) {
			System.out.println("음수");
		} else {
			System.out.println("숫자만 입력하세요.");
		}
		*/
		
		// 문제2
		// 홀수인지 짝수인지 판단하여 출력
		
		/*
		Scanner scanner2 = new Scanner(System.in);
		System.out.print("숫자를 입력하세요(홀짝판독기): ");
		int num2 = scanner2.nextInt();
		if(num2 % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		*/
		
		
		// 문제3
		// 임의의 두 수 x, y를 받아서
		// 둘 중에 큰 값 출력
		
		/*
		Scanner scanner3_1 = new Scanner(System.in);
		System.out.print("값1: ");
		int x1 = scanner3_1.nextInt();
		Scanner scanner3_2 = new Scanner(System.in);
		System.out.print("값2: ");
		int y1 = scanner3_2.nextInt();
		if(x1 > y1) {
			System.out.println("큰 값: " + x1);
		} else if (x1 < y1){
			System.out.println("큰 값: " + y1);
		} else {
			System.out.println("두 수의 값이 같아요.")
		}
		*/
		
		// 문제4
		// 임의의 money를 입력 받아서
		// 7000원 이상이면 "택시타자" 출력
		// 3000원 이상이면 "버스타자" 출력
		// 3000원 미만이면 "걸어가자" 출력
		
		/*
		Scanner scanner4 = new Scanner(System.in);
		System.out.print("얼마있나요: ");
		int money = scanner4.nextInt();
		if(money >= 7000) {
			System.out.print("택시타자");
		} else if(money >= 3000) {
			System.out.print("버스타자");
		} else {
			System.out.print("걸어가자");
		}
		*/
		
		// 문제5
		// '가위', '바위', '보' 입력 받아서 게임 완성
		// 5-1 컴퓨터는 항상 '바위'만 낼 경우
		
		/*
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
		*/
		
		// 5-2 컴퓨터도 random으로
		// '이겼다', '비겼다', '졌다' 출력
		
		/*
		min = 1;
		max = 3;
		Scanner scanner5_2 = new Scanner(System.in);
		System.out.print("가위바위보!: ");
		String rsp_me = scanner5_2.nextLine();
		double rsp_rand = Math.random();
		int rsp_data_i = (int)(rsp_rand * (max - min + 1)) + min;
		if(rsp_data_i == 1) { // 가위인 경우
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
		} else if(rsp_data_i == 2) { // 바위인 경우
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
		} else if(rsp_data_i == 3) { // 보인 경우
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
		*/
		
		// 문제6
		// 임의의 세 수 x, y, z를 받아서
		// z가 x ~ y 사이에 있는지 판단
		
		/*
		// x >= y 인 경우도 생각해보자
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
		*/
		
		// 문제7
		// 몇 월인지 입력받아서 
		// 계절 출력
		// 13, -1 입력하면 "정확히 입력해주세요" 출력
		
		/*
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
		*/
		
		// 문제8
		// 임의의 수를 입력받아서 다음과 같이 출력
		// 예: 125
		// 입력한 수는 100보다 크고, 양수이고, 홀수입니다.
		
		/*
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
		*/
		
		// 문제9
		// 온도를 입력받아서 다음과 같이 출력
		// 예 : -3
		// "영하 3도 입니다."
		// 예: 5
		// "영상 5도 입니다."
		
		/*
		Scanner scanner9 = new Scanner(System.in);
		System.out.print("온도를 입력하세요: ");
		int degree = scanner9.nextInt();
		if(degree > 0) {
			System.out.println("영상 " + degree + "도 입니다.");
		} else {
			System.out.println("영하 " + (degree*(-1)) + "도 입니다.");			
		}
		*/
		
		// 응용문제
		// 문제10
		// 시, 분을 입력 받아서 35분 후의 시. 분을 출력
		// 3, 51을 입력받으면
		// "4시 26분" 출력
		
		/*
		Scanner scanner10 = new Scanner(System.in);
		System.out.print("몇시인가요?: ");
		int hour = scanner10.nextInt();
		System.out.print("몇분인가요?: ");
		int minute = scanner10.nextInt();
		int minuteData = minute + 35;
		if(hour < 24 && hour >=1) {
			if(minute <= 24 && minute >= 0) {
				System.out.println("35분 뒤의 시간은 "+ hour + "시 " + minuteData + "분 입니다.");
			} else if(minute > 24) {
				System.out.println("35분 뒤의 시간은 "+ (hour -24 + 1) + "시 " + (minuteData - 60) + "분 입니다.");			
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
		*/
		
		// 문제11
		// 두 자리 숫자를 입력받아서
		// 10의 자리와 1의 자리가 같은지 판단
		// 예: 77 => 같음, 94 => 다름
		
		/*
		Scanner scanner11 = new Scanner(System.in);
		System.out.print("두 자리 숫자를 입력하세요: ");
		int inputNum = scanner11.nextInt();
		int inputNum10 = inputNum / 10;
		int inputNum1 = inputNum % 10;
		if(inputNum10 == inputNum1) {
			System.out.println(inputNum10 + "은(는) " + inputNum1 + "와(과) 같음");
		} else if(inputNum10 != inputNum1) {
			System.out.println(inputNum10 + "은(는) " + inputNum1 + "와(과) 다름");
		} else {
			System.out.println("두 자리 숫자만 입력하세요.");
		}
		*/
		
		// 문제12
		// 1~99까지 369게임
		// 임의의 수를 받아서 3, 6, 9 숫자가 있으면 "박수" 출력
		// 없으면 그 숫자 그대로 출력
		// 예: 33 => 박수, 31 => 박수, 12 => 12
		
		/*
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
			System.out.println("1 ~ 99의 숫자만 입력 가능합니다.");
		}
		*/
		
		// 문제13
		// 충돌검사
		// 사각형의 한쪽 모서리 : x1:10, y1:20
		// 반대편 모서리 : x2;90, y2:100
		// 입력받은 두 수를 좌표로 하는 점이 사각형에 겹치는가
		
		/*
		Scanner scanner13 = new Scanner(System.in);
		int x1= 10;
		int y1 = 20;
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
		*/
		
//		// 모두 && 일 때
//		// false를 찾으면 뒤의 연산을 하지 않는다
//		if(false && true) {
//			
//		}
//		// 모두 || 일 때
//		// true를 찾으면 뒤의 연산을 하지 않는다
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
