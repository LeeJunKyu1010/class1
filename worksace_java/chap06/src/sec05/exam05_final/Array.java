package sec05.exam05_final;

public class Array {

//	int[] a = new int[3];
//	Array() {
//		System.out.println(a.length);
//		a.length // final 정수 변수
//	}
	
	final int length; // 배열의 크기
	int[] arr;		   // 나만의 배열
	int cursor = 0;
	
	Array (int length){
		this.length = length;
		arr = new int[length];
	}
	
	
	// add()에 값을 넣으면 자동으로 현재 index에 추가
			//		단, 크기를 벗어나면 "에러 문구 출력"
	void add(int x) {
		if(cursor < this.length) {
			arr[cursor] = x;
			cursor++;
		}else {
			System.out.println("cursor :" + cursor + ", x :" + x + " 범위초과");
		}
	}
	
	// get()에 index를 넣으면 그 index의 값을 return함
	int get(int index) {

		if(index < this.length) {
			return arr[index];
		}else {
			System.out.println(index +"범위초과");
			return Integer.MIN_VALUE;
		}
	}
	
}
