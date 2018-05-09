package me.xunmi.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

// 重复put == 更新
		heroMap.put("jack", new Hero("big mouse"));
		System.out.println(heroMap);
	}
	
	public static void storeInHashMap() {
		HashMap<String, List<Hero>> heros = new HashMap<>();
		long start = System.currentTimeMillis();
		for(int i = 0; i<3000000; i++) {
			Hero hero = new Hero("hero-"+ (int)(Math.random()*9000 + 1000));
			List<Hero> heroList = heros.get(hero.name);
// 新的name, HashMap中没有. 先put 一个空的List , 再往List 中加对象			
			if (heroList == null) {
				//少了这句, 会nullPointer 异常
				heroList = new ArrayList<>();
				heros.put(hero.name, heroList);
			}
			heroList.add(hero);
		}
		long end = System.currentTimeMillis();
		System.out.println("store all in HashMap spend time: "+(end - start));
		
		start = System.currentTimeMillis();
		List<Hero> result = new ArrayList<>();
		result = heros.get("hero-5555");
		end = System.currentTimeMillis();
		System.out.println(result);
		System.out.println("search hero-5555 in HashMap spend time: "+(end - start));
	}
	
	public static void storeInList(){
		List<Hero> heros = new ArrayList<>();
		long start = System.currentTimeMillis();
		for(int i=0; i<3000000; i++) {
// 产生四位随机数
			heros.add(new Hero("hero-"+ (int)(Math.random()*9000 + 1000)));
		}
		long end = System.currentTimeMillis();
		System.out.println("store all in List spend time: "+(end - start));
		
		List<Hero> result = new ArrayList<>();
		start = System.currentTimeMillis();
		for(Hero h: heros) {
			if (h.name.equals("hero-5555")) {
				result.add(h);
			}
		}
		end = System.currentTimeMillis();
		System.out.println(result);
		System.out.println("search hero-5555 in List spend time: "+(end - start));
		
		
	}
	
	public static void reverseKeyValue() {
		HashMap<String,String> notExist = new HashMap<>();
		notExist.put(null, "notExist");
		notExist.put("notExist", null);
		
		Hashtable<String,String> ht = new Hashtable<>();
// 运行时错误, 编译时不报错
//		ht.put(null, "notExist");
//		ht.put("notExist", null);
		
		HashMap<String,String> reverse = new HashMap<>();
		reverse.put("key1", "value1");
		reverse.put("key2", "value2");
		System.out.println(reverse);
		System.out.println();
		Set<String> keys = reverse.keySet();
		reverse.values();
// HashMap 没有此遍历		
/*		for (String r: reverse) {
			
		}*/

		HashMap<String,String> temp = new HashMap<>();
		
//HashMap 遍历方法一:		iterator entrySet()
		Iterator<Map.Entry<String, String>> it = reverse.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String value = entry.getValue();
			String key = entry.getKey();
			//运行时会 java.util.ConcurrentModificationException			
		  //reverse.put(value, key);
			temp.put(value, key);
		}
		
		System.out.println("iterator entrySet");
		reverse.clear();
		reverse.putAll(temp);
		System.out.println(reverse);
		
		temp.clear();
		System.out.println();
		
//HashMap 遍历方法二:		enforce for entrySet()
		Set<Map.Entry<String, String>> entrySet = reverse.entrySet();
		for(Map.Entry<String, String> es: entrySet) {
			temp.put(es.getValue(), es.getKey());
		}
		reverse.clear();
		reverse.putAll(temp);
		System.out.println("enforce for entrySet");
		System.out.println(reverse);
	
		temp.clear();
		System.out.println();
		
//HashMap 遍历方法三:     enforce for keySet()
		Set<String> keySet = reverse.keySet();
		for(String key: keySet) {
			String value = reverse.get(key);
			temp.put(value, key);
		}
		reverse.clear();
		reverse.putAll(temp);
		System.out.println("enforce for keySet");
		System.out.println(reverse);
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testHashMap();
//		storeInHashMap();
//		storeInList();
		reverseKeyValue();
	}

}
