
 package jdbc;

//public class newFacultyDetails {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
 
//user abstract --> student,customer,admin ,aggregation(independent),composition(parent will depend on child),game java,oops,leetcode optimization,projects,dp,backtrack,java(camelcase notation),class name-caps,no hard code,sql,java,joins,string override,uml,git,edge case

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

//calender
import com.toedter.calendar.JDateChooser;

import jdbc.newStudentDetails;

public class newFacultyDetails extends JFrame implements ActionListener {
	
	//global variables
	JTextField tfname,tfid,tfmailP,tfmailO,tfQuali,tfdesignation,tfrelation,tfdob,tftutor,tfph_no;
	JDateChooser date,tfjoin_date;
	JComboBox dept;
	JButton submit,cancel,reset;
	
	newFacultyDetails(){
		
		setLayout(null);
		setSize(900,700);
		setLocation(350,50);
		getContentPane().setBackground(Color.lightGray);
		
		JLabel heading = new JLabel("Faculty Entry Portal");
		heading.setBounds(280,30,500,50);
		heading.setFont(new Font("Bahnschrift Condensed",Font.BOLD,40));
		add(heading);
		
		JLabel lblname = new JLabel("Name: ");
		lblname.setBounds(50,100,70,100); //from left from top and size: length, width
		lblname.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(210,140,170,25);
		tfname.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,15));
		add(tfname);
		
		JLabel lblid = new JLabel("Faculty Id: ");
		lblid.setBounds(50,180,90,100); //from left from top and size: length, width
		lblid.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lblid);
		
		tfid = new JTextField();
		tfid.setBounds(210,220,170,25);
		tfid.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,15));
		add(tfid);
		
		JLabel lblEmailP = new JLabel("Personal E-mail: ");
		lblEmailP.setBounds(50,260,140,100); //from left from top and size: length, width
		lblEmailP.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lblEmailP);
		
		tfmailP = new JTextField();
		tfmailP.setBounds(210,300,170,25);
		tfmailP.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,15));
		add(tfmailP);
		
		JLabel lblmailO = new JLabel("College E-Mail: ");
		lblmailO.setBounds(50,340,130,100); //from left from top and size: length, width //50 80 inc 20 inc 100
		lblmailO.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lblmailO);
		
		tfmailO = new JTextField();
		tfmailO.setBounds(210,380,170,25); //150 80inc 150 25
		add(tfmailO);
		
