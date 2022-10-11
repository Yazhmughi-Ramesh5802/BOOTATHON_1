package resetpass;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import forgot.forgot;

public class pass extends JFrame
{
    Label l1, l2;
    TextField t1, t2;
    Button b1, b2;
    String password, repassword;
    pass()
    {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1 = new Label("Enter  Password");
        l2 = new Label("Renter Password");
        t1 = new TextField();
        t2 = new TextField();
        b1 = new Button("Submit");
        b2 = new Button("Back");
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
                String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$"; 
                if(!password.matches(regex))
                {
                    JOptionPane.showMessageDialog(null, "Invalid Password");
                }
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
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        l1.setBounds(400, 200, 200, 30);
        l2.setBounds(400, 250, 200, 30);
        t1.setBounds(600, 200, 200, 30);
        t2.setBounds(600, 250, 200, 30);
        b1.setBounds(600, 300, 100, 25);
        b2.setBounds(600, 600, 100, 30);
        add(l1); add(l2); add(t1); add(t2); add(b1); add(b2);
        setSize(1280, 720);
        setBackground(Color.white);
        setResizable(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new pass();
    }
}