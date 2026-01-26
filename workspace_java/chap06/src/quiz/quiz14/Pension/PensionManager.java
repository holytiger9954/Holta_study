package quiz.quiz14.Pension;

import java.util.ArrayList;
import java.util.Scanner;

public class PensionManager {
	
	ArrayList<Room> roomList = new ArrayList<Room>();
	
	PensionManager() { // 101호 ~ 110호 만들기
		for(int i = 0; i < 10; i++) {
			Room r = new Room(101 + i); 
			roomList.add(r);
		}
	}

	void reserv() { // 예약 시스템 메인
		Scanner scan = new Scanner(System.in);
		System.out.println("---- 성범펜션 예약시스템 ----");
		
		System.out.print("방문자 수: ");
		int userSize = scan.nextInt();
		
		System.out.print("반려동물 동반 (1.있음 0.없음): ");
		// 1이면 true, 아니면 false(이러면 if문으로 방어코드 안짜도 될듯?)
	    boolean userPet = (scan.nextInt() == 1);
	    
	    System.out.print("바베큐 이용 (1.사용 0.미사용): ");
	    boolean userBbq = (scan.nextInt() == 1);
	    
	    System.out.print("시작일(1~10): ");
	    int start = scan.nextInt();
	    
	    System.out.print("종료일(1~10): ");
	    int end = scan.nextInt();
	    
	    ArrayList<Room> availRoomList = new ArrayList<Room>();
	    
	    // roomList 하나씩 검사
	    for(int i = 0; i < roomList.size(); i++) {
	    	Room r = roomList.get(i); // i번째 방 꺼내기
	    	
	    	boolean petCheck = true;
	    	if(userPet == true && r.pet == false) {
	    		petCheck = false;
	    	}
	    	
	    	if(userSize <= r.maxSize && petCheck) {
	    		boolean isPossible = true;
	    		
	    		for(int j = start; j <= end; j++) {
	    			if(r.isBooked[j]) {
	    				isPossible = false;
	    				break;
	    			}
	    		}
	    		
	    		if(isPossible) {
	    			availRoomList.add(r);
	    		}
	    	}
	    }
	    
	    if(availRoomList.size() == 0) {
	    	System.out.println("희망하시는 방이 없습니다");
	    } else {
	    	System.out.println("[예약 가능한 호실]");
	    	for(int i =0; i < availRoomList.size(); i++) {
	    		Room r = availRoomList.get(i);
	    		System.out.print((i + 1) + ". " + r.roomNo + "호실");
	    		
	    		for(int k = 1; k <= roomList.size(); k++) {
	    			System.out.print(r.isBooked[k] ? "(이용불가)" : "(이용가능)");
	    			break;
	    		}
	    		System.out.println();
	    	}
	    	
	    	System.out.println("예약할 호실을 선택하세요: ");
	    	int choice = scan.nextInt();
	    	
	    	Room selectedRoom = availRoomList.get(choice - 1);
	    	
	    	for(int i = start; i <= end; i++) {
	    		selectedRoom.isBooked[i] = true;
	    	}
	    	
	    	System.out.println("---------------------------------------");
	        System.out.println(selectedRoom.roomNo + "호 예약이 성공적으로 완료되었습니다");
	        System.out.println("예약 기간: " + start + "일 ~ " + end + "일");
	        System.out.println("---------------------------------------");
	    }
	}
	
	
}
