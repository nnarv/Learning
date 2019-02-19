package com.basic.String;

public class ReverseString {

	public static void main(String[] args) {
		String s = "testing";
		
		//Using StringBuffer and in-built function. NO in-built function in String class
		StringBuffer sb = new StringBuffer(s);
		System.out.println(sb.reverse().toString());
		
		int n = s.length();
		StringBuilder rev = new StringBuilder();
		for(int i=n-1;i>=0;i--){
			rev.append(s.charAt(i));
		}
		System.out.println(rev.toString());
	}

}
