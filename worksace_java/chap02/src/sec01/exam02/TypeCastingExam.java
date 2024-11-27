package sec01.exam02;

public class TypeCastingExam {

	public static void main(String[] args) {{
		
		// int를 long 으로 형 변환
		int a = 2 + (3 * 4);	// 여기서 ()는 우선순위
		long b = (long)a;		// 여기서 ()는 형변환 연산자
		// int가 long 보다 작으니까 형 변환해도 손해가 없다.
		// 형 변환 연산자 생략 가능
		long c = a;
		
		long d = 3000000000L;
		int e = (int)d;
		System.out.println("e : " + e);
		// long을 int로 변환 하는 경우
		// 8byte 중에서 상위 4byte만 남기기 때문에
		// 예측 하지 못한 값이 나올 수 있어서 
		// 생략 불가능
		
		long f = 10;
		/*
		 * int ii = 10;
		 * long f = (long)ii;
		 * long f = ii;
		 */
		
		
		int g = 3;
		long h = 4L;
		long i = (long)g + h;
		long i2 = g + h;		// long을 생략 가능하다
		
		double j = 3.3;
		double k = (double)g + j;
		double k2 = g + j;	// double을 생략 가능하다
		System.out.println("(double)g : " + (double)g);
		
		int g2 = (int)j;
		System.out.println("(int)j : " + (int)j);
		
		
		// total(단위 만원)은 회식비입니다.
		// count 참석인원 입니다.
		// 주최자가 만원 이하는 쏘기로 했습니다.
		// 이때 인당 얼마를 내야하는지 출력 하시오.
		double total = 4.3;
		int count = 4;
		
		double d_result = total / (double)count;
		// count가 int이므로 double로 변경 후 total과 나누기
		int i_result = (int)d_result;
		// d_result가 double이므로 int로 변경하여 소수점 자리 없애기
		System.out.println(i_result);}
		
		/*
		 * 1. 내 나이 : int
		 * 2. 운전면허 보유 여부 : boolean
		 * 3. 우리집의 스마트폰 개수 : int
		 * 4. 내 이름 : String
		 * 5. 소수점까지의 온도 : double
		 * 6. 1.2999 와 1.3이 같은가? : boolean
		 * 7. 1평이 3.3제곱미터 : double
		 * 
		 */
		
		
		// 깜짝 퀴즈
		// 그럼 주최자는 얼마를 내야 하는가?
		/*
		 * 전체 금액에서 한명당 내야 하는 금액
		 * int 한명당 = 10000원
		 * 
		 * 
		 * 
		 */
		// 진짜 문제
		/*
		 * String a = "수박";
		 * String b = "볼링공";
		 * 
		 * // a = "볼링공" 이런거 금지
		 * 
		 * System.out.println ( a ); // "볼링공"
		 * System.out.println ( b ); // "수박"
		 */
		
		String a = "수박";
		String b = "볼링공";
		
		
		
		System.out.println(a);
		System.out.println(b);
		
	
		
	}

}
