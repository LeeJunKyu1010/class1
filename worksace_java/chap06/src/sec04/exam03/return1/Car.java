package sec04.exam03.return1;

public class Car {

	int gas = 5;
	// 필드
	// 같은말로 멤버 변수
	// 클래스를 생성 (new 하는 순간)과 함께 생성됨
	// 클래스 소멸 (가베지 컬렉터 동작) 시까지 생존
	// 그동안 메모리를 차지 하면서 계속 저장된 값이 유지됨
	// 가능하면 지역변수로 먼저 해결하는게 좋음
	// 클래스 자체에 값을 저장하거나 
	// 메소드끼리 공유하는 목적으로 사용하거나 한다.
	
	
	
	int speed;
	// 값을 선언하지 않은 경우
	// 0, false, null로 초기화된다.
	
	
	
	void setSpeed(int s) {
		speed = s;
		System.out.println("속도를 "+speed+"로 바꿉니다.");
	}
	
	
	// 메소드는 무조건 return을 해야만 한다.
	// 단, void의 경우 생략할 수 있다.
	void setGas(int g) {
		gas = g;
//		return;
	}
	
	// 만약 주석을 단다면
	// gas의 값이 0이면 false를
	// 그렇지 않으면 true를 돌려주는 함수
	
	// 방법1.
	boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;	// return 하는 순간
							// 메소드 종료!
		}
			else {
			// else가 있는 경우 if의 분기는 무조건
			// 하나의 return을 보장한다.
			System.out.println("gas가 있습니다.");
			return true;
		}  //else 사용 안한경우
//		System.out.println("gas가 있습니다.");
//		return true;
	}
	
	
	
	// 방법2.
	boolean isLeftGas2() {
		boolean result = false;
		
		if (gas == 0) {
			System.out.println("gas가 없습니다.");
			result = false;	
		} else {
			System.out.println("gas가 있습니다.");
			result = true;
		}
		
		return result;
	}
	
	
	// 방법3. gas가 0이 아닐때 true가 나온다.
	boolean isLeftGas3() {
		return gas != 0;
	}
	
	void run() {
		while(true) {
			if (gas > 0) {
				System.out.println("주행중... 잔량 : "+gas);
				setSpeed(gas);
				gas--;
			}else {
				System.out.println("주행종료.. 잔량 : "+gas);
				
				return;
			}
		}
	}
	
	
}