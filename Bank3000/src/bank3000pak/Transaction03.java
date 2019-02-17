package bank3000pak;

import javax.swing.JOptionPane;

public class Transaction03 {

private int account;
private double amount;
private String date;


public Transaction03( int acct, double amt, String dt)
{
account=acct;
amount=amt;
date=dt;
}

public int getAccount(){
return account;
}
public double getAmount(){
	return amount;	
}
public String getDate(){
	return date;
}

public String printTrans(){

	return ("\n"+String.valueOf(amount)+"\t"+date);
}
}



