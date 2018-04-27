package com.dogtperfect.buffer;

import java.io.Serializable;

public class Hero implements Serializable{
	private static final long serialVersionUid = 1L;
	public String name;
	public float hp;
	Hero(String name){
		this.name = name;
	}
	Hero(){
		
	}
}
