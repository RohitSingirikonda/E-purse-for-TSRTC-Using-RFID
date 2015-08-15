package tsrtc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.File;
public class DBCon{
    private static Connection con;
	
public static Connection getCon()throws Exception {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost/tsrtc","root","root");
    return con;
}
public static String deductFare(String src,String des,String card)throws Exception{
	String msg="fail";
	double amount = 0;
	double fare = 0;
    con = getCon();
	Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select amount from issue_card where card_no='"+card+"'");
	if(rs.next()){
        amount = rs.getDouble(1);
    }
	stmt=con.createStatement();
    rs=stmt.executeQuery("select amount from addfare where source='"+src+"' and destination='"+des+"'");
	if(rs.next()){
        fare = rs.getDouble(1);
    }
	if(amount > fare){
		amount = amount - fare;
		PreparedStatement stat=con.prepareStatement("update issue_card set amount=? where card_no=?");
		stat.setDouble(1,amount);
		stat.setString(2,card);
		int i=stat.executeUpdate();
		stat.close();
		if(i > 0)
			msg = "success";
	}else{
		msg = "insufficient fund";
	}
	con.close();
    return msg;
}
public static String addrecharge(String input[])throws Exception{
	String msg="fail";
	boolean flag = false;
    con = getCon();
	PreparedStatement stat=con.prepareStatement("update issue_card set amount=amount+"+input[1]+" where card_no=?");
	stat.setString(1,input[0]);
	int i=stat.executeUpdate();
	stat.close();
	if(i > 0)
		msg = "success";
	con.close();
    return msg;
}
public static String addFare(String[] input)throws Exception{
    String msg="fail";
	boolean flag = false;
    con = getCon();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select source from addfare where source='"+input[0]+"' and destination='"+input[1]+"'");
	if(rs.next()){
        msg = "fare for given route already exist";
		flag = true;
    }
	stmt=con.createStatement();
    rs=stmt.executeQuery("select source from addfare where source='"+input[1]+"' and destination='"+input[0]+"'");
	if(rs.next()){
        msg = "fare for given route already exist";
		flag = true;
    }
	if(!flag){
		java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		PreparedStatement stat=con.prepareStatement("insert into addfare values(?,?,?)");
		stat.setString(1,input[0]);
		stat.setString(2,input[1]);
		stat.setDouble(3,Double.parseDouble(input[2]));
		int i=stat.executeUpdate();
		stat.close();
		if(i > 0)
			msg = "success";
	}
	rs.close();stmt.close();con.close();
    return msg;
}
public static String addEmp(String[] input)throws Exception{
    String msg="fail";
    con = getCon();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select username from addemployes where username='"+input[0]+"'");
	if(rs.next()){
        msg = "username already exist";
    }else{
		java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		PreparedStatement stat=con.prepareStatement("insert into addemployes values(?,?)");
		stat.setString(1,input[0]);
		stat.setString(2,input[1]);
		int i=stat.executeUpdate();
		stat.close();
		if(i > 0)
			msg = "success";
	}
	rs.close();stmt.close();con.close();
    return msg;
}
public static String issueCard(String[] input)throws Exception{
    String msg="fail";
    con = getCon();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select card_no from issue_card where card_no='"+input[3]+"'");
	if(rs.next()){
        msg = "Card no already exist";
    }else{
		java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		PreparedStatement stat=con.prepareStatement("insert into issue_card values(?,?,?,?,?,?)");
		stat.setString(1,input[0]);
		stat.setString(2,input[1]);
		stat.setString(3,input[2]);
		stat.setString(4,input[3]);
		stat.setDate(5,d2);
		stat.setDouble(6,0.0);
		int i=stat.executeUpdate();
		stat.close();
		if(i > 0)
			msg = "success";
	}
	rs.close();stmt.close();con.close();
    return msg;
}
public static String login(String input[])throws Exception{
    String msg="fail";
    con = getCon();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select username from addemployes where username='"+input[0]+"' && password='"+input[1]+"'");
    if(rs.next()){
        msg = "success";
	}
	rs.close();stmt.close();con.close();
    return msg;
}
public static String[] getCard()throws Exception{
    StringBuilder sb = new StringBuilder();
    con = getCon();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select card_no from issue_card");
    while(rs.next()){
        sb.append(rs.getString(1)+",");
	}
	if(sb.length() > 0)
		sb.deleteCharAt(sb.length()-1);
	rs.close();stmt.close();con.close();
    return sb.toString().split(",");
}
}
