package sec02.exam01;

public class AnimalExam {

	public static void main(String[] args) {
		
		// Animal의 eat()과 sound만 알고 있는 상태
		Animal a1 = new Animal();
		a1.eat();
		a1.sound();
		
		Cat cat = new Cat();
		cat.eat();
		cat.push();
		
		//형변환
		Animal a2 = (Animal)cat; // 자식이 부모가 될때
		Animal a3 = cat; 		 // 형변환 연산자 생략 가능
								 // 사실은 자식에서 부모만 빼온다, 자식은 살아있음
		a3.eat();
		a3.sound();
//		a3.push(); // 못쓴다 자식안에있는 부모꺼를 쓰는거라
		
//		Dog dog = new Dog();
//		Animal a5 = (Animal)dog;
		Animal a4 = new Dog(); // 이건 위에 두줄을 한줄로 만든것이다.
		a4.eat();
		a4.sound();
		
		catMom(cat); // 메인페이지가static이여서 static을 써야함  
					 //	밑에 static을 지우면
					 // 사용이 불가하다
		Dog dog = new Dog();
//		catMom(Dog);
		Animal a6 = (Animal)cat; 
		System.out.println("a6 == cat : "+(a6 == cat));
		feed(a6);
		feed(dog);
		
		a6.age = 3;
		feed(a6);
		
		// 이번엔 Cat에 필드 int age를 추가
		a6.age = 4;
		feed(a6);
		
		// 이건 Cat에 있는 setAge를 쓴것
		Cat cat2 = new Cat();
		cat2.age = 5;
		cat2.setAge(50);
		feed(cat2);
	}

	static void catMom(Cat cat) {
		cat.eat();
		cat.sound();
		cat.push();
		
	}
	
	static void feed(Animal animal) {
		System.out.println("                   feed 실행");
		animal.eat();
		animal.sound();
		System.out.println("나이는 :" + animal.age);
		
	}
	
}
