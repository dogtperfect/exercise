package com.dogtperfect.buffer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class systemin {

//�������� byte[]
	public static void sin() {
		try(InputStream is = System.in){
			while(true) {
				int i = is.read();
				System.out.println(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
// �������� char[] �� String	
	public static void scanner() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			String line = scan.nextLine();
			System.out.println(line);
		}
	}
	
// ͬ������20, ���������ת�� ascii ��	, �����Զ�ȥ���س���
	public static void readint() {
		Scanner ri = new Scanner(System.in);
		while(true) {
			int i = ri.nextInt();
			System.out.println(i);
		}
	}
	
	public static void buildClass() {
		File moban = new File("c:/lianxi/moban.txt");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input class name");
		String className = sc.nextLine();
		className = toUpperFirstLetter(className);
		System.out.println("Please input property type");
		String ptype = sc.nextLine();
		System.out.println("Please input property name");
		String pname = sc.nextLine();
		String Upname = toUpperFirstLetter(pname);
		
		String mobanContent = null;
		
		try (FileReader fr = new FileReader(moban)){
			char[] c = new char[(int)moban.length()];
			fr.read(c);
			
			mobanContent = new String(c);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mobanContent = mobanContent.replaceAll("@class@", className);
		mobanContent = mobanContent.replaceAll("@type@", ptype);
		mobanContent = mobanContent.replaceAll("@Uproperty@", Upname);
		mobanContent = mobanContent.replaceAll("@property@", pname);
		String filename = className + ".java";
		System.out.println("after replace, content is: ");
		System.out.println(mobanContent);
//ָ��Ŀ¼���½��ļ�
		File file = new File("c:/lianxi/",filename);
//д�� �½����ļ�
		try (FileWriter fw = new FileWriter(file) ){
			fw.write(mobanContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String toUpperFirstLetter(String str){
		char s0 = Character.toUpperCase(str.charAt(0));
		String s1 = str.substring(1, (int)str.length());
		str = s0 + s1;
		return str;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		sin();
//		readint();
//		scanner();
//		buildClass();
	}

}
