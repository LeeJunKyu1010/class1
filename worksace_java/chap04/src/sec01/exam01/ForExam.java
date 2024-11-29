package sec01.exam01;

public class ForExam {

	public static void main(String[] args) {
		
		int sum = 0;
		
		// 1씩 증가 하는것을 5번 하고 싶다.
		sum = sum + 1;
		sum = sum + 1;
		sum = sum + 1;
		sum = sum + 1;
		sum = sum + 1;
		System.out.println("sum : "+sum);
		
		
		// 1 + 2 + 3 + 4 + 5
		// 참고로 1~n까지의 합
		// n*(n+1) / 2
		sum = 0;
		sum = sum +1;
		sum = sum +2;
		sum = sum +3;
		sum = sum +4;
		sum = sum +5;
		System.out.println("sum : "+sum);
		
		int i = 1;
//		int i = 0;
		sum = 0;
		
		sum = sum + i; // 1
		
		i++;
		sum = sum + i; // 2
		
		//3
		i++;
		sum = sum + i; // 3
		
		i++;
		sum = sum + i; // 4
		
		i++;
		sum = sum + i; // 5
		
		System.out.println("sum : "+sum);
		
		/*
		 * 반복문을 만드는 원리
		 * 
		 * 1. 반복 되는 것 찾기
		 * 			Ctrl + c, v 했을때 바뀌지 않는 것
		 * 
		 * 
		 * 2. 반복 되지 않는 것 찾기
		 * 		규칙 (패턴)을 찾을 수 있으면 반복문으로 만들 수 있다.
		 * 		변수를 활용해서 더이상 바뀌지 않게 만들기
		 * 
		 * 
		 * 3. 시작 조건
		 * 
		 * 4. 종료 조건
		 * 
		 * for : 반복 횟수를 아는 경우
		 * 
		 * while : 반복 횟수를 모르는 경우
		 * 
		 */
		
		int sum2 = 0;
		for (int e = 1; e <= 5; e++) {
			sum2 = sum2 + e;
		}
		System.out.println("sum2 : "+sum2);
		
		int sum3 = 0;
		for (int e = 1; e <= 5; e++) {
			System.out.println("e :"+e);
			sum3 = sum3 + e;
			System.out.println("sum3 : "+sum3);
		}
		System.out.println("sum3 : "+sum3);
		
		
		// 1~10까지 출력
		
		for (int e = 1; e <= 10; e++) {
			System.out.println(e);
		}
		
		
		//1 + 2 + 3 + ... +100을 구하시오
		// 항이 많을 경우 항 별로 결과를 변수에 담아본다
		
		int q = 0;
		for (int e = 1; e <= 100; e = e+1) {
			q += e;
		}System.out.println("q : "+q);
		
		int sum5 = 1;
		sum5 = sum5 +2;
		sum5 = sum5 +3;
		sum5 = sum5 +4;
		
		
		int sum6 = 0;
		int i5 = 1;
		sum6 = sum6 +i5;
		i5 = i5 +1;
		sum6 = sum6 +i5;
		i5 = i5 +1;
		sum6 = sum6 +i5;
		i5 = i5 +1;
		sum6 = sum6 +i5;
		i5 = i5 +1;
		sum6 = sum6 +i5;
		
		
		int sum7 = 0;
		for (int i6 = 1; i6 <= 100; i6 +=1) {
			sum7 = sum7 +i6;
		}
		System.out.println(sum7);
		
		
		// 깜짝퀴즈
		// 10 ~ 1 출력하시오
		
		
		for (int i7 = 10; i7 >= 1; i7-=1) {
			
			System.out.println("i7 :"+i7);
		}
		
		
		
		
		
		
		
		
		
		// 1 ~ 20까지 짝수만 출력하시오
		for (int i8 = 2; i8 <= 20; i8 +=2 ) {
			System.out.println("짝수 :"+i8);
		}
		
		
		
		// 1 ~ 20까지 3의 배수만 출력하시오
		for (int i8 = 3; i8 <= 20; i8+=3) {
			System.out.println("3의배수 :"+i8);
		}
		
		
		
		
		
		
		// 1 ~ 5까지 모두 출력하면서 홀/짝
				// 1 : 홀수
				// 2 : 짝수
		for (int i8 = 1; i8 <= 5; i8++) {
			if ((i8%2)==0) {
				System.out.println("짝수"+i8);
			}else System.out.println("홀수"+i8);
		}
		
		
		// 1 ~ 20까지 홀수의 합
		int s = 0;
		for (int i8 = 1; i8 <=20; i8= i8+2) {
			s = s + i8;
		}
			System.out.println("1~20까지의 합 :"+s);
		
			
			// 1 ~ 20까지 홀수의 개수
		
		int cnt = 0;
		for (int i8 = 1; i8 <= 20; i8 = i8 + 2) {
			cnt += 1;
		} 
		System.out.println("홀수의 개수: "+cnt);
		
		
		
		
		// 1 ~ 10까지 옆으로 3개씩 출력
		//			123
		//			456
		//			789
		//			10
		
		for (int i8 = 1; i8 <= 10; i8++) {
			if ( i8 >= 1 && i8 <= 2) {		// 1~2까지 출력
				System.out.print(i8);
			}else if (i8 == 3) {			// 3출력 후 엔터
				System.out.println(i8);
			}else if (i8>=4 && i8 <= 5) {	// 4~5까지 출력
				System.out.print(i8);
			}else if (i8 == 6) {			// 6출력 후 엔터
				System.out.println(i8);
			}else if (i8 >= 7 && i8 <= 8) {	// 7~8까지 출력
				System.out.print(i8);
			}else if (i8 == 9) {			// 9출력 후 엔터
				System.out.println(i8);
			}else if (i8 == 10) {			// 10출력
				System.out.println(i8);
			}
		}
		
		
		
		
		
		// 구구단 2단 출력
		//		2 x 1 = 1
		//		2 x 2 = 4
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
