package com.dogtperfect.buffer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream {
	
	public static void read() {
		File f = new File("c:/lianxi/dis.txt");
		try( 
				FileInputStream fis = new FileInputStream(f);
				DataInputStream dis = new DataInputStream(fis);
		){
			boolean b = dis.readBoolean();
			int i = dis.readInt();
			String s = dis.readUTF();
			System.out.println("read boolean is : "+b);
			System.out.println("read int is : "+i);
			System.out.println("read String is : "+s);

		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write() {
		File f = new File("c:/lianxi/dis.txt");
		try (
				FileOutputStream fos = new FileOutputStream(f);
				DataOutputStream dos = new DataOutputStream(fos);
		){
			boolean b = false;
			int i = 32;
			String s = "string";
			dos.writeBoolean(b);
			dos.writeInt(i);
			dos.writeUTF(s);	
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readWrite() {
		int x = 1;
		int y = 2 ;
		File f = new File("c:/lianxi/xx.txt");
		try(
				FileInputStream fi = new FileInputStream(f);
				FileOutputStream fo = new FileOutputStream(f);
				DataInputStream dis = new DataInputStream(fi);
				DataOutputStream dos = new DataOutputStream(fo);
		){
			dos.writeInt(x);
			dos.writeInt(y);
			x = dis.readInt();
			y = dis.readInt();
			System.out.printf("使用数据流读取出的x是 %d y是 %d%n",x,y);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		write();
//		read();
		readWrite();
	}

}
