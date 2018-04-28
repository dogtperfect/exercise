package me.xunmi.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestException {
	
	public static void testException() {
		File f = new File("c:/1.txt");
		try{
			new FileReader(f);
			System.out.println("file exists");
		}catch(IOException e) {
			System.out.println("file not found");
		}finally {
			System.out.println("exec whether file exists or not");
		}
	}
	
	public static void method1() {
		try {
			method2();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void method2() throws FileNotFoundException {
		File f = new File("c:/1.txt");
		System.out.println("tempt open file");
		new FileReader(f);
		System.out.println("success open file");
	}
	
	public static int testReturn() {
		try {
			System.out.println("return 1");
			throw new RuntimeException();
//			return 1;
		}catch(Exception e) {
			System.out.println("return 2");
			e.printStackTrace();
			return 2;
		} finally {
			System.out.println("return 3");
			return 3;
		}
	}
	
//runtime Excepton 和 Error 都可以capture	
	public static void catchRuntime() {
		String str = null;
		try {
			str.toUpperCase();
		} catch (NullPointerException e ) {
			System.out.println("capture runtime exception");
			e.printStackTrace();
		}
	}
	
	public static void catchError() {
		StringBuffer sb = new StringBuffer("0123456789");
		try {
			for (int i =0 ; i<100; i++) {
				sb.append(sb.toString());
			}
		}catch(OutOfMemoryError e ) {
			System.out.println("capture outofmemery exception");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testException();
//		method1();
//		System.out.println(testReturn());
		catchRuntime();
		catchError();
	}

}
