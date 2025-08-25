package supermarket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author shrav
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Billing extends javax.swing.JFrame {

    /**
     * Creates new form Billing
     */
    public Billing() {
        initComponents();
         SelectSeller();
         GetCat();
         
          try{
           Vector <String> cols = new Vector <String>();		
            String arr[] = {"PROD ID", "PROD NAME", "QUANTITY", " PRICE", "CATEGORY"};
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
           // Con.close();
            DefaultTableModel dtm = new DefaultTableModel(rows, cols);
            ProductTable.setModel(dtm);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
    }
    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        billid = new javax.swing.JTextField();
        Productname = new javax.swing.JTextField();
        Prodqty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ADDbtn = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();
        Clearbtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillText = new javax.swing.JTextArea();
        Printbtn = new javax.swing.JButton();
        Productcb = new javax.swing.JComboBox<>();
        Prodqty1 = new javax.swing.JTextField();
        Prodqty2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        Grdtotlbl = new javax.swing.JLabel();
        Filterbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Close = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N
        jLabel1.setText("BILLING POINT");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("BILLID");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("NAME");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("QUANTITY");

        billid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billidActionPerformed(evt);
            }
        });

        Productname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductnameActionPerformed(evt);
            }
        });

        Prodqty.setText("0");

        jLabel7.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel7.setText("PRODUCT LIST");

        ADDbtn.setBackground(new java.awt.Color(153, 153, 153));
        ADDbtn.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        ADDbtn.setText("ADD TO BILL");
        ADDbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADDbtnMouseClicked(evt);
            }
        });
        ADDbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDbtnActionPerformed(evt);
            }
        });

        RefreshBtn.setBackground(new java.awt.Color(153, 153, 153));
        RefreshBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RefreshBtn.setText("Refresh");
        RefreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBtnActionPerformed(evt);
            }
        });

        Clearbtn.setBackground(new java.awt.Color(153, 153, 153));
        Clearbtn.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        Clearbtn.setText("CLEAR");
        Clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearbtnActionPerformed(evt);
            }
        });

        BillText.setColumns(20);
        BillText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BillText.setRows(5);
        jScrollPane2.setViewportView(BillText);

        Printbtn.setBackground(new java.awt.Color(153, 153, 153));
        Printbtn.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        Printbtn.setText("PRINT");
        Printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintbtnActionPerformed(evt);
            }
        });

        Productcb.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Productcb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ProductcbItemStateChanged(evt);
            }
        });
        Productcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductcbActionPerformed(evt);
            }
        });

        ProductTable.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        ProductTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODID", "PRODNAME", "PRODQTY", "PRODPRICE", "PRODCAT"
            }
        ));
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductTable);

        Grdtotlbl.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Grdtotlbl.setText("\nRs");

        Filterbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Filterbtn.setText("Filter");
        Filterbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterbtnActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrav\\Pictures\\icons\\bill.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(ADDbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Productname, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(billid, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Prodqty, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(57, 57, 57)
                                        .addComponent(Productcb, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(Filterbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(37, 37, 37)
                                .addComponent(RefreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(Grdtotlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Printbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(251, 251, 251)
                    .addComponent(Prodqty1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addGap(521, 521, 521)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(261, 261, 261)
                    .addComponent(Prodqty2, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addGap(511, 511, 511)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel7))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Productcb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Filterbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RefreshBtn)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(billid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Productname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Prodqty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ADDbtn)
                            .addComponent(Clearbtn))
                        .addGap(29, 29, 29)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Grdtotlbl)
                    .addComponent(Printbtn))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(209, 209, 209)
                    .addComponent(Prodqty1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(600, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(219, 219, 219)
                    .addComponent(Prodqty2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(590, Short.MAX_VALUE)))
        );

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        Close.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Close.setForeground(new java.awt.Color(255, 255, 255));
        Close.setText("x");
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseMouseClicked(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Logout)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 632, Short.MAX_VALUE)
                .addComponent(Logout)
                .addGap(124, 124, 124))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void SelectSeller()
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
 int prid,newqty;
    public void update()
    { try
       {
           newqty = AvailQty - Integer.valueOf(Prodqty.getText());
            Con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Shravani1508");
            String Query = "Update system.Productmt set PRODQT='"+newqty+"'"+"where PRODID="+prid;
            Statement Add = Con.createStatement();
            Add.executeUpdate(Query);
           // JOptionPane.showMessageDialog(this, "Product Updated");
            SelectSeller();
            //Con.close();
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }}
    private void ADDbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDbtnMouseClicked

    }//GEN-LAST:event_ADDbtnMouseClicked
