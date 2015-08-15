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
public class EmpGUI extends JFrame
{
	GradientPanel p1;
	JPanel p2;
	JLabel l1,l2,title,l3,l4;
	JTextField tf1;
	JComboBox c1,c2;
	JButton b1,b2;
	Font f1;
	Main main;
	SmartCard sc;
public EmpGUI(Main ma){
	super("Emp GUI Screen");
	main = ma;
	p1 = new GradientPanel(600,200);
	p1.setLayout(null);
	
	f1 = new Font("Courier New",Font.BOLD,14);
	p2 = new TitlePanel(600,60);
	p2.setBackground(new Color(204, 110, 155));
	title = new JLabel("<HTML><BODY><CENTER>SMART CARD BASED E-PURSE TO PAY CHANGE IN TSRTC</CENTER></BODY></HTML>");
	title.setForeground(Color.white);
	title.setFont(new Font("Times New ROMAN",Font.PLAIN,17));
	p2.add(title);

	l3 = new JLabel("Emp GUI Screen");
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
	
	l4 = new JLabel("Card No");
	l4.setFont(f1);
	l4.setBounds(200,160,100,30);
	p1.add(l4);
	tf1 = new JTextField(15);
	tf1.setFont(f1);
	tf1.setBounds(300,160,130,30);
	p1.add(tf1);

	
	b2 = new JButton("Logout");
	b2.setFont(f1);
	b2.setBounds(220,210,80,30);
	p1.add(b2);
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			sc.close();
			setVisible(false);
			main.setVisible(true);
		}
	});

	getContentPane().add(p1,BorderLayout.CENTER);
	getContentPane().add(p2,BorderLayout.NORTH);

	sc = new SmartCard(this);
	sc.setPort("COM1");
	sc.setRate(9600);
	sc.initialize();
}
public void clear(){
	tf1.setText("");
}
}
