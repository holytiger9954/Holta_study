package sec04._return03;

public class Car {
	
	int gas;
	
	void setGas(int g) {
		gas = g;
	}
	
	boolean isLeftGas() {
		// else가 있다는 것은 무조건 하나는 실행한다는 의미
		if(gas == 0) {
			System.out.println("gas가 없습니다");
			return false;
		} else {
			System.out.println("gas 있습니다");
			return true;
		}
	}
	
	boolean isLeftGas2() {
		// return 하는 순간에 method 종료
		if(gas == 0) {
			System.out.println("gas가 없습니다");
			return false;
		} 
		System.out.println("gas 있습니다");
		return true;
		// 에러: 도달할 수 없는 코드
//		System.out.println();
	}
	
	// return을 한번만 하는 방식
	boolean isLeftGas3() {
		boolean result = false;
		if(gas == 0) {
			System.out.println("gas가 없습니다");
			result = false;
		} else {
			System.out.println("gas 있습니다");
			result = true;
		}
		return result;
	}
	
	boolean isLeftGas4() {
		return (gas != 0);
	}
	
	void run() {
		while(true) {
//			if(gas != 0) {
//			if(true) {
			if(gas > 0) {
				System.out.println("고고~ 잔량: " + gas);
				gas--;
			} else {
				System.out.println("멈춰! 잔량: " + gas);
				return;
				
				// void의 경우 return을 생략할 수 있다
				// 위 코드와 같이 사용할 수 있다.
			}
		}
	}
	
}
