package SourceCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import Interfaces.*;


public class LoginUser extends JFrame implements ActionListener , UserLoginInterface {
	
	JLabel l1,l2,l3,l4;
	JPanel p1,p2;
	JButton Back,Login,Signup;
	JTextField screen1;
	JPasswordField screen2;
	JCheckBox showpassBox;
	Font font = new Font("Times New Roman", Font.PLAIN, 20);
	
	ImageIcon icon1 = new ImageIcon ("pics/lo.png");
	ImageIcon icon = new ImageIcon ("pics/user signin.png");
	
	
	public LoginUser ()
	{
		super("User Login");
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
		p2.setBounds(250, 55, 500, 450);
		p2.setBackground(new Color(0,0,0,90));
		p1.add(p2);
		p2.setLayout(null);
		l1 = new JLabel("Log In");
		l1.setBounds(200, 40, 200, 45);
		l1.setForeground(new Color(255,255,255));
		l1.setFont(new Font("Times New Roman" , Font.BOLD ,30));
		p2.add(l1);
		l2= new JLabel("Username : ");
		l2.setBounds(125,90,200,45);
		l2.setForeground(new Color(255,255,255));
		l2.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p2.add(l2);

		l3 = new JLabel("Password : ");
		l3.setBounds(125,185,200,45);
		l3.setForeground(new Color(255,255,255));
		l3.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p2.add(l3);

		l4 = new JLabel("Don't have an account?");
		l4.setBounds(360,515,300,45);
		l4.setForeground( Color.black);
		l4.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p1.add(l4);

		screen1 = new JTextField();
		screen1.setBounds(125,130,250,35);
		screen1.setFont(new Font("Times New Roman" , Font.PLAIN ,20));
		screen1.setBackground(new Color(255,255,255,250));
		p2.add(screen1);

		screen2 = new JPasswordField();
		screen2.setBounds(125,225,250,35);
		screen2.setFont(new Font("Times New Roman" , Font.PLAIN ,20));
		screen2.setBackground(new Color(255,255,255,250));
		p2.add(screen2);

		Signup = new JButton("Sign up");
		Signup.setBounds(590,525,80,25);
		Signup.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		Signup.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		Signup.addActionListener(this);
		Signup.setFocusPainted(false);
		Signup.setOpaque(false);
		Signup.setBorder(BorderFactory.createEmptyBorder());
		Signup.setForeground(Color.RED);
		Signup.setBackground(new Color(100,102,204));
		p1.add(Signup);

		Back = new JButton("Back");
		Back.setBounds(125,320,105,40);
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
		Back.setForeground(Color. WHITE);
		Back.setBackground(new Color(17, 68, 135));
		p2.add(Back);

		Login = new JButton("Login");
		Login.setBounds(265,320,105,40);
		Login.setFont(new Font("Times New Roman" , Font.BOLD ,18));
		Login.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		Login.setFocusPainted(false);
		Login.setForeground(Color.WHITE);
		Login.setBackground(new Color(10,128, 61));
		p2.add(Login);

		showpassBox = new JCheckBox("Show Password");
		showpassBox.setBounds(125,280,125,15);
		showpassBox.setForeground(new Color(255,255,255));
		showpassBox.setOpaque(false);
		showpassBox.setFocusPainted(false);
		showpassBox.addActionListener(this);
		p2.add(showpassBox);

		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String username = screen1.getText();
				char[] password = screen2.getPassword();
				boolean loggedIn = checkLoginData(username, password);
				if (loggedIn) {

					LoginUser.this.setVisible(false);
					new WelcomePage();
				}
				else {
					JOptionPane.showMessageDialog(p2, "Incorrect username or password.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		this.setVisible(true);
	}
	public boolean checkLoginData(String username, char[] password) {
		try {
			File file = new File("Data/User_Data.txt");
			FileReader reader = new FileReader(file);
			BufferedReader bufferReader = new BufferedReader(reader);

			String line;
			while ((line = bufferReader.readLine()) != null) {
				if (line.startsWith("Username")) {
					String[] data = line.split(":");
					if (data.length == 2 && data[1].trim().equals(username)) {
						line = bufferReader.readLine(); // read next line (password)
						data = line.split(":");
						if (data.length == 2 && data[1].trim().equals(new String(password))) {
							bufferReader.close();
							return true;
						}
					}
				}
			}

			bufferReader.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(p2, "Failed to read sign up data.", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return false;
	}




   public void actionPerformed(ActionEvent ae) {
	   
     if(ae.getSource()==showpassBox) {
          if(showpassBox.isSelected()) {
            screen2.setEchoChar((char)0);
        } else {
            screen2.setEchoChar('•');

        }
    } 
	
		
	else if(ae.getSource()==Back) {
       
        this.setVisible(false);
        new Page1();
		
      }
	  
	  else if(ae.getSource()==Signup) {
       
        this.setVisible(false);
        new SignupUser();
		
      }
    }
}