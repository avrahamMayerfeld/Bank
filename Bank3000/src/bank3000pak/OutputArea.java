package bank3000pak;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OutputArea extends JPanel{
private JTextArea  area;
private JScrollPane jsp;
public OutputArea(){
area=new JTextArea(30,40);
area.setLineWrap(true);
jsp=new JScrollPane(area);
add(jsp);
area.setEditable(false);
}
public void setArea(String e){
area.append(e);

}

}


