package chap03;

public class OpExam {

	public static void main(String[] args) {

		int x = 10;
		
		x++;
		System.out.println("x++: " + x);
		
		x = 10;
		x = x + 1;
		// 나에게 + 1 해서 다시 내게 저장
		// 축약형
		x += 1; // 위와 같은 코드
		x++; // 위와 같은 코드 // 단, + 1 한정
		
		x = 10;
		++x;
		System.out.println("++x: " + x);
		
		x = 10;
		x--;
		--x;
		System.out.println("x: " + x);
		
		x = 10;
		int z = ++x;
		System.out.println("z(++x): " + z);
		System.out.println("x(++x): " + x);
		
		x = 10;
		z = x++;
		System.out.println("z(x++): " + z);
		System.out.println("x(x++): " + x);
		
		x = 10;
		System.out.println("x++: " + x++ + " x: " + x);
		
		x = 10;
		// 10 + 12
		z = x++ + ++x;
		// 예측: 22
		System.out.println("z: " + z);
		
		x = 1;
		z = x++ - --x * x++ - x--;
		// z와 x의 출력값
		// 1 - 1 * 1 -2
		// 예측 z: -2
		// 예측 x: 1
		System.out.println("z: " + z);
		System.out.println("x: " + x);
		
		// 나누기 할 때 0으로 나누지 않는다 (무한루프)
		int b = 10;
//		int c = b / 0;
		double d = 7.3;
		double e = d / 0;
		System.out.println("d/0: " + e); // Infinity
		
		// 나머지
		int f = 10 % 3;
		System.out.println("10%3: " + f);
		// 0 부터 ~ 나머지 하는 숫자 보다 1 작은 숫자만 나온다 
		
		/*
		 * 숫자 149
		 * ---------
		 * 출력결과
		 * ---------
		 * "백의 자리: 1"
		 * "십의 자리: 4"
		 * "일의 자리: 9"
		 */
		// %를 활용해서 풀기
		int num = 149;
		
		int num_100 = num / 100;
		int num_10 = num % 100 / 10;
		int num_1 = num % 10;
		System.out.println("백의 자리: " + num_100 +  "\n십의 자리: " + num_10 + "\n일의 자리: " + num_1);
		
		System.out.println(0.1);
		System.out.println(0.1f);
		System.out.println(0.1 == 0.1f);
		// 소수점은 근사치로 저장한다
		// 그나마 같은 타입으로 변환해서 비교하면 수월함
		
		String s1 = "s1";
		String s2 = "s1";
		System.out.println(s1.equals(s2));
		// 글씨는 무조건 equals()로 비교한다
		System.out.println("sdfdfs".equals(s1)); // false
		
		int c1 = 22;
		int c2 = 4;
		System.out.println("몫: " + (c1 / c2));
		System.out.println("나머지: " + (c1 % c2));
		
		// 문제1
		// 나는 돈이 10000원있다
		// 1. 4500원 짜리 쌍화차를 최대 몇잔 마실 수 있을까?
		// 2. 그리고 남는 돈은?
		int money1 = 10000;
		int tea1 = 4500;
		int num_t = money1 / tea1;
		int money2 = money1 % tea1;
		System.out.println("최대 몇잔?: " + num_t + "잔");
		System.out.println("잔돈: " + money2);
		
		// 문제2
		// 올리브영에서 꿀홍차가 8000원인데
		// 15% 세일! 그렇다면 가격은?
		int redTea = 8000;
		double sale = 0.15;
		double discount = redTea * (1 - sale);
		int discounti = (int)discount;
		System.out.println("할인가: " + discounti + "원");
		
		// 문제3
		double v1 = 1000;
		double v2 = 794.0;
		// v1 / v2를 소수점 3째자리까지만 출력하시오
		// 오직 사칙연산만 사용
		double v3 = v1 / v2 * 1000;
		System.out.println(v3);
		int v4 = (int)(v3);
		System.out.println(v4);
//		double v5 = v4 / 1000; // int / int 형태라 결과값도 int 형임
//		double v5 = (double)v4 * 0.001; // 1.2590000000000001 부동소수점
		double v5 = (double)v4 / 1000;
		System.out.println(v5);
		
		// 문제4
		// 17000원이 있을 때
		// 5000원 몇장?
		// 1000원 몇장?
		int total = 17000;
		int m5 = 5000;
		int m1 = 1000;
		int k5 = total / m5;
//		int k1 = (total - m5 * k5) / m1;
		int k1 = total % m5 / m1;
		System.out.println("금액: " + total + "원");
		System.out.println("5천원권: " + k5 + "장");
		System.out.println("1천원권: " + k1 + "장");
		
		int s = 95;
		String grade = (s > 90) ? "A" : "B";
		System.out.println("grade: " + grade);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
