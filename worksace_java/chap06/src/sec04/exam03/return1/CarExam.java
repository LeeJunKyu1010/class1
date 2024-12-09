package sec04.exam03.return1;

public class CarExam {
	
	// main 메소드
    // java가 실행된다는 건
    // JVM에서 수행한다는 이양기
    // java가 자동 실행해주는 유일한 메소드
    // void main(String[])
	public static void main(String[] args) {
		for (int i=0; i<args.length; i++) {
			System.out.println("args["+i+"]:"+args[i]);
		}
		
		
		Car car = new Car();
		System.out.println( car.speed );
		
		car.setSpeed(200);
		System.out.println( car.speed );
		
		
		boolean gasState = car.isLeftGas();
//		if (car.isLeftGas()) 아래와 같은것
		if (gasState) {
			System.out.println("출발합니다.");
			car.run();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
