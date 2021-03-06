/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author HP
 */
public class Account_Management extends javax.swing.JFrame {
    
    Connection conn;
    Statement s;
    ResultSet  rs;
    
    String AID = null;
    String NIC = null;
    
    
    /**
     * Creates new form User_Management
     */
    public Account_Management() {
        initComponents();
        
      //  btnEditUser.setVisible(false);
      btnAddNewAccount.requestFocus();
      jlmbLogUser.setText(Login_Details.Username);
      jlmbLogUserType.setText(Login_Details.Usertype);
        
        try
             {
                DB_Connection obj=new DB_Connection();
                conn = obj.getConnection();
                
                fetch_data();                 
            }
         catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error encounterd while entering connection" +e);
            }      
        
    }
    
    
    
    public void fetch_data(){
    
        try{
        
            String Sql="SELECT * FROM `accounts`";
                
                s=conn.createStatement();
        
                rs = s.executeQuery(Sql);
                
                
                DefaultTableModel model = new DefaultTableModel();
                
                model.addColumn("Account No");
                model.addColumn("Account Type");
                model.addColumn("Open Date");
                model.addColumn("Balance");
                model.addColumn("Customer Nic");
                
                while(rs.next()){
                
                    String Balance = ("Rs. "+rs.getString(4));
                    String Values[] = {rs.getString(1), rs.getString(2), rs.getString(3), Balance, rs.getString(5)};
                    model.addRow(Values);
                    AccountTable.setModel(model);
                
                }
        
        
        }
        
        catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error encounterd while entering connection" +e);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtUserSerach2 = new javax.swing.JTextField();
        iconSerach2 = new javax.swing.JLabel();
        jlmbLogUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlmbLogUserType = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AccountTable = new javax.swing.JTable();
        btnViewMore = new javax.swing.JButton();
        btnAddNewAccount = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        txtUserSerach2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUserSerach2.setForeground(new java.awt.Color(102, 102, 102));
        txtUserSerach2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUserSerach2.setText("Enter UserID 'Serach Detalis'");
        txtUserSerach2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserSerach2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserSerach2FocusLost(evt);
            }
        });
        txtUserSerach2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserSerach2ActionPerformed(evt);
            }
        });
        txtUserSerach2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserSerach2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserSerach2KeyReleased(evt);
            }
        });

        iconSerach2.setBackground(new java.awt.Color(255, 51, 0));
        iconSerach2.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\search.png")); // NOI18N
        iconSerach2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconSerach2MouseClicked(evt);
            }
        });
        iconSerach2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                iconSerach2KeyPressed(evt);
            }
        });

        jlmbLogUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlmbLogUser.setForeground(new java.awt.Color(255, 255, 255));
        jlmbLogUser.setText("Uname");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/images/User-icon.png"))); // NOI18N

        jlmbLogUserType.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlmbLogUserType.setForeground(new java.awt.Color(255, 255, 255));
        jlmbLogUserType.setText("Utype");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/images/Connected-icon.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ACCOUNT MANAGER");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(txtUserSerach2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iconSerach2)
                .addGap(47, 47, 47)
                .addComponent(jLabel3)
                .addGap(124, 124, 124)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlmbLogUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlmbLogUser, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlmbLogUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jlmbLogUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(iconSerach2)
                                .addComponent(txtUserSerach2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        AccountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Username", "User Type", "Full Name"
            }
        ));
        AccountTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                AccountTableMouseMoved(evt);
            }
        });
        AccountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AccountTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AccountTableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AccountTableMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(AccountTable);

        btnViewMore.setText("View More");
        btnViewMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewMoreMouseClicked(evt);
            }
        });
        btnViewMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMoreActionPerformed(evt);
            }
        });

        btnAddNewAccount.setText("Add New Account");
        btnAddNewAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewAccountActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(204, 255, 204));
        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/images/Button-Refresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(btnAddNewAccount)
                        .addGap(140, 140, 140)
                        .addComponent(btnViewMore, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnViewMore, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddNewAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AccountTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountTableMouseClicked
        // TODO add your handling code here:
       
        btnViewMore.setVisible(true);
        int i = AccountTable.getSelectedRow();
        TableModel model=AccountTable.getModel();
        
        AID = model.getValueAt(i,0).toString();
        NIC = model.getValueAt(i,4).toString();
        
        
        
        
        
       // JOptionPane.showMessageDialog(null,"you selected Uid Is : "+UID);
    }//GEN-LAST:event_AccountTableMouseClicked

    private void AccountTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountTableMouseEntered
        // TODO add your handling code here:
        
       
      // userTable.setForeground(new Color(100,255,255));
    }//GEN-LAST:event_AccountTableMouseEntered

    private void AccountTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountTableMouseMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_AccountTableMouseMoved

    private void AccountTableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountTableMouseExited
        // TODO add your handling code here:
        
         //userTable.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_AccountTableMouseExited

    private void btnViewMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMoreActionPerformed
        // TODO add your handling code here:
        if(AID == null && NIC== null){
           JOptionPane.showMessageDialog(null,"Pleace Select An Account For View More"); 
        }
        
        else{
            
            String Sql="SELECT * FROM `accounts` WHERE account_no ='"+AID+"' ";
            
            try{
                
                s=conn.createStatement();
        
                ResultSet  rs = s.executeQuery(Sql);
                
                while (rs.next())
                      {
                    
                     
                            JOptionPane.showMessageDialog(null,"Record Found !");
                            
                            View_and_Edit_Account C = new View_and_Edit_Account(AID,NIC);
                            
                            C.setVisible(true);
                           
                           // this.setVisible(false);
                           //AccountTable.setSelectionMode(NORMAL);
                             fetch_data();
                             AID = null;
                             NIC= null;
                           
                      }
                
                
                
            
            
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error encounterd while entering connection" +e);
            }   
        
            
        }
    }//GEN-LAST:event_btnViewMoreActionPerformed

    private void btnViewMoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewMoreMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btnViewMoreMouseClicked

    private void btnAddNewAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewAccountActionPerformed
        // TODO add your handling code here:

      Create_Account_Old_Customer C=new Create_Account_Old_Customer();
      C.setVisible(true);
      this.setVisible(false);
    }//GEN-LAST:event_btnAddNewAccountActionPerformed

    private void txtUserSerach2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserSerach2KeyReleased
        // TODO add your handling code here:
        txtUserSerach2.setText(txtUserSerach2.getText().toUpperCase());
    }//GEN-LAST:event_txtUserSerach2KeyReleased

    private void txtUserSerach2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserSerach2KeyPressed
        // TODO add your handling code here:

        String User_ID = txtUserSerach2.getText();
        int length = User_ID.length();

        if(length<10 && evt.getExtendedKeyCode()!=KeyEvent.VK_SPACE)
        {
            txtUserSerach2.setEditable(true);
        }

        else
        {
            txtUserSerach2.setEditable(false);
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtUserSerach2.setEditable(true);
            }
            else
            {
                txtUserSerach2.setEditable(false);

            }
        }
    }//GEN-LAST:event_txtUserSerach2KeyPressed

    private void txtUserSerach2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserSerach2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserSerach2ActionPerformed

    private void txtUserSerach2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserSerach2FocusLost
        // TODO add your handling code here:
        if(txtUserSerach2.getText().equals("")){

            txtUserSerach2.setText("Enter UserID 'Serach Detalis'");
            txtUserSerach2.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtUserSerach2FocusLost

    private void txtUserSerach2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserSerach2FocusGained
        // TODO add your handling code here:
        if(txtUserSerach2.getText().equals("Enter UserID 'Serach Detalis'")){

            txtUserSerach2.setText("");
            txtUserSerach2.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txtUserSerach2FocusGained

    private void iconSerach2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iconSerach2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_iconSerach2KeyPressed

    private void iconSerach2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconSerach2MouseClicked
        // TODO add your handling code here:

        String Aid = txtUserSerach2.getText();

        
            
            String Sql="SELECT * FROM `accounts` WHERE account_no ='"+Aid+"' ";
            
            try{
                
                s=conn.createStatement();
        
                ResultSet  rs = s.executeQuery(Sql);
                
                if (rs.next()){
                    
                      
                          
                         
                          JOptionPane.showMessageDialog(null,"Record Found");
                          View_and_Edit_Account A =new View_and_Edit_Account(Aid,NIC);
                          A.setVisible(true);
                          
                          
                      
                        }   
                      else{
                          
                          
                              
                               
                              JOptionPane.showMessageDialog(null,"Record Not Found");
                              
                          txtUserSerach2.setText("Enter UserID 'Serach Detalis'");
                        txtUserSerach2.setForeground(new Color(153,153,153));
                        btnAddNewAccount.requestFocus();
                          
                      
                      
                      }
                
                AccountTable.setSelectionMode(NORMAL);
                
                }
                
                
            
            
            
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error encounterd while entering connection" +e);
            }   
        
            
        
    }//GEN-LAST:event_iconSerach2MouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        
        fetch_data();
        
    }//GEN-LAST:event_btnRefreshActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Account_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Account_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Account_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Account_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Account_Management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AccountTable;
    private javax.swing.JButton btnAddNewAccount;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnViewMore;
    private javax.swing.JLabel iconSerach2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlmbLogUser;
    private javax.swing.JLabel jlmbLogUserType;
    private javax.swing.JTextField txtUserSerach2;
    // End of variables declaration//GEN-END:variables
}
