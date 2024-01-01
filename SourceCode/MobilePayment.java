package SourceCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MobilePayment extends JFrame implements ActionListener {

	JPanel p1;
	JButton  BackBtn, bkashBtn, rocketBtn, nagadBtn;
	JButton selectedButton;

	Font font = new Font("Times New Roman", Font.PLAIN, 20);

	ImageIcon icon1 = new ImageIcon("pics/lo.png");
	ImageIcon icon = new ImageIcon("pics/MobilePay.png");

	public MobilePayment() {
		super("Mobile Payment");
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

		bkashBtn = new JButton("");
		bkashBtn.setBounds(435, 145, 150, 70);
		bkashBtn.setContentAreaFilled(false);  // Make button transparent
		bkashBtn.setBorderPainted(false);// Remove border
		bkashBtn.addActionListener(this);
		p1.add(bkashBtn);

		nagadBtn = new JButton("");
		nagadBtn.setBounds(435, 250, 150, 70);
		nagadBtn.setContentAreaFilled(false);  // Make button transparent
		nagadBtn.setBorderPainted(false);      // Remove border
		nagadBtn.addActionListener(this);
		p1.add(nagadBtn);

		rocketBtn = new JButton("");
		rocketBtn.setBounds(435, 350, 150, 70);
		rocketBtn.setContentAreaFilled(false);  // Make button transparent
		rocketBtn.setBorderPainted(false);      // Remove border
		rocketBtn.addActionListener(this);
		p1.add(rocketBtn);

		BackBtn = new JButton("Cancel");
		BackBtn.setBounds(800, 500, 105, 30);
		BackBtn.setFont(font);
		BackBtn.setForeground(Color.white);
		BackBtn.setBackground(new Color(142, 69, 133));
		BackBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		BackBtn.addActionListener(this);
		BackBtn.setFocusPainted(false);
		p1.add(BackBtn);



		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == BackBtn) {
			this.setVisible(false);
			new PaymentMethod();
		} else if (ae.getSource() == bkashBtn || ae.getSource() == nagadBtn || ae.getSource() == rocketBtn) {
			// Handle button clicks as before
			selectedButton = (JButton) ae.getSource();
		}
			// Check if any button is selected
		if (selectedButton == null) {
				//JOptionPane.showMessageDialog(this, "Please select a payment option.", "WorkShare",
						//JOptionPane.WARNING_MESSAGE);
			} else {
				// Handle the selected button accordingly
				if (selectedButton == bkashBtn) {
					this.setVisible(false);
					new PaymentBkash();
				} else if (selectedButton == nagadBtn) {
					this.setVisible(false);
					new PaymentNagad();
				} else if (selectedButton == rocketBtn) {
					this.setVisible(false);
					new PaymentRocket();
				}
			}
		}
	}

