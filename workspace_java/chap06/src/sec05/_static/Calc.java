package sec05._static;

import java.util.Scanner;

public class Calc {

	String color;
	
	// 어짜피 변수이긴 하다
	// 정적 멤버, 공용 변수, 클래스 변수
	static double pi = 3.14;
	
	int max_int = Integer.MAX_VALUE;
	
	static int price;
	
	String c2 = color;
//	static String c3 = color;
	
	{
		System.out.println("필드에 있는 실행 블럭");
	}
	
	static {
		System.out.println("필드에 있는 static 실행 블럭");
		Scanner s = new Scanner(System.in);
		price = s.nextInt();
	}

//	price = 100;
	
	Calc() {
		System.out.println("Calc 생성자 실행");
		
		this.price = 10;
		Calc.price = 10;
	}
	
	static void test() {
		System.out.println("잘 된다");
//		this.color = 10;
	}
	
	void test2() {
		System.out.println("잘 됨");
	}
}
