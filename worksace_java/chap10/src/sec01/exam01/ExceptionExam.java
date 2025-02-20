package sec01.exam01;

public class ExceptionExam {

	public static void main(String[] args) {
		
		
		for(int i=0; i<args.length; i++) {
			System.out.println(i + ":"+args[i]);
		}
		
		int a = 10;
		String b = "100good";
		try {
			a = Integer.parseInt(b);
			
			Class clazz = Class.forName("java.lang.String2");
			
			System.out.println("이게 출력된다는건 위에 예외가 없었다.");
		} catch(NumberFormatException e) {
			System.out.println("catch 블럭");
			System.out.println(e);
			e.printStackTrace(); // 에러찾는 방법
			System.out.println(e.getMessage());
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} finally {
			System.out.println("finally는 무조건 실행");
		}
		
		System.out.println("end");

		
	}

}
