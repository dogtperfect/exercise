package com.dogtperfect.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class TestCode {

	public static void showCode(String str) {
		String[] encodes = new String[] {"BIG5","GBK", "GB2312", "UTF-8","UTF-16","UTF-32"};
		for (String encode: encodes) {
			showCode(str,encode);
		}
	}
	
	public static void showCode(String str, String encode) {
		try {
			System.out.printf("Undering %s encode, character \"%s\" \' hex code is: %n",encode,str);
		
			// 得到 utf-8 编码后的byte[], 也就是写入磁盘的01
			byte[] bs = str.getBytes(encode);
			
// utf-8编码的unicode -> new String(byte[], "utf-8") -> 解码出unicode
			//解码unicode是应用程序自动完成
			String gbk = new String(bs, "GBK");
			System.out.println("parse GBK byte array: "+ gbk);
			String utf8 = new String(bs, "UTF-8");
			System.out.println("parse utf8 byte array: "+ utf8); 
			String utf16 = new String(bs, "UTF-16");
			System.out.println("parse utf16 byte array: "+ utf16); 
			
			for (byte b: bs) {
				int i = b&0xff;
				System.out.print(Integer.toHexString(i)+" ");
			}
			System.out.println();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.printf("%s encoding can\'t parse character %s %n" , encode,str);
		}		
	}
	
	public static void setCharset() {
		File f = new File("c:/lianxi/tt.txt");
		
		// new stream reader 放在一行，  这样只要一个 try 就行了 
		// Charset.forName("utf-8") 指定InputStreamReader 的编码
		// 换成 GBK 就中文乱码
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f), Charset.forName("utf-8"))){
			char[] cs= new char[(int)f.length()];
			
			isr.read(cs);
			System.out.println("utf-8 编码方式识别出的字符是 ： ");
			System.out.println(new String(cs));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
		try(FileReader fr = new FileReader(f)){
			char[] cs = new char[(int)f.length()];
			fr.read(cs);
			//中文操作系统 中文默认编码 GBK
			System.out.println("FileReader 默认的编码方式 读出来的内容是：");
			System.out.println(new String(cs));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "中";
//		showCode(str);
		setCharset();
	}

}
