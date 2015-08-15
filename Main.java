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
public class Main extends JFrame
{
	GradientPanel p1;
	JPanel p2;
	JLabel title;
	JButton b1,b2,b3;
	Font f1;
public Main(){
	super("TSRTC");
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
	b1 = new JButton("Administrator");
	b1.setFont(f1);
	b1.setBounds(220,50,150,30);
	p1.add(b1);
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			setVisible(false);
			AdminLogin al = new AdminLogin(Main.this);
			al.setVisible(true);
			al.setSize(600,360);
			al.setLocationRelativeTo(null);
			al.setResizable(false);
		}
	});
	b2 = new JButton("Employees");
	b2.setFont(f1);
	b2.setBounds(220,100,150,30);
	p1.add(b2);
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			setVisible(false);
			Login al = new Login(Main.this);
			al.setVisible(true);
			al.setSize(600,360);
			al.setLocationRelativeTo(null);
			al.setResizable(false);
		}
	});

	b3 = new JButton("Exit");
	b3.setFont(f1);
	b3.setBounds(220,150,150,30);
	p1.add(b3);
	b3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			System.exit(0);
		}
	});


	getContentPane().add(p1,BorderLayout.CENTER);
	getContentPane().add(p2,BorderLayout.NORTH);
}
public static void main(String a[])throws Exception{
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	Main main = new Main();
	main.setVisible(true);
	main.setSize(600,360);
	main.setLocationRelativeTo(null);
	main.setResizable(false);
}


}
