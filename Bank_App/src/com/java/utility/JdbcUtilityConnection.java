package com.java.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtilityConnection {
     public static Connection getConnection() throws ClassNotFoundException, SQLException {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
      
    	 return con;
      
     }
     
}
