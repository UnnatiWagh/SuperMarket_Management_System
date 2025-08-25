/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package supermarket;


import java.sql.*;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.table.*;

/**
 *
 * @author shrav
 */
public class Productmanage extends javax.swing.JFrame {

    /*
     * Creates new form productmanage
     */
    public Productmanage() {
        initComponents();
        SelectProductmg();
        GetCat();
       
        try
        {
        Vector <String> cols = new Vector <String>();		
            String arr[] = {"PROD ID", "PROD NAME", " QUANTITY", "PRICE", "CATEGORY"};
            for(int i=0; i < arr.length; i++)
            cols.add(arr[i]);
            
            Vector <Vector>rows = new Vector <Vector>();

            String sql = "select * from Productmt";
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
		int pid = rs.getInt("prodid");
		String pname = rs.getString("prodname");
		String pqty = rs.getString("prodqt");
		String price = rs.getString("prodprc");
                String cat = rs.getString("prodcat");
		Vector <String>single_row = new Vector<String>();
		single_row.add(pid+"");
		single_row.add(pname);
		single_row.add(pqty);
		single_row.add(price);
                single_row.add(cat);
		rows.add(single_row);
            }
            ps.close();
            rs.close();
            Con.close();
            DefaultTableModel dtm = new DefaultTableModel(rows, cols);
            ProductTable.setModel(dtm);
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
   
     public void SelectProductmg()
    {
        try
        {
           Con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Shravani1508");
           St = Con.createStatement();
           Rs = St.executeQuery("Select * from system.Productmt");
          
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
     private void GetCat()
     {
          try
        {
           Con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Shravani1508");
           St = Con.createStatement();
           String query ="Select * from system.Categoryt";
           Rs = St.executeQuery(query);
          while(Rs.next())
          {
            String Mycat =Rs.getString("catname");
            Productcb.addItem(Mycat);
          
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Productid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Productprc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Productname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Productqty = new javax.swing.JTextField();
        Productcb = new javax.swing.JComboBox<>();
        Edit = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("x");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel2.setText("PRODUCTS LIST");

        jLabel3.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel3.setText("NAME");

        Productid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductidActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel4.setText("PROD ID");

        Productprc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductprcActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel5.setText("PRICE");

        Productname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductnameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel6.setText("CATEGORY");

        jLabel7.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel7.setText("QUANTITY");

        Productqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductqtyActionPerformed(evt);
            }
        });

        Productcb.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Productcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        Productcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductcbActionPerformed(evt);
            }
        });

