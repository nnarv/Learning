
public class Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * rint returns the closest integer to the double argument
		 */
		double r = Math.rint(9.4)+Math.rint(11.2);
		System.out.println(r);
		
		/**
		 * '+' operator for char adds the ASCII values of arguments
		 */
		char b ='a'+ 'c';
		int x = 'a';
		int y = 'c';
		char d = (char) (x+y);
		System.out.println(b);
		System.out.println(d);
		
		/**
		 * BODMAS : Brackets Orders Division Multiplication Addition Subtraction
		 * Division and Multiplication are of the same order. Start from left to right whichever comes first.
		 * Similarly Addition and Subtraction rank equally
		 */
		int v1=5;
		int v2=6;
		int v3;
		v3 =v2++*v1/v2+v2;
		System.out.println(v3);
		
		int x1=5;
		float y1=x1;
		System.out.println(y1%x1);
		

	}

}
