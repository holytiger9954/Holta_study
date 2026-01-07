package chap02;

public class StudyClass {

	public static void main(String[] args) {
		
		int intValue = 1 + 2 + 3;
		System.out.println("intValue: " + intValue);
		
//		String strValue = 1 + 2 + 3;
		String strValue1 = 1 + "2" + 3;
		System.out.println("strValue: " + strValue1);
		String strValue2 = "1" + (2 + 3);
		System.out.println("strValue: " + strValue2);

	}

}
