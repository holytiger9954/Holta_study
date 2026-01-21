package quiz.quiz02.Song;

public class _SongExam {

	public static void main(String[] args) {

		_Song s1 = new _Song();
		s1.title = "Good Goodbye";
		s1.singer = "화사";
		s1.albumName = "Good Goodbye";
		s1.lyrics = "굿바이~";
		s1.time = 310;
		
		_Song s2 = new _Song();
		s2.title = "사랑하게 될거야";
		s2.singer = "한로로";
		s2.albumName = "이상비행";
		s2.lyrics = "뭔가 이상해";
		s2.time = 240;
		
		System.out.println(s1.title);
		System.out.println(s2.title);
		
		s1.info();
		s2.info();
		
	}

}
