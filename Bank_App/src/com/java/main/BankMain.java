package com.java.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.dao.Balance;
import com.java.dao.BankAccountOpening;
import com.java.dao.Profile;
import com.java.dao.Withdraw;
import com.java.dao.deposit;

public class BankMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Welcome to the Bank of Java");
		Scanner sc=new Scanner(System.in);
		int option = 0;
	    while (option != 7) {

	      System.out.println("1. Account Open");
	      System.out.println("2. All Records");
	      System.out.println("3. check balance");
	      System.out.println("4. Deposit");
	      System.out.println("5. Withdraw");
	      System.out.println("6. Exit");
	      System.out.print("Enter an option: ");
	      option = sc.nextInt();
		switch (option) {
		case 1:BankAccountOpening.openAcount();
		break;
		case 2:Profile.getProfile();//depositAmount;
		break;
		case 3:Balance.checkBalance();//withdrawAmount();
		break;
		case 4:deposit.depositAmount();
		break;
		case 5:Withdraw.withdrawAmount();;
		break;
		case 6:System.out.println("Exit");
		break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	    }
	}
}
