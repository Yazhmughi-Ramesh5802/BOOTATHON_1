package login;
import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import forgot.forgot;
import mainpage.mainpage;

public class login extends JFrame
{
    Label l1, l2;
    TextField t1, t2, t3;
    Button b1, b2;
    String username, password;
    login()
    {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1 = new Label("UserName");
        l2 = new Label("Password");
        t1 = new TextField();
        t2 = new TextField();
        b1 = new Button("Forgot Password");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        t1.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                username = t1.getText();
            }
        });
        t2.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                password = t2.getText();
            }
        });
        t2.setEchoChar('*');
        b2 = new Button("Login");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                Boolean flag = true;
                String regex1 = "[a-zA-z]{5,20}";
                if(!username.matches(regex1))
                {
                    flag = false;
                    JOptionPane.showMessageDialog(null, "Invalid Name");
                }
                String regex2 = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
                if(!password.matches(regex2))
                {
                    flag = false;
                    JOptionPane.showMessageDialog(null, "Invalid Password");
                }
                t1.setText("");
                t2.setText("");
                if(flag)
                {
                    dispose();
                    mainpage.main(null);
                }
                }
                catch(Exception t)
                {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                }
            }
        });
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new forgot();
            }
        });
        l1.setBounds(400, 200, 200, 30);
        l2.setBounds(400, 250, 200, 30);
        t1.setBounds(600, 200, 200, 30);
        t2.setBounds(600, 250, 200, 30);
        b1.setBounds(600, 300, 100, 25);
        b2.setBounds(600, 400, 100, 25);
        
        add(l1); add(l2); add(t1); add(t2); add(b1); add(b2);
        setSize(1280, 720);
        setBackground(Color.white);
        setResizable(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new login();
    }
}