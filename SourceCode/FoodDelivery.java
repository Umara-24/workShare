package SourceCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FoodDelivery extends JFrame implements ActionListener {

	JPanel p1;
	JButton Back,Exit,Confirm;
	Font font = new Font("Times New Roman", Font.PLAIN, 20);

	ImageIcon icon1 = new ImageIcon ("pics/lo.png");
	ImageIcon icon = new ImageIcon ("pics/FoodDelivery.png");


	public FoodDelivery()
	{
		super("Food Delivery");
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

		Back = new JButton("Back");
		Back.setBounds(35,500,100,35);
		Back.setFont(font);
		Back.setForeground(Color.white);
		Back.setBackground(new Color(17, 68, 135));
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
		p1.add(Back);

		Exit = new JButton("Exit");
		Exit.setBounds(850, 500, 100,35);
		Exit.setFont(font);
		Exit.setForeground(Color.white);
		Exit.setBackground(new Color(175,47, 47));
		Exit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		Exit.addActionListener(this);
		Exit.setFocusPainted(false);
		p1.add(Exit);

		Confirm = new JButton("Confirm");
		Confirm.setBounds(850,410,110,35);
		Confirm.setFont(font);
		Confirm.setForeground(Color.black);
		Confirm.setBackground(new Color(255,165,0));
		Confirm.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		Confirm.addActionListener(this);
		Confirm.setFocusPainted(false);
		p1.add(Confirm);


		this.setVisible(true);

	}


	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource()==Back)
		{

			this.setVisible(false);
			new Criteria1();

		}

		else if(ae.getSource()== Confirm)
		{
			JOptionPane.showMessageDialog(this, "Your job has been confirmed!");
			this.setVisible(false);
			new PageFinishing();

		}



		else if(ae.getSource()==Exit)
		{
			System.exit(0);
		}
	}


}