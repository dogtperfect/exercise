package com.dogtperfect.io;

import java.io.File;
import java.util.Date;

public class TestFile {
	
	public static void file() {
		File f1 = new File("b:/lianxi/");
		System.out.println("f1 absolute path is: "+ f1.getAbsolutePath());
		File f2 = new File("io.txt");
		System.out.println("f2 absolute path is: "+ f2.getAbsolutePath());
		File f3 = new File(f1,"ii.txt");
		System.out.println("f3 absolute path is: "+ f3.getAbsolutePath());
		
		File f4 = new File("b:/lianxi/io.txt");
		System.out.println("f4 : "+ f4);
		System.out.println("if f4 exists : "+ f4.exists());
		System.out.println("if f4 is directory: "+ f4.isDirectory());
		System.out.println("if f4 is file: " + f4.isFile());
		System.out.println("length of f4 is: "+ f4.length());
		
		long time = f4.lastModified();
		Date d = new Date(time);
		System.out.println("last modify time : "+ d);
		f4.setLastModified(0);
		
		long time2 = f4.lastModified();
		Date d2 = new Date(time2);
		System.out.println("last modify time : "+ d2);
		
		File f5 = new File("b:/lianxi/oo.txt");
		f4.renameTo(f5);
		
		File f6 = new File("b:/lianxi/oo/oo.txt");
		f1.list();
		f1.listFiles();
		// 建立 oo.txt 所在的目录 ./lianxi/oo/
		File dir = f6.getParentFile();
		dir.mkdirs();
		
		f6.listRoots();
	}
	
/*	public static void findFile() {
		File f= new File("b:/lianxi/");
		File[] fs = f.listFiles();
		if (null == fs) {
			return;
		}
		long minSize = Integer.MAX_VALUE;
		long maxSize = 0;
		File minFile = null;
		File maxFile = null;
		for(File file: fs) {
			if(file.isDirectory()) {
				continue;
			}
			if (file.length()> maxSize) {
				maxSize = file.length();
				maxFile = file;
			}
			if (file.length()!=0 && file.length()< minSize) {
				minSize = file.length();
				minFile = file;
			}
		}
		System.out.printf("max file is %s, size is %d byte%n",maxFile.getAbsoluteFile(),maxFile.length());
		System.out.printf("min file is %s, size is %d byte%n", minFile.getAbsoluteFile(), minFile.length());
		
	}
	*/
	static long minSize = Integer.MAX_VALUE;
	static long maxSize = 0;
	static File minFile = null;
	static File maxFile = null;
	public static void recurFindFile(File file) {
		if(file.isFile()) {
			if(file.length() > maxSize) {
				maxSize = file.length();
				maxFile = file;
			}
			if (file.length() < minSize && file.length() != 0) {
				minSize = file.length();
				minFile = file;
			}
		}
		
		if(file.isDirectory()) {
			File[] fs = file.listFiles();
			if(null!=fs) {
				for (File f: fs) {
					recurFindFile(f);
				}
			}
		}		
	}
	
	public static void main(String[] args) {
		file();
//		findFile();
		File f = new File("b:/lianxi/");
		recurFindFile(f);
		System.out.printf("max file is %s, size is %d byte%n",maxFile.getAbsoluteFile(),maxFile.length());
		System.out.printf("min file is %s, size is %d byte%n", minFile.getAbsoluteFile(), minFile.length());
	}
}



















