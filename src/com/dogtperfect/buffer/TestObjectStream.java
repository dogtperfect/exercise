package com.dogtperfect.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjectStream {
	
	public static void testSerialize() {
		Hero h = new Hero();
		h.name = "greem";
		h.hp = 616;
		File f = new File("c:/lianxi/xxx.txt");
		try(
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
		){
			oos.writeObject(h);
			Hero h2 = (Hero)ois.readObject();
			System.out.println(h2.name);
			System.out.println(h2.hp);
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void serializeArray() {
		Hero[] ha = new Hero[10];
		for(int i =0 ; i<ha.length; i++) {
			ha[i] = new Hero("Hero "+i);
		}
		File f = new File("c:/lianxi/hero.lol");
		
		try(
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
		){
			
// 可以直接把 对象数组 写进文件
			oos.writeObject(ha);
// 从文件直接读出 对象数组
			ha = (Hero[])ois.readObject();
			
			for(Hero h : ha) {
				System.out.println(h.name);
			}
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testSerialize();
		serializeArray();
	}

}
