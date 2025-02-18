package quiz2;

public class Phone2 extends Phone{

	

	void callback(String number) {
		System.out.println(number+" 전화가 왔습니다");
	}
	
	void SMS(String number, String msg) {
		System.out.println(number +"로 "+ msg+ " 나는 문자를 보낸다");
	}
}
