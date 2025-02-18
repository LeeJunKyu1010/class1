package quiz2;

public class CafeExam {

	public static void main(String[] args) {
		
		Barista barista = new Barista();
		Baker baker = new Baker();
		
		Welfare w = new Welfare();		
		w.pay(barista, 100);
		w.pay(baker, 123);
		
		
		barista.printMoney();
		baker.printMoney();
		
		barista.study("커피");
		
	}

}
