package sec01.exam01;

public class StudentExam {

	public static void main(String[] args) {

		Student s1 = new Student();
		
		Student s2;
		s2 = new Student();
		
		System.out.println(s1 == s2); // false 주소가 다름
		
		Student s3 = null;
		s3 = s1;
		System.out.println(s3 == s1); // true 주소가 같음
		
		s1 = null;
		// s3는 null이 아님
		// s1의 stack 영역의 주소값이 null이 됐을 뿐
		// s3의 stack 영역에는 s1으로 부터 가져온 주소값이 남아있다
		
		s1 = s2;
		// s3는 stack 영역에서 여전히 s1에 있었던 주소값(인스턴스)이 유지됨
		// 즉, 참조타입에서 stack 영역에는 주소값,
		// heap 영역에 주소가 가리키는 값이 저장된다 
		
		Teacher t = new Teacher();
		
	}

}
