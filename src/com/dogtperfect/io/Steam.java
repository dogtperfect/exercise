package com.dogtperfect.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Steam {
	public static void fileStream () {
		File f= new File("b:/lianxi/oo.txt");
		try {
			FileInputStream fis= new FileInputStream(f);
			byte[] all = new byte[(int)f.length()];
			fis.read(all);
			for(byte b: all) {
//				System.out.println((char)b);
				System.out.println(b);
			}
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File f2 = new File("b:/lianxi/dd.txt");
		try {
			byte[] data = new byte[]{88,  90};
			FileOutputStream fos = new FileOutputStream(f2);
			fos.write(data);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void splitFile(File srcFile, int eachSize) {
		if (0==srcFile.length()) 
			throw new RuntimeException("file size is 0 , can't split");
		byte[] allFile = new byte[(int)srcFile.length()];
		try {
			FileInputStream fis = new FileInputStream(srcFile);
			fis.read(allFile);
			fis.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void murgeFile(String folder, String filename) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileStream ();
	}

}
