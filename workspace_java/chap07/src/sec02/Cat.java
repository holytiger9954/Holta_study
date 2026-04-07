package sec02;

public class Cat extends Animal {
	
	String color = "무지개";

	@Override
	void sound() {
		System.out.println("야옹");
	}
	
	void grooming() {
		System.out.println("고롱고롱");
	}
	
}
