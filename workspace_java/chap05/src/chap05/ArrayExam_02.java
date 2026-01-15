package chap05;

import java.util.Scanner;

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
		
		// 문제7
		// {3, 4, 7, 5, 1, 4, 6}
		// 두번째로 큰 수 찾기
		// --- 사고의 흐름---
		// 일단 가장 큰 수 찾기
		// 가장 큰 수가 나오면 배열에서 지우기(대충 가장 작은 수)
		// 다시 가장 큰수 찾기
		System.out.println("-----문제7-----");
		int[] f = {3, 4, 7, 5, 1, 4, 6};
		int fb = f[0];
		
		for(i = 0; i < f.length; i++) { // 가장 큰 수 뽑기
			if(fb < f[i]) {
				fb = f[i];
			}
		}
		System.out.println("가장 큰 수: " + fb);
		for(i = 0; i < f.length; i++) { // 가장 큰 수 
			if(fb == f[i]) {			// 가장 큰 수를
				f[i] = -2100000000;		// 가장 작은 수로 만들기(음수 대응)
			}
		}
		fb = f[0];
		for(i = 0; i < f.length; i++) { // 두 번째 큰 수 뽑기
			if(fb < f[i]) {
				fb = f[i];
			}
		}
		System.out.println("두 번째 큰 수: " + fb);
		
		// 문제8
		// 오른쪽으로 한 칸씩 밀기 (왼쪽은 0으로 채우기)
		// 예:
		// 1라운드 : {3, 4, 7, 5, 1, 4, 6}
		// 2라운드 : {0, 3, 4, 7, 5, 1, 4}
		// 3라운드 : {0, 0, 3, 4, 7, 5, 1}
		// --- 사고의 흐름---
		// 0이 아닌 값부터 한 칸씩 밀기
		// 0이 아닌 첫 값을 0으로 바꾸기
		// 배열의 끝부터 한 칸씩 민다
		// 맨 앞자리 부터 0으로 바꾸기
		System.out.println("-----문제8-----");
		int[] g = {3, 4, 7, 5, 1, 4, 6};
		int j = 0;
		
		for(i = 1; i < g.length; i++) {
			for(j = g.length - 1; j > 0; j--) {
				g[j] = g[j - 1];
			}
			g[i-1] = 0;
			System.out.println(i + "라운드 : " 
					+ "{" 
					+ g[0] + ", "
					+ g[1] + ", "
					+ g[2] + ", "
					+ g[3] + ", "
					+ g[4] + ", "
					+ g[5] + ", "
					+ g[6] 
							+ "}");
		}
		
		/* 틀린 방식
		int empty = 0;

		for(i = 1; i < g.length; i++) {
			for(j = i - 1; j < g.length - 1; j++) {
				if(j == 0) {
					temp = g[j + 1]; // temp = g[1]
					g[j + 1] = g[j]; // g[1] = g[0]
					g[j] = 0;		 // g[0] = 0	
				} else {
					empty = temp;	 // empty = g[1] 4
					temp = g[j + 1]; // temp = g[2] 7
					g[j + 1] = g[j]; // g[2] = g[1] 
					g[j] = 0;		 // g[1] = 0
					
					
				}
			}
			System.out.println(i + "라운드 : " 
					+ "{" 
					+ g[0] + ", "
					+ g[1] + ", "
					+ g[2] + ", "
					+ g[3] + ", "
					+ g[4] + ", "
					+ g[5] + ", "
					+ g[6] 
							+ "}");
		}
		*/
		
		
		// 문제9
		// 오른쪽으로 한 칸씩 밀기
		// 멘 끝값은 맨 처음으로 보내기
		// 예:
		// 1라운드 : {3, 4, 7, 5, 1, 4, 6}
		// 2라운드 : {6, 3, 4, 7, 5, 1, 4}
		// 3라운드 : {4, 6, 3, 4, 7, 5, 1}
		System.out.println("-----문제9-----");
		int[] h = {3, 4, 7, 5, 1, 4, 6};
		int temp = 0;
		
		for(i = 1; i < h.length; i++) {
			temp = h[h.length - 1];
			for(j = h.length - 1; j > 0; j--) {
				h[j] = h[j - 1];
			}
			h[0] = temp;
			System.out.println(i + "라운드 : " 
					+ "{" 
					+ h[0] + ", "
					+ h[1] + ", "
					+ h[2] + ", "
					+ h[3] + ", "
					+ h[4] + ", "
					+ h[5] + ", "
					+ h[6] 
							+ "}");
		}
		
		// 문제10
		// 임시비밀번호 8자리
		// 10-1 : 숫자만
		System.out.println("-----문제10-1-----");
		int[] pwdNum = new int[8];
		System.out.print("임시 비밀번호(숫자): [");
		for(i = 0; i < pwdNum.length; i++) {
			double rand = Math.random();
			double temp0 = rand * 10; // 0 ~ 9.999999999
			int result = (int)temp0;
			pwdNum[i] = result;
		}
		for(j = 0; j <= 7; j++) {
			System.out.print(pwdNum[j]);			
		}
		System.out.println("]");
		// 10-2 : 소문자만
		//		hint 1 : char + 아스키코드 (97~122)
		//		hint 2 : {"a", "b", "c",...}
		System.out.println("-----문제10-2-----");
		char[] pwdUni = new char[8];
		System.out.print("임시 비밀번호(알파벳 소문자): [");
		for(i = 0; i < pwdUni.length; i++) {
			double rand = Math.random();
			double temp0 = rand * 26; // 0 ~ 25.999999999
			char result = (char)(temp0 + 97); // 97~122
			pwdUni[i] = result;
		}
		for(j = 0; j <= 7; j++) {
			System.out.print(pwdUni[j]);			
		}
		System.out.println("]");
		// 10-3 : 숫자 2개 이상, 대/소문자 각 1개 이상
		System.out.println("-----문제10-3-----");
		char[] pwdMix = new char[8];
		System.out.print("임시 비밀번호(숫자 + 알파벳 대/소문자 조합): [");
		while(true) {
			int countA = 0, countB = 0, countC = 0;
			for(i = 0; i < pwdMix.length; i++) {
				int type = (int)(Math.random() * 3);
				if(type == 0) { // 숫자
					pwdMix[i] = (char)((int)(Math.random() * 10) + 48); // 0~9
					countA++;
				} else if(type == 1) { // 대문자
					pwdMix[i] = (char)((int)(Math.random() * 25) + 65); // 65~90
					countB++;
				} else { // 소문자
					pwdMix[i] = (char)((int)(Math.random() * 25) + 97); // 97~122
					countC++;
				}
			}
			if(countA >=2 && countB >= 1 && countC >= 1) {
				break;
			}
		}
		// 출력
		for(j = 0; j <= 7; j++) {
			System.out.print(pwdMix[j]);			
		}
		System.out.println("]");
		
		// 문제11
		// 자리가 10개 있는 소극장 예약 시스템
		// 자리 번호는 1-10번 번호의 자리가 있다
		// 메뉴 : "1.예약 2.모든 좌석 현황 3.잔여 좌석 0.종료"
		// 조건1 : 예약이 가능하다면 "n번 자리 예약되었습니다"
		// 조건2 : 예약이 되어있다면 "이미 예약 되어 있습니다"
		System.out.println("-----문제11-----");
		int[] seat = new int[10];
		Scanner scanner = new Scanner(System.in);
		
		for(i = 0; i < seat.length; i++) {
			seat[i] = (int)(Math.random() * 2);
		}
		int select = -1;
		do {
			System.out.println("메뉴 : 1.예약 2.모든 좌석 현황 3.잔여 좌석 0.종료");
			System.out.print("메뉴 선택 > ");
			select = scanner.nextInt();
			
			if(select == 1) {
				System.out.print("좌석을 선택하세요(1~10) : ");
				int resv = scanner.nextInt();
				
				if (resv < 1 || resv > 10) {
					System.out.println("정확한 좌석 번호를 입력해주세요");
				} else {
					if (seat[resv - 1] == 0) {
						seat[resv - 1] = 1;
						System.out.println(resv + "번 자리 예약되었습니다");
					} else {
						System.out.println("이미 예약 되어 있습니다");
					}
				}
			} else if(select == 2) {
				for(i = 0; i < seat.length; i++) {
					if(seat[i] == 1) {
						System.out.print((i + 1) + "번: 예약됨 | ");
					} else {
						System.out.print((i + 1) + "번: 비어있음 | ");
					}
				}
				System.out.println();
			} else if(select == 3) {
				count = 0;
				for(i = 0; i < seat.length; i++) {
					if(seat[i] == 0) {
						count++;
					}
				}
				System.out.println("잔여 좌석: " + count);
			} else if(select == 0) {
				System.out.println("종료합니다");
			} else {
				System.out.println("다시 입력하세요");
			}
		} while(select != 0);
		
		
		
		
		// 문제12
		// 로또 번호 6개 배열에 저장
		// 단, 중복 없이!
		System.out.println("-----문제12-----");
		int[] rotto = new int[6];
		
		for(i = 0; i < rotto.length; i++) { //rotto[0]~[5] 까지
			// 1~45 중에서 랜덤 넣기
			rotto[i] = (int)(Math.random()*45) + 1; 
			
			// 중복 없애기
			for(j = 0; j < i; j++) { // 0~(i-1)
				if(rotto[i] == rotto[j]) { // rotto[i] 일때 rotto[0]~ 비교
					i--; // 다시 뽑기
					break; // i로 돌아가기
				}
			}
		}
		// 정렬해보기
		temp = 0;
		for(i = 0; i < rotto.length - 1; i++) { // i + 1 < rotto.length
			// 가장 작은 수부터 for문 사이클마다 점점 앞쪽으로 정렬됨
			// 버블정렬이었나?
			for(j = 0; j < rotto.length - 1 - i; j++) { 
				if(rotto[j] > rotto[j + 1]) { // 
					temp = rotto[j];	  	  // 앞의 수가
					rotto[j] = rotto[j + 1];  // 바로 뒤의 수보다 크면
					rotto[j + 1] = temp;	  // 서로 위치 바꾸기
				}
			}
			
		}
		// 출력
		int k = 0;
		System.out.print("로또 번호: [");
		for(k = 0; k < rotto.length; k++) {
			if(k < rotto.length - 1) {
				System.out.print(rotto[k] + ", ");				
			} else {
				System.out.print(rotto[k]);								
			}
		}
		System.out.println("]");
		
		// 일단 해본거
