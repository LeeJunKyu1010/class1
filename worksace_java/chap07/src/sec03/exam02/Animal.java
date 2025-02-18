package sec03.exam02;

// abstract 추상클래스
public abstract class Animal {
	
	String kind;
	
	void breathe() {
		System.out.println("아우렐리온 솔 용의 숨결");
	}
	
	// 추상 메소드
	// abstract 키워드가 붙은 메소드
	// 실행 블럭 { } 이 있으면 안된다.
	// 나는 구현하지 않음
	// 대신에 나를 상속받은 자식이 반드시 구현 해야한다.
	abstract void sound();
	
	
}
