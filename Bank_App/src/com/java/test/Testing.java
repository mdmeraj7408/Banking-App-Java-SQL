package com.java.test;

import java.sql.SQLException;

import com.java.dao.deposit;

public class Testing {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	String username="meraj";
	long number=747585874;
	
	String name = deposit.getName(username.toString());
	System.out.println(name);
	String mobileNumber = deposit.getMobileNumber("740");
   if(name.equals(username)&&mobileNumber.equals( number)) {
	   double balance = deposit.getBalance(name);
	    System.out.println(balance);
   }else {
	   System.out.println("Invalid User.............");
   }
}
}
