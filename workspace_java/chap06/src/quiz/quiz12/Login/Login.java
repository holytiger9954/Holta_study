package quiz.quiz12.Login;

import java.util.ArrayList;

public class Login {
	
	ArrayList<Member> userList = new ArrayList<Member>();
	
	void signUp(String name, String id, String password) {
		Member newMember = new Member(name, id, password);
		
		this.userList.add(newMember);
		
		System.out.println(name + "님 회원가입 완료!");
	}
	
	void login(String id, String password) {
		boolean loginCheck = false;
		
		for(int i = 0; i < this.userList.size(); i++) {
			Member m = this.userList.get(i);
			if(id.equals(m.id) && password.equals(m.password)) {
				loginCheck = true;
				break;
			}
		}
		
		if(loginCheck) {
			System.out.println("----------로그인 성공!----------");
			System.out.println("--------메인 페이지 출력--------");
		} else {
			System.out.println("*아이디 또는 패스워드가 다릅니다");
		}
	}
	
}
