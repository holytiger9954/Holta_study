package quiz01;

public class DaumLogin extends Login {

	DaumLogin(String id, String pw) {
		super(id, pw);
	}
	
	@Override
	void login(String id, String pw) {
		if(loginCheck(id, pw)) {
			System.out.println("Daum 로그인 성공");
		} else {
			System.out.println("Daum 로그인 실패");
		}
	}
}
