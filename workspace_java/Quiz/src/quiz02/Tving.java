package quiz02;

public class Tving {

	void tvingLogin(OAuth o, String id, String pw) {
		if(o.login(id, pw)) {
			System.out.println("Tving 메인 페이지 표시");
		} else {
			System.out.println("다시 로그인 하세요");
		}
	}
	
}
