package com.dogtperfect.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class IoPractice {

	public static void copyFile(String src, String dest) {
		File s = new File(src);
		File d = new File(dest);
		
		
//用FileReader 复制, 中文乱码, 因为FileReader 默认用 GBK解码
/*		char[] c = new char[(int)s.length()];
		try(	FileReader fr = new FileReader(s);
				FileWriter fw = new FileWriter(d);
		){	
			fr.read(c);
			fw.write(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
		
//用FileInputStream 复制,  中文没有乱码
/*		byte[] b = new byte[(int)s.length()];
		try(	FileInputStream fis = new FileInputStream(s);
				FileOutputStream fos = new FileOutputStream(d);
		){
			fis.read(b);
			fos.write(b);
		}catch(IOException e) {
			e.printStackTrace();
		}*/
		
// 网站答案用 byte[1024], 复制大文件的时候不占用内存		
		byte[] buffer = new byte[128];
		try(	FileInputStream fis = new FileInputStream(s);
				FileOutputStream fos = new FileOutputStream(d);
		){
			while(true) {
				int count = fis.read(buffer);
				if (count == -1) {
					break;
				}
// fos.write(buffer) , 会把buffer 中的空的部分也复制过去				
				fos.write(buffer,0,count);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void copyDir(String src, String dest) {
		File s = new File(src);
		File d = new File(dest);
		if (! s.exists()) {
			return;
		}
		if ( !s.isDirectory()) {
			return;
		}
		if ( d.isFile()) {
			return;
		}
		if ( !d.exists()) {
			d.mkdirs();
		}
		File[] files = s.listFiles();
		for(File f : files) {
			if(f.isFile()) {
				//d 是文件夹, getName() 得到文件夹或文件的名字
				File newFile = new File(d,f.getName());
				copyFile(f.getAbsolutePath(),newFile.getAbsolutePath());
			}
			if(f.isDirectory()) {
				File destDir = new File(d, f.getName());
				copyDir(f.getAbsolutePath(),destDir.getAbsolutePath());
			}
		}
		
	}
	
	public static void search(File f, String s) {
		if(f.isFile()) {
			if(f.getName().toLowerCase().endsWith(".java")) {
				String fileContent = readFile(f);
				if(fileContent.contains(s)) {
					System.out.printf("find %s, at %s %n",s,f.getAbsolutePath());
				}
			}
		}
		if(f.isDirectory()) {
			for(File ff: f.listFiles()) {
				search(ff,s);
			}
		}
	}

//此方法无法搜索中文, 因为FileRead 默认用GBK , 无法解码notepad 的utf-8
/*	public static String readFile(File f) {
		char[] cs = new char[(int)f.length()];
		try(FileReader fr = new FileReader(f)) {
			fr.read(cs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(cs);
	}*/

	public static String readFile(File f) {
		char [] bs = new char[(int)f.length()];
		try( 
				FileInputStream fs = new FileInputStream(f);
				InputStreamReader isr = new InputStreamReader(fs, Charset.forName("utf-8"));
		){
			isr.read(bs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(bs);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		copyFile("c:/lianxi/copy.txt", "c:/lianxi/copy2.txt");
//		copyDir("c:/lianxi/", "c:/lianxi2/");
		File j = new File("c:/lianxi");
		search(j,"中文");
	}

}
