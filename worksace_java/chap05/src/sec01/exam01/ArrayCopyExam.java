package sec01.exam01;

import java.util.ArrayList;

public class ArrayCopyExam {

	public static void main(String[] args) {
		
		
		// 1호점에서 판매하는 메뉴
		String[] menu1 = new String[3];
		
		menu1[0] = "아이스아메리카노";
		menu1[1] = "녹차라떼";
		menu1[2] = "고구마라떼";
		
		// 2호점에서 1호점과 똑같은 메뉴를 판매할거입니다.
		/*
		 * 얕은 복사
		 * shallow copy. thin copy, call by reference
		 * stack 영역의 값 (주소)만 복사
		 * 값을 변경할 경우 원본이 바뀝니다.
		 * 
		 */
		String[] menu2 = menu1;
		// 얕은 복사로 연결되어 있어서
		// 즉 주소값만 굥유하는거라서
		// 복사본을 바꿔도 원본이 변경된다.
		menu2[2] = "초코라떼";
		System.out.println("menu1[2] : "+menu1[2]);
		
		
		
		
		
		
		
		
		
		/*
		 * 깊은 복사
		 * deep copy, deep clone, call by value
		 * 전혀 다른 heap 영역에 똑같은 내용으로 채워놓는다.
		 * 원본과 복사본은 전혀 다른 객체이다.
		 * 
		 */
		
		String[] menu3 = new String[menu1.length];
		
		for (int i=0; i<menu3.length; i++) {
			menu3[i] = menu1[i];
		}
		menu3[2] = "초코바나나라떼";
		System.out.println("menu1[2] : "+menu1[2]);
		System.out.println("menu3[2] : "+ menu3[2]);
		
		
		
		
		System.out.println();
		
		
		
		// 3호점에서만 "사라다빵"을 추가로 팔고싶다.
		/*
		 * 전략
		 * menu3 보다 크기가 1개 많은 새로운 배열을 만들고
		 * 앞부분은 깊은 복사 해놓고
		 * 마지막에 "사라다빵"을 수동으로 추가해보자
		 */
		
		
		
		menu3 =new String[menu1.length+1];	// 배열 깊은복사
		
		for (int i=0; i<menu1.length; i++) {	// 배열 추가
			menu3[i] = menu1[i];
		}
		
		menu3[menu3.length-1] = "사라다빵";	// 사라다빵 추가
		
		
		for(int i=0; i<menu3.length; i++) {
			System.out.println("menu3[i] : "+menu3[i]);
		}
		
		
		
		
		
		// ArrayList 사용법
		ArrayList list = new ArrayList();
		
		// 추가
		list.add(1);		// 배열도 들어감
		list.add("문자");	// 문자도 들어감
		list.add(false); 	// boolean도 들어감
		
		// 사용
		System.out.println( list.get(0) );  // 추가한 순서대로 출력
		System.out.println( list.get(1) );
		System.out.println( list.get(2) );
		
		// 사이즈
		System.out.println( list.size() );	// 배열 개수
		
		System.out.println( list );
		
		
		
		
		
		
//		for ( int i=0; i< menu3.length; i++) {
//			String menu = menu3[i];
//			System.out.println("menu : "+ menu);
//		}
		
		
		
		// 향상된 for문
		for( String menu : menu3 ) {
			System.out.println("menu : "+menu);
		}
		
		
		
		
		// 223.P   문제5번
		System.out.println("------------ 223p 문제5번------------");
		
		
		int[][] array = {
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
		};
		
		
		int max = Integer.MIN_VALUE;	// 최대값 구하기
		
		int q = 0; // 카운트
		int sum = 0;    // 합 출력
		double avg = 0.0; // 평균 출력
		
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<array[i].length; j++) {
				sum = sum + array[i][j];	// 합계
				
				q++;	// 카운트
				avg = (double)sum / q;	// 평균값
				
				if (max < array[i][j]) {	// 최대값
					max = array[i][j];
				}
				
			}
		}
		System.out.println("합계 : "+sum);
		System.out.println("평균 : "+avg);
		System.out.println("최대값 : "+max);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
