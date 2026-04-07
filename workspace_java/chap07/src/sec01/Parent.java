package sec01;

public class Parent {

	String name = "parent의 name";

	String getName() {
		System.out.println("parent의 getName 실행");
		return this.name;
	}

	Parent(int a) {
		System.out.println("Parent의 생성자");
	}

}
