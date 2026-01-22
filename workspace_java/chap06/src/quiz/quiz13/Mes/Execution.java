package quiz.quiz13.Mes;

public class Execution {

	public static void main(String[] args) {

		Item item1 = new Item("스마트폰");
		Item item2 = new Item("노트북");
		
		Process p = new Process();
		
		p.run(item1);
		p.run(item2);
		
	}

}
