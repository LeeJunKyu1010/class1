package sec01.exam01;

public class VarExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 한줄 주석
		
		/* 범위 주석
		 * 
		 * 여러줄 가능
		 */
		
		
		// 이클립스 단축키
		/*
		 * 한줄 지우기	: Ctrl + d
		 * 한줄 복사:	: Ctrl + Alt + 위아래 방향키
		 * 한줄 이동	: Alt + 위아래 방향키
		 * 코드 정렬	: Ctrl + Shift + f
		 * 주석 단축키	: Ctrl + /
		 */

		System.out.println("Hello World 한글");
		
		//변수 value 선언
		//int value = 30; // 선언과 동시에 초기화
		  int value;
		  value = 30;
		  
		  
		//변수 value 값을 읽고 10을 더하는 산술 연산을 수행
		//연산의 결과값을 변수 result의 초기값으로 저장
		// = 을 기준으로 오른쪽 먼저 실행
		// value에 있는 값을 꺼내서 + 10 한 결과를
		// result 변수에 저장
		  int result = value + 10;

		  
		//변수 result 값을 읽고 콘솔에 출력
		System.out.println(value);		// value 값 출력
		System.out.println(result);		// result 값 출력 ( 위에 result = value + 10)
		result = 100;					// 변수 값을 100으로 지정
		System.out.println(result);		// 변경된 변수값으로 출력
		
	}

}
