package sec02.exam01;

public class Cat extends Animal{

//	int age;
	
	@Override
	void sound() {
		System.out.println("미야용~캬~~");
		
	}

	
	
	@Override
	void eat() {
		System.out.println("추루룹");
	}



	void push() {
		System.out.println("꾹꾹이 합니다");
	}
	
//	이건 Dog처럼 age를 활용해서 만든것
	void setAge(int age) {
		super.age = age;
	}
	
}
