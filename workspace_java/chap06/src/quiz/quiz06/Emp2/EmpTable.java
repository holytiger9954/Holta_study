package quiz.quiz06.Emp2;

import java.util.ArrayList;

public class EmpTable {

	ArrayList<Emp> list = new ArrayList<Emp>();

//	Emp e1 = new Emp(1001, "김철수", "부장", 8000, 1000);
//	Emp e2 = new Emp(1002, "홍길동", "대리", 3600, e1.emp);
//	Emp e3 = new Emp(1003, "임꺽정", "사원", 1800, e2.emp);

	void addEmp(Emp e) {
		this.list.add(e);
	}

	void info() {
		for (int i = 0; i < list.size(); i++) {

			Emp e = list.get(i);

			System.out.println("사번: " + e.emp);
			System.out.println("이름: " + e.name);
			System.out.println("직급: " + e.position);
			System.out.println("연봉: " + e.salary);
			System.out.println("직속 상사 사번: " + e.boss);
			System.out.println("--------------------------");
		}
	}

	void infoS() {
		for (int i = 0; i < list.size(); i++) {

			Emp e = list.get(i);

			if (e.salary >= 2000) {

				System.out.println("사번: " + e.emp);
				System.out.println("이름: " + e.name);
				System.out.println("직급: " + e.position);
				System.out.println("연봉: " + e.salary);
				System.out.println("직속 상사 사번: " + e.boss);
				System.out.println("--------------------------");

			}

		}
	}

	void bossN() {
		for (int i = 0; i < list.size(); i++) {

			Emp e = list.get(i);

			System.out.println(e.name + "의 상사: " + e.bossName);

		}
	}
}
