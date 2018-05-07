package me.xunmi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dogtperfect.buffer.Hero;

public class TestORM {

	public static Hero get(int id) {
		Hero h = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "select * from hero where id = ? ";
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
				PreparedStatement ps = c.prepareStatement(sql);		
		){		
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			if(rs.next()) {
				h = new Hero();
				h.id = rs.getInt(1);
				h.name = rs.getString(2);
				h.skill = rs.getString(3);
				h.hp = rs.getFloat(4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return h;
	}
	
	public static void add(Hero h) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "insert into hero values (null,?,?,?)";
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
				PreparedStatement ps = c.prepareStatement(sql);		
		){		
			
// add 的参数 (对象hero) 没有 id 值 ? 不需要吗. 如果参数hero有id, 和自增产生的不一样怎么办?	
			ps.setString(1, h.name);
			ps.setString(2, h.skill);
			ps.setFloat(3, h.hp);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void update(Hero h) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "update hero set name = ?, skill = ?, hp = ? where id = ? ";
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
				PreparedStatement ps = c.prepareStatement(sql);		
		){		
			
// update hero 需要 hero.id			
			ps.setString(1, h.name);
			ps.setString(2, h.skill);
			ps.setFloat(3, h.hp);
			ps.setInt(4, h.id);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void delete(Hero h) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "delete from hero where id = ? ";
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
				PreparedStatement ps = c.prepareStatement(sql);		
		){		
			int id = h.id;
			ps.setInt(1, id);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static List<Hero> list(){
		List<Hero> heros = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "select * from hero";	
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
				PreparedStatement ps = c.prepareStatement(sql);		
		){		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Hero h = new Hero();
				h.id = rs.getInt(1);
				h.name = rs.getString(2);
				h.skill = rs.getString(3);
				h.hp = rs.getFloat(4);
				heros.add(h);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return heros;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Hero> hs = list();
		System.out.println("have heros: "+ hs.size());
		Hero h = new Hero();
		h.name = "cat";
		add(h);
		
		hs = list();
		System.out.println("have heros: "+ hs.size());
// 不是第几条, 是id 的真实值, 根据序号有可能取不到, 出现运行时异常		
		h = get(18);
		h.name = "dog";
		System.out.println("update 3rd hero'name to dog");
		update(h);
		
		h = get(24);
		System.out.println("delete 2cond hero");
		delete(h);
		hs = list();
		System.out.println("have heros: "+ hs.size());
	}

}
