package chap04;

import java.util.Scanner;

public class Pyramid_03_1 {

	public static void main(String[] args) {

		// 1단계
		// +++++
		System.out.println("-----1단계-----");
		int num = 5;
		for(num = 1; num <= 5; num++) {
			System.out.print("+");
		}
		System.out.println();
		
		// 2단계
		// +_+_+_+_+_
		System.out.println("-----2단계-----");
		num = 10;
		for(num = 1; num <= 10; num++) {
			if(num % 2 == 1) {
				System.out.print("+");
			} else {
				System.out.print("_");				
			}
		}
		System.out.println();
		
		// 3단계
		// +++++
		// +++++
		// +++++
		System.out.println("-----3단계-----");
		num = 5;
		int height = 3;
		for(height = 1; height <= 3; height++) {
			for(num = 1; num <= 5; num++) {
				System.out.print("+");
			}
			System.out.println();
		}
		System.out.println();
		
		// 4단계
		// 11111
		// 22222
		// 33333
		// 44444
		// 55555
		System.out.println("-----4단계-----");
		num = 5;
		height = 5;
		for(height = 1; height <= 5; height++) {
			for(num = 1; num <= 5; num++) {
				System.out.print(height);
			}
			System.out.println();
		}
		System.out.println();
		
		// 5단계
		// 1
		// 22
		// 333
		// 4444
		// 55555
		System.out.println("-----5단계-----");
		num = 5;
		height = 5;
		for(height = 1; height <= 5; height++) {
			for(num = 1; num <= height; num++) {
				System.out.print(height);
			}
			System.out.println();
		}
		System.out.println();
		
		// 6단계
		// +
		// ++
		// +++
		// ++++
		// +++++
		System.out.println("-----6단계-----");
		for(height = 1; height <= 5; height++) {
			for(num = 1; num <= height; num++) {
				System.out.print("+");
			}
			System.out.println();
		}
		System.out.println();
		
		// 7단계
		// 11111
		// 2222
		// 333
		// 44
		// 5
		System.out.println("-----7단계-----");
		height = 5;
		num = 5;
		for(height = 1; height <= 5; height++) {
			for(num = 1; num <= (5 - height + 1); num++) {
				System.out.print(height);
			}
			System.out.println();
		}
		System.out.println();
		
		// 8단계
		// +____
		// ++___
		// +++__
		// ++++_
		// +++++
		System.out.println("-----8단계-----");
		int num0 = 0;
		int num1 = 0;
		int num2 = 0;
		height = 5;
		for(num0 = 1; num0 <= height; num0++) {
			for(num1 = 1; num1 <= num0; num1++) {
				System.out.print("+");				
			}
			for(num2 = 1; num2 <= (height-num0); num2++) {
				System.out.print("_");
			}
			System.out.println();
		}
		System.out.println();
		
		// 9단계
		// ____+
		// ___++
		// __+++
		// _++++
		// +++++
		System.out.println("-----9단계-----");
		num0 = 0;
		num1 = 0;
		num2 = 0;
		height = 5;
		for(num0 = 1; num0 <= height; num0++) {
			for(num2 = 1; num2 <= (height-num0); num2++) {
				System.out.print("_");
			}
			for(num1 = 1; num1 <= num0; num1++) {
				System.out.print("+");				
			}
			System.out.println();
		}
		System.out.println();
		
		// 10단계
		// ____+
		// ___+++
		// __+++++
		// _+++++++
		// +++++++++
		System.out.println("-----10단계-----");
		num0 = 0;
		num1 = 0;
		num2 = 0;
		height = 5;
		for(num0 = 1; num0 <= height; num0++) {
			for(num2 = 1; num2 <= (height-num0); num2++) {
				System.out.print("_");
			}
			for(num1 = 1; num1 <= (2 * num0 - 1); num1++) {
				System.out.print("+");				
			}
			System.out.println();
		}
		System.out.println();
		
		// 11단계
		// ____+____
		// ___+++___
		// __+++++__
		// _+++++++_
		// +++++++++
		System.out.println("-----11단계-----");
		num0 = 0;
		num1 = 0;
		num2 = 0;
		height = 5;
		for(num0 = 1; num0 <= height; num0++) {
			for(num2 = 1; num2 <= (height-num0); num2++) {
				System.out.print("_");
			}
			for(num1 = 1; num1 <= (2 * num0 - 1); num1++) {
				System.out.print("+");				
			}
			for(num2 = 1; num2 <= (height-num0); num2++) {
				System.out.print("_");
			}
			System.out.println();
		}
		System.out.println();
		
		// 12단계
		// 입력 받은 줄 수 대로 출력
		System.out.println("-----12단계-----");
		Scanner input = new Scanner(System.in);
		System.out.print("몇줄 만들래요?: ");
		height = input.nextInt();
		num0 = 0;
		num1 = 0;
		num2 = 0;
		for(num0 = 1; num0 <= height; num0++) {
			for(num2 = 1; num2 <= (height-num0); num2++) {
				System.out.print("_");
			}
			for(num1 = 1; num1 <= (2 * num0 - 1); num1++) {
				System.out.print("+");				
			}
			for(num2 = 1; num2 <= (height-num0); num2++) {
				System.out.print("_");
			}
			System.out.println();
		}
		System.out.println();
		
		// 13단계
		// 마름모 만들기
		
		/*// 잘못된 방식
		System.out.println("-----13단계-----");
		System.out.print("몇줄 만들래요?: ");
		height = input.nextInt();
		num0 = 0;
		num1 = 0;
		num2 = 0;
		for(num0 = 1; num0 <= height - (1 - height % 2); num0++) {
			if(num0 <= (height / 2) + (height % 2)) {
				for(num2 = 1; num2 <= ((height / 2) + (height % 2) - num0); num2++) {
					System.out.print("_");
				}
				for(num1 = 1; num1 <= (2 * num0 - 1); num1++) {
					System.out.print("+");				
				}
				for(num2 = 1; num2 <= ((height / 2) + (height % 2) - num0); num2++) {
					System.out.print("_");
				}
			} else {
				for(num2 = 1; num2 <= num0 - height / 2 - height % 2; num2++) {
					System.out.print("_");
				}
				for(num1 = 2 * (height - num0) + 1; num1 >= 1; num1--) {
					System.out.print("+");				
				}
				for(num2 = 1; num2 <= num0 - height / 2 - height % 2; num2++) {
					System.out.print("_");
				}
			}
			System.out.println();
		}
		System.out.println();
		*/
		
		/*
		System.out.println("-----13단계-----");
		input = new Scanner(System.in);
		System.out.print("몇줄 만들래요?: ");
		height = input.nextInt();
		num0 = 0;
		num1 = 0;
		num2 = 0;
		for(num0 = 1; num0 <= height; num0++) {
			for(num2 = 1; num2 <= (height-num0); num2++) {
				System.out.print("_");
			}
			for(num1 = 1; num1 <= (2 * num0 - 1); num1++) {
				System.out.print("+");				
			}
			for(num2 = 1; num2 <= (height-num0); num2++) {
				System.out.print("_");
			}
			System.out.println();
		}
		for(num0 = (height - 1); num0 >= 1; num0--) {
			for(num2 = 1; num2 <= (height-num0); num2++) {
				System.out.print("_");
			}
			for(num1 = 1; num1 <= (2 * num0 - 1); num1++) {
				System.out.print("+");				
			}
			for(num2 = 1; num2 <= (height-num0); num2++) {
				System.out.print("_");
			}
			System.out.println();
		}
		System.out.println();
		*/
		
	}

}
