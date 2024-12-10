package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.utility.JdbcUtilityConnection;

public class Balance {
public static void checkBalance() throws ClassNotFoundException, SQLException {
	
	Connection con=JdbcUtilityConnection.getConnection();
	Scanner sc=new Scanner(System.in);
	
	System.out.print("Enter Your name: ");
	String name = sc.next();
	System.out.print("Enter Your mobile no: ");
	String mobileNumber = sc.next();
	
	String query="SELECT name, mobileNumber, balance FROM users1 where name=?";
	PreparedStatement statement = con.prepareStatement(query);
	statement.setString(1,name);
	
	String string =null;
	String mobileNum;
	double balance=0;
	
	ResultSet executeQuery = statement.executeQuery();

	while(executeQuery.next()) {
		//int account=executeQuery.getInt(1);
		 string = executeQuery.getString(1);
		 mobileNum = executeQuery.getString(2);
		 balance=executeQuery.getDouble(3);
		 System.out.println("\n"+"Hey! "+string+" Your mobile number  Is "+mobileNum+" and your balance is "+balance+"\n");
	
	}

}
}
