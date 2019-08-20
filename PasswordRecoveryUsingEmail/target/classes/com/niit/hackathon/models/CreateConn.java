package com.niit.hackathon.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConn {

		public static Connection createConnection()
		{
			String user="sa";
			String pwd="";
			String url="jdbc:h2:tcp://localhost/~/test";
			try {
			Connection conn=DriverManager.getConnection(url, user, pwd);
			System.out.println(conn);
			return conn;
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
}
