package sec05.exam01;

public class CarExam {

	public static void main(String[] args) {
		
		Car model1 = new Car("카이엔");
		Car model2 = new Car("마칸");
		
		model1.printModel();
		model2.printModel();
		System.out.println("------------------");
		System.out.println(model1.model);

		

	}

}