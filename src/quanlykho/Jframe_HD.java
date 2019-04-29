/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykho;

import XuLy_HoaDon.HoaDon;
import XuLy_HoaDon.Show_HD;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.Vector;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static quanlykho.Jframe_HD.hd;

public class Jframe_HD extends javax.swing.JFrame {
    public static String string1;
    public static String string2;
    public static String string3;
    public static String string4;
    public static String string5;
    public static Jframe_HD hoadon;
    public static HoaDon hd =new HoaDon();
    public static Jframe_ChucNang_NV chucnang;
    private ArrayList<HoaDon> list =new ArrayList<>();
    DefaultTableModel model1 = new DefaultTableModel();

    public Jframe_HD() {
        hoadon=this;
        initComponents();  
        this.jTable1.setModel(model1);
        AddCol();
    }

    public void AddCol(){
        model1.addColumn("Mã nhân viên");
        model1.addColumn("Mã khách hàng");
        model1.addColumn("Ngày mua");
        model1.addColumn("Thành tiền");
    }
    public void AddRow(){
        Object[] gtri = new Object[6];
           gtri[0] = string1;
           gtri[1] = string2;
           gtri[2] = string3;
           gtri[3] = string4;
         
          
           model1.addRow(gtri);
           jTable1.setModel(model1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnHD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setTitle("Giỏ hàng");
        jInternalFrame1.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Thông tin hóa đơn");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Mã khách hàng", "Ngày mua", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnHD.setText("In hóa đơn");
        btnHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(btnHD, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHD)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDActionPerformed
 //lấy dữ liệu và ghi vào bảng hóa đơn trong CSDL
            if(jTable1.getRowCount()>0){
            String maHD=" ";
            String maNV =jTable1.getValueAt(jTable1.getSelectedRow(),0)+"";
            String maKH =jTable1.getValueAt(jTable1.getSelectedRow(),1)+"";
            String ngay =jTable1.getValueAt(jTable1.getSelectedRow(),2)+"";
            String ttien=jTable1.getValueAt(jTable1.getSelectedRow(),3)+"";
             
            for(HoaDon HD:list ){
                Vector <Object> vec= new Vector();
                vec.add(HD.getMahoadon());
                
            }
           
            hd.setMahoadon(maHD);
            hd.setManv(maNV);
            hd.setMakh(maKH);
            hd.setNgaymua(ngay);
            hd.setTongtien(ttien);
             
            Show_HD them=new Show_HD();
            int check =them.ThemHoaDon(hd);
            if(check != -1){
           //sau khi ghi hóa đơn vào cơ sở dữ liệu thì sẽ quay lại chọn chức năng cho nhân viên bán hàng
                JOptionPane.showMessageDialog(rootPane,"In hóa đơn thành công");
                chucnang.setVisible(true);
                dispose();
                
            }
            }  
    }//GEN-LAST:event_btnHDActionPerformed

  
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
            java.util.logging.Logger.getLogger(Jframe_HD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jframe_HD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jframe_HD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jframe_HD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jframe_HD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHD;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
