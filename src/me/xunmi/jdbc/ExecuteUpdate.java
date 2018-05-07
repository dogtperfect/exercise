package me.xunmi.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.cj.jdbc.DatabaseMetaData;

public class ExecuteUpdate {
	public static void testUpdate() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
				Statement s = c.createStatement();				
		){
	
				String sqlI = "insert into hero values(null ,'sword','wolf', 999)";
				String sqlD = "delete from hero where hp = 999";
				String sqlU = "update hero set hp = 888 where hp = 999";
		
				s.execute(sqlI);
				s.execute(sqlD);
// execute 返回true,表示执行的是select,  返回false,表示执行的是update,insert,delete				
				boolean isUpdate = s.execute(sqlU);
				System.out.println("test what update return: "+isUpdate);

// executeUpdate 返回受影响的条数				
				int i = s.executeUpdate(sqlI);
				int d = s.executeUpdate(sqlD);
				int u = s.executeUpdate(sqlU);
				System.out.println(i+"  "+d+"  "+u);
				
				String sqlS = "select * from hero";
				boolean isSelect = s.execute(sqlS);
				System.out.println("now exec select: "+isSelect);
				ResultSet rs = s.getResultSet();
				while(rs.next()) {
					System.out.println(rs.getInt("id"));
				}
// s.executeUpdate() 参数为 sql			
//				s.executeUpdate(sqlS);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static int  getGenKeys() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		int id = 0;
		String sql = "insert into hero values (null,?,?,?)";
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");
				PreparedStatement s = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);				
// createStatement 必须无参数
//				PreparedStatement s = c.createStatement(sql,Statement.RETURN_GENERATED_KEYS);				
		){
			s.setString(1, "rabbit");
			s.setString(2, "jump");
			s.setInt(3, 666);
			s.execute();
			
			ResultSet rs = s.getGeneratedKeys();
			if(rs.next()) {
//int id = rs.getInt(2) 报错: 2>1,  只有id列 一列
				id = rs.getInt(1);
				System.out.println("insert id is: "+id);
			}
							
			for(int i=id-1;i>0; i--) {
				int tid = i;
				String sqlS = "select * from hero where id = "+tid;
// PreparedStatement s , 也可以执行 不带 ? 的sql 语句
				ResultSet rs2 = s.executeQuery(sqlS);		
				if(rs2.next()) {
					System.out.println("have id: "+tid+" delete it");
					String sqlD = "delete from hero where id = "+tid;
					s.execute(sqlD);
					break;
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public static void getMeta() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/ja?characterEncoding=UTF-8","root","xinshang123");			
		){
			DatabaseMetaData dmd = (DatabaseMetaData) c.getMetaData();
			System.out.println(dmd.getDatabaseProductName());
			System.out.println(dmd.getDatabaseProductVersion());
			System.out.println(dmd.getDriverName());
			System.out.println(dmd.getDriverVersion());
			System.out.println(dmd.getCatalogSeparator());
			ResultSet rs = dmd.getCatalogs();
			while(rs.next()) {
				System.out.println("database name is: "+rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/*	public static void deletePre () {
		
		
		int pre = getGenKeys();
		if (pre !=0 ) {
			
		}
	}*/
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testUpdate();
		getGenKeys();
//		getMeta();
	}

}
