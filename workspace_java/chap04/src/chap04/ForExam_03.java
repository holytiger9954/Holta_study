package chap04;

import java.util.Scanner;

public class ForExam_03 {

	public static void main(String[] args) {
		
		// for문의 기본 형식
//		for( ; ; ) {
//			
//		}
		
		int sum = 0;
//		for(int i = 1; i <= 100; i++) {
//		for(int i = 1; i <= 100; i = i + 1) {
//		for(int i = 1; i <= 100; i = i + 2) {
//		for(i=1; i<=100; i++) {
		int i = 0;
		i = 1;
		for(; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
		System.out.println(i);
		
		// 깜짝 퀴즈 
		// 1~10까지 출력
		for(int j = 1; j <= 10; j++) {
			System.out.println(j);
		}
		
		// 1+1+1+...+1
		// 1씩 더하는 것을 5번 하기
		int sum1 = 0;
		sum1 = sum1 + 1;
		sum1 = sum1 + 1;
		sum1 = sum1 + 1;
		sum1 = sum1 + 1;
		sum1 = sum1 + 1;
		System.out.println(sum1);
		
		// 시작 값
		// 종료 조건
		int sum2 = 0;
		for(int j = 1; j <= 5; j++) {
			sum2 = sum2 + 1;
		}
		System.out.println(sum2);
		
		// 1~5의 합
		sum = 0;
		sum = sum + 1;
		sum = sum + 2;
		sum = sum + 3;
		sum = sum + 4;
		sum = sum + 5;
		
		sum = 0;
		int k = 1;
		sum = sum + k; // k == 1
		k++;
		sum = sum + k; // k == 2
		k++;		
		sum = sum + k; // k == 3
		k++;
		sum = sum + k; // k == 4
		k++;
		sum = sum + k; // k == 5
		
		for(k = 1; k <= 5; k++) {
			sum = sum + k;
		}
		System.out.println(sum);
		
		/*
		 *  ** 반복문 만드는 원리 **
		 *  
		 *  1. 반복 되는 것 찾기
		 *  	ctrl + c, v 했을 때 바뀌지 않는 것 찾기
		 *  
		 *  2. 반복 되지 않는 것의
		 *  2-1. 규칙 찾기
		 *  2-2. 변수로 바꿔서 더이상 바뀌지 않게 하기
		 *  
		 *  3. 시작 값 파악
		 *  
		 *  4. 종료 조건 파악
		 */
		
		// 퀴즈
		// 구구단 2단 출력
		// 2 x 1 = 2
		sum = 0;
		int gogodan = 2;
		for(k = 1; k <= 9; k++) {
			sum = gogodan * k;
			System.out.println(gogodan + " X " + k + " = " + sum);
		}
		
		// 구구단
		sum = 0;
		int j = 0;
		k = 0;
		for(j = 1; j <= 9; j++) {
			System.out.println("----" + j + "단----");
			for(k = 1; k <= 9; k++) {
				sum = j * k;
				System.out.println(j + " X " + k + " = " + sum);
			}
		}
		System.out.println("----------");
		
		// 10부터 1까지 출력
		for(j = 10; j >= 1; j--) {
			System.out.println(j);
		}
		System.out.println("----------");
		// 10부터 2까지 짝수만 출력
		for(j = 10; j >= 2; j -= 2) {
			System.out.println(j);			
		}
		System.out.println("$$$$$$$$$$$$");
		
		 // --- 꼭 풀 수 있어야 함 ---
        // 문제1
        // 1~5까지 출력하되 홀수인지 짝수인지 같이 출력
        // 예) 1:홀수
        //     2:짝수
		
		/*
		for(j = 1; j <= 5; j++) {
			if(j % 2 == 1) {
				System.out.println(j + ": 홀수");
			} else {
				System.out.println(j + ": 짝수");				
			}
		}
		System.out.println("----------");
		*/
        
        // 문제2
        // 1~100까지 홀수의 합과 개수
		
		/*
		sum = 0;
		int count = 0;
		for(j = 1; j <= 100; j++) {
			if(j % 2 == 1) {
				sum = sum + j;
				count++;
			}
		}
		System.out.println("홀수의 합: " + sum);
		System.out.println("홀수의 개수: " + count);
		System.out.println("----------");
        */
		
        // 문제3
        // 1 ~ 입력 받은 수 까지 더하기
		
		/*
		sum = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("수를 입력하세요: ");
		int scan = scanner.nextInt();
		for(j = 1; j <= scan; j++) {
			sum += j;
		}
		System.out.println("합은 " + sum);
		System.out.println("----------");
        */
        
        // --- 조금 난이도 있는 ---
        // 문제4
        // 1~10까지 3개씩 옆으로 찍
        //    1  2  3
        //    4  5  6 
        //    7  8  9
        //    10
		
		/*
		j = 0;
		for(j = 1; j <= 10; j++) {
			if(j % 3 == 0) {
				System.out.println(" " + j);
			} else {
				System.out.print(" " + j);	
			}
		}
		System.out.println();
		System.out.println("----------");
        */
		
        // --- 2중 for문 ---
        // 문제1
        // 구구단 모든 단 출력
		
		/* clear
		sum = 0;
		j = 0;
		k = 0;
		for(j = 2; j <= 9; j++) {
			System.out.println("----" + j + "단----");
			for(k = 1; k <= 9; k++) {
				sum = j * k;
				System.out.println(j + " X " + k + " = " + sum);
			}
		}
		System.out.println("----------");
		*/
		
		// 문제2
		// 구구단 출력 단마다 옆으로 출력
		// 2x1=2 2x2=4 ...
		
		/* clear
		sum = 0;
		j = 0;
		k = 0;
		for(j = 2; j <= 9; j++) {
			System.out.println("----" + j + "단----");
			for(k = 1; k <= 9; k++) {
				sum = j * k;
				System.out.print(j + " X " + k + " = " + sum + " ");
			}
			System.out.println();
		}
		System.out.println("-----------");
		*/
		
		// 문제3
		// 구구단 3단씩 옆으로 출력
		// 2x1=2 3x1=3 4x1=4
		// 2x2=4 3x2=6 4x2=8
		
		// 2x1=2 3x1=3 4x1=4 ... 9x1=9
		// 2단부터 3개단 단위
		// 2 3 4
		// 5 6 7
		// 8 9
		
		/* // clear
		i = 0;
		j = 0;
		for(i = 2; i <= 9; i += 3) {
			for(j = 1; j <= 9; j++) {
				System.out.print(i + " X " + j + " = " + (i * j) + "\t");
				if(i + 1 <= 9) {
					System.out.printf((i + 1)+ " X " + j + " = " + ((i + 1) * j) + "\t");					
				}
				if(i + 2 <= 9) {
					System.out.printf((i + 2)+ " X " + j + " = " + ((i + 2) * j) + "\t");										
				}
				System.out.println();
			}
			System.out.println();
		}
		*/
		
		/* // clear
		sum = 0;
		i = 0;
		j = 0;
		k = 0;
		for(i = 2; i <= 9; i += 3) {
			for(j = 1; j <= 9; j++) {
				for(k = i; k < i + 3 && k <= 9; k++) {
					sum = k * j;
					System.out.print(k + " X " + j + " = " + sum + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
		*/
		
		/* 틀린 방식
		int j_end = 9;
		int k_end = 9;
		sum = 0;
		j = 0;
		k = 0;
		for(j = 1; j <= j_end; j++) {
			for(k = 2; k <= k_end; k++) {
				sum = j * k;
				if((k % 3 == 1)) {
				System.out.println(k + " X " + j + " = " + sum + " ");
				} else if(k == k_end) {
					System.out.println(k + " X " + j + " = " + sum + " ");					
				} else {
					System.out.print(k + " X " + j + " = " + sum + " ");
				}
			}
		}
		 */
		
		// 문제4
		// 주사위 2개를 굴려서
		// 나올 수 있는 모든 조합
		// [1,1] [1,2] ... [6,6]
		
		/* // clear
		sum = 0;
		j = 0;
		k = 0;
		for(j = 1; j <= 6; j++) {
			for(k = 1; k <= 6; k++) {
				System.out.print("[" + j + "," + k + "]");
			}
		}
		System.out.println();
		*/
		
		// 문제5
		// 주사위 2개를 굴려서
		// 합 별로 출력
		// 합2: [1,1]
		// 합3: [1,2] [2,1]
		// 합4: [1,3] [2,2] [3,1]
		// 합5: [1,4] [2,3] [3,2] [4,1]
		// 합6: [1,5] [2,4] [3,3] [4,2] [5,1]
		// 합7:       [2,5] [3,4] [4,3] [5,2] [6,1]
		// 합8:       [2,6] [3,5] [4,4] [5,3] [6,2]
		// 합9:             [3,6] [4,5] [5,4] [6,3]
		// 합10:                  [4,6] [5,5] [6,4]
		// 합11:                        [5,6] [6,5]
		// 합12:                              [6,6]
		
		/* // clear
		sum = 0;
		i = 0;
		j = 0;
		for(sum = 2; sum <= 12; sum++) {
			System.out.print("합 " + sum + ":\t");
			for(i = 1; i <= 6; i++) {
				j = sum - i;
				if(j >= 1 && j <= 6) {
					System.out.print("[" + i + "," + j + "]\t");
				}
			}
			System.out.println();
		}
		*/
		
		/* 틀린 방식
		sum = 0;
		i = 0;
		j = 0;
		k = 0;
		for(i = 1; i <= 6; i++) {
			for(j = 1; j <= 6; j++) {
				sum = i + j;
				for(k = 1; (k <= (sum - i)) && k <= 6; k++) {
					System.out.print("["+ i + "," + k + "]");					
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
		*/
		
		// 문제6
		// 주사위 2개를 굴려서 나올 조합에서
		// 중복 없이 출력
		// 예: [1,2] [2,1] 중복 [1,2] 만 나오게
		
		/*
		sum = 0;
		i = 0;
		j = 0;
		k = 0;
		for(sum = 2; sum <= 12; sum++) {
			System.out.print("합:" + sum + "\t");
			for(i = 1; i <= 6; i++) {
				j = sum - i;
				if(j >= 1 && j <= 6) {
					if(i <= j) {
						System.out.print("[" + i + "," + j + "]\t");						
					}
				}
			}
			System.out.println();
		}
		*/
		
		// 번외
		// 피라미드
		
		/*
		int height = 5;
		i = 0;
		j = 0;
		k = 0;
		for(i = 1; i <= height; i++) {
			for(j = 1; j <= (height - i); j++) {
				System.out.print("-");
			}
			for(k = 1; k <= (2 * i - 1); k++) {
				System.out.print("*");
			}
			for(j = 1; j <= (height - i); j++) {
				System.out.print("-");
			}			
			System.out.println();
		}
		System.out.println("$$$$$$$$$$$$");
		
		
		// 다이아몬드 만들기
		height = 5;
		i = 0;
		j = 0;
		k = 0;
		for(i = 1; i <= height; i++) {
			for(j = 1; j <= (height - i); j++) {
				System.out.print("-");
			}
			for(k = 1; k <= (2 * i - 1); k++) {
				System.out.print("*");
			}
			for(j = 1; j <= (height - i); j++) {
				System.out.print("-");
			}			
			System.out.println();
		}
		for(i = (height - 1); i >= 1; i--) {
			for(j = 1; j <= (height - i); j++) {
				System.out.print("-");
			}
			for(k = 1; k <= (2 * i - 1); k++) {
				System.out.print("*");
			}
			for(j = 1; j <= (height - i); j++) {
				System.out.print("-");
			}			
			System.out.println();
		}
		*/
		
		// 상자 만들기
		// 첫번째 줄 마지막 줄은 공백없이 출력
		// 사이에 있는 줄은 양 끝 제외 공백 출력
		// 가로 세로 길이는 입력한 수만큼
		
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.print("상자 사이즈를 입력하세요: ");
		int size = scanner.nextInt();
		i = 0;
		j = 0;
		for(i = 1; i <= size; i++) {
			for(j = 1; j <= size; j++) {
				if(j == 1 || j == size) {
					System.out.print("*");		
				} else {
					if(i == 1 || i == size) {
						System.out.print("*");								
					} else {
						System.out.print(" ");												
					}
				}
			}
			System.out.println();
		}
		*/
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
