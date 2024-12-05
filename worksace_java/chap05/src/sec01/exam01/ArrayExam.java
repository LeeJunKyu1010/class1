package sec01.exam01;

public class ArrayExam {

	public static void main(String[] args) {

		
		/*
		 * 배열
		한번에 여러 변수를 만드는 방법
		같은 타입만 선언할 수 있다.
		생성 할 때 전체 크기를 지정해줘야 한다.
		생성된 여러 변수들은 index로 관리한다. ( index는 0번부터 시작 )
		*/
		
		// 선언 방법
		int[] score; 	// java 스타일
//		int [] score3; 	// java 스타일
		int score2 [];	// c 스타일
		
		// 변수 앞이 무조건 타입이라고 읽는 경우
		// score 변수는 "int로 구성된 배열이다."
		
		// 배열은 참조타입
		score = null;
		
		/////////////////////
		int score_0 = 90;
		int score_1 = 60;
		int score_2 = 70;
		
		/*
		 
		 배열을 생성 할 때 크기를 알려줘야 한다.

		첫번째 [ ] ( int[ ] ) : int로 이루어진 배열이다.

		두번째 [ ] ( new int[3] ) : 배열의 크기, 즉 한번에 만들 변수의 개수

				타입의 크기만큼 연달아서 메모리를 할당

				첫번째 주소를 변수에 저장
	
				index 0부터 첫번째 변수를 활용할 수 있다.

		세번째 [ ] ( intArray[0] ) : 만들어진 변수 중에서 첫번째 변수를 뜻함
		 
		 */
/////////////////////////////////////////////////////////////////////////
		
		
		// 배열을 선언하는 첫번째 방법
		
		int[] intArray = new int[3];
		intArray[0] = 90;
		intArray[1] = 60;
//		intArray[2] = 70;
		
		System.out.println("intArray[0] :"+ intArray[0]);
		
		
		// 기본값은 0, false, null로 초기화된다.
		System.out.println("intArray[2] :"+ intArray[2]);
		
		
		
		// 0~2까지만 사용 가능한데 3으로 시도했다
		//java.lang.ArrayIndexOutOfBoundsException
//		System.out.println("intArray[3] :"+ intArray[3]);
		
		
		// 배열을 선언하는 두번째 방법
		
		// 넣을 값을 모두 정확히 알고 있는 경우
		// 랜덤도 넣을수 있으나 double이므로 int로 변경 해야한다.
		int[] intArray2 = new int[] {90,70,(int)Math.random()};
		
		int[] intArray2_1 = null;
		intArray2_1 = new int[] {90,70,(int)Math.random()};
		
		
		// 배열을 선언하는 세번째 방법
		
		// new int[]에 해당하는걸 생략가능
		// 선언과 동시에 초기화 하는 경우에만 사용 가능
		int[] intArray3 = {90,70,(int)Math.random()};
//		intArray3 = {90,60,70,(int)Math.random()};
		
		System.out.println("intArray3의 길이 : "+ intArray3.length);
		// length는 읽기전용이라 직접 값을 넣을수 없음
//		intArray3.length = 5;
		
		
		System.out.println("intArray3 :"+intArray3);
		
		
		String[] sArr = new String[14];
		
		sArr[0] = "이름1";
		sArr[1] = "이름2";
		
		int k = 1;
		
		// sArr[2] = "이름3";
		
		k++;
		sArr[k] = "이름"+(k+1);
		
		for(int i=0; i<sArr.length; i++) {
			sArr[i] = "이름"+(i+1);
		}
		
		for(int i=0; i<sArr.length; i++) {
			System.out.println(sArr[i]);
		}
		
		
		
		
		
		// 깜짝퀴즈
		// 1~10까지 배열에 넣고
		// 배열의 총 합 출력
		// 배열의 평균값 출력
		
		int[] nums = new int[10];
		for (int i=0;i<nums.length;i++) {
			nums[i] = i+1;
		}
		
		
		int sum = 0;
		for (int i=0; i < nums.length; i++) {
			sum = sum + nums[i];
		}
		System.out.println("합계 : "+ sum);
		System.out.println("평균 : "+ (double)sum / nums.length);
		
		
		// 간단퀴즈
		// 1~10까지 순서대로 저장된 배열을
		// 10부터 1까지 거꾸로 출력
		System.out.println("-----10부터 1까지 거꾸로 출력-----");
		
		for(int i=nums.length-1; i>=0; i--) {
			System.out.println(nums[i]);
		}
		
		System.out.println("------------2번째 방법------------");
		System.out.println("-----10부터 1까지 거꾸로 출력-----");
		for (int i=0; i<nums.length; i++) {
			System.out.println(nums[nums.length-1-i]);
		}
		
		
		
		
		// [3,4,7,5,1,4,6]
		/*
		 * 문제1. 홀수의 개수 구하기
		 * 문제2. 4보다 큰 수의 개수 구하기
		 * 문제3. 최대값 구하기
		 */
		
		
		
		/* 문제4. 두번째 큰 수 구하기
		 * 문제5. 배열을 하나씩 뒤로(오른쪽) 밀기
		 * 		5-1 : 0으로 채우기
		 * 		5-2 : 첫 자리에 마지막것 넣기
		 * 문제6. 임시 비밀번호 8자리 만들기
		 * 		6-1 : 숫자로 
		 * 		6-2 : 소문자로
		 * 		*6-3 : 숫자 2개 이상, 대/소문자 조합
		 * 
		 * 문제7. 예약
		 * 		자리가 10개 있는 소극장 예약 시스템
		 * 		자리 번호는 1~10번까지 번호의 자리가 있음
		 * 		만약 1 : 예약이 가능하면 "n번자리 예약 했습니다."
		 * 		만약 2 : 예약이 불가능하다면 "이미 예약되어 있습니다."
		 * 		메뉴 : "1.예약, 2.모든예약현황, 3. 잔여좌석, 4.종료
		 * 
		 * 문제8. 로또 6개 배열에 저장
		 * 		단, 중복 없이
		 */
		
		
		System.out.println("-----1번문제-----");
		// 문제1. 홀수의 개수 구하기
		int[] q = new int[] {3,4,7,5,1,4,6};
		int  cnt = 0;
		for (int i=0; i<q.length; i++) {
			if (q[i] % 2 != 0) {	// 짝수가 아닌것
				cnt++;				// 개수 카운트
			}
		}
		System.out.println("홀수의 개수 : "+cnt);
		
		
		
		
		
		System.out.println();
		System.out.println("-----2번문제-----");
		// 문제2. 4보다 큰 수의 개수 구하기
		int cnt2 = 0;
		for (int i=0; i<q.length ; i++) {
			if( q[i] > 4) {
				cnt2++;
			}
		}
		System.out.println("4보다 큰수의 개수 : "+cnt2);
		
		
		
		
		
		
		System.out.println();
		System.out.println("-----3번문제-----");
		// 문제3. 최대값 구하기
		// 전략
		// 앞에서부터 하나씩
		// //첫번째 것을 기준으로
		// int 최소값을 기준으로
		// 다음것과 비교해서 큰것을
		// 따로 저장 해놓고
		// 저장 한것으로 그 다음것과 비교하는걸
		// 끝까지 반복 한다.
		
		
		int max = Integer.MIN_VALUE;	// (최소값 기준)  -2,147,483,648 
//		int max = q[0];		(배열 첫번째 기준)
		
		for (int i=0; i <q.length; i++) {
			if (max < q[i] ) {	
					max = q[i];
			}
		}
		System.out.println("최대값 : " + max);
		
		
		
		
		
		System.out.println();
		System.out.println("-----4번문제-----");
		// 문제4. 두번째 큰 수 구하기
		
		
		
		
		
		
		System.out.println();
		System.out.println("-----5번문제-----");
//		문제5. 배열을 하나씩 뒤로(오른쪽) 밀기
//		  		5-1 : 0으로 채우기
//		  		5-2 : 첫 자리에 마지막것 넣기
		
		
		
		
		
		
		System.out.println();
		System.out.println("-----6번문제-----");
//		문제6. 임시 비밀번호 8자리 만들기
//		  		6-1 : 숫자로 
//		  		6-2 : 소문자로
//		  		*6-3 : 숫자 2개 이상, 대/소문자 조합
		
		
		
		
		
		
		
		
		
		System.out.println();
		System.out.println("-----7번문제-----");
//		문제7. 예약
//		  		자리가 10개 있는 소극장 예약 시스템
//		  		자리 번호는 1~10번까지 번호의 자리가 있음
//		  		만약 1 : 예약이 가능하면 "n번자리 예약 했습니다."
//		  		만약 2 : 예약이 불가능하다면 "이미 예약되어 있습니다."
//		 		메뉴 : "1.예약, 2.모든예약현황, 3. 잔여좌석, 4.종료
		
		
		
		
		
		
		
		
		
		System.out.println();
		System.out.println("-----8번문제-----");
//		문제8. 로또 6개 배열에 저장
//		  		단, 중복 없이
		
		
		
		
		
		
		
		
		
		
		
		
		// 1차원 배열
		int[] class1 = new int[20];
		int[] class2 = new int[20];
		int[] class3 = new int[20];
		int[] class4 = new int[20];
		
		int[] [] 천안 = new int[4][20];
		
		System.out.println("천안 : "+천안); // 메모리 주소
		System.out.println("천안[0] : "+천안[0]);
		System.out.println("천안[0][0]: "+천안[0][0]);
		
		
		// 2차원 배열
		// 서로 다른 크기를 가지는 2차원 배열 (배열 안에 배열을 넣을 수 있다.)
		int[][] test = {
				{1,2,3},	// 첫번째 배열
				{1,2,3,4},	// 두번째 배열
				{78}		// 세번째 배열
						};
		
		// 두번째 배열의 마지막 값 출력
		System.out.println("test : "+test[1][3]);
		
		// 배열의 개수
		System.out.println("test.length : "+test.length);
		
		// test 배열의 첫번째 배열 개수
		System.out.println("test[0].length : "+test[0].length);
		
		// test 배열의 두번째 배열 개수
		System.out.println("test[1].length : "+test[1].length);
		
		
		
		
		
		// 3차원 배열
		
		int[][] 수원 = new int[4][20];
		int[][] 서울 = new int[4][20];
		
		
		int[][][] 휴먼 = new int[3][4][20];
		


		// 가상의 달력
		// 근데 12개월이고 모든 달은 30일까지만 있는..
		// 한달은 1~30
		// 모든 날짜 채워 넣기
		// 따로 모든 (또는 11월) 출력하기
		
		// 1단계 : 1월만 만들어보기
		// 2단계 : 완성
		
		int[] month1 = new int [30];
		month1[0] = 1;
		month1[1] = 2;
		
		
		for (int i=0; i<month1.length; i++) {
			month1[i] = i+1;
		}
		
		for (int i=0; i<month1.length; i++) {
			System.out.print(month1[i]+",");
		}
		
		
		
		
		
		
//		int[] month2 = new int[30];
//		
//		for (int i=0; i<month2.length; i++) {
//			month1[i] = i+1;
//		}
		
		
		
		
		
		// 12개월 달력
		
		
		int[][] month = new int[12][30];
		
		// 일에 해당되는 배열에 +1 (배열이 0부터시작이므로)
		for (int i=0; i<month[0].length; i++) {
			month[0][i] = i+1;
		}
		
		
		
		
		// 일에 해당되는 배열에 +1 (배열이 0부터시작이므로)
		for (int i=0; i<month[1].length; i++) {
			month[1][i] = i+1;
		}
		
		
		
		
		// j가 달에 해당됨
		for (int j=0; j<month.length;j++) {
			for (int i=0; i<month[j].length; i++) {
				month[j][i] = i+1;
			}
		}
		
		
		
		// j달 i일
		for (int j=0; j<month.length;j++) {
			for (int i=0; i<month[j].length; i++) {
				System.out.println("j :"+j+","+" i :"+i+","+" 일 :"+month[j][i]);
			}
		}
		
		
		
		
		
		
		
		
		// 배열 복사하기
		
		String[] name1 = {"김","이","박","최"};		  // 원본
		// name1와 정확히 동일한 name2를 만드세요.
		
		String[] name2 = new String [ name1.length ]; // 복사준비
//		name2[0] = name1[0];
		
		for (int i = 0; i<name1.length; i++) {	// 복사
			name2[i] = name1[i];
		System.out.println(name2[i]);
		}
		
		
		
		String str = "01234";
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
