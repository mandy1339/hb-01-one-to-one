package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("connecting to database: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("connection successful");	
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
