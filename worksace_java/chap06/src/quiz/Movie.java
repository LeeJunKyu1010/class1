package quiz;

public class Movie {
	
	// 생성자
	// 생성자 선언 : 클래스명 (전달인자들){ }
	
	// 생성자가 없으면
	// 기본적으로 생김 : 클래스명 (){ }  <- 전달인자 없이 생김
	// 생성자를 적으면 기본생성자는 생성 되지 않음

	
//	Movie(){
//		
//	}
	
	
//	Movie(){
//		System.out.println(1);
//	}
	 
	
	Movie(String title){
		System.out.println(title);
		System.out.println("------------------");
	}
	
	
	
	
	String title;	// 영화제목
	int year;		// 개봉일
	
//	Movie(String t, int y){
//	title = t;
//	year = y;
//	}
	
	
	
	
	
	
	
	Movie(String title, int year){
		this.title = title;
		this.year = year;
		System.out.println("영화 제목1 : "+this.title);
		System.out.println("개봉일1 : "+this.year);
		System.out.println("------------------");
	}
	
	
	
	
	
	
	
	// title의 값을 바꿀수 있다.
	void setTitle(String title) {
		if (title != null) {
			this.title = title;
			System.out.println("영화제목2 : "+this.title);
		}
		else {
			System.out.println("제목을 정확히 입력하세요.");
			System.out.println("------------------");
		}
	}
	
	void print () {
		System.out.println("제목 : "+this.title);
		System.out.println("개봉일 : "+this.year);
	}
	
	
	
	
	
}
