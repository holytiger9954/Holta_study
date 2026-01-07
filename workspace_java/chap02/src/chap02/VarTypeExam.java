package chap02;

public class VarTypeExam {

	public static void main(String[] args) {
		
		byte b1;
		b1 = 127;
		System.out.println("b1: " + b1);
//		b1 = 128;
		
		char c1 = 65;
		System.out.println("c1: " + c1);
		char c2 = 65 + 2;
		System.out.println("c2: " + c2);
		char c3 = 'B';
		System.out.println("c3 - c1: " + (c3 - c1));
		
		// L 또는 l을 붙이면 명시적인 long
//		long l1 = 2200000000;
		long l1 = 2200000000L;
		long l2 = 30;
		System.out.println(l1);
		System.out.println(l2);
		
		String s1 = "허성범";
		System.out.println("s1: " + s1);
		
		String s2 = "허\"성범";
		System.out.println("s2: " + s2);
		String s3 = "\\허\t성\n범";
		System.out.println("s3: " + s3);
		
		System.out.println("글씨" + 3);
		System.out.println("글씨" + 3 + 2); // 글씨32
		System.out.println("글씨" + (3 + 2)); // 글씨5
		System.out.println(3 + 2 + "글씨"); // 5글씨
		
//		int a = 3.14;
		
		float f1 = 3.14f;
		System.out.println("f1: " + f1);
		
		double d1 = 3.14;
		System.out.println("d1: " + d1);
		
		float f2 = 0.1234567890123f;
		System.out.println(f2);
		// float의 정밀도: 소수점 7번째 자리까지

		double d2 = 0.12345678901234567890;
		System.out.println("d2: " + d2);
		// double의 정밀도: 소수점 16번째 자리까지
		
		double d3 = 5e3;
		System.out.println("d3: " + d3);
		
		boolean stop = true;
		boolean start = false;
		
		System.out.println("stop: " + stop);
		
		// 문제1
		// 내 나이를 저장
		int age = 28;
		System.out.println("내 나이는 " + age +"살");
		
		// 문제2
		// 운전 면허가 있다/없다
		boolean license = true;
		System.out.println("내 운전면허: " + license);
		// *문제2 확장
		if (license = true)
		System.out.println("나 운전면허 있어");
		
		// 문제3
		// 우리 집에 있는 스마트폰의 개수
		int phone_num = 4;
		System.out.println("우리 집은 스마트폰 " + phone_num + "개 있다~");
		
		// 문제4
		// 내 이름
		String name = "허성범";
		System.out.println("내 이름은 " + name);
		
		// 문제5
		// 1평은 3.3 제곱미터
		// 5평이 몇 제곱미터인지
		double room = 3.3;
		System.out.println("5평은 " + (room * 5) + " 제곱미터");
		
		// 문제6
		// 6-1: 두 변수 x, y에 각 숫자를 넣고
		// 출력결과: "3 > 4 결과는 false 입니다."
		int x = 3;
		int y = 4;
		boolean result1 = x > y;
		System.out.println(x + " > "+ y + " 결과는 " + result1 + "입니다.");
		
		boolean result2 = y > x;
		// 6-2: x, y 값 바꿔서 정답 나오는지 출력
		System.out.println(y + " > "+ x + " 결과는 " + result2 + "입니다.");
		
		// 문제7
		/*
		 * 숫자 149
		 * ---------
		 * 출력결과
		 * ---------
		 * "백의 자리: 1"
		 * "십의 자리: 4"
		 * "일의 자리: 9"
		 */
		int num = 149;
		
		int num_100 = num / 100;
		int num_10 = num % 100 / 10;
		int num_1 = num % 10;
		System.out.println("백의 자리: " + num_100 +  "\n십의 자리: " + num_10 + "\n일의 자리: " + num_1);
		
		int n100 = num / 100;
		int n10 = (num - n100 * 100) / 10;
		int n1 = (num - n100 * 100 - n10 * 10) / 1;
		System.out.println("백의 자리: " + n100 +  "\n십의 자리: " + n10 + "\n일의 자리: " + n1);
		
		// 문제8
		// 회식비 43000원
		// 참석인원 4명
		// 인당 얼마?
		// 8-1: 디테일하게 원단위
		int cost = 43000;
		int member = 4;
		int cost1 = cost / member;
		System.out.println("정산: " + cost1 + "원");
		// 8-2: 백원단위까지만 받기
		int cost2 = cost / (member * 100) * 100;
		System.out.println("백원 단위 정산: " + cost2 + "원");
		// 8-2-1: 주최자는 얼마? (나머지는 만원단위만)
		int cost3 = cost / (member * 10000) * 10000;
		System.out.println("만원 단위 정산: " + cost3 + "원");
		int cost4 = cost - cost3 * (member - 1);
		System.out.println("주최자: " + cost4 + "원");
		
		// 문제9
		String left = "오예스";
		String right = "사탕";
		
		// 뭔가 하기
		String center = left;
		left = right;
		right = center;
				
		System.out.println("left: " + left); // 사탕
		System.out.println("right: " + right); // 오예스
	}

}



















