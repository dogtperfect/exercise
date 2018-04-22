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
		
			// �õ� utf-8 ������byte[], Ҳ����д����̵�01
			byte[] bs = str.getBytes(encode);
			
// utf-8�����unicode -> new String(byte[], "utf-8") -> �����unicode
			//����unicode��Ӧ�ó����Զ����
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
		
		// new stream reader ����һ�У�  ����ֻҪһ�� try ������ 
		// Charset.forName("utf-8") ָ��InputStreamReader �ı���
		// ���� GBK ����������
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f), Charset.forName("utf-8"))){
			char[] cs= new char[(int)f.length()];
			
			isr.read(cs);
			System.out.println("utf-8 ���뷽ʽʶ������ַ��� �� ");
			System.out.println(new String(cs));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
		try(FileReader fr = new FileReader(f)){
			char[] cs = new char[(int)f.length()];
			fr.read(cs);
			//���Ĳ���ϵͳ ����Ĭ�ϱ��� GBK
			System.out.println("FileReader Ĭ�ϵı��뷽ʽ �������������ǣ�");
			System.out.println(new String(cs));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "��";
//		showCode(str);
		setCharset();
	}

}
