package quiz01;

public class LoginExam {

	public static void main(String[] args) {

		Login l = new Login("qwer1234", "zxcv0987");
		l.login("qwer1234", "zxcv0987");
		l.login("qwer", "zxcv");
		System.out.println("-----------------------");
		
		NaverLogin n = new NaverLogin("qwer1234", "zxcv0987");
		n.login("qwer1234", "zxcv0987");
		n.login("qwer", "zxcv");
		System.out.println("-----------------------");
		
		DaumLogin d = new DaumLogin("qwer1234", "zxcv0987");
		d.login("qwer1234", "zxcv0987");
		d.login("qwer", "zxcv");
		System.out.println("-----------------------");		
		
	}

}
