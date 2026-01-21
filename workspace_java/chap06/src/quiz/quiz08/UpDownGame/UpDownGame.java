package quiz.quiz08.UpDownGame;

import java.util.Scanner;

public class UpDownGame {
	
	int gameNum;
	int myNum;
	int count;
	
	void gameNumInput() {
		this.gameNum = (int)(Math.random() * 10 + 1);
	}
	
	void udgSystem() {
		System.out.println("업/다운 게임!");
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("숫자를 입력하세요: ");
			this.myNum = scan.nextInt();
			if(myNum < gameNum) {
				System.out.println("업!");
			} else if(myNum > gameNum) {
				System.out.println("다운!");
			} else {
				System.out.println("정답!");
				break;
			}
			this.count++;
		}
		System.out.println("총 " + (count + 1) + "번 만에 맞췄어요!");
		System.out.println("게임을 종료합니다");
	}
	
	void udg() {
		gameNumInput();
		udgSystem();
	}
	
	
}
