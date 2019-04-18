/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykho;

import XuLy_KH.KetNoi_CSDL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static quanlykho.Main.taikhoan;
/**
 *
 * @author admin
 */
public class Jframe_DN extends javax.swing.JFrame {
     Connection cn;
    protected PreparedStatement ps;
    protected ResultSet rs ;
    protected Statement sm;
   
   
    public Jframe_DN() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        btnDN = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPW = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/BANNER.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setTitle("Jframe đăng nhập");
        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tài khoản:");
        jInternalFrame1.getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 90, 90, 23);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mật khẩu :");
        jInternalFrame1.getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 130, 85, 24);

        txtTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jInternalFrame1.getContentPane().add(txtTK);
        txtTK.setBounds(120, 80, 240, 38);

        btnDN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDN.setText("Đăng Nhập");
        btnDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDNActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(btnDN);
        btnDN.setBounds(130, 220, 207, 41);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel5.setText("QUẢN LÝ");
        jInternalFrame1.getContentPane().add(jLabel5);
        jLabel5.setBounds(440, 60, 180, 60);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel6.setText("BÁN HÀNG");
        jInternalFrame1.getContentPane().add(jLabel6);
        jLabel6.setBounds(440, 120, 210, 60);
        jInternalFrame1.getContentPane().add(txtPW);
        txtPW.setBounds(120, 130, 240, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/BANNER.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jInternalFrame1.getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, -20, 720, 370);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDNActionPerformed
         String url="jdbc:sqlserver://;databaseName=QUANLYBANHANG";
         String name="sa";
         String password="123456";
         try {
             cn=DriverManager.getConnection(url, name, password);
         } catch (SQLException ex) {
             Logger.getLogger(Jframe_DN.class.getName()).log(Level.SEVERE, null, ex);
         }
       taikhoan = txtTK.getText().trim();
       String matkhau =txtPW.getText().trim();
       String nv ="select *from NHANVIEN where MANV =? and MATKHAU =?";
       String ql="select *from QUANLY where MAQL =? and MATKHAU=?";
         char s1= taikhoan.charAt(0);
      
            if(taikhoan.length()==0 && matkhau.length()==0){
                 JOptionPane.showConfirmDialog(rootPane, "Chua nhap tai khoan va mat khau", "Waiting", JOptionPane.OK_OPTION);
             }else if(taikhoan.length()==0 && matkhau.length() !=0){
             JOptionPane.showConfirmDialog(rootPane, "Chua nhap tai khoan", "Waiting", JOptionPane.OK_OPTION);
             }else if(taikhoan.length()!=0 && matkhau.length() ==0){
                 JOptionPane.showConfirmDialog(rootPane, "Chua nhap mat khau", "Waiting", JOptionPane.OK_OPTION);
             }else {
                 if(Character.compare(s1,'N')==0){
                 try {
                     ps=cn.prepareStatement(nv);
                     ps.setString(1,taikhoan);
                     ps.setString(2,matkhau);
                     rs =ps.executeQuery();
                     if(rs.next()){
                         JOptionPane.showMessageDialog(rootPane,"Chuc mung ban dang nhap thanh cong");
                         Jframe_ChucNang_NV j=new  Jframe_ChucNang_NV ();
                         j.setVisible(true);
                         dispose();
                     }else{
                         JOptionPane.showMessageDialog(rootPane,"Ban dang nhap nhan vien that bai");
                     }
                 } catch (SQLException ex) {
                     Logger.getLogger(Jframe_DN.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
             }else{
                  try {
                     ps=cn.prepareStatement(ql);
                     ps.setString(1,taikhoan);
                     ps.setString(2,matkhau);
                     rs =ps.executeQuery();
                     if(rs.next()){
                         JOptionPane.showMessageDialog(rootPane,"Chuc mung ban dang nhap thanh cong");
                         Jframe_QL j=new Jframe_QL ();
                         j.setVisible(true);
                         //dispose();
                     }else{
                         JOptionPane.showMessageDialog(rootPane,"Ban dang nhap that bai");
                     }
                 } catch (SQLException ex) {
                     Logger.getLogger(Jframe_DN.class.getName()).log(Level.SEVERE, null, ex);
                 }   
                 }
             }
            //đóng kết nối
            if(ps!= null)
                  try {
                      ps.close();
         } catch (SQLException ex) {
             Logger.getLogger(Jframe_DN.class.getName()).log(Level.SEVERE, null, ex);
         }
             if(rs !=null)
                  try {
                      rs.close();
         } catch (SQLException ex) {
             Logger.getLogger(Jframe_DN.class.getName()).log(Level.SEVERE, null, ex);
         }if(sm != null)
              try {
                  sm.close();
         } catch (SQLException ex) {
             Logger.getLogger(Jframe_DN.class.getName()).log(Level.SEVERE, null, ex);
         }   
         
    }//GEN-LAST:event_btnDNActionPerformed

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
            java.util.logging.Logger.getLogger(Jframe_DN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jframe_DN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jframe_DN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jframe_DN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jframe_DN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDN;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txtPW;
    private javax.swing.JTextField txtTK;
    // End of variables declaration//GEN-END:variables

    
}
