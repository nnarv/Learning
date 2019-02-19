
public class NumberSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 18;
		int b = 65;
		System.out.println("before swap : "+ a + " : " + b);
		
		//1. using temp variable
		/*int temp = a;
		a = b;
		b = temp;*/
		
		// Without temp. using + operator
	/*	a = a + b; //83
		b = a - b; //18 
		a = a - b; //65
*/		
		//Without temp. using * operator
		a = a * b ; // 1170
		b = a / b ; // 18
		a = a / b ; // 65
		
		//Without temp. using XOR (^) operator
		a = a ^ b ;
		System.err.println(a);
		/*a = a ^ b;
		System.err.println(b);*/
		
		System.out.println("after swap : "+ a + " : " + b);
	}

}
