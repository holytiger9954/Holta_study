package sec03._abstract;

public class Dog extends Animal {

	Dog() {
		super(1000);
	}
	
	@Override
	void sound() {
		System.out.println("멍멍");
	}

}
