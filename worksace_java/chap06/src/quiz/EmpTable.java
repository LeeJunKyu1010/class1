package quiz;

public class EmpTable {
	
	public static void main(String[] args) {

		Emp e1 = new Emp();
		e1.empno = 100;
		e1.ename = "이름1";
		e1.mgr = 102;
		e1.sal = 1000;
		
		Emp e2 = new Emp();
		e2.empno = 101;
		e2.ename = "이름2";
		e2.mgr = 102;
		e2.sal = 1000;
		
		Emp e3 = new Emp();
		e3.empno = 102;
		e3.ename = "이름3";
		e3.mgr = 000;
		e3.sal = 2000;
		
		
		
		EmpExam el = new EmpExam("EmpTable");
		el.add(e1);
		el.add(e2);
		el.add(e3);
		
		el.print();
		el.print1();
		
		
		
		
		
		
		
		
	}
}
