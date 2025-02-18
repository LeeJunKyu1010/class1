package quiz2;

public class Emp {
	
	int money;

	// 손님응대
	// 공부하기
	// 월급 받기
	
	void service() {
		System.out.println("손님을 응대합니다.");
	}
	
	void study(String theme) {
		System.out.println(theme + "공부하기");
	}
	
	void sal(int money) {
		System.out.printf("월급 %d원을 받습니다.\n", money);
		this.money +=money;
	}
	
}
