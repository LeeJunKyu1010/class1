package quiz;

import java.util.Scanner;

public class Warmer {
	
	// 전원 켜기 기능
	// 전원 끄기 기능
	// 저온 발열 기능 (단, 전원이 켜져있을때만)
	// 고온 발열 기능 (단, 전원이 켜져있을때만)
	// 발열 중지 기능
	// 상태 표시 기능 (전원 상태와 발열 상태 출력)
	
	String powerOn;
	
	String powerOff;
	
	String low;
	
	String hi;

	String start;
	
	String stop;
	
	String dis;
	
	// 전원 on, off
	String power (String q) {
		if(q.equals("on")) {
			this.powerOn  = q;
			this.start = this.powerOn;
			System.out.println("전원상태 : 전원 켜짐");	// p가 true일때 전원켜짐
		}else if (q.equals("off")) {
			this.powerOff = q;
			this.stop = this.powerOff;
			System.out.println("전원상태 : 전원 꺼짐");	//  전원 꺼짐
		}else {
			System.out.println("전원상태 : on 또는 off를 하세요");	// 그외 입력
		}
		System.out.println("---------------------------------------");
		return q;
	}
	
	
	
	// 전원이 켜져있을때 작동    (온도 설정)
	String start (String q) {
		if ("on".equals(this.powerOn) && q.equals("저온")) {
			this.low = q;
			this.start = q;
			System.out.println("작동상태 : 저온발열");
		}else if ("on".equals(this.powerOn) && q.equals("고온")) {
			this.hi = q;
			this.start = q;
			System.out.println("작동상태 : 고온발열");
		}else if ("off".equals(this.powerOff)) {
			System.out.println("작동상태 : 전원을 켜시십오");
		}else 
			System.out.println("작동상태 : 저온 또는 고온을 입력하십시오");
		System.out.println("---------------------------------------");
		return q;
	}
			
	
	
	
	// 작동 중지  ( 작동 상태 )
	String stop (String q) {
		if ("저온".equals(this.start)&& q.equals("stop")) {
			this.stop = q;
			System.out.println("중지상태 : 작동중지");
		}else if ("고온".equals(this.start)&& q.equals("stop")) {
			this.stop = q;
			System.out.println("중지상태 : 작동중지");
		}else if ("off".equals(this.powerOff)) {
			System.out.println("중지상태 : 전원이 꺼져있습니다.");
		}else if("on".equals(this.powerOn) && q.equals("start")){
			this.start = q;
			System.out.println("중지상태 : 작동중...");
		}else {
			System.out.println("중지상태 : 작동상태 확인");
			System.out.println("중지상태 : stop 또는 start를 입력하십시오");
		}
		System.out.println("---------------------------------------");
		return q;
	}
	
	
	// 디스플레이
	String dis (String q) {
		if ("on".equals(this.powerOn) && q.equals("상태")) {
			System.out.println("display : 전원이 켜져있습니다");
		}else if ("off".equals(this.powerOff) && q.equals("상태")) {
			System.out.println("display : 전원이 꺼져있습니다"); // 전원상태
		}
		
		if ("stop".equals(this.stop) && q.equals("상태")) {
			System.out.println("display : 작동중지 상태");
		}else if ("start".equals(this.start) && q.equals("상태")) {
			System.out.println("display : 작동중...");
		}
			
		if ("고온".equals(this.hi) && q.equals("상태")) {
			System.out.println("display : 고온으로 설정되어 있습니다");
		}else if ("저온".equals(this.low) && q.equals("상태")) {
			System.out.println("display : 저온으로 설정되어 있습니다");
		}
		
		
		System.out.println("---------------------------------------");
		return q;
	}
	
	
	
}
