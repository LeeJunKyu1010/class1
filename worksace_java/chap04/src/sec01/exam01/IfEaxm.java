package sec01.exam01;

import java.util.Scanner;

public class IfEaxm {

	public static void main(String[] args) {
		
		
		int score = 69;
//		Scanner scan = new Scanner(System.in);
//		Scanner가 빨간줄이면 ctrl + shift + o 누르면 됨
//		int score = scan.nextInt();
		
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A 입니다.");
		}
		
		if (score < 90) {
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B 입니다.");
		}
		
		
		
		
		
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A 입니다.");
		}	
			else {
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B 입니다.");
			
		}
		
		
		if(score >= 90) {
			System.out.println("점수가 90점 이상입니다.");
			System.out.println("등급은 A 입니다.");
			
		} else if(score < 90 && score >= 80) {
			System.out.println("점수가 80~89점입니다.");
			System.out.println("등급은 B 입니다.");
			
		} else if(score < 80 && score >= 70) {
			System.out.println("점수가 70~79점입니다.");
			System.out.println("등급은 C 입니다.");
			
		} else {
			System.out.println("점수가 70점 미만입니다.");
			System.out.println("등급은 D 입니다.");
		}
		
		
		
		// 문제 1
		// z1이 x1과 y1 사이에 있는지 확인
		int x1 = 15;
		int y1 = 20;
		int z1 = 17;
		
		
		if (z1 > x1 && z1 < y1) {
			System.out.println("사이에 있음");
		}
		else {
			System.out.println("사이에 없음");
		}
		
		
		
		
		int x2 = 3;
		if ( (x2 % 2) == 0 ) {
			System.out.println(x2 + ": 짝수");
		} else {
			System.out.println(x2 + ": 홀수");
		}
		
		
		// 문제 2
		/*
		 * 어제의 온도가 -3도 였을때
		 * 오늘의 온도(입력 받아도 됨)가
		 * 
		 * 1.오늘이 "영하"인지 "영상"인지 (0은 영하)
		 * 
		 * 2.만약 영하라면 " 영하 1도 입니다"
		 * 영상이라면 "영상 2도 입니다"
		 * 
		 * 3."어제보다 온도가 높습니다."
		 * "어제보다 온도가 낮습니다."
		 * 
		 * 4. "어제보다 2도 높습니다"
		 * ex : 3, -1면 "어제보다 4도 낮습니다"
		 * 
		 */
		int yt = -2; 	// 어제 온도
		int t = 3; 	// 온도
		
		if (t > 0) {
			System.out.println("오늘은 영상");
			System.out.println("영상"+t+"입니다.");
		}else {
			System.out.println("오늘은 영하");
			System.out.println("영하"+t+"입니다.");
		}
		if (t > yt) {
			System.out.println("어제보다 온도가 높습니다.");
			System.out.print("어제보다 ");
			System.out.println(t-yt+"도 높습니다.");
		}else {
			System.out.println("어제보다 온도가 낮습니다.");
			System.out.print("어제보다 ");
			System.out.println(yt-t+"도 낮습니다.");
		}
		
			
		// 문제 3
		/*
		 * 어떤 수가 있을때
		 * 
		 * "입력한 수는 100보다 큰/같은/작은 수이며
		 * 양수이고
		 * 홀수입니다"
		 * 
		 */
		int qwe = 100;
		System.out.println("문제3번 숫자를 입력하시오");
		//Scanner scan = new Scanner(System.in);
		//int qwe = scan.nextInt();
		
		if (qwe > 100) { 
			System.out.print("문제3번 100보다 큰 수이며 ");
		}else if (qwe == 100) { 
			System.out.print("문제3번 100과 같은 수이며 ");
		}else  { 
			System.out.print("문제3번 100보다 작은 수이며 ");
		} 
			
		if (qwe >= 0) {
			System.out.print("양수이고 ");
		}else {
			System.out.println("음수이고 ");
		}
		
		if ((qwe % 2) == 0) {
			System.out.println("짝수 입니다.");
		}else {
			System.out.println("홀수 입니다.");
		}
		
		
		
		
		// 문제 4
		/*
		 * a,b 두 수가 있을때
		 * 둘중에 큰 값 출력
		 * 
		 */
		
		int a = 3;
		int b = 2;
		System.out.println("문제4번 A와 B의 값중 큰것이 출력됨");
		System.out.println("A의 값을 입력하시오");
		//int a = scan.nextInt();
		
		System.out.println("B의 값을 입력하시오");
		//int b = scan.nextInt();
		
		if (a > b) {
			System.out.println("문제4번 A");
		}else System.out.println("문제4번 B");
		
		
		// 문제 5
		/*
		 * 숫자가
		 * 1일때 "일"
		 * 2일때 "이"
		 * 3일때 "삼"
		 * 다른 수일때 "그 외"
		 * 
		 */
		int one = 1;
		System.out.println("문제5번 1~3을 입력하면 한글로 나오고 나머지는 그외");
		//int one = scan.nextInt();
		
		if 	(one == 1) {
			System.out.println("문제5번 일");
		}else if (one == 2) {
			System.out.println("문제5번 이");
		}else if (one == 3) {
			System.out.println("문제5번 삼");
		}else System.out.println("문제5번 그 외");
				
		
		
		// 문제 6
		/*
		 * 월에 따라서 
		 * 4계절을 출력
		 * 3~5 : 봄
		 * 6~8 : 여름
		 * 9~11: 가을
		 * 12~2: 겨울
		 */
		
		int qq = 12;
		System.out.println("문제6번 1~12월을 입력하시오");
		//int qq = scan.nextInt();
		
		if (qq >= 3 && qq <= 5) {
			System.out.println("문제6번 봄");
		}else if (qq >= 6 && qq <= 8) {
			System.out.println("문제6번 여름");
		}else if (qq >=9 && qq <= 11) {
			System.out.println("문제6번 가을");
		}else if (qq == 12 || (qq >= 1 && qq <=2)){
			System.out.println("문제6번 겨울");
		}else {
			System.out.println("1월부터12월 입력하세요");
		}
		
		
		// 어려운 문제 1.
        // 두자리 정수가
        // 10의 자리와 1의자리가 같은지 판단
		
		int num = 33;   // 같음
		num = 64;		// 다름
		
		
		
		
        // 어려운 문제 2.
        // 사각형의 한쪽 모서리 : xa: 10, ya: 20
        // 다른쪽 모서리 : xb: 90, yb: 100
        // 새로운 점 : xc, yc가 직각사각형에 포함 되는가?
		
		
		
		//random 사용법
		/*
		 * Math.random();
		 * 0 <= Math.random() < 1
		 * 
		 * 주사위 : 1 ~ 6
		 * (0 ~ 5) + 1
		 * x + 1 = y - 2
		 * x + 1 + 2 = y - 2 + 2
		 * 
		 * 0 <= Math.random() < 1
		 * 0*5 <= Math.random()*5 < 1*5 // 0~4.999
		 * 0*(5+1)<= Math.random()*(5+1) < 1*(5+1)
		 * // 0 ~ 5.999999999999
		 * (int) 0~5
		 *  
		 */
		double rand = Math.random();
		System.out.println("rand"+rand);
		// 주사위
		double rand2 = Math.random()*(5+1);
		int rand3 = (int)rand2; // 0~5
		int rand4 = rand3 +1;	// 1~6
		System.out.println("주사위 :"+ rand4);
		
		// 쉽게 사용하기
		int rnd1 = (int) (Math.random() * 60);
		int rnd2 = rnd1 % 6;
		int rnd3 = rnd2 + 1;
		System.out.println(rnd3);
		
		
		
		//가위 바위 보 게임
		Scanner scan = new Scanner(System.in);
		String asd = scan.nextLine();
				
		int 
		
		
		int r = (int)(Math.random()*30);
		int r1 = r % 3;
		int r2 = r1 + 1;
		
		
		if (r2 == 1) {
			System.out.println("가위");
		}else if (r2 == 2) {
			System.out.println("바위");
		}else if (r2 == 3) {
			System.out.println("보");
		}
		
		if (asd < r2) {
			System.out.println("이김");
		}else if (asd == r2) {
			System.out.println("비김");
		}else if (asd > r2) {
			System.out.println("패배");
		}
		
		
		
		
		
		
		
		
		
		
	}

}