        Edit.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        Edit.setText("EDIT");
        Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditMouseClicked(evt);
            }
        });
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        Delete.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        Delete.setText("DELETE");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Clear.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        Clear.setText("CLEAR");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Add.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        Add.setText("ADD");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N
        jLabel8.setText("MANAGE PRODUCTS");

        ProductTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "QUANTITY", "PRICE", "CATEGORY"
            }
        ));
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductTable);

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrav\\Pictures\\icons\\category.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Productname, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Productid, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Productqty, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Productprc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Productcb, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel8)
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Productid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(Productqty, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Productname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(Productprc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Productcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jLabel9.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CATEGORY");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("SELLER");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(312, 312, 312))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel9))
                            .addComponent(Logout))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Logout))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProductidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductidActionPerformed

    private void ProductprcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductprcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductprcActionPerformed

    private void ProductnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductnameActionPerformed

    private void ProductqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductqtyActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        
        if(Productid.getText().isEmpty()||Productname.getText().isEmpty()||Productqty.getText().isEmpty()||Productprc.getText().isEmpty())
        {
           JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
       try
       {
            Con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Shravani1508");
            String Query = "Update system.Productmt set PRODNAME='"+Productname.getText()+"'"+",PRODQT='"+Productqty.getText()+"'"+",PRODPRC='"+Productprc.getText()+"'"+",PRODCAT='"+Productcb.getSelectedItem().toString()+"'"+"where PRODID="+Productid.getText();
            Statement Add = Con.createStatement();
            Add.executeUpdate(Query);
            JOptionPane.showMessageDialog(this, "Product Updated");
            SelectProductmg();
            //Con.close();
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       }
        
         try
        {
        Vector <String> cols = new Vector <String>();		
            String arr[] = {"PRODUCT ID", "PRODUCT NAME", "PRODUCT QUANTITY", "PRODUCT PRICE", "CATEGORY"};
            for(int i=0; i < arr.length; i++)
            cols.add(arr[i]);
            
            Vector <Vector>rows = new Vector <Vector>();

            String sql = "select * from Productmt";
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
		int pid = rs.getInt("prodid");
		String pname = rs.getString("prodname");
		String pqty = rs.getString("prodqt");
		String price = rs.getString("prodprc");
                String cat = rs.getString("prodcat");
		Vector <String>single_row = new Vector<String>();
		single_row.add(pid+"");
		single_row.add(pname);
		single_row.add(pqty);
		single_row.add(price);
                single_row.add(cat);
		rows.add(single_row);
            }
            ps.close();
            rs.close();
            Con.close();
            DefaultTableModel dtm = new DefaultTableModel(rows, cols);
            ProductTable.setModel(dtm);
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }//GEN-LAST:event_EditActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        if(Productid.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(this, "Enter Product To be Deleted");
       }
       else
       {   
           try
           {
                Con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Shravani1508");
                String Pid = Productid.getText();
                String Query = "Delete from system.Productmt where Prodid="+Pid;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                SelectProductmg();
                JOptionPane.showMessageDialog(this, "Product Deleted Successfully");
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
        }
        
         try
        {
        Vector <String> cols = new Vector <String>();		
            String arr[] = {"PRODUCT ID", "PRODUCT NAME", "PRODUCT QUANTITY", "PRODUCT PRICE", "CATEGORY"};
            for(int i=0; i < arr.length; i++)
            cols.add(arr[i]);
            
            Vector <Vector>rows = new Vector <Vector>();

            String sql = "select * from Productmt";
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
		int pid = rs.getInt("prodid");
		String pname = rs.getString("prodname");
		String pqty = rs.getString("prodqt");
		String price = rs.getString("prodprc");
                String cat = rs.getString("prodcat");
		Vector <String>single_row = new Vector<String>();
		single_row.add(pid+"");
		single_row.add(pname);
		single_row.add(pqty);
		single_row.add(price);
                single_row.add(cat);
		rows.add(single_row);
            }
            ps.close();
            rs.close();
            Con.close();
            DefaultTableModel dtm = new DefaultTableModel(rows, cols);
            ProductTable.setModel(dtm);
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }//GEN-LAST:event_DeleteActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        Productid.setText("");
        Productname.setText("");
        Productqty.setText("");
        Productprc.setText("");
    }//GEN-LAST:event_ClearActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
         if(Productid.getText().isEmpty()|| Productname.getText().isEmpty()|| Productqty.getText().isEmpty()|| Productprc.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Missing Information");
        }
       else
        {
            try
            {
                Con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Shravani1508");
                PreparedStatement add= Con.prepareStatement("insert into Productmt values(?,?,?,?,?)");
                add.setInt(1, Integer.valueOf(Productid.getText()));
                add.setString(2, Productname.getText());
                add.setString(3, Productqty.getText());
                add.setString(4, Productprc.getText());
                add.setString(5, Productcb.getSelectedItem().toString());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this,"Product Added successfully");
               
              
            Vector <String> cols = new Vector <String>();		
            String arr[] = {"PRODUCT ID", "PRODUCT NAME", "PRODUCT QUANTITY", "PRODUCT PRICE", "CATEGORY"};
            for(int i=0; i < arr.length; i++)
            cols.add(arr[i]);
            
            Vector <Vector>rows = new Vector <Vector>();

            String sql = "select * from Productmt";
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
		int pid = rs.getInt("prodid");
		String pname = rs.getString("prodname");
		String pqty = rs.getString("prodqt");
		String price = rs.getString("prodprc");
                String cat = rs.getString("prodcat");
		Vector <String>single_row = new Vector<String>();
		single_row.add(pid+"");
		single_row.add(pname);
		single_row.add(pqty);
		single_row.add(price);
                single_row.add(cat);
		rows.add(single_row);
            }
            ps.close();
            rs.close();
            Con.close();
            DefaultTableModel dtm = new DefaultTableModel(rows, cols);
            ProductTable.setModel(dtm);
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
                
    }//GEN-LAST:event_AddActionPerformed

    private void EditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_EditMouseClicked

    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked
      DefaultTableModel  model = (DefaultTableModel)ProductTable.getModel();
      int Myindex = ProductTable.getSelectedRow();
      Productid.setText(model.getValueAt(Myindex, 0).toString());
      Productname.setText(model.getValueAt(Myindex, 1).toString());
      Productqty.setText(model.getValueAt(Myindex, 2).toString());
      Productprc.setText(model.getValueAt(Myindex, 3).toString());            
    }//GEN-LAST:event_ProductTableMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        new Seller().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
       new CATEGORIES().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void ProductcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductcbActionPerformed
       
    }//GEN-LAST:event_ProductcbActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

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
            java.util.logging.Logger.getLogger(Productmanage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productmanage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productmanage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productmanage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productmanage().setVisible(true);
        }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Clear;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JButton Logout;
    private javax.swing.JTable ProductTable;
    private javax.swing.JComboBox<String> Productcb;
    private javax.swing.JTextField Productid;
    private javax.swing.JTextField Productname;
    private javax.swing.JTextField Productprc;
    private javax.swing.JTextField Productqty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
