package quiz2;

public class Barista extends Emp{
	
	// 커피를 종류별로 만든다
	// 설겆이
	
	String makeCoffee(String menu) {
		System.out.println(menu + "만드는중...");
		return menu;
	}

	void wash() {
		System.out.println("설거지");
	}
	
	void printMoney(){
		System.out.println("바리스타 잔액: "+this.money);
	}
	
}
