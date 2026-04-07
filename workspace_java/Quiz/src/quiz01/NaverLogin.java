package quiz01;

public class NaverLogin extends Login {
	
	NaverLogin(String id, String pw) {
		super(id, pw);
	}

	@Override
	void login(String id, String pw) {
		if(loginCheck(id, pw)) {
			System.out.println("Naver 로그인 성공");
		} else {
			System.out.println("Naver 로그인 실패");
		}
	}
	
	
}
