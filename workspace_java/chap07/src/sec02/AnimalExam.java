package sec02;

public class AnimalExam {

	public static void main(String[] args) {
		
		Cat cat = new Cat();
		String result = cat.eat("츄르");
		System.out.println(result);
		cat.sound();
		
		System.out.println("--------------");
		
		Cat cat2 = new Cat();
		Animal a1 = (Animal)cat2;
		Animal a2 = cat2;
		
		System.out.println(a2 == cat2);
		
		// 같은 이름의 필드가 있는 경우
		// 가려짐에 따라 출력된다
		System.out.println("cat2.color: " + cat2.color);
		System.out.println("a2.color: " + a2.color);
		
		Animal a3 = new Dog();
		a3.sound();
		
		Dog d1 = (Dog)a3;
		Cat c1 = (Cat)a2;
		c1.grooming();
		
		// ClassCastExeption
//		Dog d2 = (Dog)a2;
	}
}
