package quiz02;

import java.util.Scanner;

public class TvingExam {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        Tving tving = new Tving();
        
        // 1. 각 서비스별 계정 생성 (미리 회원가입 시켜두기)
        OAuth naver = new Naver();
        naver.join("naverUser", "n1234");
        
        OAuth kakao = new Kakao();
        kakao.join("kakaoUser", "k5678");

        // 2. 로그인 서비스 선택
        System.out.println("로그인 방식을 선택하세요 (1.네이버 / 2.카카오)");
        int choice = sc.nextInt();
        
        // 부모 타입 변수를 미리 선언
        OAuth selectedAuth = null;
        
        if (choice == 1) {
            selectedAuth = naver; // 부모는 자식을 담을 수 있다
        } else if (choice == 2) {
            selectedAuth = kakao;
        }

        // 3. 아이디/비번 입력 및 로그인 실행
        if (selectedAuth != null) {
            System.out.print("ID: ");
            String inputId = sc.next();
            System.out.print("PW: ");
            String inputPw = sc.next();
            
            // tvingLogin은 어떤 객체가 들어오든 군말없이 처리함
            tving.tvingLogin(selectedAuth, inputId, inputPw);
        } else {
            System.out.println("잘못된 선택입니다.");
        }
		
	}

}
