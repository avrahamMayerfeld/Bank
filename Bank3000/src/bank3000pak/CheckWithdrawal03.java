package bank3000pak;

public class CheckWithdrawal03 extends Transaction03
{
  private int checkNumber;
   
  public CheckWithdrawal03(int acct, double amt, String dt, int ckNum){
	  super(acct,amt,dt);
	  checkNumber=ckNum;
	  }
public int getChecknum(){
return checkNumber;
} 
  
public String printCheckW(){
	return ("\n"+String.valueOf(getAmount())+"\t"+getDate()+"\tCheck#"+String.valueOf(checkNumber));
	}
}

   







