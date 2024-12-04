package sec01.exam01;

import java.util.Scanner;

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
		
		int q1 = 0;
		for (int e = 1; e <= 100; e = e+1) {
			q1 += e;
		}System.out.println("q : "+q1);
		
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
		
		// 다른 방법
		for ( int i8 = 1; i8 <= 20; i8++) {
			if (i8 % 2 == 0)
				System.out.println("다른방법 짝수 :"+i8);
		} 
		
		
		
		
		
		// 1 ~ 20까지 3의 배수만 출력하시오
		for (int i8 = 3; i8 <= 20; i8+=3) {
			System.out.println("3의 배수 :"+i8);
		}
		
		// 다른 방법
		for ( int i8 = 1; i8 <= 20; i8++) {
			if (i8 % 3 == 0)
				System.out.println("다른방법 3의 배수 :"+i8);
		}
		
		
		
		
		// 1 ~ 5까지 모두 출력하면서 홀/짝
				// 1 : 홀수
				// 2 : 짝수
		for (int i8 = 1; i8 <= 5; i8++) {
			if ((i8%2)==0) {
				System.out.println("짝수"+i8);
			}else System.out.println("홀수"+i8);
		}
		// 다른 표기방법
//		String qq = "홀수";
//		if (i8%2 ==0){
//			qq = "짝수";
//		}else System.out.println("홀수");
//		
//		}
		
		
		
		
		
		
		// 1 ~ 20까지 홀수의 합
		int s = 0;
		for (int i8 = 1; i8 <=20; i8= i8+2) {
			s = s + i8;
		}
			System.out.println("1~20까지의 합 :"+s);
		
		
		// 다른 방법
		int qe = 0;
		for ( int i8 = 1; i8 <= 20; i8++) {
			if (i8 % 2 == 1) {
				qe += i8;
		}
		}System.out.println("다른방법 1~20까지의 합 :"+qe);
			
			
			
		
		
			
		// 1 ~ 20까지 홀수의 개수
		
		int cnt = 0;
		for (int i8 = 1; i8 <= 20; i8 = i8 + 2) {
			cnt += 1;
		} 
		System.out.println("홀수의 개수: "+cnt);
		
		
		
		
		
		// 구구단 2단 출력
		//		2 x 1 = 1
		//		2 x 2 = 4
		
		for (int i8 = 1; i8 <= 9; i8++) {	
			System.out.println("2 x "+i8+" = "+(2*i8));
		}	
			
		
		
		// 1 ~ 10까지 옆으로 3개씩 출력
		//			123
		//			456
		//			789
		//			10
		
		for ( int i8 = 1; i8 <= 10; i8++ ) {
			if (i8 % 3 != 0 ) {
				System.out.print(i8+" ");	// 3의 배수가 아닌것
			}else {
				System.out.println(i8+" ");	// 3의 배수면 엔터
			}
		}
		
		// 다른방법
//		for (int i8 = 1; i8 <= 10; i8++) {
//			if ( i8 >= 1 && i8 <= 2) {		// 1~2까지 출력
//				System.out.print(i8);
//			}else if (i8 == 3) {			// 3출력 후 엔터
//				System.out.println(i8);
//			}else if (i8>=4 && i8 <= 5) {	// 4~5까지 출력
//				System.out.print(i8);
//			}else if (i8 == 6) {			// 6출력 후 엔터
//				System.out.println(i8);
//			}else if (i8 >= 7 && i8 <= 8) {	// 7~8까지 출력
//				System.out.print(i8);
//			}else if (i8 == 9) {			// 9출력 후 엔터
//				System.out.println(i8);
//			}else if (i8 == 10) {			// 10출력
//				System.out.println(i8);
//			}
//		}
		System.out.println("");
		
		
		
		
		// 1부터 n까지 합을 구하기 & 짝수 구하기
		
//		Scanner scanner = new Scanner(System.in);
//		int qq = scanner.nextInt();
//		
//		
//		int ww = 0;
//		for ( int ii = 1; ii <= qq; ii++) {
//			ww +=ii;
//		}
//		System.out.println("1 ~ " + qq + "까지의 합은" + ww);
		
		
		
		// 구구단 전부 출력
        
         
//		2단 출력
//		--------
//		3단 출력
		
