package sec01.exam01;

public interface RemoteControl {
	
	// 상수
	public static final int MIN_VOLUME = 0;
	int MAX_VOLUME = 10;

	// 추상 메소드
	public abstract void turnOn();
	void turnOff();
	void setVolume(int vol);
	
	default void mic(String text) {
		
	}
	
}
