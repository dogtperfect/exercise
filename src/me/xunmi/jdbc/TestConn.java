package me.xunmi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
  
            // ���������ݿ��Connection����
            // ������Ҫ�ṩ��
            // ���ݿ������ڵ�ip:127.0.0.1 (����)
            // ���ݿ�Ķ˿ںţ� 3306 ��mysqlר�ö˿ںţ�
            // ���ݿ����� how2java
            // ���뷽ʽ UTF-8
            // �˺� root
            // ���� admin
  
            Connection c = DriverManager
                    .getConnection(
                            "jdbc:mysql://106.14.147.204:3306/talk?characterEncoding=UTF-8",
                            "talk", "is9zIT168XvgLVhAZIxK");
  
            System.out.println("���ӳɹ�����ȡ���Ӷ��� " + c);
  
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
