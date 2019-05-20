package bank3000pak;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.*;
public class BankGui extends JFrame {
	OpenAcctPanel OAP=new OpenAcctPanel();
      	TransactionInput TI=new TransactionInput();
	OutputArea OA=new OutputArea();
	private JPanel butPan=new JPanel();
	private JButton open = new JButton("Open acccount");
	private JButton perfTrans= new JButton("Deposit/Withdrawal");
	private JButton  hist = new JButton("Display acct info"); 
	private JPanel bigPanel=new JPanel();


	public BankGui(){

		setLayout(new BorderLayout());
		open.addActionListener(new OpenListener() );
		perfTrans.addActionListener(new TransactionListener() );
		hist.addActionListener(new HistoryListener() );

		butPan.add(open);
		butPan.add(perfTrans) ;
		butPan.add(hist);
		setTitle("Bank Console");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bigPanel.add(butPan); 
		bigPanel.add(OA);

		add(bigPanel,BorderLayout.SOUTH);
		add(TI,BorderLayout.CENTER);
		add(OAP,BorderLayout.NORTH);

		pack();
		setVisible(true);

	}

	private class HistoryListener implements ActionListener
	{ 
		public void actionPerformed(ActionEvent e)
		{
	 		String string=Bank03.readAccount(Integer.parseInt(TI.getAcctNum() ));   
			OA.setArea(string);                                      
			TI.resetTransFields();
		}
	}

	private class OpenListener implements  ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(OAP.getAcctNum().isEmpty()||OAP.getName().isEmpty())
				   JOptionPane.showMessageDialog(null,"Fill all account opening  fields."); 
			else if (OAP.getSav().isSelected())
	   			Bank03.openAccount("savings",OAP.getName(),Integer.parseInt(OAP.getAcctNum()));
			else if  (OAP.getChek().isSelected())
	   			Bank03.openAccount("checking",OAP.getName(),Integer.parseInt(OAP.getAcctNum()));
			else if (OAP.getCd().isSelected())
				 Bank03.openAccount("CD",OAP.getName(),Integer.parseInt(OAP.getAcctNum()));
			else
				JOptionPane.showMessageDialog(null,"Select an account type.");
			OAP.resetAcctFields();
		}
	}  

	private class TransactionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent af)
		{
			if(TI.getAcctNum().isEmpty()||TI.getDate().isEmpty()||TI.getAmount().isEmpty())
	   			JOptionPane.showMessageDialog(null,"Fill all transaction fields"); 

			else  if(!(TI.getCkNum().isEmpty()))    
				Bank03.performCheckWithdrawal(Integer.parseInt(TI.getAcctNum()),Double.parseDouble(TI.getAmount()),TI.getDate(),Integer.parseInt(TI.getCkNum()));
	 		else
				Bank03.performTransaction(Integer.parseInt(TI.getAcctNum()),Double.parseDouble(TI.getAmount()),TI.getDate());

			TI.resetTransFields();
		}
	}

}

