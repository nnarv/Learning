package com.basic.String;

public class ReverseString {

	
	/**
	 * Reverse string recursively. 
	 * substring(startIndex,endIndex) --- returns string from startIndex to endIndex-1
	 * 
	 * @param s
	 * @return
	 */
	static String recursiveReverse(String s){
		if(s.length()==1){
			return s;
		}
		
		return s.charAt(s.length()-1) + recursiveReverse(s.substring(0, s.length()-1));
	}
	
	/**
	 * Reverse string iteratively
	 * 
	 * @param s
	 * @return
	 */
	static String iterativeReverse(String s){
		//Using StringBuffer and in-built function. NO in-built function in String class
		StringBuffer sb = new StringBuffer(s);
		System.out.println(sb.reverse().toString());
		
		int n = s.length();
		StringBuilder rev = new StringBuilder();
		for(int i=n-1;i>=0;i--){
			rev.append(s.charAt(i));
		}
		return rev.toString();
	}
	
	
	public static void main(String[] args) {
		String s = "testing";
		
		System.out.println(ReverseString.iterativeReverse(s));
		
		System.out.println(ReverseString.recursiveReverse(s));
	}

}
