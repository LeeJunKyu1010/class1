package sec03.exam01;

public class Car {
	
	/*
	 
	  생성자

	클래스를 생성할 때 즉, new 할 때 무조건 실행되는 메소드의 일종

	리턴타입이나 return문은 쓰지 않는다.

	이유는 무조건 생성된 heap 영역의 주소를 돌려주기 때문에 고정값이라서.

	메소드 명에 해당하는 이름은 무조건 클래스 이름이어야 한다.

	즉, 리턴타입이 없고 메소드명이 클래스명과 동일한 경우 생성자라고 한다.
	*/

	/*
	
	기본생성자 : 전달인자와 실행 내용이 없는 생성자

	public Car() { }

	기본 생성자는 생략 가능하다.

	즉, 생성자를 적지 않으면 기본 생성자가 자동 완성된다.
	 
	 */
	
	
	String brand = "아반떼";
	// 값을 입력 안하면 String은 null, int는 0으로 초기화한다.
	String color = null;
//	color = "횐색"; 이렇게는 안된다. (실행블럭에만 넣을 수 있음)
	int cc = 0;
	
//	System.out.println("안됨");
	
	// 클래스를 new 생성할때
	// 1. 필드 먼저 선언됨
	// 2. 생성자 실행
	public Car(int c) {
		cc = c;
		color = "흰색";
		System.out.println("Car(int) 생성");
		test();
	}
	
	Car(String b){
		brand = b;
		System.out.println("Car(String) 생성 : "+ brand);
	}
	
	
	
	Car(){
		this("아반떼","흰색",1300);
		System.out.println("Car() 생성자 실행");
	}
	
	
	Car(String b, String c, int cc2){
		// 다른 생성자 호출 하는 방법
		// Car() 호출
		// 무조건 첫번째 줄에서 호출해야한다.
//		this();
		
		brand = b;
		color = c;
		cc = cc2;
		System.out.println("Car(String b, String c, int cc2) 생성자 실행");
		
//		this();	// 무조건 첫번째 줄에서 호출해야 하므로 안됨

	}
	
	Car(String brand, int cc){
		
		String color = "파랑";
		System.out.println(color);
		System.out.println(this.color);
	
		this.brand = brand;
		this.cc = cc;
	}
	
	void setBrand(String brand) {
		this.brand = brand;
	}
	
	void test() {
		color = "회색";
		System.out.println("test() 실행");
	}
	
	void init() {
		brand = "아반떼";
		color = "횐색";
		cc = 1600;
	}
	
	
	
	
	
	
}
