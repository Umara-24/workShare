package SourceCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Criteria1 extends JFrame implements ActionListener {

    JPanel p1;
    JButton Back,Exit;
    JButton babySitting,houseCleaning,tutorButton,cashierButton,foodDelivery,retailSales;
    Font font = new Font("Times New Roman", Font.PLAIN, 20);

    ImageIcon icon1 = new ImageIcon ("pics/lo.png");
    ImageIcon icon = new ImageIcon ("pics/Citeria1.png");


    public Criteria1()
    {
        super("Available Jobs");
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
        Back.setBounds(35,515,100,35);
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
        Exit.setBounds(850,515,100,35);
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


        //job buttons are starting from here

        babySitting= new JButton("BabySitting");
        babySitting.setBounds(441,442,118,30);
        babySitting.setForeground(Color.white);
        babySitting.setBackground(Color.black);
        babySitting.setFocusPainted(false);
        babySitting.setOpaque(false);
        babySitting.setBorderPainted(false);
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

        tutorButton= new JButton("Tutor");
        tutorButton.setBounds(792,442,65,30);
        tutorButton.setForeground(Color.white);
        tutorButton.setBackground(Color.black);
        tutorButton.setFocusPainted(false);
        tutorButton.setOpaque(false);
        tutorButton.setBorderPainted(false);
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

        cashierButton = new JButton("Receptionist");
        cashierButton.setBounds(124,205,117,30);
        cashierButton.setForeground(Color.white);
        cashierButton.setBackground(Color.black);
        cashierButton.setFocusPainted(false);
        cashierButton.setOpaque(false);
        cashierButton.setBorderPainted(false);
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

        foodDelivery = new JButton("Food Delivery");
        foodDelivery.setBounds(757,205,134,30);
        foodDelivery.setForeground(Color.white);
        foodDelivery.setBackground(Color.black);
        foodDelivery.setFocusPainted(false);
        foodDelivery.setOpaque(false);
        foodDelivery.setBorderPainted(false);
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

        houseCleaning = new JButton("House Cleaning");
        houseCleaning.setBounds(436,205,144,30);
        houseCleaning.setForeground(Color.white);
        houseCleaning.setBackground(Color.black);
        houseCleaning.setFocusPainted(false);
        houseCleaning.setOpaque(false);
        houseCleaning.setBorderPainted(false);
        houseCleaning.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        houseCleaning.addActionListener(this);
        p1.add(houseCleaning);

        retailSales = new JButton("Retail Sales Associate");
        retailSales.setBounds(84,441,190,30);
        retailSales.setForeground(Color.white);
        retailSales.setBackground(Color.black);
        retailSales.setFocusPainted(false);
        retailSales.setOpaque(false);
        retailSales.setBorderPainted(false);
        retailSales.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        retailSales.addActionListener(this);
        p1.add(retailSales);

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
            new BabySitting();

        }
        else if(ae.getSource()==tutorButton)
        {

            this.setVisible(false);
            new Tutor ();

        }
        else if(ae.getSource()==foodDelivery)
        {

            this.setVisible(false);
            new FoodDelivery();

        }
        else if(ae.getSource()==houseCleaning)
        {

            this.setVisible(false);
            new HouseCleaning();

        }
        else if(ae.getSource()==retailSales){

            this.setVisible(false);
            new RetailSales();
        }

        else if(ae.getSource()==cashierButton) {
            this.setVisible(false);
            new Cashier();
        }

        else if(ae.getSource()==Exit)
        {
            System.exit(0);
        }
    }}
