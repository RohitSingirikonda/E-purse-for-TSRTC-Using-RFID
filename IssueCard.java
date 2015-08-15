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
import javax.swing.JOptionPane;
public class IssueCard extends JFrame
{
	GradientPanel p1;
	JPanel p2;
	JLabel l1,l2,title,l3,l4,l5;
	JTextField tf1,tf2,tf3,tf4;
	JButton b1,b2;
	Font f1;
public IssueCard(){
	super("Issue Card Screen");
	p1 = new GradientPanel(600,200);
	p1.setLayout(null);
	
	f1 = new Font("Courier New",Font.BOLD,14);
	p2 = new TitlePanel(600,60);
	p2.setBackground(new Color(204, 110, 155));
	title = new JLabel("<HTML><BODY><CENTER>SMART CARD BASED E-PURSE TO PAY CHANGE IN TSRTC</CENTER></BODY></HTML>");
	title.setForeground(Color.white);
	title.setFont(new Font("Times New ROMAN",Font.PLAIN,17));
	p2.add(title);

	l3 = new JLabel("Issue Card Screen");
	l3.setFont(new Font("Courier New",Font.BOLD,13));
	l3.setBounds(250,20,200,30);
	p1.add(l3);

	l1 = new JLabel("Card Holder Name");
	l1.setFont(f1);
	l1.setBounds(200,60,180,30);
	p1.add(l1);
	tf1 = new JTextField(15);
	tf1.setFont(f1);
	tf1.setBounds(360,60,130,30);
	p1.add(tf1);
	
	l2 = new JLabel("Contact No");
	l2.setFont(f1);
	l2.setBounds(200,110,180,30);
	p1.add(l2);
	tf2 = new JTextField(15);
	tf2.setFont(f1);
	tf2.setBounds(360,110,130,30);
	p1.add(tf2);

	l4 = new JLabel("Address");
	l4.setFont(f1);
	l4.setBounds(200,160,180,30);
	p1.add(l4);
	tf3 = new JTextField(15);
	tf3.setFont(f1);
	tf3.setBounds(360,160,190,30);
	p1.add(tf3);

	l5 = new JLabel("Card No");
	l5.setFont(f1);
	l5.setBounds(200,210,180,30);
	p1.add(l5);
	tf4 = new JTextField(15);
	tf4.setFont(f1);
	tf4.setBounds(360,210,190,30);
	p1.add(tf4);

	JPanel pan3 = new JPanel(); 
	b1 = new JButton("Issue");
	b1.setFont(f1);
	b1.setBounds(220,260,80,30);
	p1.add(b1);
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			issue();
		}
	});
	b2 = new JButton("Reset");
	b2.setFont(f1);
	b2.setBounds(320,260,80,30);
	p1.add(b2);
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
		}
	});

	getContentPane().add(p1,BorderLayout.CENTER);
	getContentPane().add(p2,BorderLayout.NORTH);
}
public void clear(){
	tf1.setText("");
	tf2.setText("");
}
public void issue(){
	String name = tf1.getText();
	String contact = tf2.getText();
	String address = tf3.getText();
	String card = tf4.getText();
	if(name == null || name.trim().length() <= 0){
		JOptionPane.showMessageDialog(this,"Card holder name must be enter");
		tf1.requestFocus();
		return;
	}
	if(contact == null || contact.trim().length() <= 0){
		JOptionPane.showMessageDialog(this,"Contact no must be enter");
		tf2.requestFocus();
		return;
	}
	if(address == null || address.trim().length() <= 0){
		JOptionPane.showMessageDialog(this,"Address must be enter");
		tf3.requestFocus();
		return;
	}
	if(card == null || card.trim().length() <= 0){
		JOptionPane.showMessageDialog(this,"Card no must be enter");
		tf4.requestFocus();
		return;
	}
	try{
		String input[] = {name,contact,address,card};
		String msg = DBCon.issueCard(input);
		if(msg.equals("success")){
			JOptionPane.showMessageDialog(this,"Card details added successfully");
			setVisible(false);
		}else{
			JOptionPane.showMessageDialog(this,"Error in adding card details");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
}

}
