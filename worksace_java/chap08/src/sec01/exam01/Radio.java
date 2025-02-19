package sec01.exam01;

public class Radio implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("Power ON");
	}

	@Override
	public void turnOff() {
		System.out.println("Power OFF");
	}

	@Override
	public void setVolume(int vol) {
		if(vol > RemoteControl.MAX_VOLUME) {
			vol = RemoteControl.MAX_VOLUME;
		}else if(vol < RemoteControl.MIN_VOLUME) {
			vol = RemoteControl.MIN_VOLUME;
		}else {
			System.out.println(vol+"volume setting");
		}
	}

}
