package sec04;

import java.util.Scanner;

public class Calc {
	
	// 메소드 선언
	void powerOn() {
		int a;
		a = 10;
		
		System.out.println("전원을 켭니다.");
	}
	
	// 잠깐 return 배우고 옴
	
	int plus(int x, int y) {
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		
		int result = x + y;
		
		return result;
	}
	
	int minus(int x, int y) {
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		
		int result = x - y;
		
		return result;
	}
	
	double divide(int x, int y) {
		double result = 0;
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		if(y == 0) {
			System.out.println("0으로 나눌 수 없다");
			
			result = 0;
//			return 0;
		} else {
			result = x / y;
		}
//		} else {
//			double result = x / y;
//			return result;
//			return (double)x / y;
//		}
//		return (double)x / y;
		return result;
	}
	
	/**
	 *  javadoc 주석
	 *  두 정수를 입력 받아서
	 *  나누기한 결과를 x/y
	 *  double로 반환하는 메소드
	 *  단 y가 0일 때는
	 *  	"0으로 나눌 수 없다"고 출력하고
	 *  	0을 반환함
	 *  
	 *  메소드명: devide
	 *  전달인자: int x, int y
	 *  리턴타입: double
	 *  
	 *  @param int x, int y
	 *  @return double
	 *  @author qwerty@naver.com
	 */
	
//	Calc 클래스에 숫자와 문자를 받을수 있는 
//	scanner ,더하기, 빼기 , 나누기 , 곱하기 Method를 만든다.
//
//	CalcExam 클래스 에서 
//
//	scanner 메소드를 호출하여 
//	1번째 숫자 , 2번째 연산자 , 3번째 숫자 를 입력하여 ArrayList 로 return 을 받는다.
//	연산자를 if 하여 연산자에 맞는 메소드에 숫자를 보내 리턴받고 출력한다. 
//
//	scanner 은 String 으로 받아서 형변환 가능 , 0번째 숫자  , 1번째 문자 , 2번째 숫자 로 받아도 됨
//
//	예 
//
//	>"1 * 2"
//
//	>"2 입니다."
//	String a = "1";
//	        int b = 9;
//	        System.out.println(Integer.parseInt(a) * b);  문자열숫자를 인트로 형변환 하는 방법중 하나 입니다.
	
	int calcP(int x, int y) {
		
		return x + y;
	}
	int clacM(int x, int y) {
		
		return x - y;
	}
	int calcD(int x, int y) {
		
		return x / y;
	}
	int calcS(int x, int y) {
		
		return x * y;
	}
	
	void scanner() {
		Scanner scan = new Scanner(System.in);
		int numX = scan.nextInt();
		String operater = scan.nextLine();
		int numY = scan.nextInt();	
	}
	
}
