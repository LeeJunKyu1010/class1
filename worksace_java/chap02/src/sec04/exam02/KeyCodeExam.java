package sec04.exam02;

import java.io.IOException;
import java.util.Scanner;


public class KeyCodeExam {

	public static void main(String[] args) {
		
		
//		int keycode;
//		
//		try {
//			keycode = System.in.read();
//			System.out.println(keycode);
//			
//			keycode = System.in.read();
//			System.out.println(keycode);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		// 스캔 하는법
		Scanner scanner = new Scanner(System.in);
		// 스캔 변수명
		
		String inputData = scanner.nextLine();
		
		System.out.println("inputData :"+ inputData);
		
		int input = scanner.nextInt();
		// nextInt를 쓰면 숫자만 들어 갈 수 있음
		
		System.out.println("input :"+ input);
		
		
		
		
		
	}

}
