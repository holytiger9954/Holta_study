package quiz.quiz03.movie;

public class Movie {

	String title;
	int since;
	
	String titleInput(String title) {
		this.title = title;
		
		return this.title;
	}
	void titleOutput() {
		System.out.println("제목: " + this.title);
	}
	
	int sinceInput(int since) {
		this.since = since;
		
		return this.since;
	}
	void sinceOutput() {
		System.out.println("개봉년도: " + this.since);
	}
	
	void info() {
		System.out.println("제목: " + this.title);
		System.out.println("개봉년도: " + this.since);
	}
	
	String makeSeries(String title) {
		this.title = title + "2";
		
		return this.title;
	}
}
