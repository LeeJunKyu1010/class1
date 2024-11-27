package sec02.Exam04;

public class OpExam {

	public static void main(String[] args) {
		
		
		
		boolean a = false;
		System.out.println("a : "+a);
		
		a = !a;
		
		System.out.println("a : "+a);
		
		double b = 7.0;
		System.out.println(b / 3);
		
//		System.out.println(b / 0);
		// double을 0으로 나누면 infinity 에러

//		System.out.println(3 / 0);
		//int를 0으로 나누면 에러
		
		
		int c = 54545351;
		int d = 5;
		System.out.println("몫 : "+ (c/d));
		System.out.println("나머지 : "+ (c%d));
		
		// 10000원이 있음 라떼 4500원 몇잔 마실 수 있나
		
		int q = 10000;
		int w = 4500;
		System.out.println("라떼 "+ q/w+"잔");
		System.out.println("거스름돈 :"+ q%w+"원");
		
		
		// 조금 어려운 문제
		// 올리브영에서 전품목 15% 세일
		// 1. 꿀홍차 (5000)을 삿을때 얼마를 내야 하나?
		// 2. 꿀홍차 (5000)와 립스틱(30000)을 사면 얼마를 내야 하는가?
		
		int e = 5000; // 꿀홍차
		double honey = e*1 - (e*0.15);
		System.out.println("꿀홍차 세일 :"+honey);
		int r = 30000; // 립스틱
		int ee = e+r; // 꿀홍차와 립스틱 더한 값
		double t = ee * 0.15; // 전품목 15% 세일
		int y = (int)t; // double로 바꿧던 더한값을 다시 int로 변경
		int u = e - y; // int로 변경했던 꿀홍차 - 15%세일 할인금액
		int i = u + r; // 할인 금액 + 립스틱
		System.out.println("올리브영 내야할 돈 :"+i+"원"); // 결과값
		
		
		// 7234원이 있다.
		// 5000, 1000, 500, 100, 50, 10, 1원
		// 각각 최대 몇개까지로 표한 할 수 있는가?
		int money1 = 7234;
		int cnt5000 = money1 / 5000;	// 1
		System.out.println("5000원 :"+cnt5000);
//		
		money1 = money1 - cnt5000;
//		int money2 = money1 - (cnt5000*5000); /2234
		int money2 = money1 % 5000; //2234
		int 천원 = money2 / 1000;
		System.out.println("1000원 :"+천원);
		money2 = money2 % 1000;
		
		int m500 = money2 / 500;
		System.out.println("500원 :"+ m500);
		money2 = money2 % 500;
		
		int m100 = money2 / 100;
		System.out.println("100원 :"+ m100);
		money2 = money2 % 100;
		
		int m50 = money2 / 50;
		System.out.println("50원 :"+ m50);
		money2 = money2 % 50;
		
		int m10 = money2 / 10;
		System.out.println("10원 :"+ m10);
		money2 = money2 %10;
		
		System.out.println("1원 :"+ money2);
		
		
		char c1 = 'A';
		c1 = (char)(c1+1);
		System.out.println(c1);
		
		// 문자 + 숫자를 사용하면
		// 숫자를 문자로 바꿔준다.
		System.out.println(""+3+3.0);
		
		
		// int c3 = Integer.parseInt(c2);를 사용하면
		// 문자를 숫자로 바꿔준다.
		String c2 = "100";
		int c3 = Integer.parseInt(c2);
		System.out.println(c3+3);
		
		boolean bool = 3 > 5;
		System.out.println(bool);
		
		System.out.println( 1 == 1);
		System.out.println( 1 == 1.0);
		System.out.println("소수점");
		System.out.println( 0.1 == 0.1f);
		// 소수점 이하는 정확 하지 않아서
		// 0.1을 0.99999999 또는 0.100000001으로 처리 할 수 있기 때문에
		// 같은 타입으로 변환해서 비교하자
		System.out.print("형변환 :");
		System.out.println( (float)0.1 == 0.1f);
		
		
		
		System.out.println('C' < 'J');  // '' char 값으로 계산했다.
//		System.out.println( "ab" < "ac"); "" String 값으로 계산했다.
		
		
		System.out.println("3 != 3 : "+ (3 != 3));
		
		
		
		String s1 = "이준규";
		String s2 = "이준규";
		System.out.println(s1 == s2);
		// 글씨 비교는 == 사용금지
		System.out.println(s1.equals(s2) ); 	// 같은 값
		System.out.println(!s1.equals(s2) );    // !를 붙이면 같지 않다.
		// String 변수 또는 "글씨".equals(비교값)
		
		int i1 = 87;
		System.out.println(i1+"은 B학점인가?");
		
		// &&는 AND 이다. i1이 80보다 크고 i1이 90보다 작다.
		System.out.println(
			(i1 >= 80) && (i1 < 90)
				);
		
		// ||는 or 이다. i1이 80보다 크고 i1이 90보다 작다.
		System.out.println(
				(i1 >= 80) || (i1 < 90)
				);
		
		
		System.out.println(10 | 1);
		System.out.println(10 | 3);
		
		
		int k1 = 7;
		int k2 = 15;
		int k3 = 17;
		System.out.print("k3이 가장 큰 값인가? : " );
		// k3가 k1보다도 크거나"고"
		// k3가 k2보다도 크거나 같으면
		// k3는 가장 크다.
		System.out.println(
				(k3 >= k1) && (k2 <= k3)
				);
		
		int m1 = 5;
		m1 = m1 + 2;
		m1 += 2; // 위에 공식과 동일하다.
		
		
		
		int n1 = 10;
		n1 += 1;		// n1 + 1 = n1 과 같다.
		n1++; 			// n1에 1을더한다.
		++n1;			// n1에 1을더한다.
		n1 -= 1;		// n1 - 1 = n1 과 같다.
		n1--;			// n1에 1을 뺀다.
		--n1;			// n1에 1을 뺀다.
		System.out.println(n1);
		
		int n2 = 10;
		System.out.println("n2 :" + (++n2) );
		System.out.println("n2 :" + (n2++) );
		// n2 == 12
		System.out.println("n2 :" + n2 );
		
		
		int x = 1;
		int yy = 1;
		
		int xx = ++x + 10;	// 12
		int yyy = yy++ + 10;	// 11
		
		System.out.println("xx :" + xx);
		System.out.println("yyy :"+yyy);
		
		int z = 1;
		//					1 + 3
//		System.out.println( z++ + ++z      );
		
		int z1 = z;
		z = z + 1;
		
		z = z + 1;
		int z2 = z;
		
		System.out.println( z1 + z2      );
		System.out.println(z);
		
		
		// 삼항 연산자
		int score = 95;
		char grade = (score > 90) ? 'A' : 'B';
		
		System.out.println(grade);
		
		
		
		
		int var1 = 5;
		int var2 = 2;
		double var3 = var1 % var2;
		int var4 = (int)(var3 * var1);
		System.out.println(var4);
				
		int value = 356;
		System.out.println(value);
		
		
		
		
		
	}

}
