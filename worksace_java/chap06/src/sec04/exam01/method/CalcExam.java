package sec04.exam01.method;

public class CalcExam {

	// 전달인자 선언의 ()
	public static void main(String[] args) {
		
		Calc calc = new Calc();
		
		calc.powerOn();   // 실행의 ()
		System.out.println("calc.isOn : "+calc.isOn);
		
		calc.powerOff();
		System.out.println("calc.isOn : "+calc.isOn);
		
		
		
		// 더하기
		int b = 7;
		int a = calc.plus(b, 10);
		
		System.out.println(a);
		
		
		
		// 나누기
		int y = 10;
		double x = calc.divide(y,4);
		
		System.out.println(x);
		
		// 배열 1개
		Calc[] d = new Calc[10];
		d[0] = new Calc();
		
		
		// 배열 2개
		Calc[] w = {new Calc(),new Calc()};
		
		boolean d0 = d[0].isOn;
		
		
		int[] f = {1,2,3,4,5};
		int f1 =calc.sum1(f);
		
		System.out.println("f1 : "+f1);
		
		
		
		int f2 = calc.sum2(f);
		int f3 = calc.sum2(1,2,3,4,5);
		System.out.println("f2 : "+f2);
		System.out.println("f3 : "+f3);
		
		
		
	}

}
