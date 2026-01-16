package sec02;

public class ChinaExam {

	public static void main(String[] args) {

		China china1 = new China();
		System.out.println("가게명: " + china1.name);
		System.out.println("위치: " + china1.address);
		System.out.print("메뉴 : ");
		for(int i = 0; i < china1.menu.length; i++) {
			System.out.print((i + 1) + ". " +  china1.menu[i] + "\t");			
		}
		System.out.println();
		System.out.println("---------------------------------------------------");
		
		china1.name = "대길이 짬뽕 2호점";
		china1.address = "천안역 도보 5분";
//		china1.menu[0] = "팔보채";
//		china1.menu[1] = "양장피";
		china1.menu = new String[] {"팔보채", "양장피"};
		
		System.out.println("가게명: " + china1.name);
		System.out.println("위치: " + china1.address);
		System.out.print("메뉴 : ");
		for(int i = 0; i < china1.menu.length; i++) {
			System.out.print((i + 1) + ". " +  china1.menu[i] + "\t");			
		}
		System.out.println();
		System.out.println("---------------------------------------------------");
		
		China china2 = new China();
		china2.name = "엄지반점";
		china2.address = "창원 어딘가";
		china2.menu = new String[] {"탕수육", "고량주", "햄버거"};
//		china2.abc = new int[] {1, 2, 3, 4, 5};
//		china2.abc = new int[5];
		
		System.out.println("가게명: " + china2.name);
		System.out.println("위치: " + china2.address);
		System.out.print("메뉴 : ");
		for(int i = 0; i < china2.menu.length; i++) {
			System.out.print((i + 1) + ". " +  china2.menu[i] + "\t");			
		}
		System.out.println();
		System.out.println("---------------------------------------------------");
	}

}
