
package quanlykho;
import XuLy_KH.KetNoi_CSDL;
import XuLy_KH.KhachHang;
import XuLy_KH.ShowKH;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static quanlykho.Jframe_BH.SL;
import static quanlykho.Jframe_BH.SL1;
import static quanlykho.Jframe_BH.j;
import static quanlykho.Jframe_HD.string4;
import static quanlykho.Main.taikhoan;

public class Jframe_MuaHang extends javax.swing.JFrame {
 static KetNoi_CSDL kn = new KetNoi_CSDL();   
public static Jframe_MuaHang muahang;
public static String str1;
public static String str2;
public static String str3;
public static String str4;
public static String str5;
public static String str6;
public static int index ;
public static Jframe_HD j=new Jframe_HD();
public static Jframe_BH BH =new Jframe_BH();
DefaultTableModel model = new DefaultTableModel();
private  Connection conn = null;
private  Statement st = null;
private  ResultSet rs = null;
private  PreparedStatement ps;
private  KhachHang kh;


 
    public Jframe_MuaHang() {
        muahang=this;
        initComponents();
        txtNV.setText(taikhoan);
        this.table.setModel(model);
       addCol();
       
       //xoa dòng trên jtable
      table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if( table.getSelectedRow()>0 ){
                 index =table.getRowCount();
                }
            }
        });
 
 
         
    }
      public void addCol(){
          model.addColumn("Mã Hàng");
          model.addColumn("Tên Hàng");
          model.addColumn("Loại Hàng");
          model.addColumn("Đơn Vị Tính");
          model.addColumn("Số Lượng");
          model.addColumn("Đơn Giá");
         
          
      }
      public void AddRow(){
           Object[] gtri = new Object[7];
           gtri[0] = str1;
           gtri[1] = str2;
           gtri[2] = str3;
           gtri[3] = str4;
           gtri[4] = str5;
           gtri[5] = str6;
      
           model.addRow(gtri);
           table.setModel(model);
      }
      
      public void Result(){
          txtMa.setText("");
          txtTen.setText("");
          txtDC.setText("");
          txtSDT.setText("");
      }
      
  //tính tổng tiền khách cần phải trả
      public void TongTien(){
          double sum =0;
          
          for(int i=0; i<table.getRowCount(); i++) 
        { 
            int sumRow=0;
            sumRow = (Integer.parseInt(table.getValueAt(i, 4).toString()) )* (Integer.parseInt(table.getValueAt(i, 5).toString()));
            sum+=sumRow; 
        } 
          sum = ( sum + (sum * 0.1));
        txtTT.setText(Double.toString( sum));
      }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        txtNV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnMua = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtDC = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        btnQL = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setResizable(true);
        jInternalFrame1.setTitle("GIỏ hàng");
        jInternalFrame1.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nhân Viên:");

        txtNV.setEditable(false);
        txtNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hàng", "Tên Hàng", "Loại Hàng", "Đơn Vị Tính", "Số Lượng", "Đơn Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Giỏ Hàng Gồm");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tổng Tiền(Bao gồm VAT):");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("VND");

        btnMua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMua.setText("Chọn Mua");
        btnMua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mã KH :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Họ Tên :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Địa Chỉ :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("SĐT :");

        txtMa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtTen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtDC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSDTKeyPressed(evt);
            }
        });

        btnQL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQL.setText("Quay Lại");
        btnQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setText("Xóa Hàng Hóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDC)
                            .addComponent(txtSDT)))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(txtNV, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(26, 26, 26)
                                .addComponent(txtTT, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(btnQL, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(btnMua, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQL)
                    .addComponent(btnMua)
                    .addComponent(btnXoa))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuaActionPerformed
      
       String sdt=txtSDT.getText().trim();
       String ma=txtMa.getText().trim();
       String ten =txtTen.getText().trim();
       String dc=txtDC.getText().trim();
         conn=kn.getKetNoiDuLieu();
         
        //ghi thông tin khách hàng vào cở sở dữ liệu
                  if(ma.length()==0){
                       JOptionPane.showMessageDialog(rootPane,"Bạn chưa nhập mã khách hàng");
                   }else if(ten.length()==0){
                       JOptionPane.showMessageDialog(rootPane,"Ban chua nhap ten khach hang");
                   }else if(ten.length()==0){
                        JOptionPane.showMessageDialog(rootPane,"Ban chua nhap địa chỉ khach hang");
                   }else if(ma.length()==0 && ten.length()==0 && ten.length()==0){
                       JOptionPane.showMessageDialog(rootPane,"Ban chua nhap thông tin khach hang");
                   }
                   else{
                       
                       //lấy dữ liệu từ textfiled lưu vào một đối tượng kh
                       kh=new KhachHang();
                       kh.setMaKH(ma);
                       kh.setHotenKH(ten);
                       kh.setDiachiKH(dc);
                       kh.setSdtKH(sdt);
                       
                       ShowKH show =new ShowKH();
                       int check= show.Them_KH(kh);
                       if(check != -1){
                        JOptionPane.showMessageDialog(rootPane,"Bạn đã thêm thành công");
                            Result();    
                       }
           //cập nhật lại số lượng sau khi chọn mua thành công
                       int SLCL ;
                     try {
                       for(int i =0;i< table.getRowCount(); i++){
                       SL =Integer.parseInt(table.getValueAt(i, 4).toString()) ;
                       SLCL = SL1 -SL ;
                       String sql ="update KHOHANG set SOLUONG= "+SLCL+" where MAHH=?";
                        ps=conn.prepareStatement(sql);
                        ps.setString(1,table.getValueAt(i,0)+"");
                        ps.executeUpdate();
                  //reset để nhận giá trị mới.
                        SLCL =0;
                        SL=0;
                         }
                   
                       } catch (SQLException ex) {
                       Logger.getLogger(Jframe_BH.class.getName()).log(Level.SEVERE, null, ex);
                        }
        // gọi jframe hóa đơn
                    j=new Jframe_HD ();
                    j.setVisible(true);
                    dispose();
       // lấy dữ liệu qua Jframe Hóa Đơn 
 
         j.string2=txtNV.getText();
         j.string3 =txtMa.getText();
         j.string5 =txtTT.getText();
         Date today=new Date(System.currentTimeMillis());
         SimpleDateFormat timeFormat= new SimpleDateFormat("YYYY-MM-DD HH:MI:SS");
         j.string4=timeFormat.format(today.getTime());
         j.hoadon.AddRow();
                  }
    
    //đóng kết nối
        try{
           if(ps!= null)
               ps.close();
            if(rs !=null)
               rs.close();
            if(st != null)
              st.close();
         } catch (SQLException ex) {
             Logger.getLogger(Jframe_DN.class.getName()).log(Level.SEVERE, null, ex);
         }   
                
       
    }//GEN-LAST:event_btnMuaActionPerformed

    private void btnQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLActionPerformed
        
        BH.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnQLActionPerformed

    private void txtSDTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
 
            conn=kn.getKetNoiDuLieu();
       //xử lý xem khách hàng đã có trog cơ sở dữ liệu chưa
       String sdt=txtSDT.getText().trim();
       String ma=txtMa.getText().trim();
       String ten =txtTen.getText().trim();
       String dc=txtDC.getText().trim();
       String sql="select * from KHACHHANG where SDT=? ";

           try {
              
               ps=conn.prepareStatement(sql);
               ps.setString(1, sdt);
               rs=ps.executeQuery();
               if(rs.next()){
                //lấy dữ liệu in ra textfield
                txtMa.setText(rs.getString("MAKH"));
                txtTen.setText(rs.getString("HOTEN"));
                txtDC.setText(rs.getString("DIACHI"));
                  
                }else{
                   JOptionPane.showMessageDialog(rootPane,"Khách hàng chưa có trong CSDL");
                   
              }
           } catch (SQLException ex) {
               Logger.getLogger(Jframe_MuaHang.class.getName()).log(Level.SEVERE, null, ex);
       }
           //đóng kết nối
           try{
           if(ps!= null)
               ps.close();
            if(rs !=null)
               rs.close();
            if(st != null)
              st.close();
         } catch (SQLException ex) {
             Logger.getLogger(Jframe_DN.class.getName()).log(Level.SEVERE, null, ex);
         }   
        }
    }//GEN-LAST:event_txtSDTKeyPressed

    private void jScrollPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyPressed
       // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1KeyPressed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
    
    }//GEN-LAST:event_tableKeyPressed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
      int option=  JOptionPane.showConfirmDialog(rootPane,"Bạn có muốn xóa hàng hóa không ?","Delete",JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION){
            model.removeRow(index);
            table.setModel(model);
            
        }
        
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(Jframe_MuaHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jframe_MuaHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jframe_MuaHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jframe_MuaHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jframe_MuaHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMua;
    private javax.swing.JButton btnQL;
    private javax.swing.JButton btnXoa;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtDC;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTT;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
