package sec03._abstract;

public abstract class Animal {

	void breathe() {
		System.out.println("숨 쉬어");
	}
	
//	abstract void sound() {};
	
	// 추상 메소드
	// 실행 블럭이 있으면 안됨
	// 나는 구현하지 않고 자식에게 떠넘김
	abstract void sound();
	
	String kind;
	Animal(int maxAge) {
		System.out.println("Animal 생성자 실행");
	}
}
