package me.xunmi.testInterface;

import me.xunmi.testclass.Hero;

public class Support extends Hero implements Healer{
	public void heal() {
		System.out.println(name+"add one blood");
	}
}
