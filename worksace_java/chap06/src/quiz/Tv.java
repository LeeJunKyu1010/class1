package quiz;

public class Tv {
	
	
	// 전원 기능
	// 볼륨 up/down (0~10까지)
	// 채널 up/down/ 직접입력
	// 현재 정보 보기
	
	String powerOn;
	String powerOff;
	
	int vinfo = 5;
	int vUp;
	int vDown;
	
	int cUp;
	int cDown;
	
	String info;
	
	
	// 전원 기능
	String power (String q) {
		if (q.equals("on")) {
		System.out.println("전원 켜기");	
		}else if (q.equals("off")) {
			System.out.println("전원 끄기");
		}
		return q;
	}
	
	
	// 볼륨 up/down (0~10까지)
	
	int vInfo (int x) {
		if (x < 10) {
			this.vinfo = this.vinfo+x;
			System.out.println("볼륨증가");
		}else if (x > 10) {
			this.vinfo = this.vinfo-x;
			System.out.println("볼륨감소");
		}
		return x;
	}
	
	
	
	
	
	
	// 채널 up/down/ 직접입력
	
	
	
	
	
	
	
	
	
	
	
	
	// 현재 정보 보기
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
