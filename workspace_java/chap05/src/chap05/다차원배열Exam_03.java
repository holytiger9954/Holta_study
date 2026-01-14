package chap05;

public class 다차원배열Exam_03 {

	public static void main(String[] args) {

		int a0 = 5;
		int a1 = 15;
		int a2 = 34;
		
		// int 변수를 여러개 만들기
		int[] b0 = new int[3];
		// b의 첫번째 변수에 a0 넣기
		// b의 두번째 변수에 a1 넣기
		b0[0] = a0;
		b0[1] = a1;
		b0[2] = a2;
		
		int[] b1 = new int[3];
		b1[0] = a0 + 1;
		b1[1] = a1 + 1;
		b1[2] = a2 + 1;
		
		// b0와 b1을 배열로 만들기
//		int[][] c0 = new int[2][];
//		c0[1] = new int[3];
		
		int[][] c0 = new int[2][3];
		c0[0] = b0;
		c0[1] = b1;
		
		System.out.println(c0[0][1]);
		
		System.out.println("c0.length : " + c0.length);
		
		System.out.println("b1의 길이 : " + c0[1].length);
		
		int[][] c1 = new int[][] {{1, 2, 3}, new int[]{4, 5, 6}};
		int[][] c2 = {{1, 2, 3}, 
					   new int[]{4, 5, 6}
					 };
		
		int[][] arr = new int[2][];
		// 가장 바깥 차원은 꼭 크기가 있어야 한다
		// heap에 공간을 만들기 위한 최소 조건
		// 모두 null로 초기화
		// 참조 공간만 만들고 실제 배열은 나중에 만들게됨
		// 가변(비정형) 배열
		// 공간을 연속으로 잡지 않아서 고성능에서는 불리할 수 있다
		
		System.out.println(c0);
		System.out.println(c0[0]);
		System.out.println(c0[0][0]);
		
		/////////////////////////////////////
		System.out.println("-------------");
		
		// 깊은 복사
		// 원본, 사본의 값이 바뀌어도 서로에게 영향 받지 않는다
		int k1 = 10;
		int k2 = k1; // stack에 값이 들어감
		System.out.println("k2 : " + k2);
		k1 = 5;
		System.out.println("k2 : " + k2);
		
		// 얕은 복사 (call by reference)
		// 값을 변경하는 경우 원본, 사본 모두 바뀐다
		int[] d1 = {1, 2, 3};
		int[] d2 = d1; // stack에 주소값만 들어감 (참조 타입)
		
		System.out.println("d2[0] : " + d2[0]);
		d1[0] = 4;
		System.out.println("d2[0] : " + d2[0]);
		
		System.out.println("d1[2] : " + d1[2]);
		d2[2] = 40;
		System.out.println("d1[2] : " + d1[2]);
		
		// 깊은 복사 (call by value)
		int[] d3 = new int[d1.length];
		for(int i = 0; i < d1.length; i++) {
			d3[i] = d1[i];
		}
		
		// 깜짝퀴즈
		// 꼭 반복문 쓰기
		
		// 문제1-1
		// 1~5. 11~15, 101~105를 저장하는 2차원 배열을 만드시오
		// 그리고 다른 반복으로 모두 출력하시오
		
		System.out.println("----------문제1-1----------");
		int[][] arr1_1 = new int[3][5];
		int num1 = 1;
		int num2 = 11;
		int num3 = 101;
//		System.out.println(arr1_1[0].length);
		for(int i = 0; i < arr1_1.length; i++) {
			for(int j = 0; j < arr1_1[0].length; j++) {
				if(i == 0) {
					arr1_1[i][j] = num1;
					num1++;
				} else if(i == 1) {
					arr1_1[i][j] = num2;
					num2++;					
				} else if(i == 2) {
					arr1_1[i][j] = num3;
					num3++;										
				}
			}
		}
		for(int i = 0; i < arr1_1.length; i++) {
			for(int j = 0; j < arr1_1[0].length; j++) {
				if(i == 0) {
					System.out.println("arr1[" + i + "]" + "[" + j + "] : " + arr1_1[i][j]);
				} else if(i == 1) {
					System.out.println("arr1[" + i + "]" + "[" + j + "] : " + arr1_1[i][j]);
				} else if(i == 2) {
					System.out.println("arr1[" + i + "]" + "[" + j + "] : " + arr1_1[i][j]);
				}
			}
		}
		
		// 강사님 풀이
		// 1. 1~5
		int[] q1_1 = new int[5];
		for(int i = 0; i < q1_1.length; i++) {
			q1_1[i] = i + 1;
		}
		// 1. 11~15
		int[] q1_2 = new int[5];
		for(int i = 0; i < q1_2.length; i++) {
			q1_2[i] = i + 11;
		}
		// 1. 101~105
		int[] q1_3 = new int[5];
		for(int i = 0; i < q1_3.length; i++) {
			q1_3[i] = i + 101;
		}
		
		int[][] q1 = new int[3][5];
		q1[0] = q1_1;
		q1[1] = q1_2;
		q1[2] = q1_3;
		
		// q1을 모두 출력
		System.out.println("----------강사님 풀이----------");
		for(int i = 0; i < q1.length; i++) {
			for(int j = 0; j < q1[0].length; j++) {
				System.out.println("q1[" + i + "]" + "[" + j + "] : " + q1[i][j]);
			}
		}
		
		// 문제1-2
		// 3차원 배열에 순차적으로 값이 들어가게 하기
		System.out.println("----------문제1-2----------");
		int num0 = 1;
		int[][][] arr1_2 = new int[3][3][3];
		for(int i = 0; i < arr1_2.length; i++) {
			for(int j = 0; j < arr1_2[0].length; j++) {
				for(int k = 0; k < arr1_2[0][0].length; k++) {
					arr1_2[i][j][k] = num0;
					System.out.println("arr1[" + i + "]" + "[" + j + "]" + "[" + k + "] : " + arr1_2[i][j][k]);
					num0++;
				}
			}
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
