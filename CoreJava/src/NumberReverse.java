
public class NumberReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 78945;
		int rev = 0;
		while(num>0){
			rev = rev * 10 + num % 10 ;
			num = num/10;
		}
		System.err.println(rev);
	}

}
