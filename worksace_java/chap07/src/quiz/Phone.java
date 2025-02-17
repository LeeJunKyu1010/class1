package quiz;

public class Phone {
	
	boolean power;
	
	
	
	void call(String number) {
		if(this.power == true) {
			System.out.println(number + "에 연결중입니다.");
		}else {
			System.out.println("전원이 꺼져있습니다.");
		}
	}
	
	void onOff() {
//		if(this.power) {
//			this.power = false;
//		}else {
//			this.power = true;
//		}
		
		this.power = !this.power;
	}
	
	
	
	void ball() {
		System.out.println("벨울림");
	}
	
}
