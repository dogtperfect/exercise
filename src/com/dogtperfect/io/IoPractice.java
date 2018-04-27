package com.dogtperfect.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IoPractice {

	public static void copyFile(String src, String dest) {
		File s = new File(src);
		File d = new File(dest);
		
		
//��FileReader ����, ��������, ��ΪFileReader Ĭ���� GBK����
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
		
//��FileInputStream ����,  ����û������
/*		byte[] b = new byte[(int)s.length()];
		try(	FileInputStream fis = new FileInputStream(s);
				FileOutputStream fos = new FileOutputStream(d);
		){
			fis.read(b);
			fos.write(b);
		}catch(IOException e) {
			e.printStackTrace();
		}*/
		
// ��վ���� byte[1024], ���ƴ��ļ���ʱ��ռ���ڴ�		
		byte[] buffer = new byte[128];
		try(	FileInputStream fis = new FileInputStream(s);
				FileOutputStream fos = new FileOutputStream(d);
		){
			while(true) {
				int count = fis.read(buffer);
				if (count == -1) {
					break;
				}
// fos.write(buffer) , ���buffer �еĿյĲ���Ҳ���ƹ�ȥ				
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
				File newFile = new File(d,f.getName());
				copyFile(f.getAbsolutePath(),newFile.getAbsolutePath());
			}
			if(f.isDirectory()) {
				File newDir = new File()
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		copyFile("c:/lianxi/copy.txt", "c:/lianxi/copy2.txt");
	}

}
