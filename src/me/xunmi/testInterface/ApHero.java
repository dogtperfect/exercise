package me.xunmi.testInterface;

import me.xunmi.testclass.Hero;

public class ApHero extends Hero implements Ap{
	public void magicAttack() {
		System.out.println("magic attacking");
	}
}
