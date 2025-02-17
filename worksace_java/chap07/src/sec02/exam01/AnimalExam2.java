package sec02.exam01;

public class AnimalExam2 {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.age = 3;
//		System.out.println("cat.age = "+cat.age);
		Animal a1 = cat;
//		feed(a1);
		
		// 줄여서 쓴게
		feed(new Cat()); // 이건 Cat안에있는 Animal를 이용해서 사용한다
		feed(new Dog()); // 이건 Dog안에있는 Animal를 이용해서 사용한다
		

	}
	
	static void feed(Animal a) {
		System.out.println("---feed 실행");
		a.eat();
		a.sound();
		
		
	}

}
