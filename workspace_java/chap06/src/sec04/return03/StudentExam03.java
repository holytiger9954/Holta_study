package sec04.return03;

public class StudentExam03 {

	public static void main(String[] args) {

		Student s1 = new Student();
		s1.name = "허성범";
		s1.age = 28;
		
		s1.name = null;
		s1.age = -20;
		
		s1.setName("허성범");
		String name = s1.getName();
		System.out.println("이름: " + name);
		
	}

}
