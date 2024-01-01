package SourceCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class WelcomePage extends JFrame implements ActionListener {

    JPanel p1;

    JButton aboutUsButton, findJobButton, contactUsButton, ourteam, findWorkerButton;

    JButton Back, Exit;

    JTextField screen1;

    JPasswordField screen2;

    Font font = new Font("Times New Roman", Font.PLAIN, 20);

    ImageIcon icon1 = new ImageIcon("pics/lo.png");

    ImageIcon icon = new ImageIcon("pics/Wel2.png");

    public WelcomePage() {

        super("Home Page");

        this.setSize(1000, 600);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        this.setIconImage(icon1.getImage());

        p1 = new JPanel();

        p1.setLayout(null);

        p1.setBounds(0, 0, 1000, 600);

        p1.setOpaque(false);

        this.add(p1);

        this.setLayout(null);





        JLabel background = new JLabel(icon);

        background.setBounds(0, 0, 1000, 600);

        this.add(background);

        aboutUsButton = new JButton("About Us");

        aboutUsButton.setBounds(800, 40, 170, 40);

        aboutUsButton.setFont(font);

        aboutUsButton.setBackground(new Color(114, 15, 64));

        aboutUsButton.setForeground(new Color(255,255,255));

        aboutUsButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        aboutUsButton.addActionListener(this);

        aboutUsButton.setFocusPainted(false);

        p1.add(aboutUsButton);



        contactUsButton = new JButton("Contact Us");

        contactUsButton.setBounds(610, 40, 170, 40);

        contactUsButton.setFont(font);

        contactUsButton.setBackground(new Color(9, 120, 132));

        contactUsButton.setForeground(new Color(255,255,255));

        contactUsButton.setFocusPainted(false);

        contactUsButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        contactUsButton.addActionListener(this);

        p1.add(contactUsButton);


        findJobButton = new JButton(" Find Job ");

        findJobButton.setBounds(40, 40, 170, 40);

        findJobButton.setFont(font);

        findJobButton.setBackground(new Color(149, 80, 33));

        findJobButton.setForeground(new Color(255,255,255));

        findJobButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        findJobButton.addActionListener(this);

        findJobButton.setFocusPainted(false);

        p1.add(findJobButton);


        findWorkerButton = new JButton(" Find Worker ");

        findWorkerButton.setBounds(230, 40, 170, 40);

        findWorkerButton.setFont(font);

        findWorkerButton.setBackground(new Color(85, 43, 90));

        findWorkerButton.setForeground(new Color(255,255,255));

        findWorkerButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        findWorkerButton.addActionListener(this);

        findWorkerButton.setFocusPainted(false);

        p1.add(findWorkerButton);


        ourteam = new JButton("Our Team");

        ourteam.setBounds(420, 40, 170, 40);

        ourteam.setFont(font);

        ourteam.setBackground(new Color(26, 92, 46));

        ourteam.setForeground(new Color(255,255,255));

        ourteam.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        ourteam.addActionListener(this);

        ourteam.setFocusPainted(false);

        p1.add(ourteam);

        Back = new JButton("Back");

        Back.setBounds(35, 520, 100, 35);

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

        p1.add(Back);

        Exit = new JButton("Exit");

        Exit.setBounds(850, 520, 100, 35);

        Exit.setFont(font);

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

        Exit.setForeground(Color.white);

        Exit.setBackground(new Color(175,47, 47));

        p1.add(Exit);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Back) {
            this.setVisible(false);
            new LoginUser();
        } else if (ae.getSource() == Exit) {
            System.exit(0);
        } else if (ae.getSource() == aboutUsButton) {
            this.setVisible(false);
            new AboutUs();
        } else if (ae.getSource() == ourteam) {
            this.setVisible(false);
            new OurTeam();
        } else if (ae.getSource() == contactUsButton) {
            this.setVisible(false);
            new ContactUs();
        } else if (ae.getSource() == findJobButton) {
            this.setVisible(false);
            new Criteria1();
        }

        else if (ae.getSource() == findWorkerButton) {
            this.setVisible(false);
            new Criteria2();
        }

    }

}
