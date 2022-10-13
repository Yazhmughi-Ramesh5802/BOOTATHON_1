package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

//calender
import com.toedter.calendar.JDateChooser;

public class newStudentDetails extends JFrame implements ActionListener {
	
	//global variables
	JTextField tfname,tfRoll,tfmail,tftwelve,tfhsc,tfParent,tfCourse,tfbranch,tftutor,tfgdate,tfpassingYear,tfresidence;
	JDateChooser date;
	JComboBox residency,courses,Quotas;
	JButton submit,cancel,reset;
	
	public static void setTool() {
		
		UIManager.put("ToolTip.background", Color.WHITE);
		UIManager.put("ToolTip.foreground", Color.BLACK);
		UIManager.put("ToolTip.font", new Font("Arial", Font.ITALIC, 14));
	}
	
	newStudentDetails(){
		
		setLayout(null);
		setSize(900,700);
		setLocation(350,50);
		getContentPane().setBackground(Color.lightGray);
		
		JLabel heading = new JLabel("Student Entry Portal");
		heading.setBounds(280,30,500,50);
		heading.setFont(new Font("Bahnschrift Condensed",Font.BOLD,40));
		add(heading);
		
		JLabel lblname = new JLabel("Name: ");
		lblname.setBounds(50,100,70,100); //from left from top and size: length, width
		lblname.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200,140,170,25);
		tfname.setToolTipText("Name should contain only words");
		setTool();
		tfname.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,20));
		add(tfname);
		
		JLabel lblRoll = new JLabel("Roll No: ");
		lblRoll.setBounds(50,180,90,100); //from left from top and size: length, width
		lblRoll.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		add(lblRoll);
		
		tfRoll = new JTextField();
		tfRoll.setBounds(200,220,170,25);
		tfRoll.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,20));
		tfRoll.setToolTipText("Roll no can be alphanumeric");
		setTool();
		add(tfRoll);
		
		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setBounds(50,260,110,100); //from left from top and size: length, width
		lblEmail.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		add(lblEmail);
		
		tfmail = new JTextField();
		tfmail.setBounds(200,300,170,25);
		tfmail.setToolTipText("format: abc@example.com & special characters allowed: (-._)");
		setTool();
		tfmail.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,20));
		add(tfmail);
		
		JLabel lbltwelve = new JLabel("12th Marks: ");
		lbltwelve.setBounds(50,340,130,100); //from left from top and size: length, width //50 80 inc 20 inc 100
		lbltwelve.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		add(lbltwelve);
		
		tftwelve = new JTextField();
		tftwelve.setBounds(200,380,170,25); //150 80inc 150 25
		add(tftwelve);
		
		JLabel lblquota = new JLabel("Quota: ");
		lblquota.setBounds(50,420,150,100); //from left from top and size: length, width //50 80 inc 20 inc 100
		lblquota.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		add(lblquota);
		
		String quota[] = {"none","Govt Quota","Management Quota"};
		Quotas = new JComboBox(quota);
		Quotas.setBounds(200,460,170,25); //560 80inc 170 25
		Quotas.setBackground(Color.WHITE);
		add(Quotas);
