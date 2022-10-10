package forgot;
import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.*;
import javax.swing.*;
import resetpass.pass;

public class forgot extends Frame{
    Label l1, l2;
    int otp, pin;
    TextField t1, t2;
    Button b1, b2;
    String username, str;
    public forgot()
    {
        l1 = new Label("Email");
        l1.setBackground(Color.white);
        t1 = new TextField();
        l2 = new Label("OTP");
        l2.setBackground(Color.white);
        t2 = new TextField();
        b1 = new Button("Generate OTP");
        b2 = new Button("Submit");
        t1.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                username = t1.getText();
            }
        });
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Pattern p = Pattern.compile("[a-z0-9]*@.[a-z]*.com");
                Matcher m = p.matcher(username);
                if(!m.matches())
                {
                    JOptionPane.showMessageDialog(null, "Invalid Username");
                    t1.setText("");
                }
                otp = (int)(Math.random()*(9999-1000+1) + 1000);
                System.out.println(otp);
            }
        });
        t2.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                str = t2.getText();
                System.out.println(str);
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(str.matches("[0-9]*"))
                {
                    pin = Integer.parseInt(str);
                }
                if(otp != pin)
                {
                    JOptionPane.showMessageDialog(null, "Invalid OTP");
                }
                else
                {
                    dispose();
                    pass.main(null);
                }
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
        setBackground(Color.MAGENTA);
        setResizable(true);
        setVisible(true);
    }
    public static void start()
    {
        new forgot();
    }
}