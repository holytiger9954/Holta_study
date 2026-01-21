package quiz.quiz06.Emp2;

public class EmpExam {

	public static void main(String[] args) {
		
		EmpTable et = new EmpTable();
		
		Emp e1 = new Emp(1001, "김철수", "부장", 8000, 1000, "백대표");
		Emp e2 = new Emp(1002, "홍길동", "대리", 3600, e1.emp, e1.name);
		Emp e3 = new Emp(1003, "임꺽정", "사원", 1800, e2.emp, e2.name);
		
		et.addEmp(e1);
		et.addEmp(e2);
		et.addEmp(e3);
		
		et.info();
		
		System.out.println("--------------------------");
		
		et.infoS();
		
		System.out.println("--------------------------");
		
		et.bossN();
	}

}
