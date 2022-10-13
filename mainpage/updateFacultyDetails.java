package jdbc;

//public class UpdateFacultyDetails {
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
import java.sql.ResultSet;
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

public class updateFacultyDetails extends JFrame implements ActionListener {
	
	//global variables
	JTextField tfname,tfid,tfmailP,tfmailO,tfQuali,tfdesignation,tfrelation,tfdob,tftutor,tfph_no,tfEnter;
	JDateChooser date,tfjoin_date;
	JComboBox dept;
	JButton submit,cancel,reset,Get_DATA;
	JLabel labelname,labelid,labelmailO,labeldate,labeljoin_date;
	
	updateFacultyDetails(){
		
		setLayout(null);
		setSize(900,700);
		setLocation(350,50);
		getContentPane().setBackground(Color.lightGray);
		
		JLabel lblEnter = new JLabel("Enter Faculty ID: ");
		lblEnter.setBounds(150,40,200,20);
		lblEnter.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,20));
		add(lblEnter);
		
		tfEnter = new JTextField();
		tfEnter.setBounds(300,40,150,20);
		tfEnter.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,20));
		add(tfEnter);
		
		Get_DATA = new JButton("GET DATA");
		Get_DATA.setBounds(530,35,120,30);
		Get_DATA.setBackground(Color.black);
		Get_DATA.setForeground(Color.WHITE);
		Get_DATA.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		Get_DATA.addActionListener(this);
		add(Get_DATA);
		
		JLabel lblname = new JLabel("Name: ");
		lblname.setBounds(50,100,70,100); //from left from top and size: length, width
		lblname.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lblname);
		
		labelname = new JLabel();
		labelname.setBounds(210,140,170,25);
		labelname.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,15));
		add(labelname);
		
		JLabel lblid = new JLabel("Faculty Id: ");
		lblid.setBounds(50,180,90,100); //from left from top and size: length, width
		lblid.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lblid);
		
		labelid = new JLabel();
		labelid.setBounds(210,220,170,25);
		labelid.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,15));
		add(labelid);
		
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
		
		labelmailO = new JLabel();
		labelmailO.setBounds(210,380,170,25); //150 80inc 150 25
		labelmailO.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,20));
		add(labelmailO);
		
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
		tfQuali.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,20));
		add(tfQuali);
		
		JLabel lbldesignation = new JLabel("Designation: ");
		lbldesignation.setBounds(50,500,170,100); //from left from top and size: length, width //50 80 inc 20 inc 100
		lbldesignation.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lbldesignation);
		
		tfdesignation = new JTextField();
		tfdesignation.setBounds(210,540,170,25); //150 80inc 150 25
		tfdesignation.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,20));
		add(tfdesignation);
		
		//right side
		
		JLabel lblrelation = new JLabel("Relation: ");
		lblrelation.setBounds(460,100,90,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		lblrelation.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lblrelation);
		
		tfrelation = new JTextField();
		tfrelation.setBounds(610,140,170,25); //560 80inc 170 25
		tfrelation.setBackground(Color.WHITE);
		tfrelation.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,20));
		add(tfrelation);
		
		JLabel lblbday = new JLabel("Date of Birth: ");
		lblbday.setBounds(460,180,110,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		lblbday.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lblbday);
		
		labeldate = new JLabel();
		labeldate.setBounds(610,220,170,25); //560 80inc 170 25
		labeldate.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,20));
		add(labeldate);
		
		JLabel lbltutor = new JLabel("Tutor: ");
		lbltutor.setBounds(460,260,130,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		lbltutor.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lbltutor);
		
		tftutor = new JTextField();
		tftutor.setBounds(610,300,170,25); //560 80inc 170 25
		tftutor.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,20));
		add(tftutor);
		
		JLabel lblphNo = new JLabel("Phone no: ");
		lblphNo.setBounds(460,340,150,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		lblphNo.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(lblphNo);
		
		tfph_no = new JTextField();
		tfph_no.setBounds(610,380,170,25); //560 80inc 170 25
		tfph_no.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,20));
		add(tfph_no);
		
		JLabel joinDate = new JLabel("Date of Joining: ");
		joinDate.setBounds(460,420,150,100); //from left from top and size: length, width //450 80 inc 20 inc 100
		joinDate.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		add(joinDate);
		
		labeljoin_date = new JLabel();
		labeljoin_date.setBounds(610,460,170,25); //560 80inc 170 25
		labeljoin_date.setFont(new Font("Bahnschrift Condensed",Font.PLAIN,20));
		add(labeljoin_date);
		
		
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
		
		submit = new JButton("Update");
		submit.setBounds(200,600,120,30);
		submit.setBackground(Color.black);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Bahnschrift Condensed",Font.BOLD,15));
		submit.addActionListener(this);
		add(submit);
		
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
		new updateFacultyDetails();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//tfname,tfid,tfmailP,tfmailO,tfQuali,tfdesignation,tfrelation,tfdob,tftutor,tfph_no,tfjoin_date;
		String name,E_id = null,mail_P = null,mail_O = null,qualification = null,desi = null,relate = null,dob = null,tutor = null,ph_no = null, join_date = null,deptm=null;
		if(e.getSource() == submit) {
			//VALIDATION
			
//			name = tfname.getText();
//			String NamePattern = "^[a-zA-Z\s]+$";
//			Pattern pattern = Pattern.compile(NamePattern);
//			Matcher match = pattern.matcher(name);
//	
//			if(name.equals("")) {
//				JOptionPane.showMessageDialog(this, "Name field is Empty");
//			}
//			else if(!match.matches()) {
//				JOptionPane.showMessageDialog(this,"Name should contain only characters");
//			}
//			else {
//				
//				//E_id
//				E_id = tfid.getText();
//				String eIDPattern = "^[a-zA-Z\\d]+$";
//				Pattern idpattern = Pattern.compile(eIDPattern);
//				Matcher idmatch = idpattern.matcher(E_id);
//				
//				if(E_id.equals("")) {
//					JOptionPane.showMessageDialog(this, "Personal mail field is Empty");
//				}
//				else if(!idmatch.matches()) {
//					JOptionPane.showMessageDialog(this,"Enter valid email id");
//				}
				
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
//					else {
//						//mailO
//						mail_O = tfmailO.getText();
//						String MailoPattern = "^([a-z\\d.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?$";
//						Pattern mopattern = Pattern.compile(MailoPattern);
//						Matcher mo_match = mopattern.matcher(mail_O);
//						if(mail_O.equals("")) {
//							JOptionPane.showMessageDialog(this, "Email field is Empty");
//						}
//						else if(!mo_match.matches()) {
//							JOptionPane.showMessageDialog(this,"Enter valid email id");
//						}
//					
						
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
									
//									else {
//										//dob
//										dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
//										if(dob.equals("")) {
//											JOptionPane.showMessageDialog(this,"Date Of Birth field is Empty");
//										}
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
//												else {
//												
//													join_date = ((JTextField) tfjoin_date.getDateEditor().getUiComponent()).getText();
//													if(join_date.equals("")) {
//														JOptionPane.showMessageDialog(this,"Join date field is Empty");
//													}
													else {
															deptm = (String) dept.getSelectedItem();
															if(deptm.equals("none")) {
																JOptionPane.showMessageDialog(this,"Department field is Empty");
															}
															else {
																try {
																	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root", ""); 
																	Statement st = con.createStatement();
																	String query = "update facultyDetails set PERSONAL_EMAIL = '"+mail_P+"',QUALIFICATION = '"+qualification+"',DESIGNATION = '"+desi+"',RELATION = '"+relate+"',TUTOR = '"+tutor+"',PHONE_NO = '"+ph_no+"',DEPARTMENT = '"+deptm+"' where FACULTY_ID = '"+(tfEnter.getText())+"'";
																	st.executeUpdate(query);
																	JOptionPane.showMessageDialog(null, "Successfully UPDATED");
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

			//sql commands should not run until validation  --> try in else block
			
		//tfname,tfid,tfmailP,tfmailO,tfQuali,tfdesignation,tfrelation,tfdob,tftutor,tfph_no,tfjoin_date;
		else if(e.getSource() == Get_DATA) {
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOTATHON", "root", ""); 
				Statement st = con.createStatement();
				//st.executeUpdate("create table Friends(name varchar(20),city varchar(20))");
				ResultSet rs = st.executeQuery("select * from facultyDetails where FACULTY_ID = '"+tfEnter.getText()+"'");
				if(!rs.isBeforeFirst()) JOptionPane.showMessageDialog(null, "Faculty ID doesn't exist");
				else {
					while(rs.next()) {
						labelname.setText(rs.getString("NAME"));
						labelid.setText(rs.getString("FACULTY_ID"));
						labelmailO.setText(rs.getString("COLLEGE_MAIL"));
						labeldate.setText(rs.getString("DATE_OF_BIRTH"));
						labeljoin_date.setText(rs.getString("JOIN_DATE"));
						//System.out.println(labelname);
					}
					con.setAutoCommit(true);
					con.close();
				}
			}
			catch(Exception ae1) {
				ae1.printStackTrace();
			}
			
	}
		else {
			new FACULTY();
		}
	

}
}