package com.dogtperfect.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// BufferReader BufferWriter ��һ����, ʢ��
public class testBuffer {
	public static void bufferReaderIsChars() {
		File f = new File("c:/lianxi/tt.txt");
		try (FileReader fr = new FileReader(f) ){
// BufferedReader ��Ҫ��װ FileReader
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
			}
				
		}catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	public static void testPrintWriter() {
		File f = new File("c:/lianxi/tp.txt");
		try(FileWriter fw = new FileWriter(f)) {
// PrintWriter ��Ҫ��װ FileWriter
			PrintWriter pw = new PrintWriter(fw);
			pw.println("green");
			pw.println("red");
// PrintWriter ����Ҫflush			
//			pw.flush();
			pw.println("blue");
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	public static void testBufferedWriter() {
		File f = new File("c:/lianxi/bw.txt");
		try(FileWriter fw = new FileWriter(f)) {
// BufferWriter ��Ҫ��װ FileWriter
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("bw green\r\n");
			bw.write("bw red");
// BufferedWriter ��Ҫflush , ����д���ļ�,������Ҫ��buffer��
//			bw.flush();
			bw.write("bw blue");
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	public static void removeComment(File f) {
		StringBuffer sb = new StringBuffer();
		
		try(FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr);){
			while(true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				if ( ! line.trim().startsWith("//")) {
					sb.append(line).append("\r\n");
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		try(FileWriter fw = new FileWriter(f); PrintWriter pw = new PrintWriter(fw);){
			pw.write(sb.toString());
		}catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		bufferReaderIsChars();
		testPrintWriter();
		testBufferedWriter();
//		File f = new File("c:/lianxi/cm.txt");
//		removeComment(f);
	}

}
