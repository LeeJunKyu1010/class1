package sec01.exam02;

public class VariableUseExam {

	public static void main(String[] args) {
		
		int hour = 3;		// 변수를 3으로 지정
		int minute = 5;		// 변수를 5로 지정
		System.out.println(hour + "시간 " + minute + "분");
		// hour 변수와 문자를 +로 합치고 minute 도 문자 "분"과 합치고 출력
		
		int totalMinute = (hour * 60) + minute;
		// hour를 60으로 곱하고 minute 과 더하면 totalMinute 출력
		
		System.out.println ("총 " + totalMinute + "분");
		
		int totalSec = totalMinute * 60;
		System.out.println(totalSec);
		
		int x = 10;
		int y = 20;
		System.out.println("x의 값은 :" + x);
		System.out.println("y의 값은 :" + y);
		System.out.println("x+y값은= " + (x+y));
		
		x = y;
		System.out.println("x의 값은 :" + x);
		
		
//		System.out.println(j); j가 선언되지 않아 에러가 발생함
		int j = 1;
		System.out.println("j : " + j);
		
		{
			System.out.println("j : " + j);
		}
		
		{
			//변수는 {}가 끝나면 사라진다.
			int i = 0;
			System.out.println("i : " + i);
			// 같은 변수명으로 또 선언 할 수 없
			//int i = 10;
			//int j = 100;
			i = 100;
			j = 10;
		}
		// i는 이미 사라진 상태
//			System.out.println("i : " + i);
			
			int i = 100;
			System.out.println(i);
	}

}
