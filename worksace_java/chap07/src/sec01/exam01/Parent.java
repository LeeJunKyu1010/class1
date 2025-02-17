package sec01.exam01;

public class Parent {
	
	// 기본생성자
//	Parent(){
//		System.out.println("Parent 생성자 실행");
//	}
	
	Parent(int a){
		System.out.println("Parent 생성자 실행");
	}
	
	String name = "parent의 name";
	
	String getName(){
		System.out.println("Parent의 getName 실행");
		return this.name;
	}
	
	Parent(String name){
		this.name = name;
	}
	
}
