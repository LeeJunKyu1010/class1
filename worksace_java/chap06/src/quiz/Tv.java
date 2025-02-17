package quiz;

public class Tv {
	
	
	// 전원 기능
	// 볼륨 up/down (0~10까지)
	// 채널 up/down/ 직접입력
	// 현재 정보 보기
	
	String powerOn;
	String powerOff;
	
	int vinfo;
	int vUp;
	int vDown;
	
	int cinfo;
	int cUp;
	int cDown;
	
	String info;
	
	
	// 전원 기능
	String power (String q) {
		if (q.equals("on")) {
			this.powerOn = q;
		System.out.println("PowerOn");
		}else if (q.equals("off")) {
			this.powerOff = q;
			System.out.println("PowerOff");
		}else {
			System.out.println("on , off 를 입력하세요");
		}
		return q;
	}
	
	
	// 볼륨 up/down (0~10까지)
	
	
	
	
	
	
	
	
	// 채널 up/down/ 직접입력
	
	
	
	
	
	
	
	
	
	
	
	
	// 현재 정보 보기
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
