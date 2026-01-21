package quiz.quiz04.cafe;

public class CafeExam {

	public static void main(String[] args) {
		
		Cafe c1 = new Cafe("곤뇽커피", 3500);
		
		System.out.println("상호: " + c1.name);
		System.out.println("자본금: " + c1.cost);
		System.out.print(c1.menu1 + "\t");
		System.out.println(c1.menu2);
		
	}
	
}
