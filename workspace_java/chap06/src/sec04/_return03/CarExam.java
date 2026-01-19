package sec04._return03;

public class CarExam {

	public static void main(String[] args) {

		Car car = new Car();
		boolean status = car.isLeftGas();
		
		System.out.println("가스 있나요?: " + status);
		
		car.gas = 3;
		car.setGas(3); // 같은 일을 한다
		System.out.println("가스 있나요?: " + car.isLeftGas());
		
		car.run();
		System.out.println("4885 너지?");
	}

}
