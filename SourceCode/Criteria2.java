package SourceCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Criteria2 extends JFrame implements ActionListener {

	JPanel p1;
	JButton Back,Exit;
	JButton babySitting,houseCleaning,tutorButton,cashierButton,foodDelivery,retailSaler;
	Font font = new Font("Times New Roman", Font.PLAIN, 20);

	ImageIcon icon1 = new ImageIcon ("pics/lo.png");
	ImageIcon icon = new ImageIcon ("pics/Citeria1.png");


	public Criteria2()
	{
		super("Find Worker");
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
		Back.setBounds(70,510,120,40);
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
		Exit.setBounds(800,510,120,40);
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



		//course buttons starting from here

		babySitting = new JButton("BabySitting");
		babySitting.setBounds(441,442,118,30);
		babySitting.setForeground(Color.white);
		babySitting.setBackground(Color.black);
		babySitting.setFocusPainted(false);
		babySitting.setOpaque(false);
		babySitting.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		babySitting.addActionListener(this);
		p1.add(babySitting);

		tutorButton = new JButton("Tutor");
		tutorButton.setBounds(792,442,65,30);
		tutorButton.setForeground(Color.white);
		tutorButton.setBackground(Color.black);
		tutorButton.setFocusPainted(false);
		tutorButton.setOpaque(false);
		tutorButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		tutorButton.addActionListener(this);
		p1.add(tutorButton);

		houseCleaning = new JButton("Receptionist");
		houseCleaning.setBounds(124,205,117,30);
		houseCleaning.setForeground(Color.white);
		houseCleaning.setBackground(Color.black);
		houseCleaning.setFocusPainted(false);
		houseCleaning.setOpaque(false);
		houseCleaning.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		houseCleaning.addActionListener(this);
		p1.add( houseCleaning);

		foodDelivery = new JButton("Food Delivery");
		foodDelivery.setBounds(757,205,134,30);
		foodDelivery.setForeground(Color.white);
		foodDelivery.setBackground(Color.black);
		foodDelivery.setFocusPainted(false);
		foodDelivery.setOpaque(false);
		foodDelivery.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		foodDelivery.addActionListener(this);
		p1.add(foodDelivery);

		cashierButton = new JButton("House Cleaning");
		cashierButton.setBounds(436,205,144,30);
		cashierButton.setForeground(Color.white);
		cashierButton.setBackground(Color.black);
		cashierButton.setFocusPainted(false);
		cashierButton.setOpaque(false);
		cashierButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		cashierButton.addActionListener(this);
		p1.add(cashierButton);

		retailSaler = new JButton("Retail Sales Associate");
		retailSaler .setBounds(84,441,190,30);
		retailSaler .setForeground(Color.white);
		retailSaler .setBackground(Color.black);
		retailSaler .setFocusPainted(false);
		retailSaler .setOpaque(false);
		retailSaler .addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		retailSaler .addActionListener(this);
		p1.add(retailSaler );

		this.setVisible(true);
	}


	public void actionPerformed(ActionEvent ae) {


		if(ae.getSource()==Back)
		{

			this.setVisible(false);
			new WelcomePage();

		}
		else if(ae.getSource()==babySitting)
		{

			this.setVisible(false);
			new BabySitting2();

		}

		else if(ae.getSource()==tutorButton)
		{

			this.setVisible(false);
			new Tutor2();

		}
		else if(ae.getSource()==houseCleaning)
		{

			this.setVisible(false);
			new HouseCleaning2 ();

		}
		else if(ae.getSource()==foodDelivery)
		{

			this.setVisible(false);
			new FoodDelivery2();

		}
		else if(ae.getSource()==cashierButton)
		{

			this.setVisible(false);
			new Cashier2 ();

		}

		else if(ae.getSource()==retailSaler)
		{

			this.setVisible(false);
			new RetailSales2 ();

		}
		else if(ae.getSource()==Exit)
		{
			System.exit(0);
		}
	}


}