package supermarket;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.util.*;
import javax.swing.table.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author shrav
 */

public class Seller extends javax.swing.JFrame {

    /**
     * Creates new form Seller
     */
    public Seller() {
        initComponents();
        SelectSeller();
            try
            {
                      
              
            Vector <String> cols = new Vector <String>();		
            String arr[] = {"SELLER ID", "SELLER Name", "PASSWORD", "GENDER"};
            for(int i=0; i < arr.length; i++)
            cols.add(arr[i]);
            
            Vector <Vector>rows = new Vector <Vector>();

            String sql = "select * from Sellert";
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
		int sid = rs.getInt("selid");
		String sname = rs.getString("selname");
		String pass = rs.getString("selpass");
		String gender = rs.getString("selgender");
		Vector <String>single_row = new Vector<String>();
		single_row.add(sid+"");
		single_row.add(sname);
		single_row.add(pass);
		single_row.add(gender);
		rows.add(single_row);
            }
            ps.close();
            rs.close();
            Con.close();
            DefaultTableModel dtm = new DefaultTableModel(rows, cols);
            SellerTable.setModel(dtm);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
    }

    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    
    public void SelectSeller()
    {
        try
        {
           Con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Shravani1508");
           St = Con.createStatement();
           Rs = St.executeQuery("Select * from system.Sellert");
          // Sellert.setModel(null);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SellerId = new javax.swing.JTextField();
        SellerName = new javax.swing.JTextField();
        SelPassword = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        GenderCb = new javax.swing.JComboBox<>();
        DeleteBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SellerTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        AddBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Exitbtn = new javax.swing.JLabel();
        Products = new javax.swing.JLabel();
        Category = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Gabriola", 3, 36)); // NOI18N
        jLabel2.setText("MANAGE SELLER");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("SELLERID");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("NAME");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText("PASSWORD");

        SellerId.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        SellerName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        SelPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("GENDER");

        GenderCb.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        GenderCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        DeleteBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DeleteBtn.setText("Delete");
        DeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteBtnMouseClicked(evt);
            }
        });
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        EditBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        EditBtn.setText("Edit");
        EditBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditBtnMouseClicked(evt);
            }
        });
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        ClearBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ClearBtn.setText("Clear");
        ClearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearBtnMouseClicked(evt);
            }
        });
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        SellerTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        SellerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "PASSWORD", "GENDER"
            }
        ));
        SellerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SellerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SellerTable);

        jLabel6.setFont(new java.awt.Font("Goudy Old Style", 1, 24)); // NOI18N
        jLabel6.setText("SELLER LIST");

        AddBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AddBtn.setText("ADD");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrav\\Pictures\\icons\\seller.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(38, 38, 38)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(SellerId, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(SellerName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel7)))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(GenderCb, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(SellerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(SelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SellerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(GenderCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(jLabel6)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        Exitbtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Exitbtn.setForeground(new java.awt.Color(255, 255, 255));
        Exitbtn.setText("x");
        Exitbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitbtnMouseClicked(evt);
            }
        });

        Products.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Products.setForeground(new java.awt.Color(255, 255, 255));
        Products.setText("PRODUCTS");
        Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductsMouseClicked(evt);
            }
        });

        Category.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Category.setForeground(new java.awt.Color(255, 255, 255));
        Category.setText("CATEGORIES");
        Category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoryMouseClicked(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Logout.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrav\\Pictures\\icons\\logout.png")); // NOI18N
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Products, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Category)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Logout)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(Exitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(Products)
                        .addGap(46, 46, 46)
                        .addComponent(Category)
                        .addGap(396, 396, 396)
                        .addComponent(Logout))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryMouseClicked
        // TODO add your handling code here:
        new CATEGORIES().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CategoryMouseClicked

    private void ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductsMouseClicked
        // TODO add your handling code here:
        new Productmanage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProductsMouseClicked

    private void ExitbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitbtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitbtnMouseClicked

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed

        if(SellerId.getText().isEmpty()|| SellerName.getText().isEmpty()|| SelPassword.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Missing Information");
        }
        else
        {
            try
            {
                Con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Shravani1508");
                PreparedStatement add= Con.prepareStatement("insert into Sellert values(?,?,?,?)");
                add.setInt(1, Integer.valueOf(SellerId.getText()));
                add.setString(2, SellerName.getText());
                add.setString(3, SelPassword.getText());
                add.setString(4, GenderCb.getSelectedItem().toString());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this,"Seller Added successfully");

                // int selid =SellerId.getText();
                //  String name =SellerName.getText();
                //  String pass=SelPassword.getText();
                // String Gender =GenderCb.getSelectedIitem();
                Vector <String> cols = new Vector <String>();
                String arr[] = {"SELLER ID", "SELLER Name", "PASSWORD", "GENDER"};
                for(int i=0; i < arr.length; i++)
                cols.add(arr[i]);

                Vector <Vector>rows = new Vector <Vector>();

                String sql = "select * from Sellert";
                PreparedStatement ps = Con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    int sid = rs.getInt("selid");
                    String sname = rs.getString("selname");
                    String pass = rs.getString("selpass");
                    String gender = rs.getString("selgender");
                    Vector <String>single_row = new Vector<String>();
                    single_row.add(sid+"");
                    single_row.add(sname);
                    single_row.add(pass);
                    single_row.add(gender);
                    rows.add(single_row);
                }
                ps.close();
                rs.close();
                Con.close();
                DefaultTableModel dtm = new DefaultTableModel(rows, cols);
                SellerTable.setModel(dtm);

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_AddBtnActionPerformed

