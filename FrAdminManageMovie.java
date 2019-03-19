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
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.ir.Statement;

/**
 *
 * @author Imperator
 */
public class FrAdminManageMovie extends javax.swing.JFrame {

    /**
     * Creates new form FrAdminManageMovie
     */
    Connection conMain;
    Statement stmtMain;
    PreparedStatement pstmtMain;
    ResultSet rsMain;
    int intMovies;
    public FrAdminManageMovie() {
        labelBackground();
        initComponents();
        drawMovieTable();
    }
    
    private void labelBackground(){
        try {
            BufferedImage bfimgBackground = ImageIO.read(new File("src/mwbs/images/background.png"));
            Image imgBackground = bfimgBackground.getScaledInstance(560, 300, java.awt.Image.SCALE_SMOOTH);
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
    
    private void drawMovieTable(){
        connectDatabase();
        DefaultTableModel tblModel = (DefaultTableModel) tblList.getModel();
        tblModel.setRowCount(0);
        intMovies = 0;
        String strQuery = "SELECT "
                + "movie_ID, movie_Name, movie_Tickets, movie_Reserved, movie_Showing "
                + "FROM MovieList "
                + "ORDER BY movie_ID";
        try{
            pstmtMain = conMain.prepareStatement(strQuery);
            rsMain = pstmtMain.executeQuery();
            while(rsMain.next()){
                String strID = rsMain.getString("movie_ID");
                String strName = rsMain.getString("movie_Name");
                int intMaxTickets = rsMain.getInt("movie_Tickets");
                int intReservedTickets = rsMain.getInt("movie_Reserved");
                int intTickets = intMaxTickets - intReservedTickets;
                String strShowing = rsMain.getString("movie_Showing");
                if(strShowing.equals("Y")){
                    intMovies++;
                }
                System.out.println(intMovies);
                tblModel.addRow(new Object[]{strID, strName, intTickets, strShowing});
            }
        }
        catch(SQLException error){
            System.out.println(error);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scpList = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        btnAddMovie = new javax.swing.JButton();
        btnShowMovie = new javax.swing.JButton();
        btnRemoveMovie = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Tickets", "Showing"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scpList.setViewportView(tblList);
        if (tblList.getColumnModel().getColumnCount() > 0) {
            tblList.getColumnModel().getColumn(0).setResizable(false);
            tblList.getColumnModel().getColumn(1).setResizable(false);
            tblList.getColumnModel().getColumn(2).setResizable(false);
            tblList.getColumnModel().getColumn(3).setResizable(false);
        }

        btnAddMovie.setBackground(new java.awt.Color(230, 175, 82));
        btnAddMovie.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAddMovie.setForeground(new java.awt.Color(255, 255, 255));
        btnAddMovie.setText("Add Movie");
        btnAddMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMovieActionPerformed(evt);
            }
        });

        btnShowMovie.setBackground(new java.awt.Color(230, 175, 82));
        btnShowMovie.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnShowMovie.setForeground(new java.awt.Color(255, 255, 255));
        btnShowMovie.setText("Show Movie");
        btnShowMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowMovieActionPerformed(evt);
            }
        });

        btnRemoveMovie.setBackground(new java.awt.Color(230, 175, 82));
        btnRemoveMovie.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRemoveMovie.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveMovie.setText("Remove Movie");
        btnRemoveMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveMovieActionPerformed(evt);
            }
        });

        btnReturn.setBackground(new java.awt.Color(230, 175, 82));
        btnReturn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReturn.setForeground(new java.awt.Color(255, 255, 255));
        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpList, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddMovie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShowMovie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoveMovie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddMovie)
                        .addGap(18, 18, 18)
                        .addComponent(btnShowMovie)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveMovie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReturn))
                    .addComponent(scpList, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMovieActionPerformed
        new FrAdminAddMovie().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddMovieActionPerformed

    private void btnShowMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowMovieActionPerformed
        connectDatabase();
        int intID = Integer.parseInt(String.valueOf(tblList.getValueAt(tblList.getSelectedRow(), 0)));
        String strQuery = "UPDATE MovieList "
                + "SET "
                + "movie_Showing = '"+"Y"+"' "
                + "WHERE movie_ID = "+intID;
        try{
            if(intMovies < 4){
                pstmtMain = conMain.prepareStatement(strQuery);
                pstmtMain.execute();
                drawMovieTable();
            }
            else{
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
        }
        catch(SQLException error){
            System.out.println(error);
        }
    }//GEN-LAST:event_btnShowMovieActionPerformed

    private void btnRemoveMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveMovieActionPerformed
        connectDatabase();
        int intID = Integer.parseInt(String.valueOf(tblList.getValueAt(tblList.getSelectedRow(), 0)));
        String strQuery = "UPDATE MovieList "
                + "SET "
                + "movie_Showing = '"+"N"+"' "
                + "WHERE movie_ID = "+intID;
        try{
            pstmtMain = conMain.prepareStatement(strQuery);
            pstmtMain.execute();
            drawMovieTable();
        }
        catch(SQLException error){
            System.out.println(error);
        }
    }//GEN-LAST:event_btnRemoveMovieActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        new FrAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReturnActionPerformed

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
            java.util.logging.Logger.getLogger(FrAdminManageMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrAdminManageMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrAdminManageMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrAdminManageMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrAdminManageMovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMovie;
    private javax.swing.JButton btnRemoveMovie;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnShowMovie;
    private javax.swing.JScrollPane scpList;
    private javax.swing.JTable tblList;
    // End of variables declaration//GEN-END:variables
}