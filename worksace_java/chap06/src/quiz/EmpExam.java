package quiz;

import java.util.ArrayList;

public class EmpExam {

		String emp = "";
		
		ArrayList list = new ArrayList();

		 EmpExam (String emp){
			this.emp = emp;
		}
		
		void add (Emp e) {
			this.list.add(e);
		}
		
//		void print () {
//			System.out.println(this.emp);
//			System.out.println("--------------------");
//			for(int i=0; i<list.size(); i++) {
//				Emp e = (Emp)list.get(i);
//				System.out.println("empno : " + e.empno);
//				System.out.println("ename : " + e.ename);
//				System.out.println("mgr : " + e.mgr);
//				System.out.println("sal : " + e.sal);
//				System.out.println("--------------------");
//			}
//		}
//		
//		void print1 () {
//			System.out.println("--------------------");
//			System.out.println(this.emp);
//			System.out.println("sal이 2000이상인 사원");
//			System.out.println("--------------------");
//			for(int i=0; i<list.size(); i++) {
//				Emp e = (Emp)list.get(i);
//				
//				if (e.sal >= 2000) {
//					System.out.println("empno : " + e.empno);
//					System.out.println("ename : " + e.ename);
//					System.out.println("mgr : " + e.mgr);
//					System.out.println("sal : " + e.sal);
//					System.out.println("--------------------");
//				}
//			}
//		}
		
		
		void print () {
			System.out.println("------------------------");
			System.out.println(this.emp+"               ㅣ");
			System.out.println("------------------------");
			System.out.println("empnoㅣenameㅣmgrㅣsal ㅣ");
			System.out.println("------------------------");
			for(int i=0; i<list.size(); i++) {
				Emp e = (Emp)list.get(i);
				System.out.print(e.empno+"  ㅣ");
				System.out.print(e.ename+"ㅣ");
				System.out.print(e.mgr+"ㅣ");
				System.out.println(e.sal+"ㅣ");
				}
			System.out.println("------------------------");
			
		}

		
		void print1 () {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("------------------------");
			System.out.println(this.emp+"               ㅣ");
			System.out.println("sal이 2000이상인 사원  ㅣ");
			System.out.println("------------------------");
			System.out.println("empnoㅣenameㅣmgrㅣsal ㅣ");
			System.out.println("------------------------");
			for(int i=0; i<list.size(); i++) {
				Emp e = (Emp)list.get(i);
				if (e.sal >= 2000) {
					System.out.print(e.empno+"  ㅣ");
					System.out.print(e.ename+"ㅣ");
					System.out.print(e.mgr+"ㅣ");
					System.out.println(e.sal+"ㅣ");
					System.out.println("------------------------");
				}
			}
		}
	
		
	
}
