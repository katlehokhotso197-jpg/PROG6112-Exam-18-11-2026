import javax.swing.*; 

import java.awt.*; 

import java.awt.event.*; 

import java.util.ArrayList; 

  

public class ProductApp extends JFrame { 

  

    // Fields from screenshot 

    private JTextField txtCustomer; 

    private JComboBox<String> cmbProduct; 

    private JTextField txtPrice; 

    private JButton btnProcess; 

    private JTextArea txtOutput; 

  

    // To store all sales - requirement says "store the details" 

    private ArrayList<String> allSales = new ArrayList<>(); 

  

    public ProductApp() { 

        setTitle("Product App"); 

        setSize(450, 450); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        setLayout(null); // simple layout like in screenshot, easy to match 

  

        // --- Menu Bar - File Edit --- 

        JMenuBar menuBar = new JMenuBar(); 

        JMenu fileMenu = new JMenu("File"); 

        JMenu editMenu = new JMenu("Edit"); 

  

        JMenuItem exitItem = new JMenuItem("Exit"); 

        JMenuItem clearItem = new JMenuItem("Clear"); 

  

        exitItem.addActionListener(e -> System.exit(0)); 

        clearItem.addActionListener(e -> clearForm()); 

  

        fileMenu.add(exitItem); 

        editMenu.add(clearItem); 

        menuBar.add(fileMenu); 

        menuBar.add(editMenu); 

        setJMenuBar(menuBar); 

  

        // --- Labels and Inputs --- 

        JLabel lblCustomer = new JLabel("Customer Name:"); 

        lblCustomer.setBounds(20, 20, 120, 30); 

        add(lblCustomer); 

  

        txtCustomer = new JTextField(); 

        txtCustomer.setBounds(150, 20, 250, 30); 

        add(txtCustomer); 

  

        JLabel lblProduct = new JLabel("Select Product:"); 

        lblProduct.setBounds(20, 70, 120, 30); 

        add(lblProduct); 

 // Products from Q1 - use same 3 

        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"}; 

        cmbProduct = new JComboBox<>(products); 

        cmbProduct.setBounds(150, 70, 250, 30); 

        add(cmbProduct); 

  

        JLabel lblPrice = new JLabel("Enter Price:"); 

        lblPrice.setBounds(20, 120, 120, 30); 

        add(lblPrice); 

  

        txtPrice = new JTextField(); 

        txtPrice.setBounds(150, 120, 250, 30); 

        add(txtPrice); 

  

        // --- PROCESS Button --- 

        btnProcess = new JButton("PROCESS"); 

        btnProcess.setBounds(150, 170, 250, 45); 

        btnProcess.setFont(new Font("Arial", Font.BOLD, 16)); 

        add(btnProcess); 

  

        // --- Output area --- 

        txtOutput = new JTextArea(); 

        txtOutput.setBounds(20, 230, 380, 130); 

        txtOutput.setEditable(false); 

        add(txtOutput); 

  

        // When PROCESS is clicked 

        btnProcess.addActionListener(new ActionListener() { 

            @Override 

            public void actionPerformed(ActionEvent e) { 

                processSale(); 

            } 

        }); 

  

        setVisible(true); 

    } 

  

    private void processSale() { 

        try { 

            String customer = txtCustomer.getText(); 

            String product = (String) cmbProduct.getSelectedItem(); 

            double price = Double.parseDouble(txtPrice.getText()); 

  

            // Calculations - from brief 

            double vat = price * 0.15; 

            double commission = price * 0.05; 

            double total = price + vat + commission; 

  

            String result = "Customer Name: " + customer + "\n" 

                                        + "Product Name: " + product + "\n" 

                                        + "VAT Amount: R" + vat + "\n"
                                                + "Commission Amount: R" + commission + "\n" 

                                        + "Total Sale Amount: R" + total; 

  

            txtOutput.setText(result); 

            allSales.add(result); // store it 

  

            // Also show popup like most IIE examples do 

            JOptionPane.showMessageDialog(this, result, "Sale Processed", JOptionPane.INFORMATION_MESSAGE); 

  

        } catch (NumberFormatException ex) { 

            JOptionPane.showMessageDialog(this, "Please enter a valid price!", "Error", JOptionPane.ERROR_MESSAGE); 

        } 

    } 

  

    private void clearForm() { 

        txtCustomer.setText(""); 

        txtPrice.setText(""); 

        txtOutput.setText(""); 

        cmbProduct.setSelectedIndex(0); 

    } 

  

    public static void main(String[] args) { 

        new ProductApp(); 

    } 

}