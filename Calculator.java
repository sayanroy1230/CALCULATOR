import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
	
	JFrame frame=new JFrame("CALCULATOR");
	JLabel displayarea=new JLabel();
	JPanel panel=new JPanel();
	JButton[] numberbuttons=new JButton[10];	
	JButton[] functionbuttons=new JButton[8];
	JButton addbutton,subbutton,divbutton,mulbutton,decbutton,eqbutton,delbutton,clrbutton;
	double num1=0,num2=0,result=0;
	char operator;

	
	
	
	Calculator(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(530,75,350,470);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.black);
		frame.setVisible(true);
		frame.setResizable(false);
		
		displayarea.setForeground(Color.black);
		displayarea.setFont(new Font("Verdana",Font.PLAIN,30));
		displayarea.setText("");
		displayarea.setOpaque(true);
		displayarea.setBounds(17,22,300,50);
		
		panel.setBounds(17,90,300,250);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.black);
		
		for(int i=0;i<10;i++) {
			numberbuttons[i]=new JButton(String.valueOf(i));
			numberbuttons[i].setBackground(Color.darkGray);
			numberbuttons[i].setForeground(Color.black);
			numberbuttons[i].setFont(new Font("Verdana",Font.BOLD,30));
			numberbuttons[i].setFocusable(false);
			numberbuttons[i].addActionListener(this);
		}
		
		addbutton=new JButton("+");
		subbutton=new JButton("-");
		mulbutton=new JButton("*");
		divbutton=new JButton("/");
		eqbutton=new JButton("=");
		decbutton=new JButton(".");
		delbutton=new JButton("DELETE");
		clrbutton=new JButton("CLEAR");
		
		functionbuttons[0]=addbutton;
		functionbuttons[1]=subbutton;
		functionbuttons[2]=mulbutton;
		functionbuttons[3]=divbutton;
		functionbuttons[4]=eqbutton;
		functionbuttons[5]=decbutton;
		functionbuttons[6]=delbutton;
		functionbuttons[7]=clrbutton;
		
		for(int i=0;i<=7;i++) {
			functionbuttons[i].setFont(new Font("Verdana",Font.BOLD,20));
			functionbuttons[i].setBackground(Color.gray);
			functionbuttons[i].setForeground(Color.black);
			functionbuttons[i].setFocusable(false);
			functionbuttons[i].addActionListener(this);
		}
		
		panel.add(numberbuttons[1]);
		panel.add(numberbuttons[2]);
		panel.add(numberbuttons[3]);
		panel.add(addbutton);
		panel.add(numberbuttons[4]);
		panel.add(numberbuttons[5]);
		panel.add(numberbuttons[6]);
		panel.add(subbutton);
		panel.add(numberbuttons[7]);
		panel.add(numberbuttons[8]);
		panel.add(numberbuttons[9]);
		panel.add(mulbutton);
		panel.add(decbutton);
		panel.add(numberbuttons[0]);
		panel.add(eqbutton);
		panel.add(divbutton);
		
		clrbutton.setBounds(80,360,110,50);
		delbutton.setBounds(197,360,118,50);
		
		frame.add(displayarea);
		frame.add(panel);
		frame.add(delbutton);
		frame.add(clrbutton);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberbuttons[i]) {
				displayarea.setText(displayarea.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decbutton) {
			displayarea.setText(displayarea.getText().concat("."));
		}
		if(e.getSource()==addbutton) {
			num1 = Double.parseDouble(displayarea.getText());
			operator ='+';
			displayarea.setText("");
		}
		if(e.getSource()==subbutton) {
			num1 = Double.parseDouble(displayarea.getText());
			operator ='-';
			displayarea.setText("");
		}
		if(e.getSource()==mulbutton) {
			num1 = Double.parseDouble(displayarea.getText());
			operator ='*';
			displayarea.setText("");
		}
		if(e.getSource()==divbutton) {
			num1 = Double.parseDouble(displayarea.getText());
			operator ='/';
			displayarea.setText("");
		}
		if(e.getSource()==eqbutton) {
			num2=Double.parseDouble(displayarea.getText());
			
			if(operator=='+')
				result=num1+num2;
			else if(operator=='-')
				result=num1-num2;
			else if(operator=='*')
				result=num1*num2;
			else if(operator=='/')
				result=num1/num2;
			
			displayarea.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrbutton) {
			displayarea.setText("");
		}
		if(e.getSource()==delbutton) {
			String del = displayarea.getText();
			displayarea.setText("");
			for(int i=0;i<del.length()-1;i++) {
				displayarea.setText(displayarea.getText()+del.charAt(i));
			}
		}
	}
	
	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
	}
}