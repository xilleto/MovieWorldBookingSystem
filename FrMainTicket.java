/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mwbs;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jdk.nashorn.internal.ir.Statement;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Imperator
 */
public class FrMainTicket extends javax.swing.JFrame {

    /**
     * Creates new form FrMainTicket
     */
    Connection conMain;
    Statement stmtMain;
    PreparedStatement pstmtMain;
    ResultSet rsMain;
    public FrMainTicket() {
        labelBackground();
        initComponents();
        connectDatabase();  
    }
    
    private void labelBackground(){
        try {
            BufferedImage bfimgBackground = ImageIO.read(new File("src/mwbs/images/background.png"));
            Image imgBackground = bfimgBackground.getScaledInstance(464, 103, java.awt.Image.SCALE_SMOOTH);
            setContentPane(new JLabel(new ImageIcon(imgBackground)));
        }
        catch (IOException ex) {
        }
    }
    
    private void createDatabase(){
        try {
            File flName = new File("MWBS.accdb");
            String strMovieList = "CREATE TABLE MovieList("
                    + "movie_ID INT NOT NULL,"
                    + "movie_Name VARCHAR(255),"
                    + "movie_Tickets INT,"
                    + "movie_Reserved INT,"
                    + "movie_Showing VARCHAR(255),"
                    + "PRIMARY KEY(movie_ID)"
                    + ")";
            String strTicketList = "CREATE TABLE TicketList("
                    + "ticket_ID INT NOT NULL,"
                    + "ticket_Code VARCHAR(255),"
                    + "ticket_Name VARCHAR(255),"
                    + "ticket_Movie VARCHAR(255),"
                    + "ticket_Date DATE,"
                    + "ticket_Status VARCHAR(255),"
                    + "PRIMARY KEY(ticket_ID)"
                    + ")";
            FileUtils.cleanDirectory(new File("src\\movieworldbookingsystem\\images\\movies"));
            DatabaseBuilder dbbName = new DatabaseBuilder(flName);
            dbbName.setFileFormat(Database.FileFormat.V2016);
            dbbName.create();
            connectDatabase();
            pstmtMain = conMain.prepareStatement(strMovieList);
            pstmtMain.execute();
            pstmtMain = conMain.prepareStatement(strTicketList);
            pstmtMain.execute();
        }
        catch (SQLException | IOException error) {
            File flDelete = new File("MWBS.accdb");
            flDelete.delete();
            createDatabase();
        }
    }
    
    private void connectDatabase(){
        try{
            String strURL = "jdbc:ucanaccess://MWBS.accdb";
            String strDatabaseUsername = "";
            String strDatabasePassword = "";
            conMain = DriverManager.getConnection(strURL, strDatabaseUsername, strDatabasePassword);
        }   
        catch(SQLException error){
            createDatabase();
        }
    }
    
    private int getID(String strCode){
        connectDatabase();
        int intID = 0;
        String strQuery = "SELECT "
                + "ticket_ID,"
                + "ticket_Code "
                + "FROM TicketList "
                + "ORDER BY ticket_ID";
        try{
            pstmtMain = conMain.prepareStatement(strQuery);
            rsMain = pstmtMain.executeQuery();
            while(rsMain.next()){
                if(rsMain.getString("ticket_Code").equals(strCode)){
                    intID = rsMain.getInt("ticket_ID");
                }
                else{
                    intID = 0;
                }
            }
        }
        catch(SQLException error){
        }
        return intID;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfldInputCode = new javax.swing.JTextField();
        btnEnter = new javax.swing.JButton();
        btnReserveTicket = new javax.swing.JButton();
        lblM = new javax.swing.JLabel();
        lblM1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        tfldInputCode.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        btnEnter.setBackground(new java.awt.Color(230, 175, 82));
        btnEnter.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnEnter.setForeground(new java.awt.Color(255, 255, 255));
        btnEnter.setText("Enter");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        btnReserveTicket.setBackground(new java.awt.Color(230, 175, 82));
        btnReserveTicket.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnReserveTicket.setForeground(new java.awt.Color(255, 255, 255));
        btnReserveTicket.setText("Reserve Ticket");
        btnReserveTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserveTicketActionPerformed(evt);
            }
        });

        lblM.setFont(new java.awt.Font("Trebuchet MS", 0, 88)); // NOI18N
        lblM.setForeground(new java.awt.Color(255, 255, 255));
        lblM.setText("M");

        lblM1.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        lblM1.setForeground(new java.awt.Color(255, 255, 255));
        lblM1.setText("ovie World Reservation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReserveTicket)
                        .addGap(18, 18, 18)
                        .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfldInputCode))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblM1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblM1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblM)
                    .addComponent(btnReserveTicket)
                    .addComponent(btnEnter)
                    .addComponent(tfldInputCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
       String strCode = tfldInputCode.getText();
       if(getID(strCode) != 0){
           new FrReserveManage(getID(strCode)).setVisible(true);
           this.dispose();
       }
       else if(strCode.equals("1800")){
           new FrAdmin().setVisible(true);
           this.dispose();
       }
    }//GEN-LAST:event_btnEnterActionPerformed

    private void btnReserveTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReserveTicketActionPerformed
        new FrReserveMovie().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReserveTicketActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrMainTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrMainTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrMainTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrMainTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrMainTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnReserveTicket;
    private javax.swing.JLabel lblM;
    private javax.swing.JLabel lblM1;
    private javax.swing.JTextField tfldInputCode;
    // End of variables declaration//GEN-END:variables
}