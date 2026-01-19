package sec03;

public class CarExam {

	public static void main(String[] args) {

//		new Car();
//		Car c2 = new Car("포르쉐");
		Car c3 = null;
		try {
			// 생성자가 실행되어야 실제 생성이 된다
			c3 = new Car();	// new Car()에서 오류 발생해서 c3에 저장 안됨
		}catch(Exception e) {
			System.out.println("new Car()에서 예외 발생");
		}
		System.out.println("c3: " + c3);
		
	}

}
