package sec01.override;

public class ComputerExam {

	public static void main(String[] args) {
		
		Calc calc = new Calc();
		System.out.println(calc.areaCircle(10));
		System.out.println("------------------");
		
		Computer c = new Computer();
		double result = c.areaCircle(10);
		System.out.println(result);
		System.out.println("------------------");
		
		System.out.println(c.plus(1, 2));
	}

}