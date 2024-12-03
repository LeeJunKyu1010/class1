package sec01.exam01;

public class LottoEaxm {

	public static void main(String[] args) {
		
		// 로또 : 1~45의 숫자중
		// 중복되지 않은 수 6개 고르기
		
		double rand = Math.random();
		/*
		 * 0이상 1미만
		 */
		
		
		rand = Math.random();		// 0 ~ 0.999999999
		double temp1 = rand * 45;	// 0 ~ 44.9999999999
		int temp2 = (int)temp1;		// 0 ~ 44
		int lotto1 = temp2 + 1;		// 1 ~ 45
		
		System.out.println(lotto1);
		
		rand = Math.random();		// 0 ~ 0.999999999
		double temp12 = rand * 45;	// 0 ~ 44.9999999999
		int temp22 = (int)temp12;		// 0 ~ 44
		int lotto12 = temp22 + 1;		// 1 ~ 45
		
		System.out.println(lotto12);
		
		rand = Math.random();		// 0 ~ 0.999999999
		double temp122 = rand * 45;	// 0 ~ 44.9999999999
		int temp222 = (int)temp122;		// 0 ~ 44
		int lotto122 = temp222 + 1;		// 1 ~ 45
		
		System.out.println(lotto122);
		
		rand = Math.random();		// 0 ~ 0.999999999
		double temp1222 = rand * 45;	// 0 ~ 44.9999999999
		int temp2222 = (int)temp1222;		// 0 ~ 44
		int lotto1222 = temp2222 + 1;		// 1 ~ 45
		
		System.out.println(lotto1222);
		
		
		rand = Math.random();		// 0 ~ 0.999999999
		double temp12222 = rand * 45;	// 0 ~ 44.9999999999
		int temp22222 = (int)temp12222;		// 0 ~ 44
		int lotto12222 = temp22222 + 1;		// 1 ~ 45
		
		System.out.println(lotto12222);
		
		
		rand = Math.random();		// 0 ~ 0.999999999
		double temp122222 = rand * 45;	// 0 ~ 44.9999999999
		int temp222222 = (int)temp122222;		// 0 ~ 44
		int lotto122222 = temp222222 + 1;		// 1 ~ 45
		
		System.out.println(lotto122222);
		
		
		
		
		

	}

}