//		tfhsc = new JTextField();
//		tfhsc.setBounds(200,460,170,25); //150 80inc 150 25
//		add(tfhsc);
		
		JLabel lblParent = new JLabel("Father's name: ");
		lblParent.setBounds(50,500,170,100); //from left from top and size: length, width //50 80 inc 20 inc 100
		lblParent.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		add(lblParent);
		
		tfParent = new JTextField();
		tfParent.setBounds(200,540,170,25); //150 80inc 150 25
		add(tfParent);
		
		//right side
		
		JLabel lblCourse = new JLabel("Course: ");
		lblCourse.setBounds(450,100,90,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		lblCourse.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		add(lblCourse);
		
		String course[] = {"none","B.Tech","B.E","M.Tech","M.Sc"};
		courses = new JComboBox(course);
		courses.setBounds(600,140,170,25); //560 80inc 170 25
		courses.setBackground(Color.WHITE);
		add(courses);
		
		JLabel lblbranch = new JLabel("Branch: ");
		lblbranch.setBounds(450,180,110,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		lblbranch.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		add(lblbranch);
		
		tfbranch = new JTextField();
		tfbranch.setBounds(600,220,170,25); //560 80inc 170 25
		add(tfbranch);
		
		JLabel lbltutor = new JLabel("Tutor: ");
		lbltutor.setBounds(450,260,130,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		lbltutor.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		add(lbltutor);
		
		tftutor = new JTextField();
		tftutor.setBounds(600,300,170,25); //560 80inc 170 25
		add(tftutor);
		
		JLabel lblbday = new JLabel("Date of Birth: ");
		lblbday.setBounds(450,340,150,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		lblbday.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		add(lblbday);
		
		date = new JDateChooser();
		date.setBounds(600,380,170,25); //560 80inc 170 25
		add(date);
		
		JLabel gdate = new JLabel("Pass-out year: ");
		gdate.setBounds(450,420,150,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		gdate.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		add(gdate);
		
		tfgdate = new JTextField();
		tfgdate.setBounds(600,460,170,25); //560 80inc 170 25
		tfgdate.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		tfgdate.setToolTipText("Enter a valid year(4 digits)");
		add(tfgdate);
		
//		JLabel passingYear = new JLabel("Pass-out year: ");
//		passingYear.setBounds(450,420,150,100); //from left from top and size: length, width //450 80 inc 20 inc 100
//		passingYear.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
//		add(gdate);
//		
//		tfpassingYear = new JTextField();
//		tfpassingYear.setBounds(600,460,170,25); //560 80inc 170 25
//		add(tfpassingYear);
		
		JLabel residence = new JLabel("Residence: ");
		residence.setBounds(450,500,170,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		residence.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
		add(residence);
		
		String chooseResidence[] = {"none","Hosteller","Day-Scholar"};
		residency = new JComboBox(chooseResidence);
		residency.setBounds(600,540,170,25); //560 80inc 170 25
		residency.setBackground(Color.WHITE);
		add(residency);
		
		//Buttons
		
		submit = new JButton("Submit");
		submit.setBounds(200,600,120,30);
		submit.setBackground(Color.black);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		submit.addActionListener(this);
		add(submit);
		
		reset = new JButton("Reset");
		reset.setBounds(350,600,120,30);
		reset.setBackground(Color.black);
		reset.setForeground(Color.WHITE);
		reset.addActionListener(this);
		reset.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(reset);
		
		cancel = new JButton("Back");
		cancel.setBounds(500,600,120,30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		cancel.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(cancel);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new newStudentDetails();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name=null,Quota = null,dob = null,tutor = null,Roll = null,mail = null,grade12 = null,course = null,branch = null,grad_date = null,residencies = null,father = null;
		if(e.getSource() == submit) {
			//VALIDATION
			
			name = tfname.getText();
			String NamePattern = "^[a-zA-Zs]+$";
			Pattern pattern = Pattern.compile(NamePattern);
			Matcher match = pattern.matcher(name);
	
			if(name.equals("")) {
				JOptionPane.showMessageDialog(this, "Name field is Empty");
			}
			else if(!match.matches()) {
				JOptionPane.showMessageDialog(this,"Name should contain only characters");
			}
			else {
			
				Roll = tfRoll.getText();
				String RollPattern = "^[a-zA-Z\\d]+$";
				Pattern Rpattern = Pattern.compile(RollPattern);
				Matcher Rmatch = Rpattern.matcher(Roll);
				
				if(Roll.equals("")) {
					JOptionPane.showMessageDialog(this, "Roll No fiels is Empty");
				}
				else if(!Rmatch.matches()) {
					JOptionPane.showMessageDialog(this,"Roll No should be only Alphanumeric");
				}
				else {
				
				
					mail = tfmail.getText();
					String MailPattern = "^([a-z\\d.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?$";
					Pattern mpattern = Pattern.compile(MailPattern);
					Matcher m_match = mpattern.matcher(mail);
					if(mail.equals("")) {
						JOptionPane.showMessageDialog(this, "Email field is Empty");
					}
					else if(!m_match.matches()) {
						JOptionPane.showMessageDialog(this,"Enter valid email id");
					}
					else {
					
						grade12 = tftwelve.getText();
						String gradePattern = "^[\\d\\.%]{1,7}+$";
						Pattern gpattern = Pattern.compile(gradePattern);
						Matcher g_match = gpattern.matcher(grade12);
						if(grade12.equals("")) {
							JOptionPane.showMessageDialog(this,"Grade 12 field is Empty");
						}
						else if(!g_match.matches()) {
							JOptionPane.showMessageDialog(this,"Marks should be in Float value");
						}
						else {
						
							Quota = (String) Quotas.getSelectedItem();
							if(Quota.equals("")) {
								JOptionPane.showMessageDialog(this,"Quota field is Empty");
							}
							else {
							
								father = tfParent.getText();
								String parentPattern = "^[a-zA-z.s]+$";
								Pattern Ppattern = Pattern.compile(parentPattern);
								Matcher P_match = Ppattern.matcher(father);
								if(father.equals("")) {
									JOptionPane.showMessageDialog(this,"Father's name field is Empty");
								}
								else if(!P_match.matches()) {
									JOptionPane.showMessageDialog(this,"Enter a valid Parent name");
								}
								else {
								
									course = (String)(courses.getSelectedItem());
									//System.out.println(course);
									if(course.equals("none")) {
										JOptionPane.showMessageDialog(this,"course field is Empty");
									}
									else {
									
										branch = tfbranch.getText();
										if(branch.equals("")) {
											JOptionPane.showMessageDialog(this,"Branch field is Empty");
										}
										else {
										
											tutor = tftutor.getText();
											String tutPattern = "^[a-zA-z.s]+$";
											Pattern Tpattern = Pattern.compile(tutPattern);
											Matcher T_match = Tpattern.matcher(tutor);
											if(tutor.equals("")) {
												JOptionPane.showMessageDialog(this,"Tutor field is Empty");
											}
											else if(!T_match.matches()) {
												JOptionPane.showMessageDialog(this,"Enter a valid tutor name");
											}
											else {
												dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
												if(dob.equals("")) {
													JOptionPane.showMessageDialog(this,"Date Of Birth field is Empty");
												}
												else {
												
													grad_date = tfgdate.getText();
													String gradPattern = "^[0-9]{4}$";
													Pattern grpattern = Pattern.compile(gradPattern);
													Matcher gr_match = grpattern.matcher(grad_date);
													if(grad_date.equals("")) {
														JOptionPane.showMessageDialog(this,"Pass-out year field is Empty");
													}else if(!gr_match.matches()) {
														JOptionPane.showMessageDialog(this,"Enter a valid year");
													}
													else {
													
														residencies = (String) residency.getSelectedItem();	
														if(residencies.equals("none")) {
															JOptionPane.showMessageDialog(this,"Residence field is Empty");
														}
														else {
															try {
																Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root", ""); 
																Statement st = con.createStatement();
																int fee = ((String)Quotas.getSelectedItem() == "Management Quota"?160000:130000);
																String query = "insert into studentDetails values('"+name+"','"+Roll+"','"+mail+"','"+grade12+"','"+Quota+"','"+father+"','"+course+"','"+branch+"','"+tutor+"','"+dob+"','"+grad_date+"','"+residencies+"','"+fee+"')";
																st.executeUpdate(query);
																JOptionPane.showMessageDialog(null, "Successfully inserted");
																
																con.setAutoCommit(true);
																con.close();
															}
															catch( SQLIntegrityConstraintViolationException d) {
																JOptionPane.showMessageDialog(null, "Already inserted, "+d.getMessage());
															}
															catch(Exception ex) {
																System.out.print(ex);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
		}
			//sql commands should not run until validation  --> try in else block
			
		}
		else if(e.getSource() == reset) {
			tfname.setText(null);
			tfRoll.setText(null);
			tfmail.setText(null);
			tftwelve.setText(null);
			Quotas.setSelectedItem(null);
			tfParent.setText(null);
			courses.setSelectedItem(null);
			tfbranch.setText(null);
			tftutor.setText(null);
			//date.getDateEditor().setUiComponent(null));
			date.setCalendar(null);
			tfgdate.setText(null);
			//tfpassingYear.setText(null);
			residency.setSelectedItem(null);
		}
		else {
			new mainpage();
			setVisible(false);
		}
	}
	

}