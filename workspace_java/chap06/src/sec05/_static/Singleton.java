package sec05._static;

public class Singleton {

////	Singleton singleton = null;
//	static Singleton singleton = null;
//	
//	 쓰레드 레벨에서 동시에 실행될 수 있는 위험이 있다
////	Singleton get() {
//	static Singleton get() {
//		if(singleton == null) {
//			singleton = new Singleton();
//		}
//		
//		return singleton;
//	}
	
	static Singleton singleton = new Singleton();
	
	private Singleton() {}
	
	static Singleton get() {
		return singleton;
	}
}
