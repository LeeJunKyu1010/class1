package quiz;

public class Song {
	// 필드
	// 변수 선언 : 변수타입 변수명
	// 변수 선언과 동시에 초기화는 가능
	// 나머지 "행동"은 불가능
	
	String title;	// 제목
//	String title = new String(); <- 가능
	
	//	title = "asdf";	<- 불가능
//	System.out.println(); <-불가능
	
	String singer;	// 가수명
	int like;		// 좋아요수
//	int like = (int)plus(1,2); <- 가능
	
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
		System.out.println("------------");
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
