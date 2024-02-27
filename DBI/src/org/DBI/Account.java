package org.DBI;

import java.util.Scanner;

public class Account {
	Scanner sc = new Scanner(System.in);
	int accountno;
	String name;
	long mobileno;
	String pancardno;
	long aadharecardno;
	long amount;
	
	public Account(String name, long mobileno , String pancardno, long aadharecardno, int accountno, long amount) {
		this.name = name;
		this.mobileno = mobileno;
		this.pancardno = pancardno;
		this.aadharecardno = aadharecardno;
		this.accountno = accountno;
		this.amount = amount;
	}

	public void accountDetail()
	{
		System.out.println("Your Name is:- "+name);
		System.out.println("Your Mobile Number Is:- " + mobileno);
		System.out.println("Your Pancard Number Is:- " + pancardno);
		System.out.println("Your Aadharecard Number Is:- " + aadharecardno);
		System.out.println("Your Account Number Is:- " + accountno);
		System.out.println("Your Opning Balence Is:- " + amount);
	}
	

}
