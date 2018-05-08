package me.xunmi.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionGeneric {

	public static void genericList() {
		List<Lol> lol = new ArrayList<>();
		lol.add(new Item("gun"));
		lol.add(new Hero("man"));
		lol.add(new Item("arrow"));
		lol.add(new Hero("magic"));
// 不是Lol 类型, 放不进去		
//		lol.add(new Gaint());
		System.out.println("------------for---------------");
		for(int i =0; i<lol.size(); i++) {
			System.out.println(lol.get(i));
		}
		
		System.out.println("------------iterator  for----------");
		for(Iterator<Lol> iterator = lol.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		
		System.out.println("----------iterator while ---------");
		Iterator<Lol> iterator = lol.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("-----------enforce for -----------");
		for(Lol lo: lol ) {
			System.out.println(lo);
		}
		
	}
	
	public static void deleteByName() {
		List<Hero> heros = new ArrayList<>();
		for (int i=0; i<10; i++) {
			heros.add(new Hero("hero "+i));
		}
		
		for(Hero h: heros) {
			System.out.println(h);
		}
	
// currentModify Exception		
/*		Iterator<Hero> it = heros.iterator();
		while(it.hasNext()) {
			Hero h = it.next();
			if (h.name.equals("hero 7")) {
				heros.remove(h);
			}
		}*/
		
		Hero he =null;
		Iterator<Hero> it = heros.iterator();
		while(it.hasNext()) {
			Hero hero = it.next();
			if (hero.name.equals("hero 7")) {
				he = hero;
			}
		}
//遍历过程中 , 不能修改List	
		heros.remove(he);
		
		System.out.println("------------");
		
		for(Hero h: heros) {
			System.out.println(h);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		genericList();
		deleteByName();
	}

}
