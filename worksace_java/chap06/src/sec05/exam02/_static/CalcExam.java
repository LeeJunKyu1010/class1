package sec05.exam02._static;

public class CalcExam {

	public static void main(String[] args) {

//		Calc c = new Calc();
//		c.color = "black";
//		
//		System.out.println(c.pi);

		System.out.println(Calc.pi);
		
		Calc c = new Calc();
		c.color = "black";
				System.out.println(c.pi);
		
		Calc c2 = new Calc();
		c2.color = "blue";
		System.out.println(c2.pi);
		
		Calc.pi = 2;
		System.out.println(c2.pi);
		
		
		c2 = c;
		
		Calc.printPi();
		
		Calc.out.print("글씨");
		
		c.printPi2();
		
		
//		test();
//		CalcExam ce = new CalcExam();
//		ce.test();
//		ce.main(new String[] {"abc"});
		
	}
		
//		static void test() {
//		
//		}
		
		void test() {
		
		}	
		
		
		


}