//	 	for(int q =1 ; q <= 9; q++) {
//	 		System.out.println("2 x " + q + " = " + (2*q));
//	 	}
//			for(int q =1 ; q <= 9; q++) {
//				System.out.println("3 x " + q + " = " + (3*q));
//		}
//
//		int q9 = 2;
//			for(int q =1 ; q <= 9; q++) {
//				System.out.println(q9 + " x " + q + " = " + (q9*q));
//		}
//		for(int q =1 ; q <= 9; q++) {
//	    System.out.println(q +" x " + q + " = " + (q9*q));
//		}
//
//		for(int dan =2; dan <=9; dan++) {
//	    System.out.println(" -- " + dan + "단--");
//
//	    for(int q =1 ; q <= 9; q++) {
//	        System.out.println(dan + " x " + q + " = " + (dan*q));}}
		
		
		
		
		
		
		
//		 다른 방법
//		for ( i = 2; i <= 9; i++) { // i x q (i 2단부터 시작)
//			int q = 0;
//			
//			if ( q == 9 ) {						// q가 9일때 엔터
//				System.out.print("단");
//			}else System.out.println("--"+i+"단--");
//			
//			for (q = 1; q<= 9; q +=1 ) 			// q 9까지
//			System.out.println(i+"x"+q+"="+i*q); 
//		}
		
		
		
		
		
		
		
		// 한줄에 1단식 출력
		// 2x1=2 2x2=4 ...2x9=18
		// 3x1=3 3x2=6 ...3x9=27	
		for (int ss = 2; ss<=9; ss++) {
			
			for (int w = 1; w <=9; w++) {
				System.out.print(ss+"x"+w+"="+w*ss);
				
				if (w == 9) {
					System.out.println("");
				}else System.out.print("\t");
			}
		}
			
		
		
		
		// 두~세 단씩 옆으로 출력
		// 2x1=2 3x1=3
		// ...	  ...
		// 2x9=18 3x9=17
		//
		// 4x1=4 5x1=5
		// ...   ...
		
		
		for (int  q = 2; q == 2; q++) {
			System.out.println("");
			
			for (int w = 3; w == 3; w++ ) {
				for (int e = 1; e <= 9; e++) { 
				System.out.println(q+"x"+e+"="+(q*e)+"\t"+w+"x"+e+"="+w*e);
				
				}
				q+=2;
				w+=2;
				for (int e = 1; e <= 9; e++) {
				System.out.println(q+"x"+e+"="+(q*e)+"\t"+w+"x"+e+"="+w*e);
				}
			}
		}
		
		
		
		System.out.println("2x1=2 3x1=3");
		System.out.println("2x2=4 3x2=6");
		
		
		int k = 1;
		int m = 2;
		int m2 =3;
		System.out.println
		(m+"x"+k+"="+(m*k)+ " "+(m2)+ "x"+k+"="+(m2*k)+"");
		System.out.println
		(m+"x"+k+"="+(m*k)+ " "+(m+1)+ "x"+k+"="+((m+1)*k)+"");
		
		k++;
		System.out.println
		(m+"x"+k+"="+(m*k)+ " "+(m+1)+ "x"+k+"="+((m+1)*k)+"");
		
		k++;
		System.out.println
		(m+"x"+k+"="+(m*k)+ " "+(m+1)+ "x"+k+"="+((m+1)*k)+"");
		
		// 2,3단 출력
		// 시작 : 1
		// 종료 : 9
		
		// 2~3단
		for (int k2= 1; k2 <=9; k2++) { 
			System.out.println
			(m+"x"+k2+"="+(m*k2)+ " "+(m+1)+ "x"+k2+"="+((m+1)*k2)+"");
		}
		//4~5단
		m += 2;
		for (int k2= 1; k2 <=9; k2++) {	
			System.out.println
			(m+"x"+k2+"="+(m*k2)+ " "+(m+1)+ "x"+k2+"="+((m+1)*k2)+"");
		}
		//6~7단
		m += 2;
		for (int k2= 1; k2 <=9; k2++) {	
			System.out.println
			(m+"x"+k2+"="+(m*k2)+ " "+(m+1)+ "x"+k2+"="+((m+1)*k2)+"");
		}
		
		//8~9단
		m += 2;
		for (int k2= 1; k2 <=9; k2++) {	
			System.out.println
			(m+"x"+k2+"="+(m*k2)+ " "+(m+1)+ "x"+k2+"="+((m+1)*k2)+"");
		}
			
		System.out.println();
		
		
		
		// 시작 : 2
		// 종료 : 9
		for(int p = 2; p <= 9; p += 2) {
			for (int k2= 1; k2 <=9; k2++) {	
				System.out.println
				(p+"x"+k2+"="+(p*k2)+ "\t"+(p+1)+ "x"+k2+"="+((p+1)*k2)+"");
			}
		}
		
		
		
		// 0단계
		/*
		 
		 +
		 +
		 +
		 +
		 +
		 
		 */
		System.out.println("0단계");
		
		for (int q = 1; q<= 5; q++) {
			
			System.out.println("+");
		}
		
		// 1단계
		/*
		 
		 +++++
		 
		 */
		System.out.println("1단계");
		
		for (int q = 1; q<= 5; q++) {
			
			System.out.print("+");
		}
		
		
		
		
		
		System.out.println();
		
		// 2단계
		/*
		 
		 +++++
		 +++++
		 +++++
		 
		 */
		System.out.println("2단계");
		
		for (int q = 1; q <= 3; q++) {
			
			for (int w = 1; w<=5; w++) {
				System.out.print("+");
			}
					System.out.println();
		}
		
		
		
		
		
		System.out.println();
		
		
		// 3단계
		/*
		 
		 +.+.+.+.+.
		 
		 */
		System.out.println("3단계");
		for (int q =1; q<=5; q++) {
			for(int w = 1; w<=1; w++) {
				System.out.print("+");
			}
			System.out.print(".");
		}
		System.out.println();
		
		// 4단계
		/*
		 
		 +
		 ++
		 +++
		 ++++
		 +++++
		 
		 */
		
		
		
