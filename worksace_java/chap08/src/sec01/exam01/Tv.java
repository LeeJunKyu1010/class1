package sec01.exam01;

public class Tv implements RemoteControl, Searchable{

	int vol;
	
	@Override
	public void turnOn() {
		System.out.println("tv를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("tv를 끕니다");
	}

	@Override
	public void setVolume(int vol) {
//		int a1 = RemoteControl.MIN_VOLUME;

//		if(vol < RemoteControl.MIN_VOLUME) {
//			System.out.println("0~10 사이 값을 입력하세요");
//		}else if(vol > RemoteControl.MAX_VOLUME) {
//			System.out.println("0~10 사이 값을 입력하세요");			
//		}else {
//			this.vol = vol;
//			System.out.println(vol+"로 볼륨을 바꿉니다");
//		}

		
		if(vol < RemoteControl.MIN_VOLUME)vol = RemoteControl.MIN_VOLUME;
		if(vol > RemoteControl.MAX_VOLUME)vol = RemoteControl.MAX_VOLUME;
		
		this.vol = vol;
	}

	@Override
	public void search(String text) {
		System.out.println("TV로"+text+"를 검색하는중...");
	}

}
