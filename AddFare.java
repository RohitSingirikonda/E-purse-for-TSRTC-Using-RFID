package tsrtc;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
public class AddFare extends JFrame
{
	GradientPanel p1;
	JPanel p2;
	JLabel l1,l2,title,l3,l4;
	JTextField tf1;
	JComboBox c1,c2;
	JButton b1,b2;
	Font f1;
public AddFare(){
	super("Add Fare Screen");
	
	p1 = new GradientPanel(600,200);
	p1.setLayout(null);
	
	f1 = new Font("Courier New",Font.BOLD,14);
	p2 = new TitlePanel(600,60);
	p2.setBackground(new Color(204, 110, 155));
	title = new JLabel("<HTML><BODY><CENTER>SMART CARD BASED E-PURSE TO PAY CHANGE IN TSRTC</CENTER></BODY></HTML>");
	title.setForeground(Color.white);
	title.setFont(new Font("Times New ROMAN",Font.PLAIN,17));
	p2.add(title);

	l3 = new JLabel("Add Fare Screen");
	l3.setFont(new Font("Courier New",Font.BOLD,13));
	l3.setBounds(250,20,200,30);
	p1.add(l3);

	l1 = new JLabel("Source");
	l1.setFont(f1);
	l1.setBounds(200,60,100,30);
	p1.add(l1);
	c1 = new JComboBox();
	c1.setFont(f1);
	c1.setBounds(300,60,130,30);
	p1.add(c1);
	c1.addItem("Ameerpet");
	c1.addItem("Dilsuknagar");
	
	l2 = new JLabel("Destination");
	l2.setFont(f1);
	l2.setBounds(200,110,100,30);
	p1.add(l2);
	c2 = new JComboBox();
	c2.setFont(f1);
	c2.setBounds(300,110,130,30);
	p1.add(c2);
	c2.addItem("Mehdipatnam");
	
	l4 = new JLabel("Amount");
	l4.setFont(f1);
	l4.setBounds(200,160,100,30);
	p1.add(l4);
	tf1 = new JTextField(15);
	tf1.setFont(f1);
	tf1.setBounds(300,160,130,30);
	p1.add(tf1);

	b1 = new JButton("Add Fare");
	b1.setFont(f1);
	b1.setBounds(220,210,120,30);
	p1.add(b1);
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			addfare();
		}
	});
	b2 = new JButton("Reset");
	b2.setFont(f1);
	b2.setBounds(360,210,80,30);
	p1.add(b2);
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			tf1.setText("");
			
		}
	});

	getContentPane().add(p1,BorderLayout.CENTER);
	getContentPane().add(p2,BorderLayout.NORTH);
}
public void clear(){
	tf1.setText("");
}
public void addfare(){
	String src = c1.getSelectedItem().toString().trim();
	String des = c2.getSelectedItem().toString().trim();
	String amount = tf1.getText();
	
	if(amount == null || amount.trim().length() <= 0){
		JOptionPane.showMessageDialog(this,"Amount must be enter");
		tf1.requestFocus();
		return;
	}
	double amt = 0.0;
	try{
		amt = Double.parseDouble(amount.trim());
	}catch(NumberFormatException e){
		JOptionPane.showMessageDialog(this,"Amount must be numeric only");
		tf1.requestFocus();
		return;
	}
	try{
		String input[] = {src,des,amount};
		String msg = DBCon.addFare(input);
		if(msg.equals("success")){
			JOptionPane.showMessageDialog(this,"Fare details added");
			setVisible(false);
		}else{
			JOptionPane.showMessageDialog(this,"Error in adding fare details");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
}

}