//		JLabel lblquota = new JLabel("Quota: ");
//		lblquota.setBounds(50,420,150,100); //from left from top and size: length, width //50 80 inc 20 inc 100
//		lblquota.setFont(new Font("Bahnschrift Condensed",Font.BOLD,20));
//		add(lblquota);
		
		JLabel quali = new JLabel("Qualification: ");
		quali.setBounds(50,460,150,25); //560 80inc 170 25
		quali.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(quali);
		
		tfQuali = new JTextField();
		tfQuali.setBounds(210,460,170,25); //150 80inc 150 25
		add(tfQuali);
		
		JLabel lbldesignation = new JLabel("Designation: ");
		lbldesignation.setBounds(50,500,170,100); //from left from top and size: length, width //50 80 inc 20 inc 100
		lbldesignation.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lbldesignation);
		
		tfdesignation = new JTextField();
		tfdesignation.setBounds(210,540,170,25); //150 80inc 150 25
		add(tfdesignation);
		
		//right side
		
		JLabel lblrelation = new JLabel("Relation: ");
		lblrelation.setBounds(460,100,90,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		lblrelation.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lblrelation);
		
		tfrelation = new JTextField();
		tfrelation.setBounds(610,140,170,25); //560 80inc 170 25
		tfrelation.setBackground(Color.WHITE);
		add(tfrelation);
		
		JLabel lblbday = new JLabel("Date of Birth: ");
		lblbday.setBounds(460,180,110,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		lblbday.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lblbday);
		
		date = new JDateChooser();
		date.setBounds(610,220,170,25); //560 80inc 170 25
		add(date);
		
		JLabel lbltutor = new JLabel("Tutor: ");
		lbltutor.setBounds(460,260,130,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		lbltutor.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lbltutor);
		
		tftutor = new JTextField();
		tftutor.setBounds(610,300,170,25); //560 80inc 170 25
		add(tftutor);
		
		JLabel lblphNo = new JLabel("Phone no: ");
		lblphNo.setBounds(460,340,150,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		lblphNo.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lblphNo);
		
		tfph_no = new JTextField();
		tfph_no.setBounds(610,380,170,25); //560 80inc 170 25
		add(tfph_no);
		
		JLabel joinDate = new JLabel("Date of Joining: ");
		joinDate.setBounds(460,420,150,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		joinDate.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(joinDate);
		
		tfjoin_date = new JDateChooser();
		tfjoin_date.setBounds(610,460,170,25); //560 80inc 170 25
		add(tfjoin_date);
		
		
		JLabel deptm = new JLabel("Department: ");
		deptm.setBounds(460,500,170,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		deptm.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(deptm);
		
		String chooseDept[] = {"none","IT","ECE","CSE","EEE","MECH","MCT"};
		dept = new JComboBox(chooseDept);
		dept.setBounds(610,540,170,25); //560 80inc 170 25
		dept.setBackground(Color.WHITE);
		add(dept);
		
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
		new newFacultyDetails();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//tfname,tfid,tfmailP,tfmailO,tfQuali,tfdesignation,tfrelation,tfdob,tftutor,tfph_no,tfjoin_date;
		String name,E_id = null,mail_P = null,mail_O = null,qualification = null,desi = null,relate = null,dob = null,tutor = null,ph_no = null, join_date = null,deptm=null;
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
				
				//E_id
				E_id = tfid.getText();
				String eIDPattern = "^[a-zA-Z\\d]+$";
				Pattern idpattern = Pattern.compile(eIDPattern);
				Matcher idmatch = idpattern.matcher(E_id);
				
				if(E_id.equals("")) {
					JOptionPane.showMessageDialog(this, "Personal mail field is Empty");
				}
				else if(!idmatch.matches()) {
					JOptionPane.showMessageDialog(this,"Enter valid email id");
				}
				else {
				
					//mailP
					mail_P = tfmailP.getText();
					String MailPattern = "^([a-z\\d.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?$";
					Pattern mpattern = Pattern.compile(MailPattern);
					Matcher m_match = mpattern.matcher(mail_P);
					if(mail_P.equals("")) {
						JOptionPane.showMessageDialog(this, "Email field is Empty");
					}
					else if(!m_match.matches()) {
						JOptionPane.showMessageDialog(this,"Enter valid email id");
					}
					else {
						//mailO
						mail_O = tfmailO.getText();
						String MailoPattern = "^([a-z\\d.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?$";
						Pattern mopattern = Pattern.compile(MailoPattern);
						Matcher mo_match = mopattern.matcher(mail_O);
						if(mail_O.equals("")) {
							JOptionPane.showMessageDialog(this, "Email field is Empty");
						}
						else if(!mo_match.matches()) {
							JOptionPane.showMessageDialog(this,"Enter valid email id");
						}
					
						
						else {
						
							//qualification
							qualification = tfQuali.getText();
							String qPattern = "^[a-zA-z.s']+$";
							Pattern qpattern = Pattern.compile(qPattern);
							Matcher q_match = qpattern.matcher(qualification);
							if(qualification.equals("")) {
								JOptionPane.showMessageDialog(this,"Qualification is empty");
							}
							else if(!q_match.matches()) {
								JOptionPane.showMessageDialog(this, "Enter valid qualification(in full form)");
							}
							else {
							
								desi = tfdesignation.getText();
								String dPattern = "^[a-zA-z.s]+$";
								Pattern Dpattern = Pattern.compile(dPattern);
								Matcher D_match = Dpattern.matcher(desi);
								
								if(desi.equals("")) {
									JOptionPane.showMessageDialog(this,"Designation field is Empty");
								}
								else if(!D_match.matches()) {
									JOptionPane.showMessageDialog(this,"Enter a valid Designation name");
								}
								else {
									
									//relation
									relate = tfrelation.getText();
									String relatePattern = "^[a-zA-z.s]+$";
									Pattern Rpattern = Pattern.compile(relatePattern);
									Matcher R_match = Rpattern.matcher(relate);
									
									if(relate.equals("none")) {
										JOptionPane.showMessageDialog(this,"Relation field is Empty");
									}
									else if(!R_match.matches()) {
										JOptionPane.showMessageDialog(this,"Enter a valid relation name");
									}
									
									else {
										//dob
										dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
										if(dob.equals("")) {
											JOptionPane.showMessageDialog(this,"Date Of Birth field is Empty");
										}
										else {
											//tutor
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
												//ph no
												ph_no = tfph_no.getText();
												String phPattern = "^[\\d]{10}$";
												Pattern PHpattern = Pattern.compile(phPattern);
												Matcher PH_match = PHpattern.matcher(ph_no);
												
												if(ph_no.equals("")) {
													JOptionPane.showMessageDialog(this,"Phone number field is Empty");
												}
												else if(!PH_match.matches()) {
													JOptionPane.showMessageDialog(this,"Enter a valid Phone no");
												}
												else {
												
													join_date = ((JTextField) tfjoin_date.getDateEditor().getUiComponent()).getText();
													if(join_date.equals("")) {
														JOptionPane.showMessageDialog(this,"Join date field is Empty");
													}
													else {
															deptm = (String) dept.getSelectedItem();
															if(deptm.equals("none")) {
																JOptionPane.showMessageDialog(this,"Department field is Empty");
															}
															else {
																try {
																	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root", ""); 
																	Statement st = con.createStatement();
																	String query = "insert into facultyDetails values('"+name+"','"+E_id+"','"+mail_P+"','"+mail_O+"','"+qualification+"','"+desi+"','"+relate+"','"+dob+"','"+tutor+"','"+ph_no+"','"+join_date+"','"+deptm+"')";
																	st.executeUpdate(query);
																	JOptionPane.showMessageDialog(null, "Successfully inserted");
																	setVisible(false);
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
		//tfname,tfid,tfmailP,tfmailO,tfQuali,tfdesignation,tfrelation,tfdob,tftutor,tfph_no,tfjoin_date;
		else if(e.getSource() == reset) {
			tfname.setText(null);
			tfid.setText(null);
			tfmailP.setText(null);
			tfmailO.setText(null);
			tfQuali.setText(null);
			tfdesignation.setText(null);
			tfrelation.setText(null);
			//tfdob.setText(null);
			date.setCalendar(null);
			tftutor.setText(null);
			tfph_no.setText(null);
			tfjoin_date.setCalendar(null);
			//tfpassingYear.setText(null);
			dept.setSelectedItem(null);
		}
		else {
			new mainpage();
			setVisible(false);
		}
	}
	

}