package jdbc;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
//import login.*;

public class mainpage extends JFrame{
    Button b1,b2,b3,b4,b5,b6,b7;
    mainpage()
    {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1 = new Button("NEW STUDENT ENTRY");
        b2 = new Button("NEW FACULTY ENTRY");
        b3 = new Button("STUDENT DATABASE VIEWING");
        b4 = new Button("FACULTY DATABASE VIEWING");
        b5 = new Button("EXAMINATION ENTRY");
        b6 = new Button("EXAMINATION VIEWING");
        b7 = new Button("Log Out");
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	new newStudentDetails();
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new newFacultyDetails();
                
            }
        });
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new STUDENT();
                
            }
        });
        b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new FACULTY();
                
            }
        });
        b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new MARKS();
                
            }
        });
        b6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	new MARKS_VIEW();
                
            }
        });
        b7.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                login.main(null);
            }
        });
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b1.setBounds(500, 200, 200, 30);        
        b2.setBounds(500, 250, 200, 30);        
        b3.setBounds(500, 300, 200, 30);        
        b4.setBounds(500, 350, 200, 30);        
        b5.setBounds(500, 400, 200, 30);        
        b6.setBounds(500, 450, 200, 30);
        b7.setBounds(550, 500, 100, 30);
        add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);
        setSize(1280, 720);
        setBackground(Color.white);
        setResizable(true);
        setVisible(true); 
    }
    public static void main(String[] args) {
        new mainpage();
    }
}