package quiz.quiz05.Emp;

public class Emp {

	int emp;
	String name;
	String position;
	int money;
	int boss;
	
	void info() {
		System.out.println("사번: " + this.emp);
		System.out.println("이름: " + this.name);
		System.out.println("직급: " + this.position);
		System.out.println("연봉: " + this.money);
		System.out.println("직속 상사 사번: " + this.boss);
	}
	
}
