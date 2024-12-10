package com.java.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Scanner;

import com.java.utility.JdbcUtilityConnection;

public class BankAccountOpening {
    static Connection con;
       public static void openAcount() throws ClassNotFoundException, SQLException {
    	   //String name ,long mobileNumber,String emailId,long adharNumber,String panNo,int paasscode,String Address
    	   System.out.println("Welcome to My Bank");
    	   Scanner sc=new Scanner(System.in);
    	   System.out.print("Enter Your Name: ");
    	   String name= sc.next();
    	   System.out.print("Enter Your Mo/No: ");
    	   String mobileNumber=sc.next();
    	   System.out.print("Enter your email: ");
    	   String email=sc.next();
    	   System.out.print("Enter your Adhar Number: ");
    	   String adharNumber=sc.next();
    	   System.out.print("Enter Your Pan Number: ");
    	   String panNumber=sc.next();
    	   System.out.print("Enter your PinCode: ");
    	   String passCode=sc.next();
    	   System.out.print("Enter Your Adddress: ");
    	   String address=sc.next();
    	   System.out.println("You Have To Pay 100 Rupey For Account Blance");
    	   System.out.println("Enter Your Balance:");
    	   double balance=sc.nextDouble();
    	   
    	   String query="INSERT INTO users1 (name, mobileNumber, emailId, adharNumber, panNo, passcode, address, balance)\r\n"
    	   		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);\r\n"
    	   		+ "";
    	   		
    	con=   JdbcUtilityConnection.getConnection();
    	PreparedStatement stmt=con.prepareStatement(query);
    	stmt.setString(1, name);
        stmt.setString(2, mobileNumber);
        stmt.setString(3, email);
        stmt.setString(4, adharNumber);
        stmt.setString(5, panNumber);
        stmt.setString(6, passCode);
        stmt.setString(7, address);
        stmt.setDouble(8, balance);
    	int data =stmt.executeUpdate();
    	
    	   if(data>0) {
    		   double random = Math.random()*100;
    		  long round = Math.round(random);
    		   System.out.println("Txn Id Is "+ ++round +"\nHey! "+name+" Your Account was Successfully opend..");
    	   }else {
    		   System.out.println("Hey"+name+"Your Account was not opend..");
    	   }
       }
}
