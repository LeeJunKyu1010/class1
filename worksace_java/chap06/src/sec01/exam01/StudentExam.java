package sec01.exam01;

public class StudentExam {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		
		Student s2 = new Student();
		
		
		System.out.println(s1 == s2);		// false
		
		Student s3 = null;
		s3 = s1;		// 얕은 복사
		
		System.out.println(s1 == s3);		// true
		
		// 참조타입이라서 null이 들어갈 수 있다
		s2 = null;
		
		
		
		
		
		
	}

}
