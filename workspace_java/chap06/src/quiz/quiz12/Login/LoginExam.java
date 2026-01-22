package quiz.quiz12.Login;

public class LoginExam {

	public static void main(String[] args) {

		Login l = new Login();
		
		l.signUp("허성범", "hsb0001", "sb1111");
		l.signUp("김민권", "kmg0001", "mg1111");
		l.signUp("정현수", "jhs0001", "hs1111");
		l.signUp("송종한", "sjh0001", "jh1111");
		l.signUp("송상민", "ssm0001", "sm1111");
		
		
		l.login("hsb0001", "sb1111");
		l.login("kmg0001", "mg1111");
		l.login("kmf0001", "mg1111");
		
	}

}
