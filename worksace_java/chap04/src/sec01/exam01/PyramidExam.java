package sec01.exam01;

public class PyramidExam {

	public static void main(String[] args) {
		
		// 0단계
		/*
		 
		 +
		 +
		 +
		 +
		 +
		 
		 */
		
//		System.out.println("+");
//		System.out.println("+");
		System.out.println("------0단계------");
		
		for (int i=1; i<=5; i++) {
			System.out.println("+");
		}
		
		
		
		
		// 1단계
		/*
		 
		 +++++
		 
		 */
		System.out.println("------1단계------");
		
		for (int i=1; i<=5; i++) {
			System.out.print("+");
		}
		
		
		
		
		
		// 2단계
		/*
		 
		 +++++
		 +++++
		 +++++
		 
		 */
		System.out.println();
		System.out.println("------2단계------");
		
		for (int i=1; i<=3; i++) {		// 3번 반복
			for (int j = 1; j<=5; j++) {	//5번 반복
			System.out.print("+");
			}
		System.out.println();
		}
		
		
		
		
		// 3단계
		/*
		 
		 + + + + +
		 
		 */
		System.out.println("------3단계------");
		
		for (int i=1; i<=5; i++) {
			System.out.print("+");
			System.out.print(".");
		}
		
		System.out.println();
		
		// 3.5단계
		/*
		 
		 1
		 22
		 333
		 4444
		 55555
		 */
		System.out.println("------3.5단계------");
		
//		System.out.print(1);
//		System.out.println();
//		
//		System.out.print(2);
//		System.out.print(2);
//		System.out.println();
		
		
		for (int i = 1; i <=5; i++) {
			
			for (int j = 1; j<=i; j++) {
				System.out.print(i);
			}
			System.out.println();
			
		}
		
		
		// 4단계
		/*
		 
		 +
		 ++
		 +++
		 ++++
		 +++++
		 
		 */
		// 첫번째 줄에 + 하나
		// 두번째 줄에 + 2개
		// 세번째 줄에 + 3개 출력 하고 엔터
		System.out.println("------4단계연습------");
		
		
		
		for (int i=1; i<=2; i++) {
			System.out.print("+");
		}
		System.out.println();
		
		
		for (int i=1; i<=3; i++) {
			System.out.print("+");
		}
		System.out.println();
		
		
		int q = 4;
		for (int i=1; i<=q; i++) {
			System.out.print("+");
		}
		System.out.println();
		
		
		q = q + 1;
		for (int i=1; i<=q; i++) {
			System.out.print("+");
		}
		System.out.println();
		
		
		
		
		
		System.out.println("------4단계------");
		
		for (int i = 1; i <=5; i++) {
			
			for (int j = 1; j<=i; j++) {
				System.out.print("+");
			}
			System.out.println();
		}
		
		// 4.5 단계
		/*
		 	11111
		 	2222
		 	333
		 	44
		 	5
		 	
		 */
		// 1번줄에 1이 5개
		// 2번줄에 2가 4개
		System.out.println("------4.5단계------");
		
//		int k = 1;
//		int m = 5;
//		for (int i = 1; i<=m; i++) {
//			System.out.print(k);
//		}
//		System.out.println();
//		
//		k = k +1;
//		m--;
//		for (int i = 1; i<=m; i++) {
//			System.out.print(k);
//		}
//		System.out.println();
//		
//		k = k +1;
//		m--;
//		for (int i = 1; i<=m; i++) {
//			System.out.print(k);
//		}
//		System.out.println();
		
//		int k1 = 1, m1 =5;
//		for (int k1 = 1, m1 =5; k1<=5 && m1>=1; k1++,m1--) {
//			for (int i = 1; i<=m1; i++) {
//				System.out.print(k1);
//			}
//			System.out.println();
//		}
		
//		int k = 1;
//		int m = 6 - k;
		// 전체 5줄
		for(int k = 1; k<=5; k++) {
			
			// 한줄의 내용을 완성하는 반복문 
			for (int i=1; i<=(6-k); i++) {
				System.out.print(k);
			}
			System.out.println();	//엔터
		}
		
		
		// 5단계
		/*
		 
		 +____
		 ++___
		 +++__
		 ++++_
		 +++++
		 
		 */
		System.out.println("------5단계------");
		
		for (int i = 1; i <=5; i++) {
			for(int j = 1; j<=i; j++) {
				System.out.print("+");
			}
			for (int j=1; j<=(5-i); j++) {
				System.out.print("_");
			}
			System.out.println();
		}
		
		
		
		
		
		// 6단계
		/*
		 
		 ____+
		 ___++
		 __+++
		 _++++
		 +++++
		 
		 */
		System.out.println("------6단계------");
		
		for (int i = 1; i <=5; i++) {
			for (int j=1; j<=(5-i); j++) {
				System.out.print("_");
			}
			for(int j = 1; j<=i; j++) {
				System.out.print("+");
			}
			System.out.println();
		}
		
		
		// 7단계
		/*
		 
		 ____+
		 ___+++
		 __+++++
		 _+++++++
		 +++++++++
		 
		 */
		System.out.println("------7단계------");
		
		for (int i = 1; i <=5; i++) {
			
			for (int j=1; j<=(5-i); j++) {
				System.out.print("_");
			}
			
			for(int j = 1; j<=(i*2)-1; j++) {
				System.out.print("+");
			}
			
			System.out.println();
		}
		
		
		
		// 8단계
		/*
		 
		 ____+____
		 ___+++___
		 __+++++__
		 _+++++++_
		 +++++++++
		 
		 */
		System.out.println("------8단계------");
		
		for (int i = 1; i <=5; i++) {
			for (int j=1; j<=(5-i); j++) {
				System.out.print("_");
			}
			
			for(int j = 1; j<=(i*2)-1; j++) {
				System.out.print("+");
			}
			
			for (int j=1; j<=(5-i); j++) {
				System.out.print("_");
			}
			
			System.out.println();
		}
		
		
		// 9단계
		// 입력 받은 만큼 출력
		System.out.println("------9단계------");
		
		int k = 10;	
		
		for (int i = 1; i <=k; i++) {
			for (int j=1; j<=(k-i); j++) {	// 왼쪽 _
				System.out.print("_");
			}
			
			for(int j = 1; j<=(i*2)-1; j++) {	// 중앙 +
				System.out.print("+");
			}
			
			for (int j=1; j<=(k-i); j++) {	// 오른쪽 _
				System.out.print("_");
			}
			
			System.out.println();
		}
		
		
		
		
		
		
		
		

	}

}
