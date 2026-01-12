package chap04;

public class SwitchExam_02 {

	public static void main(String[] args) {

		int num = 1;
		if(num == 1) {
			System.out.println("1 입니다.");
		} else if(num == 2) {
			System.out.println("2 입니다.");			
		} else {
			System.out.println("1 또는 2가 아닙니다.");						
		}
		
		// switch로 변환
		
		// switch 문에서 
		// 사용가능: byte, char, short, int, String
		// 사용 불가능: boolean, long, float, double
		switch(num) {
			case 1 :
				System.out.println("1 입니다.");
				break;
			case 2 :
				System.out.println("2 입니다.");
				break;
			default :
				System.out.println("1 또는 2가 아닙니다.");
				break;
		}
		
		int month = 1;
		switch(month) {
			case 1 : 
//				System.out.println("겨울");
//				break;
			case 2 : 
//				System.out.println("겨울");
//				break;
			case 12 : 
				System.out.println("겨울");
				break;
			case 3 : 
//				System.out.println("봄");
//				break;
			case 4 : 
//				System.out.println("봄");
//				break;
			case 5 : 
				System.out.println("봄");
				break;
			case 6 : 
//				System.out.println("여름");
//				break;
			case 7 : 
//				System.out.println("여름");
//				break;
			case 8 : 
				System.out.println("여름");
				break;
			case 9 : 
//				System.out.println("가을");
//				break;
			case 10 : 
//				System.out.println("가을");
//				break;
			case 11 : 
				System.out.println("가을");
				break;
			default :
				System.out.println("1년은 몇월까지 있나요?");
				break;
		}
	}

}
