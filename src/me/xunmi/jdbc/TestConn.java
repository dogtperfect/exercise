package me.xunmi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConn {

	public static void testCurd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
				Statement s = c.createStatement();				
		){
			/*String sql = "create table hero" +
						 "(id integer not null," +
						 "name varchar(20),"+
						 "skill varchar(20)," +
						 "hp integer(10)," +
						 "primary key(id) )";*/
			/*String sql = "insert into hero values("+1+",'sword','wolf',"+300+ ")";
			s.execute(sql);*/
			
/*			String d ="delete from hero";
/*			String d ="truncate table hero";   //这样删表, id 重新从1开始自增			
			s.execute(d);
			for (int i=0 ; i<100; i++) {
				String sql = "insert into hero values("+ null +",'sword','wolf',"+(i+100)+ ")";
				s.execute(sql);
			}
			*/
//			String sle = "select * from hero";
			
//sql 注入
			String na = " 'bala' or 1=1";
			String sle = "select * from hero where name = " + na;
			ResultSet rs = s.executeQuery(sle);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int hp = rs.getInt("hp");
				System.out.printf("%d\t%s\t%d%n", id,name,hp);
			}
			
			String count = "select count(id) from hero";
			ResultSet rsc = s.executeQuery(count);
			int total = 0;
//rsc.next() 不能省
			while(rsc.next()) {
				total= rsc.getInt(1);
			}
			System.out.println("total row is: "+total);
//			int total2= rsc.getInt(1);
			System.out.println("exec sql success");			
		} catch (SQLException e) {			
			e.printStackTrace();
		} 
	}
	
	public static void passwd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
				Statement s = c.createStatement();
		){
			String name = "xiaoming";
			String password = "123456";
			String sql = "select * from user where name =" + "'" + name + "'" + "and password = " + "'"+password+ "'" ;
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				System.out.println("password correct");
			} else {
				System.out.println("wrong password");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void page(int start, int number) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
				Statement s = c.createStatement();				
		){
			String sql = "select * from hero limit " + start + "," + number;
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int hp = rs.getInt("hp");
				System.out.printf("page: %d, %s, %d%n",id,name,hp);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCurd();
//		passwd();
//		page(30,5);
	}

}
