package chap02;

public class VarTypeExam {

	public static void main(String[] args) {
		
		byte b1;
		b1 = 127;
		System.out.println("b1: " + b1);
//		b1 = 128;
		
		char c1 = 65;
		System.out.println("c1: " + c1);
		char c2 = 65 + 2;
		System.out.println("c2: " + c2);
		char c3 = 'B';
		System.out.println("c3 - c1: " + (c3 - c1));
		
		// L 또는 l을 붙이면 명시적인 long
//		long l1 = 2200000000;
		long l1 = 2200000000L;
		long l2 = 30;
		System.out.println(l1);
		System.out.println(l2);
		
		String s1 = "허성범";
		System.out.println("s1: " + s1);
		
		String s2 = "허\"성범";
		System.out.println("s2: " + s2);
		String s3 = "\\허\t성\n범";
		System.out.println("s3: " + s3);
				
	}

}



















