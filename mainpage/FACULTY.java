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


public class FACULTY extends JFrame implements ActionListener {
	Choice crollno,sort;
	Connection conn;
	Statement st;
	JTable table1;
	JFrame f;
	Button search,print,update,Add,cancel,Sort;
	FACULTY(){
		setBackground(Color.black);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1360,700);
		
		JLabel heading = new JLabel("Search");
		heading.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		heading.setForeground(Color.black);
		heading.setBounds(30, 50, 100, 40);
		add(heading);
		
		JLabel sorting = new JLabel("Sort");
		sorting.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		sorting.setForeground(Color.black);
		sorting.setBounds(400, 50, 50, 40);
		add(sorting);
		
		crollno=new Choice();
		crollno.setBounds(140,60,150,40);
		add(crollno);
		
		sort=new Choice();
		sort.setBounds(480,60,150,40);
		add(sort);
		
		String[] choices= {"None","Name","Tutor"};
		for(int i=0;i<choices.length;i++) {
			sort.add(choices[i]);
		}
		
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root","");
    		st = conn.createStatement();
    		String sql="select * from facultydetails";
    		ResultSet rs = st.executeQuery(sql);
    		crollno.add("None");
    		while(rs.next()) {
    			crollno.add(rs.getString("faculty_id"));
			//System.out.print(rs.getString("emp_id"));
    		}
    		ResultSet ds = st.executeQuery(sql);
    		System.out.print("Hi");
    		table1 = new JTable();
    		JScrollPane jsp =new JScrollPane(table1);
    		jsp.setBounds(10,160,1360,600);
    		add(jsp);
    		
    		table1.setModel(DbUtils.resultSetToTableModel(ds));


    		
		}
		catch(Exception c) {
			System.out.print("error");
		}

		
	
		search = new Button("Search");
		Add = new Button("Add");
		update = new Button("Update");
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
        
        update.setBounds(250, 120, 80, 30);
        update.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
        search.setBackground(Color.white);
        search.setForeground(Color.black);
        add(update);
        
        print.setBounds(350, 120, 80, 30);
        print.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
        search.setBackground(Color.white);
        search.setForeground(Color.black);
        add(print);
        
        Sort.setBounds(450, 120, 80, 30);
        Sort.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
        search.setBackground(Color.white);
        search.setForeground(Color.black);
        add(Sort);
        
        cancel.setBounds(550, 120, 80, 30);
        cancel.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
        search.setBackground(Color.white);
        search.setForeground(Color.black);
        add(cancel);
        
        search.addActionListener(this);
        Add.addActionListener(this);
        update.addActionListener(this);
        print.addActionListener(this);
        Sort.addActionListener(this);
        cancel.addActionListener(this);

	
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent y) {
		if(y.getSource()==search) {
			String sql="";
			String item = crollno.getSelectedItem();
			if(!item.equals("None")) sql="select * from facultydetails where faculty_id='"+item+"'";
			else sql="select * from student";
			
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root","");
	    		st = conn.createStatement();

	    		
	    		ResultSet rs = st.executeQuery(sql);
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
			new newFacultyDetails();
		}
		else if(y.getSource()==print) {
			
			try {
				table1.print();
			} catch (Exception e) {
				
				System.out.print("error");
			}
			
			
		}
		else if(y.getSource()==Sort) {
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root","");
	    		st = conn.createStatement();
	    		String category=sort.getSelectedItem();
//	    		if(category.equals("Name")) category="name";
//	    		else if(category.equals("Marks")) category="marks";
//	    		else if(category.equals("Tutor")) category="tuto"
	    		
	    		String sql="select * from facultydetails order by "+category;
	    		ResultSet rs = st.executeQuery(sql);
	    		System.out.print("success");
	    		
	    	
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
		else if(y.getSource()==cancel) {
			new mainpage();
			 setVisible(false);
		}
		else if(y.getSource()==update) {
			new updateFacultyDetails();
		}
		
	}

	public static void main(String[] args) {
		//new FACULTY();

	}

}
