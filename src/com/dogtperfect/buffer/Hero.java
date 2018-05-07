package com.dogtperfect.buffer;

import java.io.Serializable;

public class Hero implements Serializable{
	private static final long serialVersionUid = 1L;
	public int id;
	public String name;
	public String skill;
	public float hp;
	public Hero(String name){
		this.name = name;
	}
	public Hero(){
		
	}
}
