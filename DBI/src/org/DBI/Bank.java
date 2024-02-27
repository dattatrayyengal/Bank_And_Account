package org.DBI;

import java.util.Scanner;

public class Bank {
	Account account;
	Scanner sc = new Scanner(System.in);
	static {
		System.out.println("Welcome DBI Bank");
	}
	public void DBI() {
		System.out.println("Press 1 for Create Account");
		System.out.println("Press 2 for Withdra Amount");
		System.out.println("Press 3 for Deposit Amount");
		System.out.println("Press 4 for Delete Account");
		System.out.println("Press 5 for Exit");
		int input = sc.nextInt();
		switch(input)
		{
			case 1:
				getDetails();
				break;
			case 2:
				if(account==null)
				{
					System.out.println("Account Is Closed ");
				}else if (account!=null){
				validaateAcountNo();
				}
				break;
			case 3:
				if(account==null)
				{
					System.out.println("Account Is Closed ");
				}else if (account!=null){
					validaateDepositNo();
				}
				
				break;
			case 4:
				if(account==null)
				{
					System.out.println("Account Is Closed ");
				}else if (account!=null){
					deleteAccount();
				}
				break;
			case 5:
				System.out.println("Your Exited Sucssfulley");
				System.exit(1);
				break;
			default :
				System.out.println("Plese Select Valid Option");
				DBI();
		}
	}
	public void extraTask() {
		System.out.println("Do Yuo Want To Do Extra Task !! ");
		System.out.println("Prees 1 For Yes");
		System.out.println("Prees 2 For Exit");
		int ExtraTask = sc.nextInt();
		if(ExtraTask == 1)
		{
			DBI();
		}else if(ExtraTask == 2) {
			System.exit(1);
		}
	}
	
	public void getDetails()
	{
		try {
			sc.nextLine();
			System.out.println("Enter your Full Name :- ");
			String name = sc.nextLine();
			System.out.println("Enter Your Mobile Number :- ");
			long number = sc.nextLong();
			System.out.println("Enter Your Aadharcard Number :- ");
			long aadharno = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter Your Pan Card Number :- ");
			String panno = sc.nextLine();
			System.out.println("Enter Your Own Choice Account Number (number should be less thane 8 digits :- ");
			int Accono=sc.nextInt();
			System.out.println("Enter Opning Balence Amount :- ");
			long amount = sc.nextLong();
			account = new Account(name,number,panno,aadharno,Accono,amount);
			System.out.println("Account Created Succsfully !!!!");
			createAccount();
		}catch (Exception e)
		{
			System.out.println("Plese Fill The Form Carefulle");
			getDetails();
		}
		extraTask();
		
	}
	
	public void createAccount()
	{
	if (account!=null)
		{
		account.accountDetail();
		}else{
			System.out.println("create account first !!!");
			DBI();
			
		}
	
	}
	public void validaateAcountNo() {
		System.out.println("Plese Enter Your Account No");
		long UserAccNo = sc.nextLong();
		if(UserAccNo == account.accountno)
		{
			withdraAmount();
		}else {
			System.out.println("Plese Enter Valid Account No.");
			validaateAcountNo();
		}
	}
	public void withdraAmount()
	{
		System.out.println("You Can Withdra This Much Amount:- " + account.amount);
		System.out.println("Enter Your Amount For Withdraw");
		long WithAmou = sc.nextLong();
		if ((WithAmou<=account.amount)&&(WithAmou>=100)) {
			account.amount=account.amount-WithAmou;
			System.out.println("Amount Withdrawl Sussesfulley");
			System.out.println("Your Current Balance is:- "+account.amount);
		}else if (WithAmou<100) {
			System.out.println("Plese Enter Amount 100,200,500 :- ");
			withdraAmount();
		}else if(WithAmou>account.amount) {
			System.out.println("Plese Enter Amount Present In Account :- ");
			withdraAmount();
		}else
		{
			System.out.println("Plese Select Valid Transection !!!");
			DBI();
		}
		extraTask();
		
		
	}
	public void validaateDepositNo() {
		System.out.println("Plese Enter Your Account No");
		long UserAccNo = sc.nextLong();
		if(UserAccNo == account.accountno)
		{
			System.out.println("The Account Number Details Is As Follows " + account.name);
			System.out.println("Is This Correct Account Details That You Enterd 1 For Yes 2 For No");
			int inp = sc.nextInt();
			if(inp == 1) {
			depositMoney();
			}else if (inp == 2) {
				validaateDepositNo(); 
			}
		}else {
			System.out.println("Plese Enter Valid Account No.");
			validaateAcountNo();
		}
	}
	public void depositMoney()
	{
		System.out.println("Plese Enter Your Amount For Deposit 100,200 & 500 only :-");
		long depoAcco = sc.nextLong();
		System.out.println("Your Amount Is :- "+depoAcco);
		System.out.println("Prees 1 For Proceed Or Prees 2 For Cancel The Trancection");
		int inp = sc.nextInt();
		if(inp == 1) {
		account.amount = depoAcco + account.amount;
		System.out.println("Your Current Balance Is :- "+account.amount);
		}else if(inp == 2) {
			System.out.println("You Transection is canceld");
		}
		extraTask();
		
		
	}
	public void deleteAccount() {
		System.out.println("Plese Enter Your Account Number For Close The Account :- ");
		long inp = sc.nextLong();
		if(inp == account.accountno) {
			System.out.println("Your Account Details Is As Follows :-" + account.name);
			System.out.println("Is Correct details Press 1 For Yes 2 For No");
			int ino = sc.nextInt();
			if (ino == 1) {
				System.out.println("Do You Want To Really Close Your Account Press 1 For Yes 2 For No");
				int ino1 = sc.nextInt();
				if(ino1==1) {
					account = null;
					System.out.println("Account Closed Succsefully!!!");
				}else if(ino1 == 2) {
					System.out.println("Opreation Cancelled");
				}
			}else if(ino == 2) {
				System.out.println("Plese Enter Details Again !!!");
				deleteAccount();
			}
		}
		extraTask();
	}

}
