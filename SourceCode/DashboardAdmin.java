package SourceCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DashboardAdmin extends JFrame implements ActionListener {
	
	JPanel p1;
    JLabel l1,l2,l3,l4;
    JButton AddUser,AddDeveloper,RemoveUser,UserInfo, Back;
	
	ImageIcon icon1 = new ImageIcon ("pics/lo.png");
	ImageIcon icon = new ImageIcon ("pics/AdminPic (1).png");
	


	
	
	public DashboardAdmin()
	
	{
		super("Admin Dashboard");
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
		
	    ImageIcon AddUserIcon = new ImageIcon("pics/Add User.png");
    	ImageIcon RemoveUserIcon = new ImageIcon("pics/user remove.png");
     	ImageIcon AddDeveloperIcon = new ImageIcon("pics/admin.png");
	    ImageIcon UserInfoIcon = new ImageIcon("pics/User Info .png");
	
	
	    l1 = new JLabel("Add User");
		l1.setBounds(305, 220, 200, 45);
		l1.setForeground(new Color(42,5,104));
		l1.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p1.add(l1);
		
		l2= new JLabel("Remove User");
		l2.setBounds(655, 220, 200, 45);
		l2.setForeground(new Color(42,5,104));
		l2.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p1.add(l2);
		
		
		l3 = new JLabel("Add Admin");
		l3.setBounds(295, 450, 200, 45);
		l3.setForeground(new Color(42,5,104));
		l3.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p1.add(l3);
		
	    l4 = new JLabel("User Info");
		l4.setBounds(675, 450, 200, 45);
		l4.setForeground(new Color(42,5,104));
		l4.setFont(new Font("Times New Roman" , Font.BOLD ,20));
		p1.add(l4);
	
	
		
		AddUser = new JButton(AddUserIcon);
		AddUser.setBounds(250, 120, 200, 200);
		AddUser.setForeground(Color.white);
        AddUser.setBackground(Color.black);
		AddUser.setFocusPainted(false);
		AddUser.setOpaque(false);
		AddUser.setBorder(null);
		AddUser.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent e) {
         setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           }
         public void mouseExited(MouseEvent e) {
         setCursor(Cursor.getDefaultCursor());
           }
           });
		AddUser.addActionListener(this);
		p1.add(AddUser);
		
        RemoveUser = new JButton(RemoveUserIcon);
		RemoveUser.setBounds(620, 120, 200, 200);
		RemoveUser.setForeground(Color.white);
        RemoveUser.setBackground(Color.black);
		RemoveUser.setFocusPainted(false);
		RemoveUser.setOpaque(false);
		RemoveUser.setBorder(null);
		RemoveUser.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent e) {
         setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           }
         public void mouseExited(MouseEvent e) {
         setCursor(Cursor.getDefaultCursor());
           }
           });
		RemoveUser.addActionListener(this);
		p1.add(RemoveUser);

		AddDeveloper = new JButton(AddDeveloperIcon);
		AddDeveloper.setBounds(250, 350, 200, 200);
		AddDeveloper.setForeground(Color.white);
        AddDeveloper.setBackground(Color.black);
		AddDeveloper.setFocusPainted(false);
		AddDeveloper.setOpaque(false);
		AddDeveloper.setBorder(null);
		AddDeveloper.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent e) {
         setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           }
         public void mouseExited(MouseEvent e) {
         setCursor(Cursor.getDefaultCursor());
           }
           });
		AddDeveloper.addActionListener(this);
		p1.add(AddDeveloper);
		
		UserInfo = new JButton(UserInfoIcon);
		UserInfo.setBounds(620, 350, 200, 200);
		UserInfo.setForeground(Color.white);
        UserInfo.setBackground(Color.black);
		UserInfo.setFocusPainted(false);
		UserInfo.setOpaque(false);
		UserInfo.setBorder(null);
		UserInfo.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent e) {
         setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           }
         public void mouseExited(MouseEvent e) {
         setCursor(Cursor.getDefaultCursor());
           }
           });
		UserInfo.addActionListener(this);
		p1.add(UserInfo);

		Back = new JButton("Back");
		Back.setBounds(45, 500, 90, 35);
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
		Back.setForeground(Color.WHITE);
		Back.setBackground(new Color(17, 68, 135));
		p1.add(Back);
		
		
		
		 this.setVisible(true);
	}


	public void actionPerformed(ActionEvent ae) {
		try {
			if (ae.getSource() == UserInfo) {
				this.setVisible(false);
				new InfoPageUser();
			} else if (ae.getSource() == RemoveUser) {
				this.setVisible(false);
				new UserPageRemove();
			} else if (ae.getSource() == AddUser) {
				this.setVisible(false);
				new NewUserAdding();
			} else if (ae.getSource() == AddDeveloper) {
				this.setVisible(false);
				new DeveloperAdding();
			} else if (ae.getSource() == Back) {
				goBack();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Handle the exception appropriately (log, show an error message, etc.)
		}
	}

	private void goBack() {
		// Implement the logic to go back to the previous frame or close the current frame
		// Example: If you have a reference to the previous frame, make it visible again
		// Example: If you want to close the current frame, use dispose()
		new LoginAdmin().setVisible(true);
		this.dispose();
		// Alternatively, you can create and show the previous frame here
		// Example: new PreviousFrame().setVisible(true);
	}
}