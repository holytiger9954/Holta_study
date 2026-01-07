package chap02;

import java.util.Scanner;

public class KeyCodeExam {

	public static void main(String[] args) {

		System.out.println(1);
		System.out.println(2);
		
		System.out.print(3);
		System.out.print(4);
		
		System.out.println(5);
		System.out.println(); // <br> 같은 효과
		System.out.println(6);
		
		String name = "허성범";
		int age = 28;
		System.out.println("이름: " + name + ", 나이: " + age);
		System.out.printf("이름: %s, 나이: %d\n", name, age);
		
		System.out.println("-------------");
		/////////////////////
		// 입력
		int keycode;

		// Scanner 연습때문에 주석처리함
/*
		try {
			System.out.print("입력하시오 >> ");
			keycode = System.in.read();
			System.out.println("keycode: " + keycode);
			
			keycode = System.in.read();
			System.out.println("keycode: " + keycode);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
*/		
		// 이클립스 단축키
		/*
		 *  한 줄 지우기: ctrl + d
		 *  한 줄 복사: ctrl + alt + 위 아래 방향키
		 *  한 줄 이동: alt + 위 아래 방향키
		 *  주석 단축키: ctrl + /
		 *  자동 정렬: ctrl + shift + f
		 *  자동 import: ctrl + shift + o 
		 */  
		Scanner scanner = new Scanner(System.in);
		// 엔터까지의 모든 글씨
//		String inputDate = scanner.nextLine();
//		System.out.println("inputDate: " + inputDate);
		
		// 개행 시 첫번째 띄어쓰기 까지만
//		inputDate = scanner.next();
//		System.out.println("inputDate: " + inputDate);
		
		// 문제
		// 나이를 입력하고 + 1 해서 출력
		System.out.print("나이를 입력하세요: ");
//		String age2 = scanner.nextLine();
//		int age3 = Integer.parseInt(age2);
		
		int age3 = scanner.nextInt();
		
		System.out.println("내년에는 " + (age3 + 1) + "살 입니다.");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
