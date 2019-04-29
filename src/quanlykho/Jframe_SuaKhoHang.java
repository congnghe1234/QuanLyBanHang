package quanlykho;


import XuLy_KH.KetNoi_CSDL;
import XuLy_Kho.MatHang;
import XuLy_Kho.Show_Kho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class Jframe_SuaKhoHang extends javax.swing.JFrame {
    static KetNoi_CSDL kn = new KetNoi_CSDL();

    private ArrayList <MatHang> list =new ArrayList<>();
    private MatHang mh;
    public Jframe_SuaKhoHang() throws SQLException {
        initComponents();
        Connection cn = kn.getKetNoiDuLieu();
        PreparedStatement ps = cn.prepareStatement("SELECT * FROM LOAIHANG");
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            String s = rs.getString(2);
            cbLoaiHang.addItem(s);
        }
        DocDS();
    }
    public void up(){
        
    }
    public void DocDS(){
      Show_Kho doc=new Show_Kho();
        list =doc.getList();
        DefaultTableModel tb =(DefaultTableModel) tableHang.getModel();
        tb.setRowCount(0);
        for(MatHang s:list){
                Vector <Object> vec =new Vector<>();
                
                vec.add(s.getMaHH());
                vec.add(s.getTen());
                vec.add(s.getLoai());
                vec.add(s.getDvt());
                vec.add(s.getSoluong());
                vec.add(s.getDongia());
                tb.addRow(vec);
               
            }
       tableHang.setModel(tb);
       tableHang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    
          @Override
          public void valueChanged(ListSelectionEvent e) {
            if( tableHang.getSelectedRow()>=0){
                tfMaHang.setText(tableHang.getValueAt(tableHang.getSelectedRow(),0)+"");
                tfTenHang.setText(tableHang.getValueAt(tableHang.getSelectedRow(),1)+"");
                cbLoaiHang.setSelectedItem(tableHang.getModel().getValueAt(tableHang.getSelectedRow(), 2)+"");
                tfDVT.setText(tableHang.getValueAt(tableHang.getSelectedRow(),3)+"");
                tfSoLuong.setText(tableHang.getValueAt(tableHang.getSelectedRow(),4)+"");
                tfDonGia.setText(tableHang.getValueAt(tableHang.getSelectedRow(),5)+"");
            }   
          }
       }
       );
    }
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlLuu = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        btnDongY = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        dlThemHang = new javax.swing.JDialog();
        lbThanhCong = new javax.swing.JLabel();
        dlXoa = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        btnDongY1 = new javax.swing.JButton();
        btnHuy1 = new javax.swing.JButton();
        dlXoaHang = new javax.swing.JDialog();
        lbThanhCong1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbThongTin = new javax.swing.JLabel();
        lbMaHang = new javax.swing.JLabel();
        lbLoaiHang = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        lbTenHang = new javax.swing.JLabel();
        lbDVT = new javax.swing.JLabel();
        lbDonGia = new javax.swing.JLabel();
        tfMaHang = new javax.swing.JTextField();
        tfTenHang = new javax.swing.JTextField();
        tfDVT = new javax.swing.JTextField();
        tfSoLuong = new javax.swing.JTextField();
        tfDonGia = new javax.swing.JTextField();
        cbLoaiHang = new javax.swing.JComboBox<>();
        lbChinh = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHang = new javax.swing.JTable();
        btnQuayLai = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        lbDanhSach = new javax.swing.JLabel();
        lbThongBao = new javax.swing.JLabel();

        dlLuu.setTitle("Thông báo!");
        dlLuu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dlLuu.setModal(true);
        dlLuu.setName(""); // NOI18N
        dlLuu.setResizable(false);
        dlLuu.setSize(new java.awt.Dimension(300, 150));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Bạn có muốn cập nhật thông tin hàng hóa?");

        btnDongY.setBackground(new java.awt.Color(0, 102, 153));
        btnDongY.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDongY.setForeground(new java.awt.Color(255, 255, 255));
        btnDongY.setText("Đồng ý");
        btnDongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongYActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(0, 102, 153));
        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlLuuLayout = new javax.swing.GroupLayout(dlLuu.getContentPane());
        dlLuu.getContentPane().setLayout(dlLuuLayout);
        dlLuuLayout.setHorizontalGroup(
            dlLuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlLuuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(dlLuuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnDongY)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuy)
                .addGap(44, 44, 44))
        );
        dlLuuLayout.setVerticalGroup(
            dlLuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlLuuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dlLuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDongY)
                    .addComponent(btnHuy))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dlThemHang.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dlThemHang.setModal(true);
        dlThemHang.setResizable(false);
        dlThemHang.setSize(new java.awt.Dimension(200, 100));

        lbThanhCong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbThanhCong.setForeground(new java.awt.Color(0, 0, 255));
        lbThanhCong.setText("Thêm hàng thành công!");

        javax.swing.GroupLayout dlThemHangLayout = new javax.swing.GroupLayout(dlThemHang.getContentPane());
        dlThemHang.getContentPane().setLayout(dlThemHangLayout);
        dlThemHangLayout.setHorizontalGroup(
            dlThemHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlThemHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbThanhCong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dlThemHangLayout.setVerticalGroup(
            dlThemHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlThemHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbThanhCong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dlXoa.setTitle("Thông báo!");
        dlXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dlXoa.setModal(true);
        dlXoa.setName(""); // NOI18N
        dlXoa.setResizable(false);
        dlXoa.setSize(new java.awt.Dimension(183, 100));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Bạn có chắc chắn xóa?");

        btnDongY1.setBackground(new java.awt.Color(0, 102, 153));
        btnDongY1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDongY1.setForeground(new java.awt.Color(255, 255, 255));
        btnDongY1.setText("Đồng ý");
        btnDongY1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongY1ActionPerformed(evt);
            }
        });

        btnHuy1.setBackground(new java.awt.Color(0, 102, 153));
        btnHuy1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHuy1.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy1.setText("Hủy");
        btnHuy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuy1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlXoaLayout = new javax.swing.GroupLayout(dlXoa.getContentPane());
        dlXoa.getContentPane().setLayout(dlXoaLayout);
        dlXoaLayout.setHorizontalGroup(
            dlXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlXoaLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(21, 21, 21))
            .addGroup(dlXoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDongY1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuy1)
                .addContainerGap())
        );
        dlXoaLayout.setVerticalGroup(
            dlXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlXoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dlXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDongY1)
                    .addComponent(btnHuy1))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        dlXoaHang.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dlXoaHang.setModal(true);
        dlXoaHang.setResizable(false);
        dlXoaHang.setSize(new java.awt.Dimension(200, 100));

        lbThanhCong1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbThanhCong1.setForeground(new java.awt.Color(0, 0, 255));
        lbThanhCong1.setText("Mặt hàng này chưa có!");

        javax.swing.GroupLayout dlXoaHangLayout = new javax.swing.GroupLayout(dlXoaHang.getContentPane());
        dlXoaHang.getContentPane().setLayout(dlXoaHangLayout);
        dlXoaHangLayout.setHorizontalGroup(
            dlXoaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlXoaHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbThanhCong1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dlXoaHangLayout.setVerticalGroup(
            dlXoaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlXoaHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbThanhCong1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(0, 0, 255));

        lbThongTin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbThongTin.setForeground(new java.awt.Color(0, 0, 255));
        lbThongTin.setText("Nhập thông tin:");

        lbMaHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbMaHang.setForeground(new java.awt.Color(0, 0, 255));
        lbMaHang.setText("Mã hàng:");

        lbLoaiHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbLoaiHang.setForeground(new java.awt.Color(0, 0, 255));
        lbLoaiHang.setText("Loại hàng:");

        lbSoLuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbSoLuong.setForeground(new java.awt.Color(0, 0, 255));
        lbSoLuong.setText("Số lượng:");

        lbTenHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTenHang.setForeground(new java.awt.Color(0, 0, 255));
        lbTenHang.setText("Tên hàng:");

        lbDVT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbDVT.setForeground(new java.awt.Color(0, 0, 255));
        lbDVT.setText("Đơn vị tính:");

        lbDonGia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbDonGia.setForeground(new java.awt.Color(0, 0, 255));
        lbDonGia.setText("Đơn giá:");

        tfMaHang.setEditable(false);

        tfTenHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTenHangActionPerformed(evt);
            }
        });

        cbLoaiHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        cbLoaiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLoaiHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbThongTin)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaHang)
                            .addComponent(lbLoaiHang)
                            .addComponent(lbSoLuong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfMaHang)
                            .addComponent(tfSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(cbLoaiHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTenHang)
                            .addComponent(lbDVT)
                            .addComponent(lbDonGia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTenHang, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(tfDVT)
                            .addComponent(tfDonGia))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbThongTin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTenHang, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMaHang)
                        .addComponent(tfMaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLoaiHang)
                    .addComponent(lbDVT)
                    .addComponent(tfDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoLuong)
                    .addComponent(lbDonGia)
                    .addComponent(tfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbChinh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbChinh.setForeground(new java.awt.Color(255, 0, 0));
        lbChinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbChinh.setText("Sửa thông tin kho hàng");

        tableHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hàng", "Tên hàng", "Loại hàng", "Đơn vị tính", "Số lượng", "Đơn giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableHang);

        btnQuayLai.setBackground(new java.awt.Color(0, 102, 153));
        btnQuayLai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnQuayLai.setForeground(new java.awt.Color(255, 255, 255));
        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(0, 102, 153));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(0, 102, 153));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        lbDanhSach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDanhSach.setForeground(new java.awt.Color(255, 0, 0));
        lbDanhSach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDanhSach.setText("Danh sách hàng hoá");

        lbThongBao.setBackground(new java.awt.Color(255, 153, 153));
        lbThongBao.setForeground(new java.awt.Color(255, 51, 51));
        lbThongBao.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lbDanhSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(lbThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            // TODO add your handling code here:
            String maHang = tfMaHang.getText();
            Connection cn = kn.getKetNoiDuLieu();
            PreparedStatement ps = cn.prepareStatement("SELECT MAHH FROM KHOHANG");
            ResultSet rs = ps.executeQuery();
            int i=0; //Kiểm tra trùng
            while(rs.next())
            {
                String s = rs.getString(1);
                if(maHang.compareToIgnoreCase(s)==0)
                {
                    dlXoa.setVisible(true);
                    i=1;
                    break;
                }
            }
            if(i==0)
            {
                dlXoaHang.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Jframe_SuaKhoHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tfTenHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTenHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTenHangActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        try
        {
            String maHang = tfMaHang.getText();
            String tenHang = tfTenHang.getText();
            String loaiHang = (String) cbLoaiHang.getSelectedItem();
            String DVT = tfDVT.getText();
            String soLuong = tfSoLuong.getText();
            String donGia = tfDonGia.getText();
            Connection cn = kn.getKetNoiDuLieu(); 
            PreparedStatement ps = cn.prepareStatement("SELECT MAHH FROM KHOHANG");
            ResultSet rs = ps.executeQuery();
            int i=0;
            while(rs.next())
            {
                String s = rs.getString(1);
                if(maHang.compareToIgnoreCase(s)==0)
                {
                    dlLuu.setVisible(true);
                    i=1;
                    break;
                }
            }
            if(i==0)
            {
                dlThemHang.setVisible(true);
                ps = cn.prepareStatement("INSERT INTO KHOHANG VALUES(?,?,?,?,?,?)");
                ps.setString(1, maHang);
                ps.setString(2, tenHang);
                
                //Lấy tên loại hàng từ database khác
                PreparedStatement ps1 = cn.prepareStatement("SELECT MALH FROM LOAIHANG WHERE TENLH = ?");
                ps1.setString(1, loaiHang);
                ResultSet rs1 = ps1.executeQuery();
                while(rs1.next())
                {
                    loaiHang = rs1.getString(1);
                }
                ps.setString(3, loaiHang);
                ps.setString(4, DVT);
                ps.setString(5, soLuong);
                ps.setString(6, donGia);
                int rowCount = ps.executeUpdate();
                lbThongBao.setText("Row Count affacted = " + rowCount);
                DocDS();
            }
            
          
        } catch (SQLException ex) {
            Logger.getLogger(Jframe_SuaKhoHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnDongYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongYActionPerformed
         //TODO add your handling code here:
        try 
        {
            String maHang = tfMaHang.getText();
            String tenHang = tfTenHang.getText();
            String loaiHang = (String)cbLoaiHang.getSelectedItem();
            String DVT = tfDVT.getText();
            String soLuong = tfSoLuong.getText();
            String donGia = tfDonGia.getText();
            Connection cn = kn.getKetNoiDuLieu();
        
            PreparedStatement ps = cn.prepareStatement("UPDATE KHOHANG SET TENHANG = ?, MALH = ?, DVT = ?, SOLUONG = ?, DONGIA = ? WHERE MAHH = ?");
            ps.setString(1, tenHang);            
            //Lấy tên loại hàng từ database khác
            PreparedStatement ps1 = cn.prepareStatement("SELECT MALH FROM LOAIHANG WHERE TENLH = ?");
            ps1.setString(1, loaiHang);
            ResultSet rs1 = ps1.executeQuery();
            while(rs1.next())
            {
                loaiHang = rs1.getString(1);
            }
            ps.setString(2, loaiHang);
            ps.setString(3, DVT);
            ps.setString(4, soLuong);
            ps.setString(5, donGia);
            ps.setString(6, maHang);

            int rowCount = ps.executeUpdate();
            lbThongBao.setText("Row Count affected= " + rowCount);
            dlLuu.setVisible(false);
            DocDS();

        } catch (SQLException ex) {
            Logger.getLogger(Jframe_SuaKhoHang.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }//GEN-LAST:event_btnDongYActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        dlLuu.setVisible(false);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnDongY1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongY1ActionPerformed
        try {
            // TODO add your handling code here:
            String maHang = tfMaHang.getText();
            Connection cn = kn.getKetNoiDuLieu();
            PreparedStatement ps;
            ps = cn.prepareStatement("DELETE FROM KHOHANG WHERE MAHH = ?" );
            ps.setString(1, maHang);
            int rowCount = ps.executeUpdate();
            // In ra số dòng được trèn vào bởi câu lệnh trên.
            lbThongBao.setText("Row Count affected = " + rowCount);
            dlXoa.setVisible(false);
            DocDS();
        } catch (SQLException ex) {
            Logger.getLogger(Jframe_SuaKhoHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnDongY1ActionPerformed

    private void btnHuy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuy1ActionPerformed
        // TODO add your handling code here:
        dlXoa.setVisible(false);
    }//GEN-LAST:event_btnHuy1ActionPerformed

    private void cbLoaiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLoaiHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLoaiHangActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        Jframe_QL j=new Jframe_QL();
        j.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

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
            java.util.logging.Logger.getLogger(Jframe_SuaKhoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jframe_SuaKhoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jframe_SuaKhoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jframe_SuaKhoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Jframe_SuaKhoHang().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Jframe_SuaKhoHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDongY;
    private javax.swing.JButton btnDongY1;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnHuy1;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbLoaiHang;
    private javax.swing.JDialog dlLuu;
    private javax.swing.JDialog dlThemHang;
    private javax.swing.JDialog dlXoa;
    private javax.swing.JDialog dlXoaHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbChinh;
    private javax.swing.JLabel lbDVT;
    private javax.swing.JLabel lbDanhSach;
    private javax.swing.JLabel lbDonGia;
    private javax.swing.JLabel lbLoaiHang;
    private javax.swing.JLabel lbMaHang;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTenHang;
    private javax.swing.JLabel lbThanhCong;
    private javax.swing.JLabel lbThanhCong1;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JLabel lbThongTin;
    private javax.swing.JTable tableHang;
    private javax.swing.JTextField tfDVT;
    private javax.swing.JTextField tfDonGia;
    private javax.swing.JTextField tfMaHang;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTenHang;
    // End of variables declaration//GEN-END:variables
}
