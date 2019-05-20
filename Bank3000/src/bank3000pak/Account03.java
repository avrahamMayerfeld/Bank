package bank3000pak;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Account03 {
	
		 private   String name;
		 private double balance;
		 private ArrayList<Transaction03> Transactions=new ArrayList<Transaction03>();
		 private int acctNumber;
		 
       
		 public Account03(String n, int aN){
			name=n;
			acctNumber=aN;

		}


		 public void setBalance(double b){
			balance+=b;
		}
		public double getBalance(){
			return balance;
		}


			
		public int getAcctNum(){
			return acctNumber;
		}
		        
		public String getName(){
		    	return name;
		}
			
		public ArrayList<Transaction03> getTransactions(){
		     	return Transactions;
		}
		       
		public void addTransaction(Transaction03 t)
		{
		      	Transactions.add(t);
		}    

		public  String printAll()
		{
			 StringBuilder sb=new StringBuilder();
			for(Transaction03 t:Transactions)
			{
		   
				if (t instanceof CheckWithdrawal03)
		  		{
					sb.append(  ( (CheckWithdrawal03) t).printCheckW() );
		       		}
		    		else
		    		{
		    			sb.append(	t.printTrans() );
		    		}
		 
			}
			return sb.toString();
		
		}
}

