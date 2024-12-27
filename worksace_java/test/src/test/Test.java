package test;

public class Test {

	public static void main(String[] args) {
		
		/*삼각형*/
		for (int i=1; i<=6; i++) {
			
			/*공백*/
			for (int j=6; j>i; j--) {
				System.out.print(" ");
			}
			
			/*별반복*/
			for (int j=1; j<=2*i-1;j++) {
				System.out.print("*");
			}
			
			/*공백*/
			for (int j=6; j>i; j--) {
				System.out.print(" ");
			}
			System.out.println();
		}
		
		
		
		/*역 삼각형*/
		for (int i=1; i<=6; i++) {
			/*공백*/
			for (int j=1; j<i; j++) {
				System.out.print(" ");
			}
			/*별 반복*/
			for (int j=i; j<=2*6-i; j++) {
				System.out.print("*");
			}
			/*공백*/
			for (int j=1; j<i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		
		
		
		System.out.println();
		
		
		
		for(int i=1; i<=6; i++) {
			for (int j=6; j>i; j--){
				System.out.print(" ");
			}
			for(int j=1; j<=2*i-1;j++){
				System.out.print("*");
			}
			for (int j=6; j>i; j--){
				System.out.print(" ");
			}
			System.out.println();
		}
		
		
		
		
	}

}
