package bank3000pak;

import java.sql.*;

public class BankDatabase 
{
	final static String DB_URL ="jdbc:derby:e:/BankDB";

   
   
	public static void store()
	{
		try
		{
			Connection c= DriverManager.getConnection(DB_URL);
			//Statement s1= c.createStatement();
			
			for (Account03 a:Bank03.listOfAccounts)
			{
			       int aNum=a.getAcctNum();
			       String nam=a.getName();
			       double bal=a.getBalance();
			       String savings="savings",cd="CD",checking="checking";

			       PreparedStatement ps=c.prepareStatement("insert into Accounts (AcctNum,Name,balance,Accttype) values(?,?,?,?)");
			       ps.setInt(1,aNum);
			       ps.setString(2,nam);
			       ps.setDouble(3,bal);

		
			       System.err.println("insert 1 coming up");
			       if  (a instanceof SavingsAccount03)
	 		       {
			       		ps.setString(4,savings);
	 				System.err.println("insert 1 completed");
	 		       }

	 			else if (a instanceof  CheckingAccount03) 
	 			{
	 				ps.setString(4,checking);
	 				System.err.println("insert 1 completed");
	 			}

				else if  (a instanceof CDAccount03)
				{
					ps.setString(4,cd); 
					System.err.println("insert 1 completed");
				}
	     
	 			ps.executeUpdate();
	
	      			for (Transaction03 t:a.getTransactions())
			   	{
		   			Statement s2=c.createStatement();
		 			if (t instanceof CheckWithdrawal03)
		 			{ 
			 			System.err.println("insert 2 coming up");

			 			s2.executeUpdate("insert into Transactions(AcctNum,Amount,Date,CheckNum) values("
						 + t.getAccount() + ", " + t.getAmount()+" ,"+ "\'"+ t.getDate()+"\',"+( (CheckWithdrawal03) t).getChecknum()+")");
			 			System.err.println("insert 2 completed");
		 			}
		 			else
		 			{ 
			 		System.err.println("insert 2 coming up");

			 		s2.executeUpdate("insert into Transactions(AcctNum,Amount,Date) values("
					 + t.getAccount() + ", " + t.getAmount()+" ,"+ "\'"+ t.getDate()+"\')");
			 		System.err.println("insert 2 completed");
		 			}
			   	}
	   
			}
		c.close();
		}
	   	catch(Exception ex)
		{
			System.out.println("ERROR "+ex.getMessage());
		}
	}
	
	public static void startDay()
	{
		try
		{
			Connection c3=DriverManager.getConnection(DB_URL);
			Statement s=c3.createStatement();		
			ResultSet rs=s.executeQuery("Select * from Accounts");	

			while(rs.next())
			{
				String aT=rs.getString("AcctType").trim(); 
				if (aT.equals("savings"))
				{
					Bank03.openAccount("savings",rs.getString(2),rs.getInt(1));
					System.err.println("retrieval 1b completed");
				}
				else if (aT.equals("checking"))

				{
					Bank03.openAccount("checking",rs.getString(2),rs.getInt(1));
					System.err.println("retrieval 1b completed");
				}
				else if (aT.equals("CD"))
				{
					Bank03.openAccount("CD",rs.getString(2),rs.getInt(1));
					System.err.println("retrieval 1b completed");
				}
				else
				{
					System.err.println("The account retrieval doesn't work.Fix!");
				}
			}	  
			s.close();		

			Statement s2=c3.createStatement();
			ResultSet rs2=s2.executeQuery("Select * from Transactions order by entry");
			while(rs2.next())
			{
				if(rs2.getInt(4)==0)
				{
					Bank03.performTransaction(rs2.getInt(1),rs2.getDouble(2),rs2.getString(3));
					System.err.println("retrieval 2b completed");
				}

				else
				{
					Bank03.performCheckWithdrawal(rs2.getInt(1),rs2.getDouble(2),rs2.getString(3),rs2.getInt(4));
					System.err.println("retrieval 2b completed");
				}
			}
			s2.executeUpdate("delete  from Transactions");
			s2.executeUpdate("delete  from Accounts");		   
			c3.close();			

		}
		catch(Exception ex)
		{
			System.out.println("ERROR "+ex.getMessage());
		}
	 
	}

}


