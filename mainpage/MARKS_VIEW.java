package jdbc;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.*;


public class MARKS_VIEW extends JFrame implements ActionListener {
	Choice crollno,sort;
	Connection conn;
	Statement st;
	JTable table;
	JFrame f;
	Button search,print,update,Add,cancel,Sort;
	MARKS_VIEW(){
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1360,700);
		
		JLabel heading = new JLabel("Search");
		heading.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		heading.setForeground(Color.white);
		heading.setBounds(30, 50, 100, 40);
		add(heading);
		
		JLabel sorting = new JLabel("Sort");
		sorting.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		sorting.setForeground(Color.white);
		sorting.setBounds(400, 50, 50, 40);
		add(sorting);
		
		crollno=new Choice();
		crollno.setBounds(140,60,150,40);
		add(crollno);
		
		sort=new Choice();
		sort.setBounds(480,60,150,40);
		add(sort);
		
		String[] choices= {"None","Sub_1","Sub_2","Sub_3","Sub_4","Sub_5","Total","GPA","Grade","Status"};
		for(int i=0;i<choices.length;i++) {
			sort.add(choices[i]);
		}
		
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root","");
    		st = conn.createStatement();
    		String sql="select roll_no,name,department,sub_1,sub_2,sub_3,sub_4,sub_5,total,gpa,grade,status from marks";
    		ResultSet rs = st.executeQuery(sql);
    		crollno.add("All");
    		while(rs.next()) {
    			crollno.add(rs.getString("roll_no"));
			//System.out.print(rs.getString("emp_id"));
    		}
    		ResultSet ds = st.executeQuery(sql);
    		
    		table = new JTable();
    		JScrollPane jsp =new JScrollPane(table);
    		jsp.setBounds(10,160,1360,600);
    		add(jsp);
    		
    		table.setModel(DbUtils.resultSetToTableModel(ds));


    		
		}
		catch(Exception c) {
			System.out.print("error");
		}

		
	
		search = new Button("Search");
		Add = new Button("Add");
		print = new Button("Print");
        cancel = new Button("Back");
        Sort=new Button("Sort");
        
        search.setBounds(50, 120, 80, 30);
        search.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
        search.setBackground(Color.white);
        search.setForeground(Color.black);
        add(search);
        
        Add.setBounds(150, 120, 80, 30);
        Add.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
        search.setBackground(Color.white);
        search.setForeground(Color.black);
        add(Add);
        
        
        print.setBounds(250, 120, 80, 30);
        print.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
        search.setBackground(Color.white);
        search.setForeground(Color.black);
        add(print);
        
        Sort.setBounds(350, 120, 80, 30);
        Sort.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
        search.setBackground(Color.white);
        search.setForeground(Color.black);
        add(Sort);
        
        cancel.setBounds(450, 120, 80, 30);
        cancel.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        add(cancel);
        
        search.addActionListener(this);
        Add.addActionListener(this);
        print.addActionListener(this);
        Sort.addActionListener(this);
        cancel.addActionListener(this);

	
        setBackground(Color.black);
        setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent y) {
		JTable table1;
		if(y.getSource()==search) {
			String sql1="";
			String item = crollno.getSelectedItem();
			System.out.print(item);
			if(!item.equals("All")) sql1="select roll_no,name,department,sub_1,sub_2,sub_3,sub_4,sub_5,total,gpa,grade,status from marks where roll_no='"+item+"'";
			else sql1="select roll_no,sub_1,sub_2,sub_3,sub_4,sub_5,total,gpa,grade,status from marks";
			
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root","");
	    		st = conn.createStatement();

	    		
	    		ResultSet rs = st.executeQuery(sql1);
	    		System.out.println("success");
	    		
	    	
	    		table1 = new JTable();
	    		JScrollPane jsp =new JScrollPane(table1);
	    		jsp.setBounds(10,160,1360,600);
	    		add(jsp);
	    		
	    		table1.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception c) {
				System.out.print("error");
				JOptionPane.showMessageDialog(f,"Error Try Again","Alert",JOptionPane.WARNING_MESSAGE);

				
			}
			
		}
		else if(y.getSource()==Add) {
			new MARKS();
		}
		else if(y.getSource()==print) {
			
			try {
				table.print();
			} catch (Exception e) {
				
				System.out.print("error");
			}
			
			
		}
		else if(y.getSource()==Sort) {
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root","");
	    		st = conn.createStatement();
	    		String category=sort.getSelectedItem();

	    		
	    		String sql="select * from marks order by "+category+" desc";
	    		ResultSet rs = st.executeQuery(sql);
	    		System.out.print("success");
	    		
	    	
	    		table = new JTable();
	    		JScrollPane jsp =new JScrollPane(table);
	    		jsp.setBounds(10,160,1360,600);
	    		add(jsp);
	    		
	    		table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception c) {
				System.out.print("error");
				JOptionPane.showMessageDialog(f,"Error Try Again","Alert",JOptionPane.WARNING_MESSAGE);

				
			}

		}
		else if(y.getSource()==cancel) {
			new mainpage();
			setVisible(false);
		}

}

	

	public static void main(String[] args) {
		//new MARKS_VIEW();

	}

}
