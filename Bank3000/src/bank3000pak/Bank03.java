package bank3000pak;

import java.util.ArrayList;

public class Bank03 {
	static ArrayList<Account03> listOfAccounts=new ArrayList<Account03>();

	public static void openAccount(String accountType,String name,int number )
	{

	switch(accountType){

		case "Savings":
		case "savings":{
			SavingsAccount03 a=new SavingsAccount03(name,number);
			listOfAccounts.add(a);
			break;
		}
		case "Checking":
		case "checking":{
			CheckingAccount03 b=new CheckingAccount03(name,number);
			listOfAccounts.add(b);
			break;
		}
		case "cd":
		case "CD":{
			CDAccount03 c=new CDAccount03(name,number);
			listOfAccounts.add(c);
			break;
		}
		default:break;
		}

	}
	
	public static void performTransaction(int x,double y, String z)
	{
		Transaction03 t=new Transaction03(x,y,z);

		for (int s=0;s<listOfAccounts.size();s++)
		{
			if (listOfAccounts.get(s).getAcctNum()==t.getAccount()) 
		      	{
		   		Account03   w= listOfAccounts.get(s);
			 	w.setBalance(t.getAmount());
			 	w.addTransaction(t);
			    	break;
		      	}
		}
	}
	
	public static void performCheckWithdrawal(int r,double g,String h,int f) {
		CheckWithdrawal03 t=new CheckWithdrawal03(r,g,h,f);

		for (int s=0;s<listOfAccounts.size();s++)
		{
			if (listOfAccounts.get(s).getAcctNum()==t.getAccount()) 
		      	{
		   		Account03   w= listOfAccounts.get(s);
		         	w.setBalance(t.getAmount());
			 	w.addTransaction(t);
                        	break;
		      	}
		}

	}
	
	public static String readAccount(int acctNum)
	{
	 	for (Account03 a:listOfAccounts)
	 	{
			if (a.getAcctNum()==acctNum) 
           		{
             			return"\n\nAccount holder:"+a.getName()+"\nAccount number:"+
			        	String.valueOf(a.getAcctNum())+
						String.format("\nBalance:$%,.2f",a.getBalance())+
							"\nTransactions:\n"+ (a.printAll());
		   	}
		
	 	}
		return"Account not found";
	}
	 
	
	public static void main(String[]args){
     
		Runtime.getRuntime().addShutdownHook( new Thread()
		{ 
			public void run()
			{
				BankDatabase.store();
			} 
		} );
		
		BankDatabase.startDay();
		
		new BankGui();
	
	}	
	
}


