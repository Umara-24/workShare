package SourceCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PaymentMethod extends JFrame implements ActionListener {

	JPanel p1;
	JButton proceedBtn, CancelBtn;
	JRadioButton mobilePaymentButton;
	JRadioButton cardPaymentButton;

	Font font = new Font("Times New Roman", Font.PLAIN, 20);
	Font radioFont = new Font("Times New Roman", Font.PLAIN, 16);

	ImageIcon icon1 = new ImageIcon("pics/lo.png");
	ImageIcon icon = new ImageIcon("pics/Pay.png");


	public PaymentMethod() {
		super("Payment Options");
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


		mobilePaymentButton = new JRadioButton("Mobile Banking");
		mobilePaymentButton.setBounds(480, 290, 300, 200);
		mobilePaymentButton.setOpaque(false);
		mobilePaymentButton.setFocusPainted(false);
		mobilePaymentButton.setForeground(Color.white);
		mobilePaymentButton.setFont(radioFont);
		p1.add(mobilePaymentButton);

		cardPaymentButton = new JRadioButton("Card Payment");
		cardPaymentButton.setBounds(480, 122, 300, 200);
		cardPaymentButton.setOpaque(false);
		cardPaymentButton.setFocusPainted(false);
		cardPaymentButton.setForeground(Color.white);
		cardPaymentButton.setFont(radioFont);
		p1.add(cardPaymentButton);

		ButtonGroup paymentButtonGroup = new ButtonGroup();
		paymentButtonGroup.add(mobilePaymentButton);
		paymentButtonGroup.add(cardPaymentButton);

		CancelBtn = new JButton("Cancel");
		CancelBtn.setBounds(170, 520, 100, 30);
		CancelBtn.setFont(font);
		CancelBtn.setForeground(Color.white);
		CancelBtn.setBackground(new Color(142, 69, 133));
		CancelBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		CancelBtn.addActionListener(this);
		CancelBtn.setFocusPainted(false);
		p1.add(CancelBtn);

		proceedBtn = new JButton("Proceed");
		proceedBtn.setBounds(730, 520, 100, 30);
		proceedBtn.setFont(font);
		proceedBtn.setForeground(Color.black);
		proceedBtn.setBackground(new Color(135, 206, 235));
		proceedBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		proceedBtn.addActionListener(this);
		proceedBtn.setFocusPainted(false);
		p1.add(proceedBtn);


		this.setVisible(true);

	}


	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == CancelBtn) {
			this.setVisible(false);
			new Criteria2();
		} else if (ae.getSource() == proceedBtn) {
			String selectedOption = "";
			if (mobilePaymentButton.isSelected()) {
				selectedOption = "Mobile Banking";
			} else if (cardPaymentButton.isSelected()) {
				selectedOption = "Card Payment";
			}

			if (selectedOption.equals("Mobile Banking")) {
				this.setVisible(false);
				new MobilePayment();
			} else if (selectedOption.equals("Card Payment")) {
				this.setVisible(false);
				CardPayment cardPayment = new CardPayment();
				cardPayment.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Please select a payment option.", "Payment Method Not Selected", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}




