package bank3000pak;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransactionInput extends JPanel
{
 private  JLabel dateLbl;
 private  JTextField date;
 private  JLabel acctNumLbl;
 private  JTextField acctNum;
 private  JLabel amountLbl;
 private  JTextField amount;
 private JLabel ckNumLbl;
 private JTextField ckNum;
 
public TransactionInput()
{
  setBorder(BorderFactory.createTitledBorder("Transaction input"));

  dateLbl=new JLabel("Transaction date-MM/DD/YYYY:");
  date=new JTextField(10);
 
  acctNumLbl=new JLabel("Account number of transaction or history viewing:");
  acctNum=new JTextField(10);

  amountLbl=new JLabel("Transaction amount-for withdrawal use a minus symbol:");
  amount=new JTextField(10);

  ckNumLbl=new JLabel("If Check Withdrawal,enter check number:");
  ckNum=new JTextField(10);
 
add(dateLbl);
add(date);
add(acctNumLbl);
add(acctNum);
add(amountLbl);
add(amount);
add(ckNumLbl);
add(ckNum);

}
public void resetTransFields()
{
	date.setText(null);
	acctNum.setText(null);
	amount.setText(null);
	ckNum.setText(null);
}


public String getDate(){
return date.getText();
}
public String getAcctNum(){
return acctNum.getText();
}
public String getAmount(){
return amount.getText();
}
public String getCkNum(){ 
return ckNum.getText();
}
}