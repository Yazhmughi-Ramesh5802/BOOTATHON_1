package exmark;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import forgot.forgot;

public class exmark extends Frame
{
    Label l1, l2, l3, l4, l5, l6, l7;
    TextField t1, t2, t3, t4, t5, t6, t7;
    Button b1, b2;
    String password, repassword;
    exmark()
    {
        setLayout(null);
        l1 = new Label("ROLL NO:");
        l2 = new Label("ROLL NO:");
        l3 = new Label("ROLL NO:");
        l4 = new Label("ROLL NO:");
        l5 = new Label("ROLL NO:");
        l6 = new Label("ROLL NO:");
        l7 = new Label("ROLL NO:");
        t1.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                password = t1.getText();
            }
        });
        t2.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                repassword = t2.getText();
            }
        });
        t2.setEchoChar('*');
        t1.setEchoChar('*');
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                /*Pattern p1 = Pattern.compile("[a-zA-z]{5,20}");
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
                if(password.equals(repassword))
                {
                    System.out.print(password +" " + repassword);
                    JOptionPane.showMessageDialog(null, "SUCCESS!");
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Password Mismatch");
                    t1.setText("");
                    t2.setText("");
                }
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                forgot.start();
            }
        });
        l1.setBounds(400, 200, 200, 30);
        l2.setBounds(400, 250, 200, 30);
        t1.setBounds(600, 200, 200, 30);
        t2.setBounds(600, 250, 200, 30);
        b1.setBounds(600, 300, 100, 25);
        b2.setBounds(600, 450, 100, 30);
        add(l1); add(l2); add(t1); add(t2); add(b1); add(b2);
        setSize(1280, 720);
        setBackground(Color.white);
        setResizable(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new exmark();
    }
}