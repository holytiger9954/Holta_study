package sec01;

public class StudentExam {

	public static void main(String[] args) {

		Student student = new Student("홍아무개", "123456-7890123", 1234);
		
		System.out.println("이름: " + student.name);
		System.out.println("주민 번호: " + student.ssn);
		System.out.println("학번: " + student.studentNo);
		
	}

}
