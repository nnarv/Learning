import java.util.Arrays;
import java.util.List;

public class LowestCost {

	public static int[] getJoinedPipes(int[] input1){
		//Arrays.sort(input1);
		
		 int n = input1[0];
		 int[] newInput = new int[n];
		 for(int j=0,i=1;j<n && i<=n;i++,j++){
		    newInput[j] = input1[i];
		 }
		sort(newInput);
	//display(newInput);
		int[] result = new int[n-1];
		
		for(int i=0;i<n-1;i++){
			int sum = newInput[i]+newInput[i+1];
			result[i] = sum;
			newInput[i+1] = sum;
		/*	System.out.println("Display iteration : "+i);
			display(result);*/
		}
		//Arrays.sort(result);
		sort(result);
		return result;
		
	}
	 
	public static void sort(int[] array){
		for(int i=0;i<array.length -1 ;i++){
			if(array[i]>array[i+1]){
				int temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
		}
	}
	public static void display(int[] result){
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {4, 4, 2, 3, 6};
		int[] result = getJoinedPipes(input);
		System.out.println("Output");
		display(result);
		
		
	}

}
