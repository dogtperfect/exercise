package com.dogtperfect.io;

import java.io.File;

public class TestFile {
	
	public static void main(String[] args) {
		File f1 = new File("b:/lianxi/");
		System.out.println("f1 absolute path is: "+ f1.getAbsolutePath());
		File f2 = new File("io.txt");
		System.out.println("f2 absolute path is: "+ f2.getAbsolutePath());
		File f3 = new File(f1,"ii.txt");
		System.out.println("f3 absolute path is: "+ f3.getAbsolutePath());
	}
}