//		int[] rotto = new int[6];
//		int result = 0;
//		boolean comp = false;
//		while(true) {
//			double rand = Math.random();
//			double temp0 = rand * 45; // 0~44.999999999
//			result = (int)(temp0 + 1); // 1~45
//			rotto[0] = result;
//			for(i = 1; i < rotto.length; i++) {
//				rand = Math.random();
//				temp0 = rand * 45; // 0~44.999999999
//				result = (int)(temp0 + 1); // 1~45
//				rotto[i] = result;
//				if(rotto[i - 1] != rotto[i]) {
//					comp = true;
//				}
//			}
//			if(comp == true) {
//				break;
//			}
//		}
//		// 출력
//		int k = 0;
//		System.out.print("로또 번호: [");
//		for(k = 0; k < rotto.length; k++) {
//			if(k < rotto.length - 1) {
//				System.out.print(rotto[k] + ", ");				
//			} else {
//				System.out.print(rotto[k]);								
//			}
//		}
//		System.out.println("]");
		
		// 중복 있음
//		int[] rotto = new int[6];
//		int k = 0;
//		int result = 0;
//		for(i = 0; i < rotto.length; i++) {
//			double rand = Math.random();
//			double temp0 = rand * 45; // 0~44.999999999
//			result = (int)(temp0 + 1); // 1~45
//			rotto[i] = result;
//		}
//		// 출력
//		System.out.print("로또 번호: [");
//		for(k = 0; k < rotto.length; k++) {
//			if(k < rotto.length - 1) {
//				System.out.print(rotto[k] + ", ");				
//			} else {
//				System.out.print(rotto[k]);								
//			}
//		}
//		System.out.println("]");
		
		// 문제13
        // 주차장에 
        // 0: 주차되어있음
        // 1: 비어있음
        /*
         * {
         *         {0, 0, 0, 0},    // 1층
         *         {0, 0, 0, 1},    // 2층
         *         {1, 0, 1, 0},	// 3층
         *         {1, 0, 1, 1},	// 4층
         *         {1, 1, 1, 1},	// 5층
         * }
         */
		int[] f1 = {0, 0, 0, 0};
		int[] f2 = {0, 0, 0, 1};
		int[] f3 = {1, 0, 1, 0};
		int[] f4 = {1, 0, 1, 1};
		int[] f5 = {1, 1, 1, 1};
		int[][] park = {f1, f2, f3, f4, f5};
		count = 0;
        // 13-1 : 2층에 주차된 차량 수 출력
		System.out.println("-----문제13-1-----");
		for(i = 0; i < f2.length; i++) {
			if(f2[i] == 0) {
				count++;
			}
		}
		System.out.println("2층: " + count + "대 주차됨");
        // 13-2 : 전체 남은 자리 수 출력
		System.out.println("-----문제13-2-----");
		count = 0;
		for(i = 0; i < park.length; i++) {
			for(j = 0; j < park[0].length; j++) {
				if(park[i][j] == 1) {
					count++;
				}
			}
		}
		System.out.println("주차 가능: " + count + "대");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
