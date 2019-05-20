package bank3000pak;

import javax.swing.*;
import java.awt.*;
public class OpenAcctPanel extends JPanel
{
	private JLabel name;
	private JTextField nameTxt;
	private JLabel acctNum;
	private JTextField acctNumTxt;

	private JRadioButton sav;
	private JRadioButton chek;
	private JRadioButton cd;
	private ButtonGroup group;
	private JPanel rd;

	public OpenAcctPanel()
	{
		setBorder(BorderFactory.createTitledBorder("New account input"));

	  	acctNum=new JLabel("Account number of new account:");
	  	acctNumTxt=new JTextField(15);
	 	name=new JLabel("Name of account holder:");
	 	nameTxt=new JTextField(15);

		add(acctNum);
		add(acctNumTxt);
		add(name);
		add(nameTxt);

		 sav=new JRadioButton("Savings");
		 chek=new JRadioButton("Checking");
		 cd=new JRadioButton("CD");

		 group=new ButtonGroup();
		 group.add(sav);
		 group.add(chek);
		 group.add(cd);

		rd=new JPanel();
		rd.setBorder(BorderFactory.createTitledBorder("Account Type"));
		rd.add(sav);
		rd.add(chek);
		rd.add(cd);
		add(rd);
	}
	
	public String getAcctNum(){
		return acctNumTxt.getText();
	}
	public String getName(){
		return nameTxt.getText();
	}
	public void resetAcctFields()
	{
		nameTxt.setText(null);   
		acctNumTxt.setText(null);
		group.clearSelection();
	}

	public JRadioButton getSav(){
		return sav;
	}
	public JRadioButton getChek(){
		return chek;
	}
	public JRadioButton getCd(){
		return cd;
	}
}
