package me.xunmi.testclass;

public class ADHero extends Hero {
	public void attack() {
		System.out.println(name + " attack some one ");
	}
	public void attack(Hero h1) {
		System.out.println(name + " attack " + h1);
	}
	public void attack(Hero h1, Hero h2) {
		System.out.println(name +" attack "+ h1 + " and "+ h2);
	}
	
	public static void main (String args[]) {
		ADHero h1 = new ADHero();
		h1.name = "h1";
		
		Hero h2 = new Hero();
		h2.name = "h2";
		
		Hero h3 = new Hero();
		h3.name = "h3";
		
		h1.attack();
		h1.attack(h2);
		h1.attack(h2,h3);
	}
}
