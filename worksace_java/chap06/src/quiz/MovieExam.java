package quiz;

public class MovieExam {

	public static void main(String[] args) {
		
		
//		new Movie(); //이걸로 생성 못하고
//		new Movie("무파사"); // 제목을 넣어야 생성되게
		
		new Movie("무파사1");
		new Movie("무파사",2025); // 이거도 되게 만들자
		
		
		
		
		
		
		// 생성자로 전달한 값 두개를 저장할 변수를 만들기
		// 생성자에서는 전달받은 값 두개로 필드값을 변경
		// 그 변수의 내용을 바꾸는 메소드 만들기
		
		Movie film = new Movie("매트릭스",1999);
		System.out.println(film.title);
		System.out.println(film.year);
		System.out.println("------------------");
		
		film.setTitle("ㅇ");
		System.out.println(film.title);
		System.out.println("------------------");
		
		
		// 클래스의 모든 정보를 출력하는 메소드
		// print 만들기
		// 다음의 코드를 대신해주는 메소드
		
		film.print();
		
		
		
		
		
		
		
		
		
		
		
	}
}
