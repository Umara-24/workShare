package SourceCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import Interfaces.*;


public class DeveloperAdding extends JFrame implements ActionListener , AddDeveloperInterface {
	
	Color color = new Color(195,195,195);
	JLabel l1,l2;
	JPanel p1;
	JButton Back,AddUser;
	JTextField screen1;
	JPasswordField screen2;
	JCheckBox showpassBox;
	Font font = new Font("Times New Roman", Font.PLAIN, 20);
	ImageIcon icon1 = new ImageIcon ("pics/lo.png");
	ImageIcon icon = new ImageIcon ("pics/ADDNEWADMIN.png");
	


	
	
	public DeveloperAdding ()
	{
		
		super("Add Admin");
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
		l1.setBounds(630,150,200,45);
		l1.setForeground(new Color(0,0,0));
		l1.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p1.add(l1);
		
		
		l2 = new JLabel("Password : ");
		l2.setBounds(630,250,200,45);
		l2.setForeground(new Color(0,0,0));
		l2.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p1.add(l2);
		
	
	
		screen1 = new JTextField(); 
		screen1.setBounds(630,200,250,35);
		screen1.setFont(font);
		screen1.setBackground(new Color(255,255,255,250));
		p1.add(screen1);
		
		screen2 = new JPasswordField();
		screen2.setBounds(630,300,250,35);
		screen2.setFont(font);
		screen2.setBackground(new Color(255,255,255,250));
		p1.add(screen2);
		
		
		
		
		Back = new JButton("Back");
		Back.setBounds(560,460,100,40);
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
		AddUser.setBounds(850,460,100,40);
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

        if (username.isEmpty() || password.length == 0 ) {
            JOptionPane.showMessageDialog(p1, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        saveSignUpData(username, password); 
    }
    });

        showpassBox = new JCheckBox("Show Password");
		showpassBox.setBounds(630,350,125,15);
		showpassBox.setForeground(new Color(0,0,0));
		showpassBox.setOpaque(false);
		showpassBox.setFocusPainted(false);
		showpassBox.addActionListener(this);
		p1.add(showpassBox);


		
		
	    this.setVisible(true);
	}


         public void saveSignUpData(String username, char[] password) {
			 
    try {
        File file = new File("Data/Admin_Data.txt");
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);

        bufferWriter.write("\n"+"       ADMIN DATA      "+"\n"+"\nUsername      : " + username + "\nPassword      : " + new String(password)+ "\n________________________________");
        bufferWriter.newLine();
        bufferWriter.close();
        JOptionPane.showMessageDialog(p1, "New Developer Added!", "workShare", JOptionPane.INFORMATION_MESSAGE);
		
	    DeveloperAdding.this.setVisible(false);
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