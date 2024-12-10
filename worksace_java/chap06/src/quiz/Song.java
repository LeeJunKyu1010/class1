package quiz;

import java.util.ArrayList;

public class Song {
	
	String title;	// 제목
	String singer;	// 가수명
	int like;		// 좋아요수
	
	
	/**
	 * 제목을 전달받아서
	 * title을 변경하는 메소드 만들기
	 * 
	 * 메소드명 : setTitle
	 * @param String
	 * @return void
	 * 
	 */
	// 메소드 선언
	// 리턴타입 메소드명 (전달인자들) { }
	
	
	void setTitle(String title, String siger) {
		this.title = title;
		this.singer = siger;
		System.out.println("노래제목1 : "+this.title);
		System.out.println("가수명1 : "+this.singer);
//		return;
	}
	
	
	void setTitle(String t) {
		this.title = t;
	}
	
	
	// double 두개를 
	// 더하기 한 결과를
	// 돌려주는 메소드 plus
	
	
	double plus (double x, double y){
		double result = x+y;
		System.out.println("더하기 결과 : "+result);
		return result;
	}
	
	
	
	
	Song(){
		double plus = plus(3.5,7.5);
	}
	
	
	
	
	
}
