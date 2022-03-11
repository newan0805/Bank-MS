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

/**
 *
 * @author HP
 */
public class View_Selected_User extends javax.swing.JFrame {

    Connection conn;
    Statement s;
    
    
    
    
    /**
     * Creates new form View_Selected_User
     */
    public View_Selected_User() {
        initComponents();
        
       
        
    }
    
    public View_Selected_User(String x) {
        
        initComponents();
        
        
        //txtUid.setText(x);
        
        String Uid = x;
        
        if(Uid==null){
        
            jlblTopic.setText("Add User");
        
        }
        
        else{
       
        String Sql="SELECT * FROM `users` WHERE user_id ='"+Uid+"' ";
       
        try{
        
            DB_Connection obj=new DB_Connection();
            conn = obj.getConnection();
        
            s=conn.createStatement();
        
            ResultSet  rs = s.executeQuery(Sql);
         
         
            if (rs.next())
                {    
                    cmbUtype.removeAllItems();
                    String Uty = rs.getString("user_type");
                    
                    //clear();
                    //txtUserSerach.setText(Uid);     
                    txtUid.setText(rs.getString("user_id"));
                    txtUname.setText(rs.getString("user_name"));
                    txtPwd.setText(rs.getString("password"));
                    cmbUtype.removeAllItems(); 
                    txtFname.setText(rs.getString("full_name"));
                    txtContact.setText(rs.getString("tel"));
                    txtNic.setText(rs.getString("nic"));
                    txaAddress.setText(rs.getString("address"));
                    
                  /*  btnUpdate.setVisible(true);
                    btnDelete.setVisible(true);
                    btnSubmit.setVisible(false);
                    btnAddUser.setVisible(true);
                    jlblTopic.setText("View & Edit");
                    */
                   
                        
                        
                        if(Login_Details.Usertype.equals("Admin"))
                            {
                    
                                if(Uty.equals("Admin")){
                                    
                                    cmbUtype.addItem(rs.getString("user_type"));
                                    btnDelete.setVisible(false);
                                    
                                }
                                else if(Uty.equals("Manager")){
                                
                                    cmbUtype.addItem(rs.getString("user_type"));
                                    cmbUtype.addItem("Cashier");
                                }
                                else 
                                {
                                    cmbUtype.addItem(rs.getString("user_type"));
                                    cmbUtype.addItem("Manager"); 
                                    
                                }
                                
                               // JOptionPane.showMessageDialog(null,"Record Found");
                            } 
                        
                        else
                            {
                                           
                                  cmbUtype.addItem(rs.getString("user_type"));
                                    
                                 // JOptionPane.showMessageDialog(null,"Record Found");
                                       
                                        
                            }     
               
                        
                   

                } 
            
            else
                {
                   // clear();
                    JOptionPane.showMessageDialog(null,"Record Not Found");

                }
         
        
        
            
        
            }
        
        catch(Exception e)
            {
        
                JOptionPane.showMessageDialog(null,"Error encounterd while entering connection" +e);
        
            }
        
        
        }
        
        
        
    }
    
    
    
    
    public void clear(){
        
        // txtUserSerach.setText("Enter UserID 'Serach Detalis'");
        // txtUserSerach.setForeground(new Color(153,153,153));
        
        
         txtUid.setText("");
         txtUname.setText("");
         txtPwd.setText("");        
         cmbUtype.removeAllItems();
         txtFname.setText("");
         txtContact.setText("");
         txtNic.setText("");
         txaAddress.setText("");
        
    
    
    
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
        txtUid = new javax.swing.JTextField();
        txtUname = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        txtPwd = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        txtNic = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaAddress = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbUtype = new javax.swing.JComboBox<>();
        btnClose = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlblTopic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtUid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUidKeyReleased(evt);
            }
        });

        txtUname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUnameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUnameKeyTyped(evt);
            }
        });

        txtContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactKeyPressed(evt);
            }
        });

        txtPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPwdActionPerformed(evt);
            }
        });
        txtPwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPwdKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPwdKeyReleased(evt);
            }
        });

        txtFname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFnameKeyReleased(evt);
            }
        });

        txtNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNicKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNicKeyReleased(evt);
            }
        });

        txaAddress.setColumns(20);
        txaAddress.setRows(5);
        txaAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txaAddressKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaAddressKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txaAddress);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NIC");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("User Type");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Full Name");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contact");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Address");

        cmbUtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUtypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUid, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(txtUname)
                    .addComponent(txtPwd)
                    .addComponent(txtNic))
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbUtype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFname)
                    .addComponent(txtContact)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbUtype, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 153, 0));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jlblTopic.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlblTopic.setForeground(new java.awt.Color(255, 255, 255));
        jlblTopic.setText("VIEW & EDIT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(287, 287, 287))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblTopic, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUidKeyPressed
        // TODO add your handling code here:

        String User_ID = txtUid.getText();
        int length = User_ID.length();

        if(length<10 && evt.getExtendedKeyCode()!=KeyEvent.VK_SPACE)
        {
            txtUid.setEditable(true);
        }

        else
        {
            txtUid.setEditable(false);
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtUid.setEditable(true);
            }
            else
            {
                txtUid.setEditable(false);

            }
        }

    }//GEN-LAST:event_txtUidKeyPressed

    private void txtUidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUidKeyReleased
        // TODO add your handling code here:

        txtUid.setText(txtUid.getText().toUpperCase());
    }//GEN-LAST:event_txtUidKeyReleased

    private void txtUnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnameKeyPressed
        // TODO add your handling code here:

        String User_Name = txtUname.getText();
        int length = User_Name.length();

        if(length<15 && evt.getExtendedKeyCode()!=KeyEvent.VK_SPACE)
        {
            txtUname.setEditable(true);
        }

        else
        {
            txtUname.setEditable(false);

            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtUname.setEditable(true);
            }
            else
            {
                txtUname.setEditable(false);

            }
        }

    }//GEN-LAST:event_txtUnameKeyPressed

    private void txtUnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnameKeyReleased
        // TODO add your handling code here:

        txtUname.setText(txtUname.getText().toLowerCase());
    }//GEN-LAST:event_txtUnameKeyReleased

    private void txtUnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnameKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtUnameKeyTyped

    private void txtContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactKeyPressed
        // TODO add your handling code here:

        String User_Contact = txtContact.getText();
        int length = User_Contact.length();

        char c = evt.getKeyChar();

        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){

            if(length<10)
            {
                txtContact.setEditable(true);
            }
            else
            {
                txtContact.setEditable(false);
            }

        }
        else
        {

            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtContact.setEditable(true);
            }
            else
            {
                txtContact.setEditable(false);

            }

        }

    }//GEN-LAST:event_txtContactKeyPressed

    private void txtPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPwdActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_txtPwdActionPerformed

    private void txtPwdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPwdKeyPressed
        // TODO add your handling code here:

        String User_Pwd = txtPwd.getText();
        int length = User_Pwd.length();

        if(length<10 && evt.getExtendedKeyCode()!=KeyEvent.VK_SPACE)
        {
            txtPwd.setEditable(true);
        }

        else
        {
            txtPwd.setEditable(false);

            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtPwd.setEditable(true);
            }
            else
            {
                txtPwd.setEditable(false);

            }
        }

    }//GEN-LAST:event_txtPwdKeyPressed

    private void txtPwdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPwdKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPwdKeyReleased

    private void txtFnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFnameKeyPressed
        // TODO add your handling code here:

        String User_Fname = txtFname.getText();
        int length = User_Fname.length();

        if(length<20)
        {
            txtFname.setEditable(true);
        }

        else
        {
            txtFname.setEditable(false);

            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtFname.setEditable(true);
            }
            else
            {
                txtFname.setEditable(false);

            }
        }

    }//GEN-LAST:event_txtFnameKeyPressed

    private void txtFnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFnameKeyReleased
        // TODO add your handling code here:

        txtFname.setText(txtFname.getText().toUpperCase());
    }//GEN-LAST:event_txtFnameKeyReleased

    private void txtNicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyPressed
        // TODO add your handling code here:

        String User_Nic = txtNic.getText();
        int length = User_Nic.length();

        if(length<10 && evt.getExtendedKeyCode()!=KeyEvent.VK_SPACE)
        {
            txtNic.setEditable(true);
        }

        else
        {
            txtNic.setEditable(false);
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtNic.setEditable(true);
            }
            else
            {
                txtNic.setEditable(false);

            }
        }

    }//GEN-LAST:event_txtNicKeyPressed

    private void txtNicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyReleased
        // TODO add your handling code here:

        txtNic.setText(txtNic.getText().toUpperCase());
    }//GEN-LAST:event_txtNicKeyReleased

    private void txaAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaAddressKeyPressed
        // TODO add your handling code here:

        String User_Address = txaAddress.getText();
        int length = User_Address.length();

        if(length<50)
        {
            txaAddress.setEditable(true);
        }

        else
        {
            txaAddress.setEditable(false);

            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txaAddress.setEditable(true);
            }
            else
            {
                txaAddress.setEditable(false);

            }
        }

    }//GEN-LAST:event_txaAddressKeyPressed

    private void txaAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaAddressKeyReleased
        // TODO add your handling code here:

        txaAddress.setText(txaAddress.getText().toUpperCase());
    }//GEN-LAST:event_txaAddressKeyReleased

    private void cmbUtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUtypeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbUtypeActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        User_Management U = new User_Management();
        U.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String Uid = txtUid.getText();
        String Uname = txtUname.getText();
        String Upwd = txtPwd.getText();
        String Utype = String.valueOf(cmbUtype.getSelectedItem());
        String Ufname = txtFname.getText();
        String Ucontact = txtContact.getText();
        String Uaddress = txaAddress.getText();
        String Unic = txtNic.getText();

        String Sql="UPDATE `users` SET `user_id`='"+Uid+"',`user_name`='"+Uname+"',`password`='"+Upwd+"',`user_type`='"+Utype+"',`full_name`='"+Ufname+"',`tel`='"+Ucontact+"',`nic`='"+Unic+"',`address`='"+Uaddress+"' WHERE `user_id`='"+Uid+"' ";

        try{

            s=conn.createStatement();

            int x = s.executeUpdate(Sql);

            if(x>0)
            {

                JOptionPane.showMessageDialog(null,"Record updated!");
                clear();
                
                User_Management U = new User_Management();
                U.setVisible(true);
                this.setVisible(false);
            }
            else
            {

                JOptionPane.showMessageDialog(null,"Record not updated!");

            }

        }

        catch(Exception e){

            JOptionPane.showMessageDialog(null,"Error encounterd while entering connection" +e);

        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        String U_id = txtUid.getText();

        String Sql ="DELETE  FROM `users` WHERE user_id = '"+U_id+"' ";

        try{

            s=conn.createStatement();

            int x = s.executeUpdate(Sql);

            if(x>0)
            {

                JOptionPane.showMessageDialog(null,"Record Deleted!");
                clear();
                User_Management U = new User_Management();
                U.setVisible(true);
                this.setVisible(false);
                
            }
            else
            {

                JOptionPane.showMessageDialog(null,"Record not Deleted!");

            }
            
            

        }

        catch(Exception e)
        {

            JOptionPane.showMessageDialog(null,"Error encounterd while entering connection" +e);

        }

    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(View_Selected_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Selected_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Selected_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Selected_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Selected_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbUtype;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlblTopic;
    private javax.swing.JTextArea txaAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtPwd;
    private javax.swing.JTextField txtUid;
    private javax.swing.JTextField txtUname;
    // End of variables declaration//GEN-END:variables
}
