package SourceCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import Interfaces.*;
import java.util.Arrays;

public class LoginAdmin extends JFrame implements ActionListener , AdminLoginInterface {
 
    JLabel adminLabel,userLabel, passLabel,logoLabel;
    JTextField userText;
    JPasswordField passText;
    JButton loginBtn, backBtn;
	JPanel p1,p2;
	JCheckBox showpassBox;
	
	ImageIcon icon1 = new ImageIcon ("pics/lo.png");
    ImageIcon icon = new ImageIcon ("pics/AdminPic (1).png");

    public LoginAdmin()
	{

        super("Admin Login");
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
		
		JLabel background = new JLabel("", icon, JLabel.CENTER);
		background.setBounds(0,0,1000,600);
		this.add(background);

        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(255, 55, 450, 450);
        p2.setBackground(new Color(0,0,0,120));
        p2.setLayout(null);
        p1.add(p2);
		
		adminLabel=new JLabel("ADMIN LOGIN");
		adminLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        adminLabel.setBounds(125, 30, 300, 65);
        adminLabel.setForeground(Color.WHITE);
		p2.add(adminLabel);

        userLabel = new JLabel("Username :");
        userLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        userLabel.setBounds(100, 115, 150, 30);
		userLabel.setForeground(Color.WHITE);
        p2.add(userLabel);
		
		userText = new JTextField();
        userText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        userText.setBounds(100, 150, 250, 35);
        p2.add(userText);

        passLabel = new JLabel("Password :");
        passLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        passLabel.setBounds(100, 200, 150, 30);
		passLabel.setForeground(Color.WHITE);
        p2.add(passLabel);
		
		passText = new JPasswordField();
        passText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passText.setBounds(100, 240, 250, 35);
        p2.add(passText);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
        backBtn.setBounds(100, 350, 90, 40);
        backBtn.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent e) {
         setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           }
         public void mouseExited(MouseEvent e) {
         setCursor(Cursor.getDefaultCursor());
           }
           });
		backBtn.addActionListener(this);
		backBtn.setFocusPainted(false);
		backBtn.setForeground(Color.white);
        backBtn.setBackground(new Color(17, 68, 135));
        p2.add(backBtn);

        loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
        loginBtn.setBounds(255, 350, 90, 40);
		loginBtn.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent e) {
         setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           }
         public void mouseExited(MouseEvent e) {
         setCursor(Cursor.getDefaultCursor());
           }
           });
		loginBtn.setFocusPainted(false);
		loginBtn.setForeground(Color.WHITE);
        loginBtn.setBackground(new Color(10,128, 61));
        p2.add(loginBtn);
		
			loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String username = userText.getText();
                char[] password = passText.getPassword();
                boolean loggedIn = checkLoginData(username, password);

                if (username.isEmpty() || password.length == 0 ) {
               JOptionPane.showMessageDialog(p2, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

                 if (loggedIn) {



					        LoginAdmin.this.setVisible(false);
                         	new DashboardAdmin();
							
							}
							
                 else {
                    JOptionPane.showMessageDialog(p1, "Incorrect username or password.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

       	showpassBox = new JCheckBox("Show Password");
        showpassBox.setBounds(100, 300, 125, 15);
        showpassBox.setForeground(new Color(255,255,255));
		showpassBox.setOpaque(false);
		showpassBox.addActionListener(this);
		p2.add(showpassBox);

        this.setVisible(true);
		
	}

    public boolean checkLoginData(String username, char[] password) {
        try (BufferedReader bufferReader = new BufferedReader(new FileReader("Data/Admin_Data.txt"))) {
            String line;
            String storedUsername = null;
            String storedPassword = null;

            while ((line = bufferReader.readLine()) != null) {
                // Skip lines that do not contain alphanumeric characters
                if (!line.matches("\\s*\\w+\\s*:\\s*\\w+\\s*")) {
                    System.out.println("Invalid data format: " + line);
                    continue;
                }

                System.out.println("Processing line: " + line);

                String[] data = line.split(":");
                String label = data[0].trim();
                String value = data[1].trim();

                if ("Username".equals(label)) {
                    storedUsername = value;
                } else if ("Password".equals(label)) {
                    storedPassword = value;
                }

                // Check if both username and password are found
                if (storedUsername != null && storedPassword != null) {
                    System.out.println("Stored username: " + storedUsername);
                    System.out.println("Stored password: " + storedPassword);

                    // Compare the entered username and password with stored values
                    if (username.equals(storedUsername) && Arrays.equals(password, storedPassword.toCharArray())) {
                        return true; // Login successful
                    }

                    // Reset for the next iteration
                    storedUsername = null;
                    storedPassword = null;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(p1, "Failed to read sign-up data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return false; // Login failed
    }




    public void actionPerformed(ActionEvent ae) {
	 
	   if(ae.getSource()==backBtn)
		{
			
			this.setVisible(false);
			SwingUtilities.invokeLater(() ->new Page1());
			
		}
		
		else if(ae.getSource()==showpassBox) {
          if(showpassBox.isSelected()) {
            passText.setEchoChar((char)0);
        } else {
            passText.setEchoChar('•');

        }
    } 


}


	
	}


    