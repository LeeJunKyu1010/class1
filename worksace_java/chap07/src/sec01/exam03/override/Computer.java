package sec01.exam03.override;

public class Computer extends Calc {
	
	@Override // 부모에 해당하는 메소드가 동일하게 있는지 검증
	int plus(int a, int b) {
		int result = a + b;
		System.out.print("답:");
		System.out.println(result + "입니다.");
		return result;
	}
	
	@Override
	double areaCircle(double r) {
		System.out.println("Computer의 areaCircle실행");
		return Math.PI * r * r;
	}
	
}
