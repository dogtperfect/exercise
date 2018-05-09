package me.xunmi.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import com.dogtperfect.numandstr.raoKouLing;


public class TestHashSet {

	public static void testHashSet() {
		HashSet<Integer> names = new HashSet<>();
		names.add(666);
		names.add(66);
		names.add(6666);
		names.add(6);
		for(Iterator<Integer> it = names.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		System.out.println();
		for(Integer name: names) {
			System.out.println(name);
		}
		System.out.println();
		
		names.add(6666);
		System.out.println("HashSet different from insert order");
		System.out.println(names);
		System.out.println();
	}
	
	public static void testLinkedHashSet() {
		LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
		lhs.add(666);
		lhs.add(66);
		lhs.add(6666);
		lhs.add(6);
		System.out.println("LinkedHashSet same insert order");
		System.out.println(lhs);
		System.out.println();
	}
	
	public static void testTreeSet() {
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(666);
		ts.add(66);
		ts.add(6666);
		ts.add(6);
		System.out.println("TreeSet have ordered");
		System.out.println(ts);
		System.out.println();
	}
	
	public static void outputPi() {
		LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
		System.out.println(Math.PI);
		String pi = String.valueOf(Math.PI);
		pi = pi.replace(".", "");
		char[] pic = pi.toCharArray();
		
		for(char c: pic) {
// char -----------------------> String ------------------------------> int
//       String.valueof(char c)           Integer.parseInt(String str)
//	 int,float,double都可以转成String	                         只有String 能转成 int
			int i = Integer.parseInt(String.valueOf(c));
			lhs.add(i);
		}
		System.out.println(lhs);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testHashSet();
		testLinkedHashSet();
		testTreeSet();
		outputPi();
		
// 使用HashSet , 存储重复的字符串		
//		raoKouLing.bijiao();
		
		
	}

}
