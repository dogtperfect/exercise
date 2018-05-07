package me.xunmi.collection;

import java.util.ArrayList;

public class TestArrayList {

	public static void testArrayList() {
		ArrayList heros = new ArrayList();
		heros.add(new Hero("tom"));
		System.out.println(heros.size());
		
		heros.add(new Hero("cat"));
		System.out.println(heros.size());
	}
	
	public static void crud() {
		ArrayList heros = new ArrayList();
		for(int i =0; i<5; i++) {
			heros.add(new Hero("hero "+i));
		}
		System.out.println(heros);
		Hero specialHero = new Hero("sepcial Hero");
		heros.add(3, specialHero);
		System.out.println(heros.toString());
		
		System.out.println("if contains new Hero 2");
		System.out.println(heros.contains(new Hero("hero "+2)));
		System.out.println("if contains special Hero");
		System.out.println(heros.contains(specialHero));
		
		System.out.println(heros.get(3));
		System.out.println(heros.get(5));
//		System.out.println(heros.get(6));
		
		System.out.println("special heros at: "+ heros.indexOf(specialHero));
// -1, 意思是不存在 
		System.out.println("new hero 1 at: "+ heros.indexOf(new Hero("hero "+1)));
		
		System.out.println("delete index 2");
		heros.remove(2);
		System.out.println(heros);
		
		System.out.println("delete index 2");
		heros.remove(2);
		System.out.println(heros);
		
		System.out.println("delete special hero");
// delete 不存在的元素， 不会抛出异常		
		heros.remove(specialHero);
		System.out.println(heros);
		
		System.out.println("update index 2");
		heros.set(2, new Hero("hero "+99));
		System.out.println(heros);
		
		Hero hs[] = (Hero[])heros.toArray(new Hero[]{});
		System.out.println("array: "+ hs);
		
		ArrayList anotherHeros = new ArrayList();
		anotherHeros.add(new Hero("hero a"));
		anotherHeros.add(new Hero("hero b"));
		anotherHeros.add(new Hero("hero c"));
		
		heros.addAll(anotherHeros);
		System.out.println("add another ArrayList");
		System.out.println(heros);
		
		heros.clear();
		System.out.println(heros);
	}
	
	public static void find() {
		ArrayList heros = new ArrayList();
		for (int i =0; i<5; i++) {
			heros.add(new Hero("hero "+i));
		}
		
		String name = "hero 3";
		
		for (int i=0; i<heros.size(); i++) {
			Hero hero = (Hero)heros.get(i);
			if(hero.name.equals(name)) {
				System.out.println("find hero 3, name is "+ hero.name);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testArrayList();
//		crud();
//		find();
		
	}

}
