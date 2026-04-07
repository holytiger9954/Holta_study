package quiz01;

public class Login {

	String id;
	String pw;
	
	Login(String id, String pw){
		this.id = id;
		this.pw = pw;
	}
	
	void login(String id, String pw) {
		if(loginCheck(id, pw)) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}
	
	boolean loginCheck(String id, String pw) {
//		boolean result = false;
		if(id.equals(this.id)) {
			if(pw.equals(this.pw)) {
//				result = true;
//				return result;
				return true;
			} else {
//				return result;
				return false;
			}
		} else {
//			return result;
			return false;
		}
	}
	
}
