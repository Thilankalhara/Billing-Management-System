package gui;


import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import reports.MyLogger;
import database.connectionProvider;

public class billing extends javax.swing.JFrame {

    public int finalTotal=0;
    private String savePath = null; 
    private static final Logger logger = MyLogger.getLogger(); // logger
  
    public billing() {
        initComponents();
        savePath = readPathFromFile(); // pdf save path
        
        SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        jLabel5.setText(dFormat.format(date));
        
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        jLabel6.setText(dtf.format(now));
        
         jTextField10.setEditable(false);
    }
   private void printPDF(String filePath) throws IOException {
    try {
        // Locate the default print service
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print PDF");

        // Load the PDF document
        PDDocument document = PDDocument.load(new File(filePath));
        job.setPageable(new PDFPageable(document));

        // Print the document
        if (job.printDialog()) {
            job.print();
        }
        document.close();
    } catch (PrinterException e) {
        e.printStackTrace();
    }
}

private void savePathToFile(String path) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("savePath.txt"))) {
        writer.write(path);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private String readPathFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader("savePath.txt"))) {
        return reader.readLine();
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}
   private String generateUniqueFileName(String directory, String fileName) {
        File file = new File(directory + fileName);
        if (file.exists()) {
            String uniqueID = UUID.randomUUID().toString();
            int dotIndex = fileName.lastIndexOf('.');
            if (dotIndex != -1) {
                fileName = fileName.substring(0, dotIndex) + "_" + uniqueID + fileName.substring(dotIndex);
            } else {
                fileName = fileName + "_" + uniqueID;
            }
        }
        return directory + fileName;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(100, 150));
        setMinimumSize(new java.awt.Dimension(1154, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/billing frame.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Billing ani.gif"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Date");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Time");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 70, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 109, 1202, 12));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Buyer Details");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 137, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Name");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 173, -1, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 172, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Contact No");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 173, -1, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 170, 170, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Email");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 173, -1, -1));

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 170, 169, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Address");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 173, -1, -1));

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(928, 170, 200, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 229, 1202, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Product Details");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 247, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Product ID");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 284, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Product Name");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 282, 121, 20));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Rate");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 285, -1, -1));

        jTextField5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 282, 88, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Quantity");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 282, -1, -1));

        jTextField6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 282, 147, -1));

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 281, 80, -1));

        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 278, 80, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Discription");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 281, -1, -1));

        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(922, 278, 210, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 320, 100, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 368, 1202, 1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Description", "Rate", "Quantity", "Total"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 385, 636, 159));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Calculation Details");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 385, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Totall");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 445, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Paid Amount");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 486, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Return Amount");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 523, -1, -1));

        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 442, 204, -1));

        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 483, 204, -1));

        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 522, 204, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 420, 95, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reset.png"))); // NOI18N
        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 470, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close Jframe.png"))); // NOI18N
        jButton4.setText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 510, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-clear-25.png"))); // NOI18N
        jButton6.setText("clean");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 320, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/billing background.png"))); // NOI18N
        jLabel22.setPreferredSize(new java.awt.Dimension(1166, 560));
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 1180, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
            String pid = jTextField5.getText();
     
        try {
             Connection con = database.connectionProvider.getCon();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM product WHERE pId='"+pid+"'");

             if (rs.next()) {
            jTextField6.setText(rs.getString(2)); 
            jTextField7.setText(rs.getString(3)); 
            jTextField8.setText("1"); 
            jTextField9.setText(rs.getString(4)); 
        } else {
            jTextField6.setText("");
            jTextField7.setText("");
            jTextField8.setText("");
            jTextField9.setText("");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        String name= jTextField1.getText();
       
        try {
             Connection con = database.connectionProvider.getCon();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM buyer WHERE name LIKE '" + name + "%'");

             if (rs.next()) {
            jTextField1.setText(rs.getString(2)); //  name
            jTextField2.setText(rs.getString(1)); // Contact
            jTextField3.setText(rs.getString(3)); //  email
            jTextField4.setText(rs.getString(4)); //  address
        } else {
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        
           String contactNo= jTextField2.getText();
       
        try {
             Connection con = database.connectionProvider.getCon();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM buyer WHERE contactNo LIKE '" + contactNo + "%'");

             if (rs.next()) {
            jTextField1.setText(rs.getString(2)); //  name
            jTextField2.setText(rs.getString(1)); // Contact
            jTextField3.setText(rs.getString(3)); //  email
            jTextField4.setText(rs.getString(4)); //  address
        } else {
            jTextField1.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
        }
    } catch (Exception e) {
       logger.log(Level.SEVERE, "Error occurred", e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                       
    String priceText = jTextField7.getText().trim();
    String quantityText = jTextField8.getText().trim();

    if (priceText.isEmpty() || quantityText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter both rate and quantity before adding the product.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        int price = Integer.parseInt(priceText);
        int quantity = Integer.parseInt(quantityText);
        int total = price * quantity;

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.addRow(new Object[]{
            jTextField6.getText(), 
            jTextField9.getText(), 
            price, quantity, total
        });

        finalTotal += total;
        jTextField10.setText(String.valueOf(finalTotal));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numeric values for price and quantity.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
String paidAmountText = jTextField11.getText().trim();

    if (paidAmountText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter the paid amount.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        int paidAmount = Integer.parseInt(paidAmountText);
        int returnAmount = paidAmount - finalTotal;
        jTextField12.setText(String.valueOf(returnAmount));
        jTextField12.setEditable(false);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter a valid number for the paid amount.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
        new billing().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 String paidAmountText = jTextField11.getText().trim();
    String totalText = jTextField10.getText().trim();

    if (totalText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please add items before making a payment.", "No Total Found", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (paidAmountText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter the paid amount.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int totalAmount;
    int paidAmount;
    try {
        totalAmount = Integer.parseInt(totalText);
        paidAmount = Integer.parseInt(paidAmountText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numeric values for total and paid amount.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (paidAmount < totalAmount) {
        JOptionPane.showMessageDialog(this, "Paid amount is less than total. Please collect full payment.", "Insufficient Payment", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int returnAmount = paidAmount - totalAmount;
    jTextField12.setText(String.valueOf(returnAmount));
    jTextField12.setEditable(false);

    // Step 2: Handle Save Path Selection
    if (savePath == null) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            savePath = selectedDirectory.getAbsolutePath() + "\\";
            savePathToFile(savePath); // Save selected path
        } else {
            System.out.println("No directory selected");
            frame.dispose();
            return;
        }

        frame.dispose();
    }

    // Step 3: Collect Buyer Information
    String name = jTextField1.getText();
    String contactNo = jTextField2.getText();
    String email = jTextField3.getText();
    String address = jTextField4.getText();

    // Step 4: Generate Unique PDF File
    String fileName = generateUniqueFileName(savePath, name + jLabel15.getText() + ".pdf");
    Document doc = new Document();

    try {
        PdfWriter.getInstance(doc, new FileOutputStream(fileName));
        doc.open();

        Paragraph paragraph1 = new Paragraph("      THILAN Store \nContact Number: 071232324\n");
        doc.add(paragraph1);

        Paragraph paragraph2 = new Paragraph("Date & Time: " + jLabel5.getText() + "     " + jLabel6.getText()
                + "\nBuyer Details:\nName: " + name
                + "\nContact No: " + contactNo
                + "\nEmail: " + email
                + "\nAddress: " + address + "\n\n");
        doc.add(paragraph2);

        // Step 5: Add Table
        PdfPTable table = new PdfPTable(5);
        table.addCell("Name");
        table.addCell("Description");
        table.addCell("Rate");
        table.addCell("Quantity");
        table.addCell("Sub Total");

        for (int i = 0; i < jTable2.getRowCount(); i++) {
            table.addCell(jTable2.getValueAt(i, 0).toString());
            table.addCell(jTable2.getValueAt(i, 1).toString());
            table.addCell(jTable2.getValueAt(i, 2).toString());
            table.addCell(jTable2.getValueAt(i, 3).toString());
            table.addCell(jTable2.getValueAt(i, 4).toString());
        }
        doc.add(table);

        // Step 6: Add Payment Summary
        Paragraph paragraph3 = new Paragraph(
                "\nTotal: " + jTextField10.getText() +
                "\nPaid Amount: " + jTextField11.getText() +
                "\nReturn Amount: " + jTextField12.getText() +
                "\n\nThank you for visiting! Come again.\nTHILAN Store"
        );
        doc.add(paragraph3);

        doc.close();

        // Step 7: Print the PDF
        printPDF(fileName);

        // Step 8: Confirmation
        JOptionPane.showMessageDialog(null, "Bill generated and printed successfully!");

        // Optionally open a new billing window
        new billing().setVisible(true);

    } catch (Exception e) {
        logger.log(Level.SEVERE, "Error occurred", e);
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "PDF Error", JOptionPane.ERROR_MESSAGE);
    }

    jTextField10.setEditable(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        String pId = jTextField5.getText();
        try {
            Connection con=  connectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM product WHERE pId= '"+pId+"'");
            if(rs.next()){
                jTextField6.setText(rs.getString(2));
                jTextField7.setText(rs.getString(3));
                jTextField9.setText(rs.getString(4));
                
            }else{
            
                JOptionPane.showMessageDialog(null, "productID does not Exist");
            }
            
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred", e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
                                               
    jTextField5.setText("");
    jTextField6.setText("");
    jTextField7.setText("");
    jTextField8.setText("");
    jTextField9.setText("");


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        jTextField12.setEditable(false);

    }//GEN-LAST:event_jTextField12ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//       FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
