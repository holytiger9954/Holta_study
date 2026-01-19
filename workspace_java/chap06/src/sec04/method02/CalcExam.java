package sec04.method02;

public class CalcExam {

	public static void main(String[] args) {

		Calc calc = new Calc();
		calc.powerOn();
		
		int a = calc.plus(5, 7);
		System.out.println("a: " + a);
		
		// 호출할 때 이름과 전달인자를 꼭 맞춰야 실행된다
//		calc.plus();
		
		int i = 4;
		a = calc.plus(i, 8);
		
		System.out.println("-------------------");
		double d = calc.divide(10, 4);
		System.out.println("d: " + d);
		System.out.println("-------------------");
		d = calc.divide(10, 0);
		System.out.println("d: " + d);
		
		// 큰형님 문제
		System.out.println("---------사칙 연산 계산기---------");
		calc.scanner();
		int result = 0;
		int numXint = Integer.parseInt(calc.input.get(0));
		int numYint = Integer.parseInt(calc.input.get(2));
		if("+".equals(calc.input.get(1))) {
			result = calc.calcP(numXint, numYint);
			System.out.println(numXint 
							 + calc.input.get(1) 
							 + numYint
							 + " = " + result);
		} else if ("-".equals(calc.input.get(1))){
			result = calc.calcM(numXint, numYint);
			System.out.println(numXint 
							 + calc.input.get(1) 
							 + numYint
							 + " = " + result);
		} else if ("/".equals(calc.input.get(1))) {
			result = calc.calcD(numXint, numYint);
			System.out.println(numXint 
							 + calc.input.get(1) 
							 + numYint
							 + " = " + result);
		} else if("*".equals(calc.input.get(1))) {
			result = calc.calcS(numXint, numYint);
			System.out.println(numXint 
							 + calc.input.get(1) 
							 + numYint
							 + " = " + result);
		} else {
			System.out.println("사칙 연산만 가능합니다");
		}
	}
	

}
