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

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author HP
 */
public class Create_Account_Old_Customer extends javax.swing.JFrame {

    Connection conn;
    Statement s;
    ResultSet  rs;
    
    String AID = null;
    
    String C_Nic ;
    
    String NIC = null;
    
    int y;
    int Val;
     
    Double DAmount = Double.parseDouble("0");
     
    public Create_Account_Old_Customer() {
        initComponents();
        
        txtAccountNo.setEditable(false);
        btnViewMore.setVisible(false);
        btnClose.requestFocus();
        account_no_prepared();
        
        
        
        txtAmmount.setText(""+DAmount);
        
        Val = y; 
        
        
        try
             {
                DB_Connection obj=new DB_Connection();
                conn = obj.getConnection();
                              
            }
         catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error encounterd while entering connection" +e);
            }      
    }
    
     public void clear(){
     
         txtNic.setText(null);
         txtName.setText(null);
         cmbGender.setSelectedIndex(0);
         txtContact.setText(null);
         txaAddress.setText(null);
         
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Account No");
        model.addColumn("Account Type");
        tableAccounts.setModel(model);
        
        
        txtAccountNo.setText(null);
        txtAmmount.setText(""+DAmount);
        cmbAtype.setSelectedIndex(0);
        jDateChooserOpenDate.setDate(null);
        txtNic.setEditable(true);
        txtName.setEditable(true);
        cmbGender.setEnabled(true);
        txtContact.setEditable(true);
        txaAddress.setEditable(true);
     
     }
     
     public void clear_accout_detailsOnly(){
     
        txtAccountNo.setText(null);
        txtAmmount.setText(""+DAmount);
        cmbAtype.setSelectedIndex(0);
        jDateChooserOpenDate.setDate(null);
         
     }
     
     
     
     
     public void fetch_data(){
     
            
        
        
        try{
        
            String Sql="SELECT * From customers INNER JOIN accounts ON customers.c_nic = accounts.c_nic WHERE accounts.c_nic='"+C_Nic+"'";
                
                s=conn.createStatement();
        
                rs = s.executeQuery(Sql);
                
                
                DefaultTableModel model = new DefaultTableModel();
                
                model.addColumn("Account No");
                model.addColumn("Account Type");
               // model.addColumn("Customer Nic");
               // model.addColumn("Customer Name");
               // model.addColumn("Customer Nic");
           
                
                
                while(rs.next())
                    
                    {
                
                   // JOptionPane.showMessageDialog(null, "Customer Found !");
                   // String Balance = ("Rs. "+rs.getString(4));
                   
                        String Values[] = {rs.getString("account_no"), rs.getString("account_type")/*, rs.getString("c_nic"),rs.getString("c_name")*/};
                        model.addRow(Values);
                   
                        tableAccounts.setModel(model);
                        txtNic.setText(rs.getString("c_nic"));
                        txtName.setText(rs.getString("c_name"));
                        cmbGender.setSelectedItem(rs.getString("c_gender"));
                        txtContact.setText(rs.getString("c_contact"));
                        txaAddress.setText(rs.getString("c_address"));
                    
                        NIC = rs.getString("c_nic");
                        
                        txtNic.setEditable(false);
                        txtName.setEditable(false);
                        cmbGender.setEnabled(false);
                        txtContact.setEditable(false);
                        txaAddress.setEditable(false);
                
                    }
                
                        
                
                
        
        }
        
        catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error encounterd while entering connection" +e);
            }
    
     
     
     
     }
     
     
     public void account_no_prepared(){
     
         
         String SQL="SELECT  `v_accountNo` FROM `valuess` WHERE v_id = '"+100+"'"; 
     
        try
           {
               DB_Connection obj=new DB_Connection();
               conn = obj.getConnection();
                
               s=conn.createStatement();
        
               rs = s.executeQuery(SQL);
               
               while(rs.next()){
               
                  // JOptionPane.showMessageDialog(null,"V Account No : "+rs.getString("v_accountNo"));
                  int x = Integer.parseInt(rs.getString("v_accountNo"));
                   y = x+1;
                  
                  if(cmbAtype.getSelectedIndex()==0){
                  
                      txtAccountNo.setText("SAV"+y);
                  
                  }
                  else if(cmbAtype.getSelectedIndex()==1){
                  
                      txtAccountNo.setText("FIX"+y);
                  }
                  else{
                  
                      txtAccountNo.setText("CUN"+y);
                  
                  }
                  
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
        jlblTopic = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAccounts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtSerachNic = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jpanleAccountDetails = new javax.swing.JPanel();
        txtAccountNo = new javax.swing.JTextField();
        cmbAtype = new javax.swing.JComboBox<>();
        txtAmmount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnViewMore = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtNic = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaAddress = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jlblTopic.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlblTopic.setForeground(new java.awt.Color(255, 255, 255));
        jlblTopic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTopic.setText("OPEN NEW ACCOUNT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jlblTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableAccounts.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account No", "Account Type"
            }
        ));
        tableAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAccountsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAccounts);

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Available Accounts are in Customer");

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSerachNic.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSerachNic.setForeground(new java.awt.Color(102, 102, 102));
        txtSerachNic.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSerachNic.setText("Enter Customer NIC");
        txtSerachNic.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSerachNicFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSerachNicFocusLost(evt);
            }
        });
        txtSerachNic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerachNicActionPerformed(evt);
            }
        });
        txtSerachNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSerachNicKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSerachNicKeyReleased(evt);
            }
        });

        btnFind.setBackground(new java.awt.Color(255, 102, 0));
        btnFind.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSerachNic, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSerachNic, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpanleAccountDetails.setBackground(new java.awt.Color(153, 51, 0));
        jpanleAccountDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 102, 0), null), "Account Details", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        txtAccountNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAccountNoMouseClicked(evt);
            }
        });
        txtAccountNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAccountNoActionPerformed(evt);
            }
        });

        cmbAtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Savings Account", "Fixed Deposit", "Current Account" }));
        cmbAtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAtypeActionPerformed(evt);
            }
        });

        txtAmmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAmmountFocusGained(evt);
            }
        });
        txtAmmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmmountActionPerformed(evt);
            }
        });
        txtAmmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmmountKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Account No");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Open Date");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Account Type");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Amount");

        javax.swing.GroupLayout jpanleAccountDetailsLayout = new javax.swing.GroupLayout(jpanleAccountDetails);
        jpanleAccountDetails.setLayout(jpanleAccountDetailsLayout);
        jpanleAccountDetailsLayout.setHorizontalGroup(
            jpanleAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanleAccountDetailsLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jpanleAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtAccountNo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jpanleAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanleAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbAtype, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmmount, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jpanleAccountDetailsLayout.setVerticalGroup(
            jpanleAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanleAccountDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanleAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanleAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAccountNo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanleAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbAtype, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jpanleAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanleAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAmmount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnSubmit.setBackground(new java.awt.Color(255, 204, 0));
        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(204, 255, 204));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(153, 0, 0));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Cancel");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnViewMore.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Customer Details", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        txtNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNicKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNicKeyReleased(evt);
            }
        });

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        txtContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactKeyPressed(evt);
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
        jScrollPane2.setViewportView(txaAddress);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("NIC");

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Gender");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Contact");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Address");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbGender, 0, 141, Short.MAX_VALUE)
                    .addComponent(txtName)
                    .addComponent(txtNic))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewMore, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpanleAccountDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanleAccountDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewMore, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
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

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        
        String C_nic = txtNic.getText();
        String C_name = txtName.getText();
        String C_contact = txtContact.getText();
        String C_gender = String.valueOf(cmbGender.getSelectedItem());
        String C_address = txaAddress.getText(); 

        String Account_no = txtAccountNo.getText();
        String Account_type = String.valueOf(cmbAtype.getSelectedItem());

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String openDate = dateformat.format(jDateChooserOpenDate.getDate());
       
        String amount = txtAmmount.getText();
        String Amount= String.valueOf(DAmount);
        
        
        int CnicL = C_nic.length();
        int CcontactL = C_contact.length();
        
        if(C_nic.equals("")){
            JOptionPane.showMessageDialog(null, "Add A NIC");
        }
        else if(C_name.equals("")){
            JOptionPane.showMessageDialog(null, "Add A Name");
        }
        
        else if(C_contact.equals("")){
            JOptionPane.showMessageDialog(null, "Add A Contact");
        }
        else if(C_address.equals("")){
            JOptionPane.showMessageDialog(null, "Add A Address");
        }
        else if(openDate == null){
            JOptionPane.showMessageDialog(null, "Add A Date");
        }
        else if(amount.equals(Amount)||amount.equals("")){
            JOptionPane.showMessageDialog(null, "Pleace Add An Amount For Open Account");
        }
        else if(CnicL<10){
            JOptionPane.showMessageDialog(null, "Must Fill 10 Digit in NIC");      
        }
        else if(CcontactL<10){
            JOptionPane.showMessageDialog(null, "Must Fill 10 Digit in Contact No");
        }
        else{
       
 
            String sql ="INSERT INTO `customers`(`c_nic`, `c_name`, `c_contact`, `c_gender`, `c_address`) VALUES ('"+C_nic+"','"+C_name+"','"+C_contact+"','"+C_gender+"','"+C_address+"')";

            String sql1="INSERT INTO `accounts`(`account_no`, `account_type`, `open_date`, `account_balance`, `c_nic`) VALUES ('"+Account_no+"','"+Account_type+"','"+openDate+"','"+amount+"','"+C_nic+"')";

            String SQL ="SELECT * FROM `customers` WHERE c_nic ='"+C_nic+"'";
            
            String Sql ="UPDATE `valuess` SET `v_accountNo`='"+Val+"' WHERE v_id='"+100+"'";
                
            try{
                DB_Connection obj=new DB_Connection();
                conn = obj.getConnection();

                s = conn.createStatement();
                    
                rs = s.executeQuery(SQL);
                    
                if(rs.next()){
                  
                    s = conn.createStatement();
                    int y = s.executeUpdate(sql1);
                        
                    if (y >0){
                            
                        JOptionPane.showMessageDialog(null, "Account Create Successfuly!");
                        fetch_data();
                        btnClose.requestFocus();
                        clear_accout_detailsOnly();
       
                        int Z = s.executeUpdate(Sql);
                        account_no_prepared();
                               

                    }
                    else{

                         JOptionPane.showMessageDialog(null, "Account Create Not Successfuly!");

                    }
                        
                }
                
                else{
                    
                    s = conn.createStatement();
                        
                    int x = s.executeUpdate(sql);
                    int y = s.executeUpdate(sql1);
                        
                    if (x>0 && y >0){
                               
                        JOptionPane.showMessageDialog(null, "Account Create Successfuly!");
                        C_Nic = txtNic.getText();
                        fetch_data();
                        btnClose.requestFocus();
                        clear_accout_detailsOnly();
                                        
                        int Z = s.executeUpdate(Sql);
                        account_no_prepared();
                               

                    }
                    else{

                        JOptionPane.showMessageDialog(null, "Account Create Not Successfuly!");

                    }
                        
                    
                }

      
            }
            catch(Exception e){
                    
                JOptionPane.showMessageDialog(null,"Error encounterd while entering connection" +e);
                
            }
       
        }
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:

        Account_Management A = new Account_Management();
        A.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
       /* DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Account No");
        model.addColumn("Account Type"); */
        
       // btnViewMore.setVisible(false);
        C_Nic = txtSerachNic.getText();
        fetch_data();
        
                if (txtSerachNic.getText().equals(NIC))
                    {
                
                        JOptionPane.showMessageDialog(null, "Customer Found !");
                        
                    }
                
                else{
                
                        JOptionPane.showMessageDialog(null, "Customer Not Found !");
                        clear();
                       // tableAccounts.setModel(model);
                
                    }

        
        
        
    }//GEN-LAST:event_btnFindActionPerformed

    private void tableAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAccountsMouseClicked
        // TODO add your handling code here:
        
        
        btnViewMore.setVisible(true);
        int i = tableAccounts.getSelectedRow();
        TableModel model=tableAccounts.getModel();
        
        AID = model.getValueAt(i,0).toString();
        
       // btnAddNewAccount.setVisible(false);
    }//GEN-LAST:event_tableAccountsMouseClicked

    private void btnViewMoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewMoreMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnViewMoreMouseClicked

    private void btnViewMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMoreActionPerformed
        // TODO add your handling code here:
        if(AID == null){
            JOptionPane.showMessageDialog(null,"Pleace Select An Account For View More");
        }

        else{

            String Sql="SELECT * FROM `accounts` WHERE account_no ='"+AID+"' ";

            try{

                s=conn.createStatement();

                ResultSet  rs = s.executeQuery(Sql);

                while (rs.next())
                {

                    //JOptionPane.showMessageDialog(null,"Succesfull !");

                    View_and_Edit_Account C = new View_and_Edit_Account(AID,NIC);

                    C.setVisible(true);
                    tableAccounts.setSelectionMode(NORMAL);
                    btnViewMore.setVisible(false);
                   
                    //this.setVisible(false);
                }

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error encounterd while entering connection" +e);
            }

        }
    }//GEN-LAST:event_btnViewMoreActionPerformed

    private void txtAccountNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAccountNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccountNoActionPerformed

    private void txtAccountNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAccountNoMouseClicked
        // TODO add your handling code here:
        
        btnViewMore.setVisible(false);
        tableAccounts.setSelectionMode(NORMAL);
    }//GEN-LAST:event_txtAccountNoMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clear();
        btnSubmit.setVisible(true);
        txtSerachNic.setText("Enter Customer NIC");
        txtSerachNic.setForeground(new Color(153,153,153));
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtSerachNicFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerachNicFocusGained
        // TODO add your handling code here:
        
        if(txtSerachNic.getText().equals("Enter Customer NIC")){

            txtSerachNic.setText("");
            txtSerachNic.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txtSerachNicFocusGained

    private void txtSerachNicFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerachNicFocusLost
        // TODO add your handling code here:
        
        if(txtSerachNic.getText().equals("")){

            txtSerachNic.setText("Enter Customer NIC");
            txtSerachNic.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSerachNicFocusLost

    private void cmbAtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAtypeActionPerformed
        // TODO add your handling code here:
        
        account_no_prepared();
    }//GEN-LAST:event_cmbAtypeActionPerformed

    private void txtNicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyPressed
        // TODO add your handling code here:
        String Customer_Nic = txtNic.getText();
        int length = Customer_Nic .length();
        
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

    private void txtSerachNicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerachNicKeyPressed
        // TODO add your handling code here:
        
        String Customer_Nic  = txtSerachNic.getText();
        int length = Customer_Nic .length();
        
        if(length<10 && evt.getExtendedKeyCode()!=KeyEvent.VK_SPACE)
           {
              txtSerachNic.setEditable(true);
           }
        
        else
           {
               txtSerachNic.setEditable(false);
               if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
                  {
                      txtSerachNic.setEditable(true);
                  }
               else
                  {
                      txtSerachNic.setEditable(false);
               
                  }
           }
        
        
    }//GEN-LAST:event_txtSerachNicKeyPressed

    private void txtSerachNicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerachNicKeyReleased
        // TODO add your handling code here:
        
        txtSerachNic.setText(txtSerachNic.getText().toUpperCase());
        
    }//GEN-LAST:event_txtSerachNicKeyReleased

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        // TODO add your handling code here:
        
        String Customer_Name = txtName.getText();
        int length = Customer_Name.length();
        
        if(length<20)
           {
              txtName.setEditable(true);
           }
        
        else
           {
               txtName.setEditable(false);
               if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
                  {
                      txtName.setEditable(true);
                  }
               else
                  {
                      txtName.setEditable(false);
               
                  }
           }
        
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        // TODO add your handling code here:
        
        txtName.setText(txtName.getText().toUpperCase());
        
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactKeyPressed
        // TODO add your handling code here:
        
        String Customer_Contact = txtContact.getText();
        int length = Customer_Contact.length();
        
        char c = evt.getKeyChar();
        
        if(c>='0' && c<='9'){
            
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

    private void txaAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaAddressKeyPressed
        // TODO add your handling code here:
        
        String Customer_Address = txaAddress.getText();
        int length = Customer_Address.length();
        
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

    private void txtAmmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmmountKeyPressed
        // TODO add your handling code here:
        
        String Account_ammount = txtAmmount.getText();
        int length = Account_ammount.length();
        
        char c = evt.getKeyChar();
        
        if(c>='0' && c<='9'){
                        
            txtAmmount.setEditable(true); 
      
        }
        else
        {
        
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
                  {
                      txtAmmount.setEditable(true);
                  }
            else
                  {
                      txtAmmount.setEditable(false);
               
                  }
        
        }
        
    }//GEN-LAST:event_txtAmmountKeyPressed

    private void txtAmmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmmountActionPerformed
        // TODO add your handling code here:   
    }//GEN-LAST:event_txtAmmountActionPerformed

    private void txtAmmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmmountFocusGained
        // TODO add your handling code here:
        
        txtAmmount.setText(null);
    }//GEN-LAST:event_txtAmmountFocusGained

    private void txtSerachNicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerachNicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerachNicActionPerformed

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
            java.util.logging.Logger.getLogger(Create_Account_Old_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Create_Account_Old_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Create_Account_Old_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Create_Account_Old_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Create_Account_Old_Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnViewMore;
    private javax.swing.JComboBox<String> cmbAtype;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlblTopic;
    private javax.swing.JPanel jpanleAccountDetails;
    private javax.swing.JTable tableAccounts;
    private javax.swing.JTextArea txaAddress;
    private javax.swing.JTextField txtAccountNo;
    private javax.swing.JTextField txtAmmount;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtSerachNic;
    // End of variables declaration//GEN-END:variables
}
