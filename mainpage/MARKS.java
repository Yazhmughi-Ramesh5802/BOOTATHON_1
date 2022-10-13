package jdbc;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.proteanit.sql.DbUtils;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.*;


public class MARKS extends JFrame implements ActionListener{
	Connection conn;
	JFrame f;
	Statement st;
	JLabel heading,roll_no,mark_1,mark_2,mark_3,mark_4,mark_5,semester;
	JTextField tRoll_no,tmark_1,tmark_2,tmark_3,tmark_4,tmark_5;
	Choice sem;
	Button submit,reset,cancel;
	MARKS(){
		f=new JFrame();
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		heading = new JLabel("Enter Marks of Students");
		heading.setFont(new Font("Bahnschrift Condensed",Font.BOLD,30));
		heading.setForeground(Color.black);
		heading.setBounds(30, 50, 500, 30);
		add(heading);
		
		roll_no=new JLabel("Roll no");
		roll_no.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		roll_no.setBounds(30, 80, 200, 50);
		add(roll_no);
	
		tRoll_no=new JTextField();
		tRoll_no.setBounds(30, 120, 200, 30);
		add(tRoll_no);
		
		semester=new JLabel("Semester");
		semester.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		semester.setBounds(30, 150, 200, 50);
		add(semester);
		
		String[] sems= {"None","Semester 1","Semester 2"};
		sem=new Choice();
		for(int i=0;i<sems.length;i++) {
			sem.add(sems[i]);
		}
		sem.setBounds(30, 200, 200, 50);
		add(sem);
		
		mark_1=new JLabel("Subject 1");
		mark_1.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		mark_1.setBounds(30, 230, 200, 50);
		add(mark_1);
		
		tmark_1=new JTextField();
		tmark_1.setBounds(30, 280, 200, 30);
		add(tmark_1);
		
		mark_2=new JLabel("Subject 2");
		mark_2.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		mark_2.setBounds(30, 310, 200, 50);
		add(mark_2);
		
		tmark_2=new JTextField();
		tmark_2.setBounds(30, 360, 200, 30);
		add(tmark_2);
		
		mark_3=new JLabel("Subject 3");
		mark_3.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		mark_3.setBounds(30, 390, 200, 50);
		add(mark_3);
		
		tmark_3=new JTextField();
		tmark_3.setBounds(30, 440, 200, 30);
		add(tmark_3);
		
		mark_4=new JLabel("Subject 4");
		mark_4.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		mark_4.setBounds(30, 470, 200, 50);
		add(mark_4);
		
		tmark_4=new JTextField();
		tmark_4.setBounds(30, 520, 200, 30);
		add(tmark_4);
		
		mark_5=new JLabel("Subject 5");
		mark_5.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		mark_5.setBounds(30, 550, 200, 50);
		add(mark_5);
		
		tmark_5=new JTextField();
		tmark_5.setBounds(30, 600, 200, 30);
		add(tmark_5);
		
		submit = new Button("Submit");
		reset = new Button("Reset");
		cancel = new Button("Back");
		
		submit.setBounds(60, 660, 100, 30);
		submit.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		
		reset.setBounds(200, 660, 100, 30);
		reset.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		
		cancel.setBounds(320, 660, 100, 30);
		cancel.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));		
		add(submit);
		add(reset);
		add(cancel);
		
		submit.addActionListener(this);
		cancel.addActionListener(this);
		reset.addActionListener(this);
		
		
		setSize(1360,800);
		setVisible(true);
		
	}
	public boolean search_id(String id) {
   	 ResultSet rs;
   	 try {
   		 Class.forName("com.mysql.cj.jdbc.Driver");
	     	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root","");
	    	 st = conn.createStatement();
	    	 
	    	 String sql_search="select * from marks where roll_no="+"'"+id+"'";
	  		 rs=st.executeQuery(sql_search);
	
	  		 while(rs.next()) {
//	  			 flag=1;
//	  			 break;
	  			 return true;
	  			 //if((rs.getString("roll_no")).equals(id)) return true;
	  		 }
	  		 return false;
   	 }
   	 catch(Exception s) {}
   	 return false;

		
    }

	public boolean search(String r) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root","");
    		st = conn.createStatement();
    		String sql = "select roll_no from studentdetails where roll_no="+"'"+r+"'";
    		ResultSet rs= st.executeQuery(sql);
    		while(rs.next()) {
    			
    			return true;
    		}
    		
    		return false;
		}
		catch(Exception c) {System.out.print("error");}
		return false;
	}
	public int mark_convert(String num) {
		double ans=Double.parseDouble(num);
		double ANS=Math.floor(ans);
		return (int)ANS;
	}
	public boolean mark_check(String num) {
		String regex="[-+]?[0-9]*\\.?[0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(num);
		return matcher.matches();
	}
	public boolean marks_validate(String num) {
		
		double ans=Double.parseDouble(num);
		int ANS=(int)Math.floor(ans);
		System.out.println(num);
		if(ANS>=0 && ANS<=100) return true;
		else return false;
	}
    public static boolean idValidation(String id) {
   	 String id_regex="^[a-zA-Z\\s]+$";
   	 Pattern id_pat=Pattern.compile(id_regex,Pattern.CASE_INSENSITIVE);
   	 Matcher matcher = id_pat.matcher(id);
   	 return matcher.find();
  
    }
    public String check(int m1,int m2,int m3,int m4,int m5,int total) {
    	String stat="Pass";
    	if(m1<20) stat="Fail";
    	else if(m2<20) stat="Fail";
    	else if(m3<20) stat="Fail";
    	else if(m4<20) stat="Fail";
    	else if(m5<20) stat="Fail";
    	else if(total<250) stat="Fail";
    	return stat;
    }
    
	 @Override
	 public void actionPerformed(ActionEvent y) {
		 if(y.getSource()==submit) {
			 String rollno="";
			 rollno=tRoll_no.getText();
			 System.out.print(tRoll_no.getText());
			 String SEM=sem.getSelectedItem();
			 String s1=tmark_1.getText();
			 String s2=tmark_2.getText();
			 String s3=tmark_3.getText();
			 String s4=tmark_4.getText();
			 String s5=tmark_5.getText();


			 
			 
			 if(tRoll_no.getText().trim().isEmpty()) JOptionPane.showMessageDialog(f,"Enter Roll Number","Alert",JOptionPane.WARNING_MESSAGE);
			 
			 else if(idValidation(rollno)) JOptionPane.showMessageDialog(f,"Enter correct roll no","Alert",JOptionPane.WARNING_MESSAGE);
			 else if(!search(rollno)) JOptionPane.showMessageDialog(f,"Student not enrolled","Alert",JOptionPane.WARNING_MESSAGE);
			 
			 else if(sem.getSelectedItem().trim().isEmpty() || sem.getSelectedItem().trim().equals("None") ) JOptionPane.showMessageDialog(f,"Choose semester","Alert",JOptionPane.WARNING_MESSAGE);
			 
			 else if(tmark_1.getText().trim().isEmpty()) JOptionPane.showMessageDialog(f,"Enter Subject 1 Mark","Alert",JOptionPane.WARNING_MESSAGE);
			 else if(!mark_check(s1)) JOptionPane.showMessageDialog(f,"Enter correct value","Alert",JOptionPane.WARNING_MESSAGE);
			 else if(!marks_validate(s1)) JOptionPane.showMessageDialog(f,"Enter correct Marks for Subject 1","Alert",JOptionPane.WARNING_MESSAGE);
			 
			 else if(tmark_2.getText().trim().isEmpty()) JOptionPane.showMessageDialog(f,"Enter Subject 2 Mark","Alert",JOptionPane.WARNING_MESSAGE);
			 else if(!marks_validate(s2)) JOptionPane.showMessageDialog(f,"Enter correct Marks for Subject 2","Alert",JOptionPane.WARNING_MESSAGE);
			 else if(!mark_check(s2)) JOptionPane.showMessageDialog(f,"Enter correct value","Alert",JOptionPane.WARNING_MESSAGE);
			 
			 else if(tmark_3.getText().trim().isEmpty()) JOptionPane.showMessageDialog(f,"Enter Subject 3 Mark","Alert",JOptionPane.WARNING_MESSAGE);
			 else if(!marks_validate(s3)) JOptionPane.showMessageDialog(f,"Enter correct Marks for Subject 3","Alert",JOptionPane.WARNING_MESSAGE);
			 else if(!mark_check(s3)) JOptionPane.showMessageDialog(f,"Enter correct value","Alert",JOptionPane.WARNING_MESSAGE);
			 
			 else if(tmark_4.getText().trim().isEmpty()) JOptionPane.showMessageDialog(f,"Enter Subject 4 Mark","Alert",JOptionPane.WARNING_MESSAGE);
			 else if(!marks_validate(s4)) JOptionPane.showMessageDialog(f,"Enter correct Marks for Subject 4","Alert",JOptionPane.WARNING_MESSAGE);
			 else if(!mark_check(s4)) JOptionPane.showMessageDialog(f,"Enter correct value","Alert",JOptionPane.WARNING_MESSAGE);
			 
			 else if(tmark_5.getText().trim().isEmpty()) JOptionPane.showMessageDialog(f,"Enter Subject 5 Mark","Alert",JOptionPane.WARNING_MESSAGE);
			 else if(!marks_validate(s5)) JOptionPane.showMessageDialog(f,"Enter correct Marks for Subject 5","Alert",JOptionPane.WARNING_MESSAGE);			 
			 else if(!mark_check(s1)) JOptionPane.showMessageDialog(f,"Enter correct value","Alert",JOptionPane.WARNING_MESSAGE);
			 //else if(idValidation(rollno)) JOptionPane.showMessageDialog(f,"Enter Correct Roll No","Alert",JOptionPane.WARNING_MESSAGE);
			 else if(search_id(rollno)) JOptionPane.showMessageDialog(f,"Student marks already entered","Alert",JOptionPane.WARNING_MESSAGE);

			 else {
				 String grade="0";
				 String status="0";
				 String name="0";
				 String email="0";
				 String dept="0";
//				 try {
//					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root","");
//			    	st = conn.createStatement();
//			    	String sql="select name,branch from studentdetails where roll_no="+"'"+rollno+"'";
//			    	ResultSet r=st.executeQuery(sql);
//			    	name=r.getString("name");
//			    	dept=r.getString("dept");
//				 }
//				 catch(Exception e) {}
				 int m1=mark_convert(s1);
				 int m2=mark_convert(s2);
				 int m3=mark_convert(s3);
				 int m4=mark_convert(s4);
				 int m5=mark_convert(s5);
				 
				 int total=m1+m2+m3+m4+m5;
				 status=check(m1,m2,m3,m4,m5,total);
				 String TOTAL = Integer.toString(total);
				 float gpa=(float)Math.ceil(total/5);
				 String GPA=Float.toString(gpa);
				 if(gpa==50) {
					 grade="O";
					 //status="Pass";
					 System.out.print("hi");
				 }
				 else if(gpa>=40 && gpa<50) {
					 grade="A+";
					 //status="Pass";
				 }
				 else if(gpa>=30 && gpa<40) {
					 grade="A";
					 //status="Pass";
				 }
				 else if(gpa>=20 && gpa<30) {
					 grade="B+";
					 //status="Pass";
				 }
				 else {
					 grade="None";
					 //status="Fail";
					 //System.out.print("hi");
				 }
				 try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root","");
			    	st = conn.createStatement();
			    	String sql_select = "select name,branch,email from studentdetails where roll_no ="+"'"+rollno+"'";
			    	ResultSet rs = st.executeQuery(sql_select);
			    	while(rs.next()) {
			    		name=rs.getString("name");
			    		dept=rs.getString("branch");
			    		email=rs.getString("email");
			    		
			    	}
			    	
			    	String sql1="insert into marks values('"+rollno+"','"+name+"','"+email+"','"+dept+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+TOTAL+"','"+GPA+"','"+grade+"','"+status+"')";
			    	
			    	st.executeUpdate(sql1);
			    	JOptionPane.showMessageDialog(f,"Success","Message",JOptionPane.WARNING_MESSAGE);

				 }
				 catch(Exception c) {
					 JOptionPane.showMessageDialog(f,"Details entered are incorrect","Alert",JOptionPane.WARNING_MESSAGE);

					 System.out.print(c);
				}
		 			tRoll_no.setText("");
		 			tmark_1.setText("");
		 			tmark_2.setText("");
		 			tmark_3.setText("");
		 			tmark_4.setText("");
		 			tmark_5.setText("");
				 
			 }

			 
			 
			 
		 }
		 else if(y.getSource()==cancel) {
			 new mainpage();
			 setVisible(false);
		 }
		 else if(y.getSource()==reset) {
 			tRoll_no.setText("");
 			tmark_1.setText("");
 			tmark_2.setText("");
 			tmark_3.setText("");
 			tmark_4.setText("");
 			tmark_5.setText("");
		 }
		 
		 
	 }

	public static void main(String[] args) {
		//new MARKS();

	}

}
