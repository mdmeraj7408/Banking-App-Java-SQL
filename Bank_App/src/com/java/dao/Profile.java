package com.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.utility.JdbcUtilityConnection;

public class Profile {
     public static void getProfile() throws ClassNotFoundException, SQLException {
    	 Connection con=JdbcUtilityConnection.getConnection();
    	 String Query="SELECT * FROM  USERS1";
    	 Statement statement = con.createStatement();
    	 ResultSet resultSet = statement.executeQuery(Query);
    	 System.out.println("Id\t"+"\sname\t\t"+"Mobile Number\t"+"Email\t\t\t"+"\tAdhar Number\t"+"Pan Number\t"+"Pin Code\t"
    	 +"Address\t\t"+"Balance\n-------\t---------\t-----------\t---------\t\t\t-----------\t---------\t-----------\t---------\t-----------\t");
    	 while(resultSet.next()) {
    		 System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+
    				 "\t\t"+resultSet.getString(5)+"\t"+resultSet.getString(6)+"\t"+resultSet.getString(7)+"\t\t"+resultSet.getString(8)+"\t\t"+resultSet.getDouble(9));
    	 }
     }
}
