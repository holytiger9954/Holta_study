package chap05;

public class ArrayExam_02 {

	public static void main(String[] args) {

		/*
		 *  배열 array
		 *  
		 *  한 번에 여러 변수를 만드는 방법
		 *  같은 타입만 선언 가능
		 *  생성할 때 전체 크기를 지정해줘야 함
		 *  생성된 여러 변수들은 index로 관리
		 *  	index는 0번부터 시작
		 */
		
		// 선언 방법
		int[] a1; // java 스타일
		int [] a2;
		int a3[]; // c 스타일
		
		// 배열 변수는 참조 타입이므로 null을 넣을 수 있다
		a1 = null;
		
		int score_0 = 90;
		int score_1 = 85;
		int score_2 = 70;
		
		/*
		 *  첫번째 [] : int[]
		 *  	int 만으로 구성된 배열 변수 타입
		 *  두번째 [] : new int[30]
		 *  	배열의 크기. 즉, 한 번에 만들 변수의 개수
		 *  세번째 [] : score[0]
		 *  	만들어진 변수 중에서 몇번째 변수인지
		 *  	index는 0부터 시작한다
		 */
		
		// 배열을 선언하는 첫번째 방법
		int[] score = new int[30];
		score[0] = 90;
		score[1] = 85;
		score[2] = 70;
//		score[3] = null;
		
		System.out.println("score[0] : " + score[0]);
		
		// ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30
		// 길이가 30이어서 0~29까지만 가능
//		score[30] = 2;
		
		String[] str = new String[3];
		System.out.println("str[0] : " + str[0]);
		System.out.println("score[5] : " + score[5]);
		
		// 배열 생성 후 기본값
		// 0, false, null로 초기화 됨
		
		// 배열을 선언하는 두번째 방법
		// 넣을 값을 모두 알고 있는 경우
		int[] i1 = new int[] {90, 85, 70};
		System.out.println("i1[0] : " + i1[0]);
		
		// 선언과 초기화를 따로 할 수 있다
		int[] i2 = null;
		i2 = new int[] {90, 85, 70};
		
		// 배열을 선언하는 세번째 방법
		// 선언과 동시에 초기화 하는 경우만 사용 가능
		// new int[]를 생략
		int[] i3 = {90, 85, 70};
//		i3 = {90, 85, 70}; // 이건 안됨
		
		int sum = 0;
//		sum += i3[0];
//		sum += i3[1];
		for(int i = 0; i < 3; i++) {
			sum += i3[i];
		}
		System.out.println("총 합 : " + sum);
		System.out.println("평균 : " + (sum/3.0));
		
		sum = 0;
		System.out.println("배열의 길이 : " + i3.length);
		for(int i = 0; i < i3.length; i++) {
			sum += i3[i];
		}
		System.out.println("---------------------------");
		
		// 5개 변수를 한번에 만들기
		// 5개 크기의 int 배열
		int[] a5 = new int[50];
		// 첫번째 변수에 1 넣기
		a5[0] = 1;
		// 두번째 변수에 2 넣기
		a5[1] = 2;
		
		// 문제1
		// 첫번째 반복문에서
		//		10개의 변수에 각 1~10 값 담기
		System.out.println("-----문제1-----");
		int[] i4 = new int[10];
		for(int i = 0; i < i4.length; i++) {
			i4[i] = i + 1;
		}
		// 두번째 반복문에서
		//		모든 값을 순서대로 출력
		for(int i = 0; i < i4.length; i++) {
			i4[i] = i + 1;
			System.out.println("i4[" + i + "]의 값 : " + i4[i]);
		}
		
//		i4.length = 10; // 변경 불가 (읽기 전용)
		
		System.out.println("args : " + args);
		System.out.println("args의 크기 : " + args.length);
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);				
		}
		
		// 문제2
		// 7, 12, 8을 순서대로 저장한 배열이 있을 때
		// 다른 배열에도 7, 12, 8로 저장되게 복사
		// 단 b = a 안됨
		System.out.println("-----문제2-----");
		int[] a = new int[] {7, 12, 8};
		int[] b = new int[a.length];
		for(int i = 0; i < a.length; i++) {
			b[i] = a[i];			
			System.out.print("a[" + i + "]의 값: " + a[i] + "\t");
			System.out.println("b[" + i + "]의 값: " + b[i]);
		}
		
		// 문제3
		// 7, 12, 8을 순서대로 저장한 배열이 있을 때
		// 다른 배열에 8, 12, 7로(거꾸로) 저장되게
		System.out.println("-----문제3-----");
		for(int i = 0; i < a.length; i++) {
			b[i] = a[(a.length -1) - i];			
			System.out.print("a[" + i + "]의 값: " + a[i] + "\t");
			System.out.println("b[" + i + "]의 값: " + b[i]);
		}
		// 문제4
		// {3, 4, 7, 5, 1, 4, 6}
		// 4-1. 배열에서 홀수의 개수 구하기
		// 4-2. 4보다 큰 수의 개수 구하기
		System.out.println("-----문제4-1-----");
		int[] c =  {3, 4, 7, 5, 1, 4, 6};
		int count = 0;
		for(int i = 0; i < c.length; i++) {
			if(c[i] % 2 == 1) {
				count++;
			}
		}
		System.out.println("홀수의 개수: " + count);
		
		System.out.println("-----문제4-2-----");
		count = 0;
		int num = 4;
		for(int i = 0; i < c.length; i++) {
			if(c[i] > num) {
				count++;
			}
		}
		System.out.println(num + "보다 큰 수의 개수: " + count);
		
		// --- 응용(어려움) ---
		// 문제5
		/*
		 * 마라톤에서 5명의 선수가 참여했다
		 * 선수들은 1 ~ 5번의 등번호 부여
		 * 대회가 끝났을 때 완주하지 못한 선수를 찾으시오
		 * 완주목록 {2, 4, 5, 1}
		 */
		
		//방법1
		System.out.println("-----문제5-----");
		int[] runner = {1, 2, 3, 4, 5};
		int[] d = {2, 4, 5, 1};
		boolean finish = false;
		for(int i = 0; i < runner.length; i++) {	
			finish = false;
			
			for(int j = 0; j < d.length; j++) {
				if(runner[i] == d[j]) {
					finish = true;
					break;
				}
			}
			
			if(finish == false) {
				System.out.println("완주 실패: " + runner[i] + "번 선수");
			}
		}
		
		// 방법2
		System.out.println("-----문제5-----");
		int rsum = runner[0];
		int dsum = d[0];
		for(int i = 1; i < runner.length; i++) {
			rsum += runner[i]; 
		}
		for(int i = 1; i < d.length; i++) {
			dsum += d[i];
		}
		System.out.println("완주 실패: " + (rsum - dsum) + "번 선수");
		
		/* //틀린 방법
		System.out.println("-----문제5-----");
		int[] d = {2, 4, 5, 1, 3};
		for(int i = 0; i < d.length; i++) {
			if(i == (d.length -1)) {
				System.out.println("완주 실패: " + d[i] + "번 선수");
			}
		}
		*/
		
		/* //틀린 방법
		System.out.println("-----문제5-----");
		int[] d = new int[5];
		for(int i = 0; i < d.length; i++) {
			d[i] = i + 1;
		}
		for(int j = 0; j < d.length; j++) {
			if(d[j] == 3) {
				System.out.println("완주 실패: " + (j + 1) + "번 선수");
			}
		}
		*/
		
		// 문제6
		/*
		 * {3, 4, 7, 5, 1, 4, 6}
		 * 여기서 가장 큰 수 찾기
		 */
		System.out.println("-----문제6-----");
		int[] e = {3, 4, 7, 5, 1, 4, 6};
		int bn = e[0];
		int i = 0;
		
		for(i = 0; i < e.length; i++) {
			if(bn < e[i]) {
				bn = e[i];
			}
		}
		System.out.println("가장 큰 수: " + bn);
		
		// while문
		System.out.println("-----문제6-----");
		while(i < e.length) {
			if(bn < e[i]) {
				bn = e[i];
			}
			i++;
		}
		System.out.println("가장 큰 수: " + bn);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
