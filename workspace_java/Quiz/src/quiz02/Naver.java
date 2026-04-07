package quiz02;

public class Naver extends OAuth {

	@Override
	boolean login(String id, String pw) {
		if(userCheck(id, pw)) {
			System.out.println("Naver 로그인 성공");
			return true;
		} else {
			System.out.println("Naver 로그인 실패");
			return false;
		}
	}
	
}
