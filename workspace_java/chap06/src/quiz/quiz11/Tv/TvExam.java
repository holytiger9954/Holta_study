package quiz.quiz11.Tv;

public class TvExam {

	public static void main(String[] args) {

		Tv t = new Tv();
		
		t.powerOn();
		
		t.volumeUp();
		t.volumeUp();
		t.volumeUp();
		t.volumeUp();
		t.volumeUp();
		t.volumeUp();
		
		t.volumeDown();
		t.volumeDown();
		t.volumeDown();
		t.volumeDown();
		t.volumeDown();
		t.volumeDown();
		t.volumeDown();
		t.volumeDown();
		t.volumeDown();
		t.volumeDown();
		t.volumeDown();
		
		t.volumeUp();
		
		t.channelCtrl(42);
		t.channelCtrl(-10);
		
		t.info();
	}

}
