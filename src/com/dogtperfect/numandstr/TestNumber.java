package com.dogtperfect.numandstr;

public class TestNumber {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		float i = (float) 3.14;
//		String pi = String.valueOf(i);
//		Float ii = i;
//		String pi = ii.toString();
//		System.out.println(pi);
//		System.out.println(pi instanceof String);
		
//		String pi = "3.14";
//		float i = Float.parseFloat(pi);
//		System.out.println(i);
//		System.out.println( i instanceof );		
		
//		String pi = "3.1a4";
		String pi = "3.14";
		float i = Float.parseFloat(pi);
		System.out.println(i);
		

		// 总结:
		// float to String : 两种方法 
		// String.valueOf(float) 
		// Integer i =4; i.toString()
		// String to float : 
		// Integer.parseInt(string)  Float.parseFloat(string)
		
	}

}
