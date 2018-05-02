package me.xunmi.testInterface;

import me.xunmi.testclass.Hero;

public class AdApHero extends Hero implements Ad, Ap {
	public void magicAttack() {
		System.out.println("magic attacking");
	}
	public void physicAttack() {
		System.out.println("physic attacking");
	}
}
