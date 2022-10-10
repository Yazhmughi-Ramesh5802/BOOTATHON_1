package mainpage;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import login.*;

public class mainpage extends Frame{
    Button b1,b2,b3,b4,b5,b6,b7;
    mainpage()
    {
        setLayout(null);
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
                dispose();
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                
            }
        });
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                
            }
        });
        b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                
            }
        });
        b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                
            }
        });
        b6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                
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
