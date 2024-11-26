package sec01.exam02;

public class VarTypeExam {

	public static void main(String[] args) {
		
		byte b = 127;
		// byte가 127byte까지 여서 b에 128byte을 넣어도 안됨
		//b = 128;
		
		//byte b1 = 100;
		//byte b2 = 80;
		//b = b1 + b2;
		
		long l1 = 10;
		long l2 = 20L;
		
		//long l3 = 10000000000;
		long l3 = 10000000000L;
		
		
		char c1 = 'A';
		System.out.println("C1 : " + c1);
		
		char c2 = 67;
		System.out.println("C2 : " + c2);
		System.out.println("C2-C1 = " + (c2-c1));
		
		char c3 = 'a';
		System.out.println("C3-C1 = " + (c3-c1));
		// 대문자와 소문자의 차이는 32이다.
		
		// ""는 문자열이다.
		String s1 = "이준규";
		System.out.println("s1 : " + s1);
		
		
		// ""를 출력 하려면 \을 사용 하면 된다
		String s2 = "\"이준규\"";
		System.out.println("s2 : "+s2);
		
		
		// \t 탭
		String s3 = "번호\t이름";
		String s4 = "번호2\t이름";
		System.out.println("s3 : "+ s3);
		System.out.println("s4 : "+ s4);
		
		
		// \n (엔터)줄바꿈
		String s5 = "홍길동\n김자바";
		System.out.println("s5 : "+ s5);
		
		System.out.print(1);
		System.out.print(2);
		System.out.println(3);
		
		
		// double 소수점 16번째 자리까지 정확함
		// 이후는 반올림되어 정확하지않다.
		double d = 0.1234567890123456789;
		System.out.println("d = " + d);
		
		// float 소수점 7번째 자리까지 정확함
		// 이후는 반올림되어 정확하지않다.
		// f를 붙여야 된다.
		float f = 0.1234567890123456789f;
		System.out.println("f = " + f);
		
		
		// 참과 거짓짓
		boolean b1 = true;
		boolean b2 = false;
		
		
		
		
		
	}

}
