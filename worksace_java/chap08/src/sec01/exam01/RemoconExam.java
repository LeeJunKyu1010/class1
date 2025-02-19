package sec01.exam01;

public class RemoconExam {

	public static void main(String[] args) {
		
		Tv tv = new Tv();
		powerOn(tv);
	}

	static void powerOn(RemoteControl rc) {
		rc.turnOn();
	}
	
}
