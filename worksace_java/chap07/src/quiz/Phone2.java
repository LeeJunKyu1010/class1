package quiz;

public class Phone2 extends Phone {
	
	
	void samsung(String number) {
		if(this.power == true) {
			System.out.println("상태: "+ (power ?"켜짐":"꺼짐"));
			this.call(number);
			this.ball();
		}else {
			System.out.println("상태: "+ (power ?"켜짐":"꺼짐"));
		}
	}
	
	void apple(String number) {
		if(this.power == true) {
			System.out.println("상태: "+ (power ?"켜짐":"꺼짐"));
			this.call(number);
			this.ball();
		}else {
			System.out.println("상태: "+ (power ?"켜짐":"꺼짐"));
		}
	}
	
	
	
	
	
}
