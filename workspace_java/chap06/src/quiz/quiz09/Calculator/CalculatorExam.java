package quiz.quiz09.Calculator;

public class CalculatorExam {

	public static void main(String[] args) {

		Calculator calc = new Calculator();
		
		calc.calc(5, "-", 4);
		calc.calc(5, "/", 0);
		calc.calc(6, "+", 4);
		
		calc.readHistory();
		
		calc.calc(11, "*", 7);
		calc.calc(13, "/", 3);
		calc.calc(77, "%", 10);
		
		calc.readHistory();
		
	}

}
