package sec01.exam01;

import java.util.Scanner;

public class BreakEaxm {

	public static void main(String[] args) {
		
		
		// while 문에서 break
		
		System.out.println("시작");
		
		int q = 0;	// 개수
		while (true) {
			
			q+=1;// 개수
			
			int num = (int)(Math.random()*6)+1; // num이 1~6 까지
			System.out.println(num);			// num의 값
			
			if (num == 6) {	// num가 6일때 멈춤
//				q--;	// 6을 제외하고 카운트 할때
				break;
				
			}
		}
		System.out.println("종료");
		System.out.println("총: "+q+"회");
		
		
		
		
		for ( q = 1; 1<= 10; q+=2) {
			System.out.println(q);
			
			if (q >= 5) {	// 혹시 몰라서 >= 사용
				break;
			}
		}
		
		
		
		
//		for (int i=0; i<5; i++) {
//			System.out.println("i :"+i);
//			
//			for (int j=0; j<30; j++) { 
//				
//				if (j >= 2) {	// j가 2이상일때 break
//					break;
//				}
//				System.out.println("j :"+j);
//				
//			}
//			
//			System.out.println();
//		}
		
		
		
		
		boolean  isStop = false;
		for (int i=0; i<5; i++) {
			System.out.println("i :"+i);
			
			for (int j=0; j<30; j++) { 
				
				if (j >= 2 ) {	// j가 2이상일때 break
					isStop = true;  // 직전에 true 인것을 만듬
					break;
					
				}
				
				System.out.println("j :"+j);
				
			}
			if (isStop) { // isStop이 true일때 break
				break;
			}
			System.out.println();
		}
			
		
		
		
		System.out.println("------------"); // 위와 아래 분리
		
		
		
		
		for (int i=1; i<=10; i++) {
			if(i % 2 == 0 ) {	// 짝수
				System.out.println(i);
			}
		}
		
		
		
		
		System.out.println("------------"); // 위와 아래 분리
		
		
		
		
		for (int i=1; i<=10; i++) {
			if(i % 2 != 0 ) {	// 홀수
				continue;		// pass (홀수를 패스하여 짝수가 나옴)
			} 
			System.out.println(i);
		}
		
		
		/*
		 *  1. 예금
		 *  예금액이 음수 불가
		 *  
		 *  2. 출금
		 *  출금액이 음수 불가
		 *  잔고보다 큰 금액 불가
		 *  
		 *  
		 */
		
		Scanner scan = new Scanner(System.in);
		int balance = 0;
		
		
		
		do {
			System.out.println("-------------------");
			System.out.println("1.예금 | 2.출금| 3.잔고 | 4.종료");
			System.out.println("-------------------");
			int menu = scan.nextInt();
			
			if (menu == 1) {	// 입금액
				System.out.println("예금액 : ");
				int input = scan.nextInt(); // 예금액 스캔
				if (input > 0) {	// 예금액이 0보다 크면
					balance += input;	// 잔고에 예금액을 더하기
				}else {
					System.out.println("예금액을 확인해주세요");
					// 0보다 작게 입금하면 
				}
			} else if (menu == 2) { // 출금액
				System.out.println("출금액 : ");
				int output = scan.nextInt(); // 출금액 스캔
				if (output < 0 || balance < output) { // 출금액이 0보다 크거나 잔고보다 클때
					System.out.println("출금액을 확인해주세요");
				}else {
					System.out.println("출금액 : "+ output); // 출금액
					balance -= output; // 잔고액 - 출금액
					System.out.println("출금 후 잔액 : "+ balance );// 출금후 잔액
				}
			}else if (menu == 3) { // 잔액
				System.out.println("잔액 : "+ balance); // 잔액
			}else if (menu == 4) { // 거래종료
				System.out.println("거래종료");
				break;
			}
		}while( true );
		
		
		
		
		

	}

}
