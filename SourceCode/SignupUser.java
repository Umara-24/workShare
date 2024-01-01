package SourceCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
import Interfaces.*;


public class SignupUser extends JFrame implements ActionListener , UserSignupInterface {
	

	JLabel l1,l2,l3,l4,l5;
	JPanel p1,p2;
	JButton Back,SignUp;
	JTextField screen1;
	JPasswordField screen2;
	JTextField mobileField,emailField;
	JCheckBox showpassBox;
	Font font = new Font("Times New Roman", Font.PLAIN, 20); //cambria
	
	ImageIcon icon1 = new ImageIcon ("pics/lo.png");
	ImageIcon icon = new ImageIcon ("pics/user signin.png");
	


	
	
	public SignupUser ()
	{
		
		super("User Sign-Up");
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
		
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(260,7,550,550);
		p2.setBackground(new Color(0,0,0,140));
		p1.add(p2);
		p2.setLayout(null);
		
		l1 = new JLabel("Sign Up");
		l1.setBounds(205,40,200,45);
		l1.setForeground(new Color(255,255,255));
		l1.setFont(new Font("Times New Roman" , Font.BOLD ,30));
		p2.add(l1);
		
		l2= new JLabel("Username : ");
		l2.setBounds(140,100,200,45);
		l2.setForeground(new Color(255,255,255));
		l2.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p2.add(l2);
		
		
		l3 = new JLabel("Password : ");
		l3.setBounds(140,190,200,45);
		l3.setForeground(new Color(255,255,255));
		l3.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p2.add(l3);
		
	    l4 = new JLabel("Mobile Number :");
		l4.setBounds(140,300,200,45);
		l4.setForeground(new Color(255,255,255));
		l4.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p2.add(l4);
		
        l5 = new JLabel("Email Address :");
		l5.setBounds(140,390,200,45);
		l5.setForeground(new Color(255,255,255));
		l5.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p2.add(l5);


		
		screen1 = new JTextField();
		screen1.setBounds(140,140,250,35);
		screen1.setFont(new Font("Times New Roman" , Font.PLAIN ,20));
		screen1.setBackground(new Color(255,255,255,250));
		p2.add(screen1);
		
		screen2 = new JPasswordField();
		screen2.setBounds(140,230,250,35);
		screen2.setFont(new Font("Times New Roman" , Font.PLAIN ,20));
		screen2.setBackground(new Color(255,255,255,250));
		p2.add(screen2);
		
		mobileField = new JTextField("+880");
		mobileField.setBounds(140,340,250,35);
		mobileField.setFont(new Font("Times New Roman" , Font.PLAIN ,20));
		mobileField.setBackground(new Color(255,255,255,250));
		p2.add(mobileField);
		
		emailField = new JTextField();
		emailField.setBounds(140,430,250,35);
		emailField.setFont(new Font("Times New Roman" , Font.PLAIN ,20));
		emailField.setBackground(new Color(255,255,255,250));
		p2.add(emailField);
		
		Back = new JButton("Back");
		Back.setBounds(140,500,100,35);
		Back.setFont(font);
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
		p2.add(Back);
		
		SignUp = new JButton("Sign Up");
		SignUp.setBounds(287,500,100,35);
		SignUp.setFont(font);
		SignUp.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent e) {
         setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           }
         public void mouseExited(MouseEvent e) {
         setCursor(Cursor.getDefaultCursor());
           }
           });
		SignUp.addActionListener(this);
		SignUp.setFocusPainted(false);
		SignUp.setForeground(Color.black);
        SignUp.setBackground(new Color(18,165, 53));
		p2.add(SignUp);
		
		


        showpassBox = new JCheckBox("Show Password");
		showpassBox.setBounds(140,278,125,15);
		showpassBox.setForeground(new Color(255,255,255));
		showpassBox.setOpaque(false);
		showpassBox.setFocusPainted(false);
		showpassBox.addActionListener(this);
		p2.add(showpassBox);
		
		
	    this.setVisible(true);
	}


         public void saveSignupData(String username, char[] password, String mobileNumber, String email,String formattedDateTime) {
			 
    try {
        File file = new File("Data/User_Data.txt");
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);

        bufferWriter.write("\n"+"       USER LOGIN DATA      "+"\n"+"\nUsername      : " + username + "\nPassword      : " + new String(password) + "\nMobile Number : " + mobileNumber + "\nEmail Address : " + email + "\nDate & Time   : "+ formattedDateTime+"\n_____________________________________");
        bufferWriter.newLine();
        bufferWriter.close();
        JOptionPane.showMessageDialog(p2, "Sign up successful!", "Succeed", JOptionPane.INFORMATION_MESSAGE);
		
	    SignupUser.this.setVisible(false);
        new LoginUser();
		
    } catch (IOException e){
        JOptionPane.showMessageDialog(p2, "Failed to save sign up data.", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

    



  @Override

public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == Back) {
        this.setVisible(false);
        new LoginUser();
    } else if (ae.getSource() == showpassBox) {
        if (showpassBox.isSelected()) {
            screen2.setEchoChar((char) 0);
        } else {
            screen2.setEchoChar('•');
        }
    }
	else if (ae.getSource() == SignUp) {
        String username = screen1.getText();
        char[] password = screen2.getPassword();
        String mobileNumber = mobileField.getText();
        String email = emailField.getText();

        if (username.isEmpty() || password.length == 0 || mobileNumber.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(p2, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

       saveSignupData(username, password, mobileNumber, email, formattedDateTime);
    }
}


}