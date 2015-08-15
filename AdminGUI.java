package tsrtc;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
public class AdminGUI extends JFrame
{
	GradientPanel p1;
	JPanel p2;
	JLabel title;
	JButton b1,b2,b3,b4,b5;
	Font f1;
	Main main;
public AdminGUI(Main ma){
	super("Admin GUI");
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

	

	JPanel pan3 = new JPanel(); 
	b1 = new JButton("Issue Card");
	b1.setFont(f1);
	b1.setBounds(220,50,150,30);
	p1.add(b1);
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			IssueCard ic = new IssueCard();
			ic.setVisible(true);
			ic.setSize(600,420);
			ic.setLocationRelativeTo(null);
			ic.setResizable(false);
		}
	});
	b2 = new JButton("Recharge Card");
	b2.setFont(f1);
	b2.setBounds(220,100,150,30);
	p1.add(b2);
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			Recharge ic = new Recharge();
			ic.setVisible(true);
			ic.setSize(600,420);
			ic.setLocationRelativeTo(null);
			ic.setResizable(false);
			ic.showCard();
		}
	});

	b3 = new JButton("Add Employees");
	b3.setFont(f1);
	b3.setBounds(220,150,150,30);
	p1.add(b3);
	b3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			AddEmp aem = new AddEmp();
			aem.setVisible(true);
			aem.setSize(600,360);
			aem.setLocationRelativeTo(null);
			aem.setResizable(false);
		}
	});

	b4 = new JButton("Add Fare");
	b4.setFont(f1);
	b4.setBounds(220,200,150,30);
	p1.add(b4);
	b4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			AddFare aem = new AddFare();
			aem.setVisible(true);
			aem.setSize(600,360);
			aem.setLocationRelativeTo(null);
			aem.setResizable(false);
		}
	});

	b5 = new JButton("Logout");
	b5.setFont(f1);
	b5.setBounds(220,250,150,30);
	p1.add(b5);
	b5.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			setVisible(false);
			main.setVisible(true);
		}
	});


	getContentPane().add(p1,BorderLayout.CENTER);
	getContentPane().add(p2,BorderLayout.NORTH);
}
}
