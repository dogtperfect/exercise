package com.dogtperfect.numandstr;
import java.util.HashSet;

import numberandstring.typebox;

public class raoKouLing {

	public static void testString() {
		String sentence = "study java array, test string java to char array";
		char[] chararray = sentence.toCharArray();
		System.out.println(sentence.length() == chararray.length);
		System.out.println(chararray);
		String subString1 = sentence.substring(3);
		System.out.println(subString1);
		String subString2 = sentence.substring(3, 5);
		System.out.println(subString2);
		String splitSentences [] = sentence.split(",");
		for(String sub : splitSentences) {
			System.out.println(sub.trim());
			System.out.println(sub.trim().toLowerCase());
			System.out.println(sub.trim().toUpperCase());
		}
		System.out.println(sentence);
		System.out.println(sentence.indexOf('u'));
		System.out.println(sentence.indexOf("java"));
		System.out.println(sentence.lastIndexOf("java"));
		System.out.println(sentence.lastIndexOf("java", 22));// output 6 ?
		System.out.println(sentence.contains("char"));
		
		System.out.println();
		String tmp = sentence.replaceAll("java", "python");
		System.out.println(tmp);		
		tmp = tmp.replaceAll("array", "arrow");
		System.out.println(tmp);		
		String temp = sentence.replaceFirst("java", "rubyer");
		System.out.println(temp);
	}
	
	
	
	public static void bijiao() {
/*		String str1 = "the light";
		String str2 = "the light";
		System.out.println(str1== str2);*/
		
/*		String str1 = "the light";
		String str2 = new String(str1);
		String str3 = str1.toUpperCase();
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str1.equalsIgnoreCase(str3));*/
		
/*		String str1 = "the light";
		String start = "the";
		String end = "light";
		System.out.println(str1.startsWith("t"));
		System.out.println(str1.startsWith(start));
		System.out.println(str1.endsWith(end));*/
		
		HashSet<String> duplicate = new HashSet<>();
		
		String[] ss = new  String[100];
		for (int i = 0; i< ss.length; i++) {
			ss[i] = typebox.randomString(2);
		}
		for(int i =0; i < ss.length; i++) {
			System.out.print(ss[i]+ " ");
			if (i%20 == 19) {                    // 20 19 ? 
				System.out.println();
			}
		}
		for (String s1 : ss) {
			int repeat =0;
			for (String s2 : ss) {
				if (s1.equalsIgnoreCase(s2)) {
					repeat++;
					if (repeat == 2) {
						duplicate.add(s1.toLowerCase());
//						putIntoDuplicateArray(s1);
						break;
					}
				}
			}
		}
		
		System.out.printf("总共有%d 种重复的字符串  %n", duplicate.size());
		System.out.println(duplicate);
		/*System.out.printf("总共有%d 种重复的字符串  %n", pos);
		if (pos!=0) {
			for (int i = 0; i < pos; i++) {
				System.out.println(foundDuplicated[i]+" ");
			}
		}*/
		
	}
	
	static int pos;
	static String[] foundDuplicated = new String[100];
	
// 精妙	
	public static void putIntoDuplicateArray (String s) {
		for (int i = 0; i < pos; i++) {
			if (foundDuplicated[i].equalsIgnoreCase(s)) {
				return;
			}
		}
		foundDuplicated[pos++]= s;
	}
	
	public static void raoKouLing() {
		String rao = "peter piper picked a peck of pickled peppers";
		System.out.println(rao);
		String [] charArray = rao.split(" ");
		int count = 0;
		for (String ch: charArray) {
			if (ch.startsWith("p")) {
				count ++;
			}
		}
		System.out.println("have "+count+" words start with 'p'");
	}
	
	public static void jianGe() {
		String str = "lengendary" ;
		char[] charStr = str.toCharArray();
		for (int i =0; i < charStr.length; i++) {
			if (i%2 == 0) {
				charStr[i] = Character.toUpperCase(charStr[i]);
			}
		}
		// two way of char array to String
		System.out.println(String.valueOf(charStr));
		System.out.println(new String(charStr));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		raoKouLing();
//		jianGe();
		bijiao();
//		testString();
	}

}
