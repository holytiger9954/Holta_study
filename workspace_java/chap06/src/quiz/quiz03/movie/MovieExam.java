package quiz.quiz03.movie;

public class MovieExam {

	public static void main(String[] args) {

		Movie m1 = new Movie();
		
		m1.titleInput("나 홀로 집에");
		m1.sinceInput(1990);
		
		m1.titleOutput();
		m1.sinceOutput();
		System.out.println("-------------------");
		
		Movie m2 = new Movie();
		
		m2.titleInput("인터스텔라");
		m2.sinceInput(2014);
		
		m2.titleOutput();
		m2.sinceOutput();
		System.out.println("-------------------");
		
		m1.info();
		m2.info();
		
		System.out.println("속편: " + m1.makeSeries(m1.title));
		System.out.println("속편: " + m1.makeSeries(m2.title));
	}

}
