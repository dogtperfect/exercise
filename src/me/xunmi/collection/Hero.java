package me.xunmi.collection;

public class Hero implements Lol {
	public String name;
	public float hp;
	public int damage;
	public Hero() {
		
	}
	public Hero(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
