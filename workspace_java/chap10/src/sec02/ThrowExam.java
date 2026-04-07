package sec02;

import java.io.IOException;

public class ThrowExam {

	public static void main(String[] args) {	
		
		try {
			test();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			test2(12);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
			if(e.getMessage().equals("화남")) {
				System.out.println("함 올라가?");
			} else if(e.getMessage().equals("덜 화남")) {				
				System.out.println("이번엔 참는다");
			}
		}
		
		try {
			test3(8);
		} catch (LoveException e) {
			e.printStackTrace();
			
			if(e.getMessage().equals("화남")) {
				System.out.println("함 올라가?");
			} else if(e.getMessage().equals("덜 화남")) {				
				System.out.println("이번엔 참는다");
			}
		}
		
	}
	
	static void test() throws ClassNotFoundException, IOException {
		Class.forName("sec02.ThrowExam");		
	}
	
	static void test2(int vol) throws IOException {
		if(vol > 10) {
			throw new IOException("화남");
		} else if(vol > 7) {			
			throw new IOException("덜 화남");
		}
	}
	
	static void test3(int vol) throws LoveException {
		if(vol > 10) {
			throw new LoveException("화남");
		} else if(vol > 7) {			
			throw new LoveException("덜 화남");
		}
	}
			
}
