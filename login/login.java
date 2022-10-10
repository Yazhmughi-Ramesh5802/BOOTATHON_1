package login;
import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.*;
import javax.swing.*;
import forgot.forgot;

public class login extends Frame
{
    Label l1, l2;
    TextField t1, t2, t3;
    Button b1, b2;
    String username, password;
    login()
    {
        setLayout(null);
        l1 = new Label("UserName");
        l2 = new Label("Password");
        t1 = new TextField();
        t2 = new TextField();
        b1 = new Button("Forgot Password");
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
                password = t1.getText();
            }
        });
        t2.setEchoChar('*');
        b2 = new Button("Login");
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Pattern p1 = Pattern.compile("[a-zA-z]{5,20}");
                Matcher m1 = p1.matcher(username);
                Boolean flag = true;
                if(!m1.matches())
                {
                    flag = false;
                    JOptionPane.showMessageDialog(null, "Invalid Name");
                }
                /*String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$"; 
                Pattern p2 = Pattern.compile(regex);
                Matcher m2= p2.matcher(password);
                if(!m2.matches())
                {
                    flag = false;
                    JOptionPane.showMessageDialog(null, "Invalid Password");
                }*/
                t1.setText("");
                t2.setText("");
                if(flag)
                {
                    System.exit(0);
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