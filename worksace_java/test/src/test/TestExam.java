package test;

import java.util.ArrayList;
import java.util.Scanner;

public class TestExam {

	public static void main(String[] args) {
		
		// Scan 및 ArrayList 생성
		// 1. 메뉴 만들기
		// 2. 메뉴를 Scan으로 선택 및 가격 표시
		// 3. 고른 메뉴에서 옵션을 Scan으로 선택
		// 4. 메뉴의 옵션을 선택
		// 5. 메뉴를 추가할지 종료할지 선택
		// 6. 메뉴를 추가하면 2번을 반복
		// 7. 현재 선택 메뉴 확인 만들기
		// 8. 7번을 하면 5번으로 이동
		// 9. 종료
		
		ArrayList<String> menuH = new ArrayList<>();
		ArrayList<Integer> menuP = new ArrayList();
		
		Scanner scan = new Scanner(System.in);
		
		String menu = ""; // 메뉴들
		
		int menuInfo = 0; // 결재금액
		
		
		do {
			System.out.println("---------Menu Pick---------");
			System.out.println("1번 : 아메리카노 3,000원");
			System.out.println("2번 : 녹차라떼 4,500원");
			System.out.println("3번 : 초코라떼 4,500원");
			System.out.println("4번 : 현재 메뉴");
			System.out.println("x : 종료");
			System.out.println("---------------------------");
			menu = scan.nextLine();
			
			
			// 메뉴들과 옵션칸을 묶음 
			// 안묶으면 현재메뉴와 종료를 선택하면 옵션이 선택됨
		if("1".equals(menu) || "2".equals(menu) || "3".equals(menu)) {
			
//			-------------아메리카노 선택 칸----------------------
			if("1".equals(menu)) {
				menuH.add("아메리카노 『3,000원』"); // 현재 메뉴에 추가
				menuP.add(3000);	// 현재 금액에 추가 (메뉴가격)
				
				System.out.println("---------------------------");
				System.out.println("아메리카노 선택 : ");
				System.out.println("아메라카노 3,000원 입니다");
				System.out.println("---------------------------");
				System.out.println();
			}
			
//			--------------녹차라떼 선택 메뉴---------------
			else if ("2".equals(menu)) {			
				menuH.add("녹차라떼 『4,500원』");	// 현재 메뉴에 추가
				menuP.add(4500);	// 현재 금액에 추가 (메뉴가격)
				
				System.out.println("---------------------------");
				System.out.println("녹차라떼 선택");
				System.out.println("녹차라떼 4,500원 입니다");
				System.out.println("---------------------------");
				System.out.println();
			}
			
//			---------------초코라떼 선택 메뉴----------------
			else if ("3".equals(menu)) {			
				menuH.add("초코라떼 『4,500원』");	// 현재 메뉴에 추가
				menuP.add(4500);	// 현재 금액에 추가 (메뉴가격)
				
				System.out.println("---------------------------");
				System.out.println("초코라떼 선택");
				System.out.println("초코라떼 4,500원 입니다");
				System.out.println("---------------------------");
				System.out.println();
			}
			
//			---------------옵션선택 칸---------------------------------
			System.out.println("---------옵션 Pick---------");
			System.out.println("1 : 아이스 (+0원), 2 : 핫 (+0원)");
			System.out.println("---------------------------");
			menu= scan.nextLine();
			
//			 ----------------------ICE 선택칸-----------------------
			if ("1".equals(menu)) { 
				menuH.add("ICE");
				System.out.println("---------------------------");
				System.out.println("ICE 선택");
				System.out.println("---------------------------");
				System.out.println();
			}
//			 ----------------------HOT 선택칸-----------------------
			else if ("2".equals(menu)) {
				menuH.add("HOT");
				System.out.println("---------------------------");
				System.out.println("HOT 선택");
				System.out.println("---------------------------");
				System.out.println();
			}
		}	
			
			
//				-----------------현재 메뉴 확인-----------------
			else if ("4".equals(menu)) {			
				menuInfo = 0;		// 현재 금액들 합계
				for (Integer i : menuP) {
					menuInfo += i;
				}
				System.out.println("-------현재 메뉴확인-------");
				System.out.println("현재메뉴 : "+ menuH);
				System.out.println("결재금액 : "+ menuInfo+"원");
				System.out.println("---------------------------");
				System.out.println();
			}
			
		
//			---------------------종료 칸-------------------------------
		} while (!"x".equals(menu));
		System.out.println("프로그램 종료");
		
		
		
		
		
		
		
		

	}

}
