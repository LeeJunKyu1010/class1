package sec02.exam01;

public class Landrover extends Car{

	@Override
	protected void drive() {
		System.out.println("레인지로버 를 운전합니다");
	}
	
	void autoRun() {
		System.out.println("자율주행을 시작합니다");
	}
	/* 이순으로 강력하다 사용가능
	 * public
	 * protected
	 * default
	 * private
	 */
	
}