//		for (int q = 1; q<= 1; q++) {
//			
//			System.out.print("+");
//		}
//		System.out.println();
//		for (int q = 1; q<= 2; q++) {
//			
//			System.out.print("+");
//		}
//		System.out.println();
//		for (int q = 1; q<= 3; q++) {
//			
//			System.out.print("+");
//		}
//		System.out.println();
//		for (int q = 1; q<= 4; q++) {
//			
//			System.out.print("+");
//		}
//		System.out.println();
//		for (int q = 1; q<= 5; q++) {
//			
//			System.out.print("+");
//		}
//		
//----------------------------------------------------
//		int a = 1;
//		for (int q = 1; q <= a; q++) {
//			
//			System.out.println("+");
//			
//			
//		}
//		a++;
//		for (int q = 1; q <= a; q++) {
//			
//			System.out.println("+");
//			
//			
//		}
//
//		a++;
//		for (int q = 1; q <= a; q++) {
//			
//			System.out.println("+");
//			
//			
//		}
//		System.out.println("3.5단계");
//		int a =1;
//		for (a = 1; a<=5; a++) {
//			
//			for (int q = 1; q <= a; q++) {
//						
//						System.out.print(a);
//						
//					}System.out.println("");
//		}
		System.out.println("4단계");
		int a =1;
		for (a = 1; a<=5; a++) {
			
			for (int q = 1; q <= a; q++) {
						
						System.out.print("+");
						
					}System.out.println("");
		}
		
		// 5단계
		/*
		 
		 +____
		 ++___
		 +++__
		 ++++_
		 +++++
		 
		 */
		
		
		
		
		
		// 6단계
		/*
				 
		____+
		___++
		__+++
		_++++
		+++++
				 
		*/		
		
		
		
		
		// 7단계
		/*
		 
		 ____+
		 ___+++
		 __+++++
		 _+++++++
		 +++++++++
		 
		 */

		// 8단계
		/*
		 
		 ____+____
		 ___+++___
		 __+++++__
		 _+++++++_
		 +++++++++
		 
		 */

		// 9단계
		// 입력 받은 만큼 출력
		
		
		// Pyramid 에 따로 적음
		
		
		
		
		
		
		
		
		
		
		
		// 주사위 두개로 나올 수 있는 모든 조합 출력
		/*
		 2 : [1,1]
		 3 : [1,2]  [2,1]
		 4 : [1,3]	[2,2] [3,1]
		 */
		
		
		
		
		
		
		
		// 중복을 제거한 경우의 수
		/*
		 	2 : 1가지
		 	3 : 1가지
		 	4 : 2가지
		 */
		
		
		int x = 1;
		
		for (x = 1; x<5; x++) {
			
		}
		System.out.println(x);
		
		
		
		
		
		
		
		
	}

}
