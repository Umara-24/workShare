package SourceCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import Interfaces.*;


public class NewUserAdding extends JFrame implements ActionListener , AddUserInterface {

	Color color = new Color(195,195,195);
	JLabel l1,l2,l3,l4;
	JPanel p1;
	JButton Back,AddUser;
	JTextField screen1;
	JPasswordField screen2;
	JTextField mobileField,emailField;
	JCheckBox showpassBox;
	Font font = new Font("Times New Roman", Font.PLAIN, 20);

	ImageIcon icon1 = new ImageIcon ("pics/lo.png");
	ImageIcon icon = new ImageIcon ("pics/ADDNEWUSER.png");





	public NewUserAdding ()
	{

		super("Add User");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(icon1.getImage());

		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0,0,1000,600);
		p1.setOpaque(false);
		this.add(p1);
		this.setLayout(null);

		JLabel background = new JLabel(icon);
		background.setBounds(0,0,1000,600);
		this.add(background);



		l1= new JLabel("Username : ");
		l1.setBounds(630,100,200,45);
		l1.setForeground(new Color(0,0,0));
		l1.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p1.add(l1);


		l2 = new JLabel("Password : ");
		l2.setBounds(630,340,200,45);
		l2.setForeground(new Color(0,0,0));
		l2.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p1.add(l2);

		l3 = new JLabel("Mobile Number :");
		l3.setBounds(630,180,200,45);
		l3.setForeground(new Color(0,0,0));
		l3.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p1.add(l3);

		l4 = new JLabel("Email Address :");
		l4.setBounds(630,260,200,45);
		l4.setForeground(new Color(0,0,0));
		l4.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p1.add(l4);



		screen1 = new JTextField();
		screen1.setBounds(630,140,250,35);
		screen1.setFont(font);
		screen1.setBackground(new Color(255,255,255,250));
		p1.add(screen1);

		screen2 = new JPasswordField();
		screen2.setBounds(630,380,250,35);
		screen2.setFont(font);
		screen2.setBackground(new Color(255,255,255,250));
		p1.add(screen2);

		mobileField = new JTextField("+880");
		mobileField.setBounds(630,220,250,35);
		mobileField.setFont(font);
		mobileField.setBackground(new Color(255,255,255,250));
		p1.add(mobileField);

		emailField = new JTextField();
		emailField.setBounds(630,300,250,35);
		emailField.setFont(font);
		emailField.setBackground(new Color(255,255,255,250));
		p1.add(emailField);




		Back = new JButton("Back");
		Back.setBounds(560,500,100,40);
		Back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Back.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		Back.addActionListener(this);
		Back.setFocusPainted(false);
		Back.setForeground(Color.white);
		Back.setBackground(new Color(17, 68, 135));
		p1.add(Back);

		AddUser = new JButton("Add");
		AddUser.setBounds(850,500,100,40);
		AddUser.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		AddUser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		AddUser.addActionListener(this);
		AddUser.setFocusPainted(false);
		AddUser.setForeground(Color.black);
		AddUser.setBackground(Color.green);
		p1.add(AddUser);


		AddUser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				String username = screen1.getText();
				char[] password = screen2.getPassword();
				String mobileNumber = mobileField.getText();
				String email = emailField.getText();

				if (username.isEmpty() || password.length == 0 || mobileNumber.isEmpty() || email.isEmpty()) {
					JOptionPane.showMessageDialog(p1, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				LocalDateTime currentDateTime = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				String formattedDateTime = currentDateTime.format(formatter);

				saveSignUpData(username, password, mobileNumber, email, formattedDateTime);
			}
		});

		showpassBox = new JCheckBox("Show Password");
		showpassBox.setBounds(630,420,125,15);
		showpassBox.setForeground(new Color(0,0,0));
		showpassBox.setOpaque(false);
		showpassBox.setFocusPainted(false);
		showpassBox.addActionListener(this);
		p1.add(showpassBox);



		this.setVisible(true);
	}


	public void saveSignUpData(String username, char[] password, String mobileNumber, String email,String formattedDateTime) {

		try {
			File file = new File("Data/User_Data.txt");
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter bufferWriter = new BufferedWriter(writer);

			bufferWriter.write("\n"+"       USER LOGIN DATA      "+"\n"+"\nUsername      : " + username + "\nPassword      : " + new String(password) + "\nMobile Number : " + mobileNumber + "\nEmail Address : " + email + "\nDate & Time   : "+ formattedDateTime+"\n_____________________________________");
			bufferWriter.newLine();
			bufferWriter.close();
			JOptionPane.showMessageDialog(p1, "This User has been Added!", "workShare", JOptionPane.INFORMATION_MESSAGE);

			NewUserAdding.this.setVisible(false);
			new DashboardAdmin();

		} catch (IOException e){
			JOptionPane.showMessageDialog(p1, "Failed to save sign up data.", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}





	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource()==Back)
		{

			this.setVisible(false);
			new DashboardAdmin();
		}

		else if(ae.getSource()==showpassBox) {

			if(showpassBox.isSelected()) {
				screen2.setEchoChar((char)0);
			} else {
				screen2.setEchoChar('•');

			}
		}

	}

}