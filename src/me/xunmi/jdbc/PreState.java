package me.xunmi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreState {
	
	public static void testPre() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "insert into hero values (null,?,?,?)";
		
// 结果为空, 阻止SQL注入
//		String na = " 'bala' or 1=1";
//		String sql = "select * from hero where name = ?";
		
		try (
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8", "root", "xinshang123");
				PreparedStatement ps = c.prepareStatement(sql);
		){
			ps.setString(1, "bala");
			ps.setString(2, "balabala");
			ps.setInt(3, 250);
			ps.execute();

			
// insert update delete , 在 prepareStatement 下 , ResultSet 为空 			
//			ResultSet rs = ps.getResultSet();
//			if (rs.next()) {
//				System.out.println("column 1 is: "+ rs.getInt(0));
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void speed() {
		long start1 = System.currentTimeMillis();
		commonInsert();
		long end1 = System.currentTimeMillis();
		System.out.println("普通SQL insert 消耗时间: "+ (end1 - start1)); // 19s
		
		long start2 = System.currentTimeMillis();
		prepareInsert();
		long end2 = System.currentTimeMillis();
		System.out.println("预编译SQL insert 消耗时间: "+ (end2 - start2)); //15s
	}
	
	public static void commonInsert() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
				Statement s = c.createStatement();				
		){		
			for (int i=0 ; i<100; i++) {
				String sql = "insert into hero values("+ null +",'sword','wolf',"+ i + ")";
				s.execute(sql);
// 普通的 Statement, cud 之后的 ResultSet 也为空
//				ResultSet rs = s.getResultSet();
//				while(rs.next()) {
//					System.out.println(rs.getInt(1));
//				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void prepareInsert() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "insert into hero values(null,?,?,?)";
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
				PreparedStatement s = c.prepareStatement(sql);				
		){		
			for (int i=0 ; i<100; i++) {
				s.setString(1, "bala");
				s.setString(2, "bala");
				s.setInt(3, i);
// 预编译 s.execute(), 括号里没有sql	, 为空			
				s.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {		
		// TODO Auto-generated method stub
		testPre();
//		speed();
//		commonInsert();
	}

}
