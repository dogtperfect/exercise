package me.xunmi.testclass;

public class Support extends Hero {

	public void heal() {
		System.out.println("add hp for self");
	}
	
	public void heal(Hero h) {
		h.hp += 100;
	}
	
	public void heal(Hero h, int hp) {
		h.hp += hp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
