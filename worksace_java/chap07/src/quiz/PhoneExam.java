package quiz;

public class PhoneExam {

	public static void main(String[] args) {

		Phone2 a = new Phone2();
//		
//		a.onOff();
//		System.out.println("상태: " + (a.power ? "켜짐":"꺼짐"));
//		
//		a.onOff();
//		System.out.println("상태: " + (a.power ? "켜짐":"꺼짐"));
		
		a.onOff();
		
		a.samsung("010-9999-9999");
		
		System.out.println("------------------");
		
		a.onOff();
		
		a.apple("010-1234-6789");
		
		
		
		
	}

}
