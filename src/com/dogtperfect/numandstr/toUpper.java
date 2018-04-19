package com.dogtperfect.numandstr;

public class toUpper {
	
	public static void testStringBuffer() {
		String str = "test string buffer";
		System.out.println(str);
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		sb.append(" and haha");
		System.out.println(sb);
		sb.delete(5, 10);  			//10 ²»É¾³ý
		System.out.println(sb);
		sb.insert(5, "lo ");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
	} 
	
	public static void main(String[] args) {
/*		String s = "do great than perfect";
		System.out.println(s);
		String[] words = s.split(" ");
		String result = "";
		for (int i =0; i< words.length;i++) {
			String word = words[i];
			char upperCase = Character.toUpperCase(word.charAt(0));
			String left = word.substring(1);
			String toUpper = upperCase + left;
			result += toUpper+" ";
		}
		System.out.println(result);*/
		
		testStringBuffer();
	}
}
