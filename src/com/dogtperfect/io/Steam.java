package com.dogtperfect.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

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
		int count = (int) Math.ceil ( (srcFile.length() / eachSize )+1 );
		System.out.println(count);
		for (int i=0; i<count; i++) {
			String eachFileName= srcFile.getName() + "-"+i;
			File eachFile = new File(srcFile.getParent(),eachFileName);
			byte[] eachContent;
			if(i!= count -1) {
				eachContent = Arrays.copyOfRange(allFile, i*eachSize, (i+1)*eachSize);
			}else {
				eachContent = Arrays.copyOfRange(allFile, i*eachSize, allFile.length);
			}
			try {
				FileOutputStream fos = new FileOutputStream(eachFile);
				fos.write(eachContent, 0, eachContent.length);
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void murgeFile(String folder, String filename) {
		File mugerFile = new File(folder,filename);
		try(FileOutputStream fos = new FileOutputStream(mugerFile)){
			int i =0;
			while(true) {
				File each = new File("c:/lianxi/cc.txt"+"-"+ i++);
				
				if (!each.exists()) {
					break;
				}
				
				try(FileInputStream fis = new FileInputStream(each)){
					byte[] b = new byte[(int)each.length()];
					fis.read(b);
					fos.write(b, 0, b.length);
					fos.flush();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		fileStream ();
		File srcFile = new File("c:/lianxi/cc.txt");
//		splitFile(srcFile, 1000*1024);
//		murgeFile("c:/lianxi/", "mm.txt");
	}
}