int i= 0;
    private void ADDbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDbtnActionPerformed
        if(Prodqty.getText().isEmpty()|| Productname.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Missing Information");
        }
        else if(AvailQty <= Double.valueOf(Prodqty.getText()))
                {
                    JOptionPane.showMessageDialog(this,"Not Enough In Stock");
        
                }
        else
        {
            i++;
            ProdTot = Uprice * Double.valueOf(Prodqty.getText());
            GrdTotal=GrdTotal+ProdTot;
            if(i==1)
            {
              BillText.setText(BillText.getText()+"*********************CARTMAX*********************\t\n"+" NUM\tPRODUCT\tPRICE\t\tQUANTITY\tTOTAL\n"+i+"\t"+Productname.getText()+"\t"+Uprice+"\t"+Prodqty.getText()+"\t"+ProdTot+"\n");
            }
            else
            {
                BillText.setText(BillText.getText()+i+"\t"+Productname.getText()+"\t"+Uprice+"\t"+Prodqty.getText()+"\t"+ProdTot+"\n");
                
            }
            //BillText.setText(BillText.getText()+"\nGrand Total = "+GrdTotal+"\n");
            Grdtotlbl.setText("Rs"+GrdTotal);
            update();
           
        }  
      try{
           Vector <String> cols = new Vector <String>();		
         String arr[] = {"PROD ID", "PROD NAME", "QUANTITY", " PRICE", "CATEGORY"};
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
           // Con.close();
            DefaultTableModel dtm = new DefaultTableModel(rows, cols);
            ProductTable.setModel(dtm);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
               
        
    }//GEN-LAST:event_ADDbtnActionPerformed

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
       try{
           Vector <String> cols = new Vector <String>();		
            String arr[] = {"PROD ID", "PROD NAME", "QUANTITY", " PRICE", "CATEGORY"};
            for(int i=0; i < arr.length; i++)
            cols.add(arr[i]);
            
            Vector <Vector>rows = new Vector <Vector>();
            Con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Shravani1508");
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
           // Con.close();
            DefaultTableModel dtm = new DefaultTableModel(rows, cols);
            ProductTable.setModel(dtm);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }    
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void ClearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearbtnActionPerformed
        Prodqty.setText("");
        Productname.setText("");
        billid.setText("");
    }//GEN-LAST:event_ClearbtnActionPerformed

    private void PrintbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintbtnActionPerformed
     try{
        BillText.setText(BillText.getText()+"\nGrand Total = "+GrdTotal+"\n");
        BillText.print();        
    }//GEN-LAST:event_PrintbtnActionPerformed
    catch(Exception e)
     {
         e.printStackTrace();
     }
    }
    // Double Uprice ,ProdTot;
    private void ProductnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductnameActionPerformed

    
    
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
    
     Double Uprice ,ProdTot=0.0,GrdTotal =0.0;
     int AvailQty;

    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked
      
      
        DefaultTableModel  model = (DefaultTableModel)ProductTable.getModel();
        int Myindex = ProductTable.getSelectedRow();
        prid=Integer.valueOf(model.getValueAt(Myindex, 0).toString());
        AvailQty = Integer.valueOf(model.getValueAt(Myindex, 2).toString());
        newqty = AvailQty - Integer.valueOf(Prodqty.getText());
        Productname.setText(model.getValueAt(Myindex, 1).toString());
        Uprice =Double.valueOf(model.getValueAt(Myindex, 3).toString());
       // billid.setText("");
        //Prodqty.setText("");
        
        ProdTot = Uprice * Integer.valueOf(Prodqty.getText());
       // Productqty.setText(model.getValueAt(Myindex, 2).toString());
        //Productprc.setText(model.getValueAt(Myindex, 3).toString());
 
    }//GEN-LAST:event_ProductTableMouseClicked

    private void ProductcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductcbActionPerformed
        
    }//GEN-LAST:event_ProductcbActionPerformed

    private void billidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_billidActionPerformed

    private void ProductcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ProductcbItemStateChanged
      
    }//GEN-LAST:event_ProductcbItemStateChanged

    private void FilterbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterbtnActionPerformed
       try
        {
           Con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Shravani1508");
           St = Con.createStatement();
           String product_type = ((String)Productcb.getSelectedItem()).trim().toUpperCase();
           Rs = St.executeQuery("Select * from system.productmt where prodcat ='"+product_type+"'");
            Vector <String> cols = new Vector <String>();		
           String arr[] = {"PROD ID", "PROD NAME", "QUANTITY", " PRICE", "CATEGORY"};
            for(int i=0; i < arr.length; i++)
            cols.add(arr[i]);
            
            Vector <Vector>rows = new Vector <Vector>();
          while(Rs.next())
            {
		int pid = Rs.getInt("prodid");
		String pname = Rs.getString("prodname");
		String pqty = Rs.getString("prodqt");
		String price = Rs.getString("prodprc");
                String cat = Rs.getString("prodcat");
		Vector <String>single_row = new Vector<String>();
		single_row.add(pid+"");
		single_row.add(pname);
		single_row.add(pqty);
		single_row.add(price);
                single_row.add(cat);
		rows.add(single_row);
            }
            St.close();
            Rs.close();
           // Con.close();
            DefaultTableModel dtm = new DefaultTableModel(rows, cols);
            ProductTable.setModel(dtm);
           
            
           // DefaultTableModel dtm = new DefaultTableModel(rows, cols);
           // ProductTable.setModel(dtm);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_FilterbtnActionPerformed

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_CloseMouseClicked

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
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDbtn;
    private javax.swing.JTextArea BillText;
    private javax.swing.JButton Clearbtn;
    private javax.swing.JLabel Close;
    private javax.swing.JButton Filterbtn;
    private javax.swing.JLabel Grdtotlbl;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Printbtn;
    private javax.swing.JTextField Prodqty;
    private javax.swing.JTextField Prodqty1;
    private javax.swing.JTextField Prodqty2;
    private javax.swing.JTable ProductTable;
    private javax.swing.JComboBox<String> Productcb;
    private javax.swing.JTextField Productname;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JTextField billid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
