package me.xunmi.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestTrans {

	public static void trans() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sqlD = "delete from hero where id = ?";
		String sqlS = "select id from hero limit 5";
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
				PreparedStatement s = c.prepareStatement(sqlD);				
		){		
			ResultSet rs = s.executeQuery(sqlS);		
			c.setAutoCommit(false);
			for (int i=0 ; i<5; i++) {
				if(rs.next()) {
					int id = rs.getInt(1);
					s.setInt(1, id);
					s.execute(sqlD);
					continue;
				}
			}
			Scanner sc = new Scanner(System.in);
			String yn = sc.nextLine();
			switch (yn) {
				case "yes":
					c.commit();
					break;
				case "no":
					yn = sc.nextLine();
					break;
				default:
					System.out.println("please input yes or no");
					yn = sc.nextLine();			
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
