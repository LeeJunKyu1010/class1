package sec01.Random;

public class RandomExam {
	public static void main(String[] args) {
		
		
		
		
		

		// 주사위 두개로 나올 수 있는 모든 조합 출력
		/*
		 2 : [1,1]
		 3 : [1,2]  [2,1]
		 4 : [1,3]	[2,2] [3,1]
		 */
		
//		for (int i = 2; i<=12; i++) {
//			System.out.print(i+":");		// 주사위 2개 최소값 2~12
//			boolean a = true;
//			for (int j=1; j <=6; j++) {
//				int c = i - j;
//				if (c>=1 && c<= 6) {
//					if(!a) {
//						System.out.print(" ");
//					}
//					System.out.print("["+j+","+c+"]");
//					a = false;
//				}
//			}
//			System.out.println();
//		}
		
		
		
		
		
		
		
		
		
		
		// 중복을 제거한 경우의 수
		/*
		 	2 : 1가지
		 	3 : 1가지
		 	4 : 2가지
		
		*/
		
		int cnt = 0;
		
		int r1 = (int)(Math.random()*45)+1;
		System.out.println("선택된 번호 :");
		System.out.println(r1);
		cnt++;
		
		for (int i=0; i <100; i++) {
			int r2 = (int)(Math.random()*45)+1;
			boolean tf = false;
			
			for (int j=0; j<cnt; j++) {
				int r3 = (int)(Math.random()*45)+1;
			
				if (r2==r3) {
					tf = true;
					break;
				}
			}	
			if (!tf) {
				System.out.println(r2);
				cnt++;
				if(cnt==6) {
					break;
				}
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
