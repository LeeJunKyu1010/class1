package sec03.exam01;

public class KimbobExam {

	public static void main(String[] args) {
		
		Kimbap  천안역점 = new Kimbap(1000);
		천안역점.order(1);
		
		천안역점.print(1, 1);
		
		천안역점.addMenu("돈까스",9000);
		천안역점.addMenu("제육덮밥",8000);
		
		Kimbap 터미널점 = new Kimbap(1000);
		천안역점.printMenu();
		터미널점.printMenu();
		
		System.out.println(천안역점.menu);
		System.out.println(천안역점.price);
		
		System.out.println(터미널점.menu);
		System.out.println(터미널점.price);
		

	}

}
