package quiz.quiz09.Calculator;

import java.util.ArrayList;

public class Calculator {

	int value1;
	String operator;
	int value2;
	int result;
	ArrayList<String> history = new ArrayList<String>();

	void calc(int value1, String operator, int value2) {
		this.value1 = value1;
		this.operator = operator;
		this.value2 = value2;
		
		System.out.println("계산기 On");
		
		if ("+".equals(this.operator)) {
			this.result = this.value1 + this.value2;
			System.out.println(this.value1 + this.operator + this.value2 + " = " + this.result);
		} else if ("-".equals(this.operator)) {
			this.result = this.value1 - this.value2;
			System.out.println(this.value1 + this.operator + this.value2 + " = " + this.result);
		} else if ("*".equals(this.operator)) {
			this.result = this.value1 * this.value2;
			System.out.println(this.value1 + this.operator + this.value2 + " = " + this.result);
		} else if ("/".equals(this.operator)) {
			if(this.value2 != 0) {
				this.result = this.value1 / this.value2;
				System.out.println(this.value1 + this.operator + this.value2 + " = " + this.result);				
			} else {
				System.out.println(this.value1 + this.operator + this.value2 + " = 무한 루프");
			}
		} else if ("%".equals(this.operator)) {
			this.result = this.value1 % this.value2;
			System.out.println(this.value1 + this.operator + this.value2 + " = " + this.result);
		} else {
			System.out.println("정확한 연산자를 입력해주세요");
		}
		if(this.value2 != 0) {
			history.add(this.value1 + this.operator + this.value2 + " = " + this.result);			
		} else {
			history.add(this.value1 + this.operator + this.value2 + " = 무한 루프");						
		}
		System.out.println("종료합니다");
		System.out.println("---------------");
	}
	
	void readHistory() {
		System.out.println("히스토리");
		for(int i = 0; i < this.history.size(); i++) {
			System.out.println(this.history.get(i));
		}
		System.out.println("---------------");
	}
}