/**/
    private void SellerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SellerTableMouseClicked
        DefaultTableModel  model = (DefaultTableModel)SellerTable.getModel();
        int Myindex = SellerTable.getSelectedRow();
        SellerId.setText(model.getValueAt(Myindex, 0).toString());
        SellerName.setText(model.getValueAt(Myindex, 1).toString());
        SelPassword.setText(model.getValueAt(Myindex, 2).toString());

    }//GEN-LAST:event_SellerTableMouseClicked

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void ClearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMouseClicked
        SellerId.setText("");
        SellerName.setText("");
        SelPassword.setText("");
    }//GEN-LAST:event_ClearBtnMouseClicked

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        if(SellerId.getText().isEmpty())//||SellerName.getText().isEmpty()||SelPassword.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            try
            {
                Con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Shravani1508");
                String Query = "Update system.Sellert set SELNAME='"+SellerName.getText()+"'"+",SELPASS='"+SelPassword.getText()+"'"+",SELGENDER='"+GenderCb.getSelectedItem().toString()+"'"+"where SELID="+SellerId.getText();
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                JOptionPane.showMessageDialog(this, "Seller Updated");
                SelectSeller();
                // Con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        try
        {

            Vector <String> cols = new Vector <String>();
            String arr[] = {"SELLER ID", "SELLER Name", "PASSWORD", "GENDER"};
            for(int i=0; i < arr.length; i++)
            cols.add(arr[i]);

            Vector <Vector>rows = new Vector <Vector>();

            String sql = "select * from Sellert";
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                int sid = rs.getInt("selid");
                String sname = rs.getString("selname");
                String pass = rs.getString("selpass");
                String gender = rs.getString("selgender");
                Vector <String>single_row = new Vector<String>();
                single_row.add(sid+"");
                single_row.add(sname);
                single_row.add(pass);
                single_row.add(gender);
                rows.add(single_row);
            }
            ps.close();
            rs.close();
            Con.close();
            DefaultTableModel dtm = new DefaultTableModel(rows, cols);
            SellerTable.setModel(dtm);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_EditBtnActionPerformed

    private void EditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditBtnMouseClicked

    }//GEN-LAST:event_EditBtnMouseClicked

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        if(SellerId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Enter The Category To be Deleted");
        }
        else
        {
            try
            {
                Con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Shravani1508");
                String Sid = SellerId.getText();
                String Query = "Delete from system.sellert where selid="+Sid;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                SelectSeller();
                JOptionPane.showMessageDialog(this, "Seller  Deleted Successfully");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        try
        {

            Vector <String> cols = new Vector <String>();
            String arr[] = {"SELLER ID", "SELLER Name", "PASSWORD", "GENDER"};
            for(int i=0; i < arr.length; i++)
            cols.add(arr[i]);

            Vector <Vector>rows = new Vector <Vector>();

            String sql = "select * from Sellert";
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                int sid = rs.getInt("selid");
                String sname = rs.getString("selname");
                String pass = rs.getString("selpass");
                String gender = rs.getString("selgender");
                Vector <String>single_row = new Vector<String>();
                single_row.add(sid+"");
                single_row.add(sname);
                single_row.add(pass);
                single_row.add(gender);
                rows.add(single_row);
            }
            ps.close();
            rs.close();
            Con.close();
            DefaultTableModel dtm = new DefaultTableModel(rows, cols);
            SellerTable.setModel(dtm);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void DeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBtnMouseClicked

    }//GEN-LAST:event_DeleteBtnMouseClicked

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed


    
    
    public static void main(String args[]) 
    {
       
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() 
            {
                new Seller().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JLabel Category;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JLabel Exitbtn;
    private javax.swing.JComboBox<String> GenderCb;
    private javax.swing.JButton Logout;
    private javax.swing.JLabel Products;
    private javax.swing.JTextField SelPassword;
    private javax.swing.JTextField SellerId;
    private javax.swing.JTextField SellerName;
    private javax.swing.JTable SellerTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
