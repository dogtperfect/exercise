package me.xunmi.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestTrans {

	public static void trans() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sqlD = "delete from hero where id = ? ";
		String sqlS = "select id from hero limit 5";
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
//ʹ������statement , ��Ȼ����ͬʱ�õ����� ResultSet. ִ����һ��execute, ��ر���һ����ResultSet		
				PreparedStatement s = c.prepareStatement(sqlD);		
				Statement sd = c.createStatement();
				Scanner sc = new Scanner(System.in);
		){		
//executeQuery(sql) ֱ�ӷ��� ResultSet, ����getResultSet			
			ResultSet rs = sd.executeQuery(sqlS);		
			c.setAutoCommit(false);
			for (int i=0 ; i<5; i++) {
				if(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("id: " + id );			
					s.setInt(1, id);
					s.execute();
					System.out.println("id: "+id+" will delete");
				}
			}
			
			System.out.println("input yes or no, if delete all the 5 data or not");
			String yn = sc.nextLine();
			boolean in = true;
			while (in) {
				switch (yn) {
					case "yes":
						c.commit();
						System.out.println("you input yes, delete 5");
						in = false;
						break;
					case "no":
						System.out.println("you input no, will not delete");
						in = false;
						break;
					default:
						System.out.println("please input yes or no");
						yn = sc.nextLine();			
				}
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trans();
	}

}
