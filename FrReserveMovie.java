/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mwbs;

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

/**
 *
 * @author Imperator
 */
public class FrReserveMovie extends javax.swing.JFrame {

    /**
     * Creates new form FrReserveMovie
     */
    Connection conMain;
    Statement stmtMain;
    PreparedStatement pstmtMain;
    ResultSet rsMain;
    int intID1;
    int intID2;
    int intID3;
    int intID4;
    public FrReserveMovie() {
        labelBackground();
        initComponents();
        getMovies();
    }
    
    private void labelBackground(){
        try {
            BufferedImage bfimgBackground = ImageIO.read(new File("src/mwbs/images/background.png"));
            Image imgBackground = bfimgBackground.getScaledInstance(278, 521, java.awt.Image.SCALE_SMOOTH);
            setContentPane(new JLabel(new ImageIcon(imgBackground)));
        }
        catch (IOException ex) {
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
        }
    }
    
    private void getMovies(){
        connectDatabase();
        String strQuery = "SELECT "
                + "movie_ID,"
                + "movie_Name,"
                + "movie_Tickets,"
                + "movie_Reserved,"
                + "movie_Showing "
                + "FROM MovieList "
                + "ORDER BY movie_ID";
        try{
            int intCounter = 0;
            pstmtMain = conMain.prepareStatement(strQuery);
            rsMain = pstmtMain.executeQuery();
            while(rsMain.next()){
                String strID = rsMain.getString("movie_ID");
                String strName = rsMain.getString("movie_Name");
                int intTickets = rsMain.getInt("movie_Tickets");
                int intReserved = rsMain.getInt("movie_Reserved");
                if(rsMain.getString("movie_Showing").equals("Y") && intCounter < 4){
                    if(intCounter == 0){
                        if(intTickets - intReserved == 0){
                            btnMovie1.setText(strName+"(SOLD OUT!)");
                        }
                        else{
                            btnMovie1.setText(strName);
                            btnMovie1.setEnabled(true);   
                        }
                        lblMovie1.setIcon(new ImageIcon(getImage(strID)));
                        intID1 = Integer.parseInt(strID);
                        intCounter++;
                    }
                    else if(intCounter == 1){
                        if(intTickets - intReserved == 0){
                            btnMovie2.setText(strName+"(SOLD OUT!)");
                        }
                        else{
                            btnMovie2.setText(strName);
                            btnMovie2.setEnabled(true);   
                        }
                        lblMovie2.setIcon(new ImageIcon(getImage(strID)));
                        intID2 = Integer.parseInt(strID);
                        intCounter++;
                    }
                    else if(intCounter == 2){
                        if(intTickets - intReserved == 0){
                            btnMovie3.setText(strName+"(SOLD OUT!)");
                        }
                        else{
                            btnMovie3.setText(strName);
                            btnMovie3.setEnabled(true);   
                        }
                        lblMovie3.setIcon(new ImageIcon(getImage(strID)));
                        intID3 = Integer.parseInt(strID);
                        intCounter++;
                    }
                    else if(intCounter == 3){
                        if(intTickets - intReserved == 0){
                            btnMovie4.setText(strName+"(SOLD OUT!)");
                        }
                        else{
                            btnMovie4.setText(strName);
                            btnMovie4.setEnabled(true);   
                        }
                        lblMovie4.setIcon(new ImageIcon(getImage(strID)));
                        intID4 = Integer.parseInt(strID);
                        intCounter++;
                    }
                }
            }
        }
        catch(SQLException error){
        }
    }
    
