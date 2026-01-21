package quiz.quiz02.Song;

public class _Song {

	String title; 		// 제목
	String singer; 		// 가수명
	String albumName; 	// 앨범명
	String lyrics; 		// 가사
	int time; 			// 시간(초단위)
	
	void info() {
		System.out.println("곡 제목: " + this.title);
	}
}
