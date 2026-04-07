package quiz02;

public class OAuth {

	String id;
	String pw;
	
	boolean join(String id, String pw) {
		
		this.id = id;
		this.pw = pw;
		
		System.out.println("회원 등록 완료");
		
		return true;
	}
	
	boolean userCheck(String id, String pw) {
		
		return (id.equals(this.id) && pw.equals(this.pw));
	}
	
	boolean login(String id, String pw) {
		if(userCheck(id, pw)) {
			
			return true;
		} else {
			
			return false;
		}
	}
}
