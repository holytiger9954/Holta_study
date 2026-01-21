package quiz.quiz07.Fan;

public class Fan {

	boolean button;
	String power;
	
	void switchOn() {
		if(this.button == false) {
			this.button = true;
			System.out.println("전원을 켭니다");			
		} else if(this.button == true) {
			System.out.println("이미 켜져있습니다");						
		}
	}
	void switchOff() {
		if(this.button == true) {
			this.button = false;
			System.out.println("전원을 끕니다");
		} else if(this.button == false) {
			System.out.println("이미 꺼져있습니다");						
		}
	}
	
	void powerCtrl(String power) {
		if(this.button == false) {
			System.out.println("전원이 꺼져있습니다");
		} else {
			if("약풍".equals(power)) {
				this.power = power;
				System.out.println("세기: " + this.power);
			} else if("강풍".equals(power)) {
				this.power = power;
				System.out.println("세기: " + this.power);
			} else {
				System.out.println("강/약 조절만 가능합니다.");
			}
		}
	}
	
}
