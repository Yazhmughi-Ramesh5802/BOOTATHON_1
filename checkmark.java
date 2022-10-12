package Swings;
import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.*;
import javax.swing.*;
public class checkmark extends Frame {
    Label l1,l2;
    TextField t1,t2;
    Button b1,b2;
    String no,dob;
    checkmark(){
        setLayout(null);
        l1 = new Label("Roll No");
        l2 = new Label("Date Of Birth");
        t1 = new TextField();
        t2 = new TextField();
        b1 = new Button("Submit");
        b2 = new Button("Close");

        t1.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                no = t1.getText();
            }
        });
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Pattern p1 = Pattern.compile("[a-zA-Z1-9]*");
                Matcher m1 = p1.matcher(no);
                Boolean flag = true;
                if(m1.matches()==false)
                {
                    flag = false;
                    JOptionPane.showMessageDialog(null, "Invalid Name");
                }
                if(flag)
                {
                    //dispose();
                    System.exit(0);
                }
            }
        });
        b1.setFont(getFont());
        t2.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                dob = t1.getText();
            }
        }); 
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        l1.setBounds(100, 100, 100, 25);
        l2.setBounds(100, 150, 100, 25);
        t1.setBounds(200, 100, 100, 25);
        t2.setBounds(200, 150, 100, 25);
        b1.setBounds(150, 200, 100, 25);
        b2.setBounds(150, 250, 100, 25);
        add(l1); add(l2); add(t1); add(t2); add(b1); add(b2);
        setSize(600, 500);
        setBackground(Color.WHITE);
        setResizable(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new checkmark();
    }

}
