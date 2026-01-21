package quiz.quiz11.Tv;

public class Tv {

	boolean power;
	int volume;
	int channel;
	
	Tv() {
		this.power = false;
		this.volume = 5;
		this.channel = 1;
	}
		
	boolean powerOn() {
		if(!power) {
			this.power = true;
			System.out.println("전원을 켭니다.");
		} else {
			System.out.println("이미 켜져있습니다");
		}
		
		return this.power;
	}
	boolean powerOff() {
		if(power) {
			this.power = false;
			System.out.println("전원을 종료합니다");
		} else {
			System.out.println("이미 꺼져있습니다");
		}
		
		return this.power;
	}
	
	int volumeUp() {
		if(this.volume < 10) {
			this.volume++;			
		} else {
			System.out.println("최대 음량");
		}
		
		System.out.println("현재 볼륨: " + this.volume);
		
		return this.volume;
	}
	int volumeDown() {
		if(this.volume > 0) {
			this.volume--;			
		} else {
			System.out.println("음소거");
		}
		
		System.out.println("현재 볼륨: " + this.volume);
		
		return this.volume;
	}
	
	int channelCtrl(int channel) {
		if(channel <= 100 && channel > 0) {
			this.channel = channel;
		} else {
			System.out.println("정확한 채널을 입력하세요");
		}
		
		System.out.println("현재 채널: " + this.channel);
		
		return this.channel;
	}
	
	void info() {
		if(this.power) {
			System.out.println("현재 상태:" + " 전원>On" + " 볼륨>" + this.volume + " 채널>" + this.channel);
		} else {
			System.out.println("전원을 켜주세요");
		}
	}
	
}
