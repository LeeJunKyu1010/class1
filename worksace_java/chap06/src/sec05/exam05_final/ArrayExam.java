package sec05.exam05_final;

public class ArrayExam {

	public static void main(String[] args) {
		
		int[] a = new int[5];
//		a[5] = 1;
		
		// Array 구현
		// 생성하고 나서
		// add()에 값을 넣으면 자동으로 현재 index에 추가
		//		단, 크기를 벗어나면 "에러 문구 출력"
		// get()에 index를 넣으면 그 index의 값을 return함
		
		
		// Array 구현/생성
		// 50개 크기의 배열 생성
		Array b = new Array(3);
		

		b.add(10);
		b.add(20);
		b.add(30);
		b.add(40);



		b.get(0);
		
//		System.out.println(b.get(1));
		
		
		if(b.get(100) == Integer.MIN_VALUE) {
			System.out.println("초과입니다.");
		}else {
			System.out.println("");
		}
		
		

		
		
		
	}

}
