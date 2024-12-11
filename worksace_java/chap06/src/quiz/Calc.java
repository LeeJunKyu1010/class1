package quiz;

public class Calc {
	
	// + - * / %
	// 각각 메소드 만들기
	
	/**
	 * compute
	 * 
	 * @param int Number, String 오칙연산자 double Number
	 * @return 
	 * 
	 */
	
	
	// 더하기
	double plus(double x, double y) {
		return x + y;
	}
	
	// 빼기
	double minus(double x, double y) {
		return x - y;
	}
	
	// 곱하기
	double x (double x, double y) {
		return x * y;
	}
	
	// 나누기
	double divide (double x, double y) {
		return x / y;
	}
	
	// 나머지
	double qq (double x, double y) {
		return x % y;
	}
	
	
	// String이 "+"일때 plus를 사용한다.
	// String이 "-"일때 minus를 사용한다.
	// String이 "*"일때 x를 사용한다.
	// String이 "/"일때 divide를 사용한다.
	// String이 "%"일때 qq를 사용한다.
	 
	
	double compute(double x, String z, double y){
		double q = 0;
		if (z.equals("+")) {
			q = this.plus(x, y);	// z가 +일때 plus를 사용하여 더하기
		}else if (z.equals("-")) {
			q = this.minus(x, y);	// z가 -일때 minus를 사용하여 빼기
		}else if (z.equals("*")) {
			q = this.x(x, y);		// z가 *일때 x를 사용하여 곱하기
		}else if (z.equals("/")) {
			q = this.divide(x, y);	// z가 /일때 divide를 사용하여 나누기
		}else if (z.equals("%")) {
			q = this.qq(x, y);		// z가 %일때 qq를 사용하여 나머지를 계산
		}else {
			System.out.println("+, -, *, /, % 중 입력하세요");
		}
		return q;
	}
	
	
	
}
