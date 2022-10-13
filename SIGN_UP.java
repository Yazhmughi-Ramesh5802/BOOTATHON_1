package jdbc;
import java.awt.*;

import java.awt.Color;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class SIGN_UP extends JFrame implements ActionListener{

     Connection conn;
     Statement st;
     
     Label title,name,emp_id,email_id,password,conf_password,phone;
     TextField Tname,Temp_id,Temail_id,Tpassword,Tconf_password,Tphone;
     Button submit,reset,cancel;
     JFrame f;
     
     
     SIGN_UP(){
         setLayout(null);
         setSize(1000,700);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         title=new Label("Sign up");
         title.setBounds(30, 30, 200, 50);
         title.setFont(new Font("Bahnschrift Condensed",Font.BOLD,30));
         add(title);
         
         name=new Label("Username");
         name.setBounds(30, 90, 200, 50);
         name.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
         add(name);
         
         Tname=new TextField();
         Tname.setBounds(30,140,300,30);
         add(Tname);
         
         emp_id=new Label("Faculty Id");
         emp_id.setBounds(500, 90, 200, 50);
         emp_id.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
         add(emp_id);
         
         Temp_id=new TextField();
         Temp_id.setBounds(500,140,300,30);
         add(Temp_id);
         
         email_id=new Label("Email Id");
         email_id.setBounds(30, 170, 200, 50);
         email_id.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
         add(email_id);
         
         Temail_id=new TextField();
         Temail_id.setBounds(30,220,300,30);
         add(Temail_id);
         
         phone=new Label("Phone Number");
         phone.setBounds(500, 170, 200, 50);
         phone.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
         add(phone);
         
         Tphone=new TextField();
         Tphone.setBounds(500,220,300,30);
         add(Tphone);
         
         
         password=new Label("Password");
         password.setBounds(30, 250, 200, 50);
         password.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
         add(password);
         
         Tpassword=new TextField();
         Tpassword.setBounds(30,300,300,30);
         Tpassword.setEchoChar('*');
         add(Tpassword);
         
         conf_password=new Label("Confirm Password");
         conf_password.setBounds(500, 250, 200, 50);
         conf_password.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
         add(conf_password);
         
         Tconf_password=new TextField();
         Tconf_password.setBounds(500,300,300,30);
         Tconf_password.setEchoChar('*');
         add(Tconf_password);
         
         submit = new Button("Submit");
         reset = new Button("Reset");
         cancel = new Button("Cancel");
         
         submit.setBounds(200,380,100,50);
         submit.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.white);
         add(submit);
         
         reset.setBounds(355,380,100,50);
         reset.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
         reset.setBackground(Color.BLACK);
         reset.setForeground(Color.white);
         add(reset);
         
         cancel.setBounds(510,380,100,50);
         cancel.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.white);
         add(cancel);
         
         submit.addActionListener(this);
         reset.addActionListener(this);
         cancel.addActionListener(this);
         setBackground(Color.gray);
         setResizable(false);

         setVisible(true);
         
         
     }
     public static boolean isValidMobileNo(String str)  
     {  
     //(0/91): number starts with (0/91)  
     //[7-9]: starting of the number may contain a digit between 0 to 9  
     //[0-9]: then contains digits 0 to 9  
     Pattern ptrn = Pattern.compile("(0/91)?[6-9][0-9]{9}");  
     //the matcher() method creates a matcher that will match the given input against this pattern  
     Matcher match = ptrn.matcher(str);  
     
     
     return (match.find() && match.group().equals(str));  
     }  
     public static boolean isAlpha(String s) {
         return s != null && s.matches("^[a-zA-Z]*$");
     }
     public boolean search(String id) {
    	 ResultSet rs;
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
	     	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root","");
	    	 st = conn.createStatement();
	    	 
	    	 String sql_search="select * from sign_up";
	  		 rs=st.executeQuery(sql_search);
	  		 int flag=0;
	  		 while(rs.next()) {
//	  			 flag=1;
//	  			 break;
	  			 if((rs.getString("emp_id")).equals(id)) return true;
	  		 }
	  		 return false;
    	 }
    	 catch(Exception s) {}
    	 return false;

 		
     }
     
     public static boolean passwordValidation(String s1) {
         if(s1.matches(".*[0-9]{1,}.*") && s1.matches(".*[@#$]{1,}.*") && s1.length() >=6 && s1.length()<=15){
             return  true;
         }
         else
         {
             return false;
         }
     }
     
     public static boolean idValidation(String id) {
    	 String id_regex="^[a-zA-Z\\s]+$";
    	 Pattern id_pat=Pattern.compile(id_regex,Pattern.CASE_INSENSITIVE);
    	 Matcher matcher = id_pat.matcher(id);
    	 return matcher.find();
   
     }
     public static boolean email_validation(String mail) {
    	 String e_mail_regex="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    	 Pattern email_pat=Pattern.compile(e_mail_regex,Pattern.CASE_INSENSITIVE);
    	 Matcher matcher = email_pat.matcher(mail);
    	 return matcher.find();
//         A-Z characters are permitted
//         a-z characters are permitted
//         0-9 digits are permitted
//         Underscore(_), dash(-), and dot(.) are permitted
//         Other characters are not permitted

     } 


    	

     
 

    public void actionPerformed(ActionEvent e) {
    		
    		
    		if(e.getSource()==submit) {
    			if(Tname.getText().trim().isEmpty()) JOptionPane.showMessageDialog(f,"Name is empty","Alert",JOptionPane.WARNING_MESSAGE);
    			else if(!isAlpha(Tname.getText().trim())) JOptionPane.showMessageDialog(f,"Enter correct name","Alert",JOptionPane.WARNING_MESSAGE);
    			else if(Temp_id.getText().trim().isEmpty()) JOptionPane.showMessageDialog(f,"Employee ID is empty","Alert",JOptionPane.WARNING_MESSAGE);
    			else if(idValidation(Temp_id.getText().trim())) JOptionPane.showMessageDialog(f,"Enter the Faculty Id in correct format","Alert",JOptionPane.WARNING_MESSAGE);
    			else if(search(Temp_id.getText().trim())) JOptionPane.showMessageDialog(f,"Employee ID already exist","Alert",JOptionPane.WARNING_MESSAGE);
    			else if(Temail_id.getText().trim().isEmpty()) JOptionPane.showMessageDialog(f,"Email ID is empty","Alert",JOptionPane.WARNING_MESSAGE);
    			else if(!email_validation(Temail_id.getText().trim())) JOptionPane.showMessageDialog(f,"Enter correct Email Id","Alert",JOptionPane.WARNING_MESSAGE);
    			else if(Tphone.getText().trim().isEmpty()) JOptionPane.showMessageDialog(f,"Phone Number is empty","Alert",JOptionPane.WARNING_MESSAGE);
    			else if(!isValidMobileNo(Tphone.getText().trim())) JOptionPane.showMessageDialog(f,"Enter correct Phone number","Alert",JOptionPane.WARNING_MESSAGE);
    			else if(Tpassword.getText().trim().isEmpty()) JOptionPane.showMessageDialog(f,"Password is empty","Alert",JOptionPane.WARNING_MESSAGE);
    			else if(!passwordValidation(Tpassword.getText().trim())) JOptionPane.showMessageDialog(f,"Password Must contain at least one digit\r\n"
    					+ "Password Must contain at least one of the following special characters @, #, $\r\n"
    					+ "Password length should be between 6 to 15 characters.","Alert",JOptionPane.WARNING_MESSAGE);
    			else if(Tconf_password.getText().trim().isEmpty()) JOptionPane.showMessageDialog(f,"Confirm Password is empty","Alert",JOptionPane.WARNING_MESSAGE);
    			else if(!(Tpassword.getText().trim()).equals(Tconf_password.getText().trim())) JOptionPane.showMessageDialog(f,"Passwords do not match","Alert",JOptionPane.WARNING_MESSAGE);
    			
    			else {	
    				try {
    	    		Class.forName("com.mysql.cj.jdbc.Driver");
    	     		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root","");
    	    		st = conn.createStatement();
    	    		String Sname=Tname.getText();
    	    		String Semp_id=Temp_id.getText();
    	    		String Semail_id=Temail_id.getText();
    	    		String Sph=Tphone.getText();
  	    		    String Spassword=Tpassword.getText();
    	    		String Sconf_password=Tconf_password.getText();

    	    		String sql1="insert into sign_up values('"+Sname+"','"+Semp_id+"','"+Semail_id+"','"+Spassword+"','"+Sconf_password+"','"+Sph+"')";
    	  			st.executeUpdate(sql1);
        	    	JOptionPane.showMessageDialog(f,"Student added Successfully","Message",JOptionPane.WARNING_MESSAGE); 
    	  			conn.close();
        			Tname.setText("");
        			Temp_id.setText("");
        			Temail_id.setText("");
        			Tphone.setText("");
        			Tpassword.setText("");
        			Tconf_password.setText("");
    			

    			}   
    	    	catch(Exception y) {
    				System.out.println("Error");
    				JOptionPane.showMessageDialog(f,"Enter correct values","Alert",JOptionPane.WARNING_MESSAGE); 
        			Tname.setText("");
        			Temp_id.setText("");
        			Temail_id.setText("");
        			Tphone.setText("");
        			Tpassword.setText("");
        			Tconf_password.setText("");
    				}
    			}
    		}
    	    
    	    
    		else if(e.getSource()==reset) {
    			Tname.setText("");
    			Temp_id.setText("");
    			Temail_id.setText("");
    			Tphone.setText("");
    			Tpassword.setText("");
    			Tconf_password.setText("");

    			
    		}
    		else if(e.getSource()==cancel) {
    			setVisible(false);
    		}

    }
public static void main(String aa[])
	 {
    	new SIGN_UP();
	 }

}
