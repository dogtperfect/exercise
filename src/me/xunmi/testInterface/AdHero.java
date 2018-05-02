package me.xunmi.testInterface;

import me.xunmi.testclass.Hero;

public class AdHero extends Hero implements Ad{
	public void physicAttack() {
		System.out.println("physic attacking");
	}
}
