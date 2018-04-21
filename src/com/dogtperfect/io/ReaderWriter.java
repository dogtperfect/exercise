package com.dogtperfect.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class ReaderWriter {
	
	public static void testReader() {
		File f = new File("c:/lianxi/crt.txt");
		try(FileReader fr = new FileReader(f)) {
			char[] all = new char[(int)f.length()];
			fr.read(all);
			System.out.println(Arrays.toString(all));
			System.out.println(String.valueOf(all));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void testWriter() {
		File f = new File("c:/lianxi/key.txt");
		try(FileWriter fw = new FileWriter(f)){
			Calendar ca = Calendar.getInstance();
			Date d1 = ca.getTime();
			String data = d1.toString();
			fw.write(data);
			
			fw.write("\r\n");
			
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			String d2 = sdf.format(d1);
			char[] da = data.toCharArray(); // string -> char[]
			fw.write(da);
//			fw.write(d2);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void jiami(File encoding, File encoded) {
		try(FileReader fr = new FileReader(encoding)){
			char[] ca = new char[(int)encoding.length()];		
			fr.read(ca);
			System.out.println("before jiami");
			System.out.println(String.valueOf(ca));
			
			for(int i=0 ; i < ca.length; i++) {
				if(ca[i] == '9') {
					ca[i] = '0';
				}else if (ca[i] == 'z'){
					ca[i] = 'a';
				} else if (ca[i] == 'Z') {
					ca[i] = 'A';
				} else if(Character.isLetterOrDigit(ca[i])) {
					ca[i] = (char) ((short)ca[i] + 1);
				}
				
			}
			
			System.out.println("after jiami");
			System.out.println(String.valueOf(ca));
			
			try(FileWriter fw = new FileWriter(encoded)){
				fw.write(ca);
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void jiemi(File decoding, File decoded) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testReader();
//		testWriter();
		File encoding = new File("c:/lianxi/jiami.txt");
		File encoded = new File("c:/lianxi/jia.txt");
		jiami(encoding, encoded);
	}

}
