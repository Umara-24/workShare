package SourceCode;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public class UserPageRemove extends JFrame implements ActionListener {

    private static final String FILENAME = "Data/User_Data.txt";
    private static final String[] COLUMN_NAMES = {"Username", "Password", "Mobile Number", "Email Address","Date", "Time"};
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 600;

    private JTable table;
	private JButton backButton,exitButton,removeButton;
    private Container contentPane;
	
	ImageIcon icon1 = new ImageIcon("Photos/Logo.jpg");

    public UserPageRemove() {
		
        super("Remove User");
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(icon1.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create label and set properties
         JLabel headerLabel = new JLabel("Remove User - workShare");
         headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
         headerLabel.setBackground(new Color(188,235,242));
         headerLabel.setHorizontalAlignment(JLabel.CENTER);
         headerLabel.setOpaque(true);
	 

        // Read data from file
        List<String[]> data = readDataFromFile();

        // Create table model
        DefaultTableModel model = new DefaultTableModel(new Object[0][COLUMN_NAMES.length], COLUMN_NAMES);

        // Add rows to table model
        for (String[] rowData : data) {
            model.addRow(rowData);
        }

        // Create table and add to scroll pane
        table = new JTable(model);
		table.setBackground(new Color(202, 111, 202));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 18)); // Increase font size of table contents
		table.setRowHeight(30);

        
		
		 // Set renderer for column names
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(204, 153, 102)); // set background color
        headerRenderer.setForeground(Color.black); // set foreground color
		headerRenderer.setFont(new Font("Times New Roman", Font.BOLD, 14));
        table.getTableHeader().setDefaultRenderer(headerRenderer);

        // Set renderer for table data
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(113,121,126)); // set background color 110, 117, 14
        cellRenderer.setForeground(new Color(0,0,0)); // set foreground color
        table.setDefaultRenderer(Object.class, cellRenderer);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(new Color(102, 51, 0));
        table.setFillsViewportHeight(true);


         // Add scroll pane to content pane
         Container contentPane = getContentPane();
		 contentPane.add(headerLabel, BorderLayout.NORTH);
         contentPane.add(scrollPane, BorderLayout.CENTER);
		
		 // Create Exit button
         exitButton = new JButton("Exit");
         exitButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
         exitButton.setBounds(850, 500, 100, 40);
         exitButton.addActionListener(this);
         exitButton.setBackground(new Color(175,47, 47));
         exitButton.setForeground(Color.WHITE);
		 exitButton.setFocusPainted(false);

		 exitButton.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent e) {
         setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           }
         public void mouseExited(MouseEvent e) {
         setCursor(Cursor.getDefaultCursor());
           }
           });
   

        // Create Back button
        backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        backButton.setBounds(20, 500, 100, 40);
        backButton.addActionListener(this);
		backButton.setBackground(new Color(17,68,135));
        backButton.setForeground(Color.WHITE);
		backButton.setFocusPainted(false);

		backButton.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent e) {
         setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           }
         public void mouseExited(MouseEvent e) {
         setCursor(Cursor.getDefaultCursor());
           }
           });
		   
        // Create Remove button
        removeButton = new JButton("Remove User");
        removeButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        removeButton.setBounds(400, 500, 70, 40);
        removeButton.addActionListener(this);
		removeButton.setBackground(new Color(204, 153, 51));
        removeButton.setForeground(Color.WHITE);
        removeButton.setFocusPainted(false);

        removeButton.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
         }
        public void mouseExited(MouseEvent e) {
       setCursor(Cursor.getDefaultCursor());
         }
         });
	   
	   removeButton.addActionListener(new ActionListener() {
    @Override
        public void actionPerformed(ActionEvent e) {
        int rowIndex = table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(UserPageRemove.this, "Please select a row to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
					
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.removeRow(rowIndex);

            // Remove row from data list
            data.remove(rowIndex);
			
			JOptionPane.showMessageDialog(UserPageRemove.this, "User Removed successfully!", "workShare",JOptionPane.INFORMATION_MESSAGE);

            // Write updated data to file
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
				
            for (String[] rowData : data) {
        writer.println("       USER LOGIN DATA    ");
		writer.print("\n");
        writer.println("Username      : " + rowData[0]);
        writer.println("Password      : " + rowData[1]);
        writer.println("Mobile Number : " + rowData[2]);
        writer.println("Email Address : " + rowData[3]);
        writer.println("Date & Time   : " + rowData[4] + " " + rowData[5]);
        writer.println("_____________________________________");
    }
     } catch (IOException ex) {
       ex.printStackTrace();
   }

        }
    }
});


   
  

        // Create panel to hold the buttons and add it to the content pane
       JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // Modify grid layout to add remove button
       buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       buttonPanel.add(backButton); 
       buttonPanel.add(removeButton); // Add remove button to panel
       buttonPanel.add(exitButton);
       contentPane.add(buttonPanel, BorderLayout.SOUTH);



        // Set frame size and make it visible
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
    }

    private List<String[]> readDataFromFile() {
    List<String[]> data = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
        String line;
        String[] rowData = new String[6];

        while ((line = br.readLine()) != null) {
            // Check if line contains one of the four fields we're interested in
            if (line.startsWith("Username")) {
                rowData[0] = line.split(":")[1].trim();
            } else if (line.startsWith("Password")) {
                rowData[1] = line.split(":")[1].trim();
            } else if (line.startsWith("Mobile Number")) {
                rowData[2] = line.split(":")[1].trim();
            } else if (line.startsWith("Email Address")) {
                rowData[3] = line.split(":")[1].trim();
            } else if (line.startsWith("Date & Time")) {
                String[] dateTimeParts = line.split(":", 2);
                String[] dateTime = dateTimeParts[1].trim().split(" ");
                rowData[4] = dateTime[0];
                rowData[5] = dateTime[1];
            }

            // Check if we have all five fields for this row
            if (rowData[0] != null && rowData[1] != null && rowData[2] != null && rowData[3] != null && rowData[4] != null && rowData[5] != null) {
                data.add(rowData);
                rowData = new String[6]; // Reset rowData for next row
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return data;
}




  public void actionPerformed(ActionEvent ae) {
	  
    if (ae.getSource() == exitButton) {
        System.exit(0);
    } else if (ae.getSource() == backButton) {
        this.setVisible(false);
        new DashboardAdmin();
    } 
    }
	} 