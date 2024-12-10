package quiz;

public class SongExam {

	public static void main(String[] args) {
		
		
		// Song 클래스를 생성
		// 제목과 가수명을 넣고
		// 제목, 가수명, 좋아요수 출력
		
		Song song1 = new Song();   // Song 클래스 생성 (변수명에 담아야됨)
		// song안에 있는 title 가지고 오기
		song1.title = "home sweet home";
		song1.singer = "G-Dragon";
		
		System.out.println("노래제목 : "+song1.title);
		System.out.println("가수명 : "+song1.singer);
		System.out.println("좋아요수 : "+song1.like);
		
		
		
		System.out.println("-------------");
		
		
		
		Song song2 = new Song();
		song2.title = "APT.";
		song2.singer = "로제";
		
		System.out.println("노래제목 : "+song2.title);
		System.out.println("가수명 : "+song2.singer);
		System.out.println("좋아요수 : "+song2.like);
		
		
		System.out.println("-------------");
		
		// song3은
		// setTitle() 이용하기
		Song song3 = new Song();
		song3.setTitle("Whiplash","aespa");
		
		System.out.println("노래제목2 : "+song3.title);
		System.out.println("가수명2 : "+song3.singer);
		
		
		
		double a = song3.plus(3.5, 7.5);
		double b = song3.plus(a, 7.5);
		double c = song3.plus(a, b);
		
		
		
	}

}
