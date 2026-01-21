package quiz.quiz03.movie;

public class _MovieExam {

	public static void main(String[] args) {

		_Movie m1 = new _Movie();
		m1.title = "난다요";
		
		m1.setTitle("고래요");
		m1.setYear(2026);
		
		System.out.println(m1.title);
		String 제목 = m1.getTitle();
		System.out.println("오늘 볼 영화: " + 제목);
		System.out.println("오늘 볼 영화: " + m1.getTitle());
		
		m1.info();
		
	}

}
