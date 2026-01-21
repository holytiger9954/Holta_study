package quiz.quiz05.Emp;

import java.util.ArrayList;

public class EmpExam {

	public static void main(String[] args) {

		Emp e1 = new Emp();
		e1.emp = 1001;
		e1.name = "김철수";
		e1.position = "부장";
		e1.money = 11800;
		e1.boss = 1000;
		
		Emp e2 = new Emp();
		e2.emp = 1002;
		e2.name = "홍길동";
		e2.position = "과장";
		e2.money = 6800;
		e2.boss = e1.emp;
		
		Emp e3 = new Emp();
		e3.emp = 1003;
		e3.name = "임꺽정";
		e3.position = "사원";
		e3.money = 2800;
		e3.boss = e2.emp;
		
		ArrayList list = new ArrayList();
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		for(int i = 0; i < list.size(); i++) {
			((Emp) list.get(i)).info();
			System.out.println("----------------------");
		}
		
	}

}
