package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.java.utility.JdbcUtilityConnection;

public class deposit {
public static void depositAmount() throws ClassNotFoundException, SQLException {
	
	
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter Your Name:");
    String name = sc.next();
    System.out.print("Enter Your Mobile Number:");
    String mobileNUmber = sc.next();
    
    String inputName= getName(name);
    String mobile=getMobileNumber(mobileNUmber);
    
    
    Connection con =JdbcUtilityConnection.getConnection();
    
    if(name.equals(inputName)||mobileNUmber.equals(mobile)) {
    	String update="UPDATE users1 SET balance = ? WHERE name = ?";
    	
    	System.out.print("Enter Your Deposit Amount:");
    	double depositAmmount = sc.nextDouble();
    	double balance=getBalance(inputName);
    	double newBalance=balance+depositAmmount;
    	
    	PreparedStatement st = con.prepareStatement(update);
    	st.setDouble(1,newBalance);
    	st.setString(2, name);
    	
    	
    	int executeUpdate = st.executeUpdate();
    	if (executeUpdate > 0) {
    		double random = Math.random();
    		long round = Math.round(random);
    		System.out.println("Your Transaction Id Is "+round+"\n");
            System.out.println("Deposit successful! Current Balance: " + newBalance+"\n");
        } else {
            System.out.println("Failed to update the balance.");
        }
    }
}
public static String getName(String searchName) throws ClassNotFoundException, SQLException {
	
    String query="select name from users1 where name=?";
    Connection con=JdbcUtilityConnection.getConnection();
    PreparedStatement psmt = con.prepareStatement(query);
    psmt.setString(1, searchName);
    ResultSet resultSet = psmt.executeQuery();
    String name1=null;
    while(resultSet.next()) {
    	name1 = resultSet.getString(1);
    	System.out.println(name1);
    }
    
  return name1;
}
public static String getMobileNumber(String mobileNumber) throws ClassNotFoundException, SQLException {
	
    String query="select name from users1 where mobileNumber=?";
    Connection con=JdbcUtilityConnection.getConnection();
    PreparedStatement psmt = con.prepareStatement(query);
    psmt.setString(1, mobileNumber);
    ResultSet resultSet = psmt.executeQuery();
    String mobile=null;
    while(resultSet.next()) {
    	mobile = resultSet.getString(1);
    }
    
  return mobile;
}
public static double getBalance(String inputName) throws ClassNotFoundException, SQLException {
	String query="select balance from users1 where name=?";
    Connection con=JdbcUtilityConnection.getConnection();
    PreparedStatement psmt = con.prepareStatement(query);
    psmt.setString(1, inputName);
    ResultSet resultSet = psmt.executeQuery();
    double balance=0;
    while(resultSet.next()) {
    	balance = resultSet.getDouble(1);
    }
return balance;
}

}
