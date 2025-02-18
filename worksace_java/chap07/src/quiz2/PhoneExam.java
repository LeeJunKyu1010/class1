package quiz2;

public class PhoneExam {

	public static void main(String[] args) {
		Phone a1 = new Phone("010-1234-5678");
		Phone a2 = new Phone2("010-0000-1234");
		Phone a3 = new SmartPhone("010-9999-9999");
		
		
		a1.Call();
		a1.EndCall();
		
		System.out.println("-------------");
		
		a2.Call();
		a2.EndCall();
		((Phone2) a2).SMS();
		
		System.out.println("-------------");
		
		a3.Call();
		a3.EndCall();
		((Phone2) a3).SMS();
		((SmartPhone) a3).in();
		
		
		
		
		
		
		
		
		
		
	}

}
