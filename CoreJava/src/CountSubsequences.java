import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Help {
	
	int countSeq(String input, char ch, int count){
		System.out.println("Input : "+ input+ " count : "+count);
        int firstIndex = input.indexOf(ch);
        if(firstIndex<0){
            return 0;
        }
        if(firstIndex == input.length()-1){
            return count + firstIndex+1;
        }
        
        if(count==0){
        	count = firstIndex + 1;
        }else{
        	count+=firstIndex + 1;
        }  
        return count + countSeq(input.substring(firstIndex+1), ch, count);
    }
	
	
}

public class CountSubsequences {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter wr = new PrintWriter(System.out);
	         String S = br.readLine();
	         int Q = Integer.parseInt(br.readLine().trim());
	         String[] arr = new String[Q];
	         for(int i_arr=0; i_arr<Q; i_arr++)
	         {
	         	arr[i_arr] = br.readLine();
	         }

	         int[] out_ = helpPrivateRyan(S, arr);
	         System.out.print(out_[0]);
	         for(int i_out_=1; i_out_<out_.length; i_out_++)
	         {
	         	System.out.print(" " + out_[i_out_]);
	         }

	         wr.close();
	         br.close();

	}
	
	static int[] helpPrivateRyan(String S, String[] arr){
        // Write your code here
		int seq[] = new int[arr.length];
        Help help = new Help();
        for(int i=0;i<arr.length;i++){
            String q = arr[i];
            char ch = q.charAt(0);
            seq[i] = help.countSeq(S, ch, 0);
        }
        return seq;
    }

}
