package quiz.quiz14.Pension;

public class Room {

	int roomNo; // 방 번호
	int maxSize; // 최대 인원
	boolean pet; // 반려동물
	boolean bbq; // 바베큐장
	
	// 1~10일 예약 현황 (0번 부터 하면 헷갈리니까 0번 쓰지말고 1번부터 사용)
	boolean[] isBooked = new boolean[11];
	
	Room(int roomNo) {
		this.roomNo = roomNo;
		this.maxSize = (int)((Math.random() * 5) + 2); // 최대 인원 2~6인
		
		int petRandom = (int)(Math.random() * 2); // 랜덤으로 0~1이 나오게 해서
		if(petRandom == 1) { // 랜덤값이 1이면
			this.pet = true; // 반려동물 동반 가능
		} else if(petRandom == 0) { // 랜덤값이 0이면
			this.pet = false; // 반려동물 동반 불가
		}
		
		int bbqRandom = (int)(Math.random() * 2); // 랜덤으로 0~1이 나오게 해서
		if(bbqRandom == 1) { // 랜덤값이 1이면
			this.bbq = true; // 바베큐장 있음
		} else if(bbqRandom == 0) { // 랜덤값이 0이면
			this.bbq = false; // 바베큐장 없음
		}
		
		for(int i = 1; i < this.isBooked.length; i++) {
			// 0~1 이면 예약 안될 확률 높을 거 같아서...
			int bookRandom = (int)(Math.random() * 5);
			if(bookRandom == 0) { // 20% 확률로 예약되어 있게 해놓음
				this.isBooked[i] = true;
			}
		}
	}
}
