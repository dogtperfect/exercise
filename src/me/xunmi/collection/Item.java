package me.xunmi.collection;

public class Item implements Lol {
	String name;
	int price;
	
	public Item() {
	
	}
	
	public Item(String name) {
		this.name = name;
	}
	
	public void effect() {
		System.out.println("after use , have some effect");
	}
	public boolean disposable() {
		return false;
	}
	
	public String toString() {
		return name;
	}
}