    private Image getImage(String strFileName){
        Image imgFile = null;
        try{
            BufferedImage bfimgFile = ImageIO.read(new File("src/mwbs/images/movies/"+strFileName+".jpg"));
            imgFile = bfimgFile.getScaledInstance(120, 180, java.awt.Image.SCALE_SMOOTH);
        }
        catch(IOException error){
        }
        return imgFile;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMovie1 = new javax.swing.JButton();
        lblMovie1 = new javax.swing.JLabel();
        btnMovie2 = new javax.swing.JButton();
        lblMovie2 = new javax.swing.JLabel();
        lblMovie3 = new javax.swing.JLabel();
        btnMovie3 = new javax.swing.JButton();
        lblMovie4 = new javax.swing.JLabel();
        btnMovie4 = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        btnMovie1.setBackground(new java.awt.Color(230, 175, 82));
        btnMovie1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMovie1.setForeground(new java.awt.Color(255, 255, 255));
        btnMovie1.setText("Coming Soon!");
        btnMovie1.setEnabled(false);
        btnMovie1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovie1ActionPerformed(evt);
            }
        });

        lblMovie1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMovie1.setForeground(new java.awt.Color(255, 255, 255));
        lblMovie1.setText("Coming Soon!!");
        lblMovie1.setPreferredSize(new java.awt.Dimension(120, 180));

        btnMovie2.setBackground(new java.awt.Color(230, 175, 82));
        btnMovie2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMovie2.setForeground(new java.awt.Color(255, 255, 255));
        btnMovie2.setText("Coming Soon!");
        btnMovie2.setEnabled(false);
        btnMovie2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovie2ActionPerformed(evt);
            }
        });

        lblMovie2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMovie2.setForeground(new java.awt.Color(255, 255, 255));
        lblMovie2.setText("Coming Soon!!");
        lblMovie2.setPreferredSize(new java.awt.Dimension(120, 180));

        lblMovie3.setBackground(new java.awt.Color(255, 255, 255));
        lblMovie3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMovie3.setForeground(new java.awt.Color(255, 255, 255));
        lblMovie3.setText("Coming Soon!!");
        lblMovie3.setPreferredSize(new java.awt.Dimension(120, 180));

        btnMovie3.setBackground(new java.awt.Color(230, 175, 82));
        btnMovie3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMovie3.setForeground(new java.awt.Color(255, 255, 255));
        btnMovie3.setText("Coming Soon!");
        btnMovie3.setEnabled(false);
        btnMovie3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovie3ActionPerformed(evt);
            }
        });

        lblMovie4.setBackground(new java.awt.Color(255, 255, 255));
        lblMovie4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMovie4.setForeground(new java.awt.Color(255, 255, 255));
        lblMovie4.setText("Coming Soon!!");
        lblMovie4.setPreferredSize(new java.awt.Dimension(120, 180));

        btnMovie4.setBackground(new java.awt.Color(230, 175, 82));
        btnMovie4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMovie4.setForeground(new java.awt.Color(255, 255, 255));
        btnMovie4.setText("Coming Soon!");
        btnMovie4.setEnabled(false);
        btnMovie4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovie4ActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(230, 175, 82));
        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMovie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMovie1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMovie2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMovie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMovie3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMovie3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMovie4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMovie4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMovie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMovie2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMovie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMovie1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMovie3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMovie3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMovie4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMovie4)))
                .addGap(18, 18, 18)
                .addComponent(btnCancel)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMovie1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovie1ActionPerformed
        new FrReserveTicket(intID1).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMovie1ActionPerformed

    private void btnMovie2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovie2ActionPerformed
        new FrReserveTicket(intID2).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMovie2ActionPerformed

    private void btnMovie3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovie3ActionPerformed
        new FrReserveTicket(intID3).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMovie3ActionPerformed

    private void btnMovie4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovie4ActionPerformed
        new FrReserveTicket(intID4).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMovie4ActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        new FrMainTicket().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(FrReserveMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrReserveMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrReserveMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrReserveMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrReserveMovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnMovie1;
    private javax.swing.JButton btnMovie2;
    private javax.swing.JButton btnMovie3;
    private javax.swing.JButton btnMovie4;
    private javax.swing.JLabel lblMovie1;
    private javax.swing.JLabel lblMovie2;
    private javax.swing.JLabel lblMovie3;
    private javax.swing.JLabel lblMovie4;
    // End of variables declaration//GEN-END:variables
}
