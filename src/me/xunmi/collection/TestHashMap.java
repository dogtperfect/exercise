package me.xunmi.collection;

import java.util.HashMap;

public class TestHashMap {
	
	public static void testHashMap() {
		HashMap<String, String> dict = new HashMap<>();
		dict.put("tom", "cat");
		dict.put("jack", "mouse");
		System.out.println(dict.get("tom"));
		
		HashMap<String,Hero> heroMap = new HashMap<>();
		heroMap.put("tom", new Hero("cat"));
		heroMap.put("jack", new Hero("mouse"));
		System.out.println(heroMap);

// ÖØ¸´put == ¸üÐÂ
		heroMap.put("jack", new Hero("big mouse"));
		System.out.println(heroMap);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testHashMap();
	}

}
