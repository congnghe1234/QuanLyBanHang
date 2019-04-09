/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy_KH;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ShowKH extends KetNoi_CSDL{
    
     public ArrayList<KhachHang> getList(){
        ArrayList <KhachHang> list =new ArrayList<>();
        String sql ="select *from dbo.KHACHHANG ";
        try {
            Open();
            sm =cn.createStatement();
            rs=sm.executeQuery(sql);
            while(rs.next()){
                
                KhachHang kh =new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHotenKH(rs.getString(2));
                kh.setDiachiKH(rs.getString(3));
                kh.setSdtKH(rs.getString(4));
                list.add(kh);
                
                System.out.println("Lay danh sach thanh cong.");
             
            }
               Close();
        } catch (SQLException e) {
        }
        return list;
    }
     public int Them_KH(KhachHang kh){
         int count;
        String sql ="insert into dbo.KHACHHANG values (?,?,?,?) ";
        try {
            Open();
            ps=cn.prepareStatement(sql);
            ps.setString(1,kh.getMaKH());
            ps.setString(2, kh.getHotenKH());
            ps.setString(3,kh.getDiachiKH());
            ps.setString(4,kh.getSdtKH());
            count =ps.executeUpdate();
            
            Close();
           System.out.println(count);
            
             return count;
        } catch (Exception e) {
            System.out.println("Khong the them.");
        }
        
        return -1;
     }
     public void Sua_KH(String maKH,String hoten,String diachi,String sdt) throws SQLException{
      
         String sql1="update dbo.KHACHHANG set HOTEN =? where MAKH= ?";
         String sql2="update dbo.KHACHHANG set DIACHI =? where MAKH= ?";
         String sql3="update dbo.KHACHHANG set SDT=? where MAKH= ?";
         try{
           Open();
         sm=cn.createStatement();
         sm.executeUpdate(sql1);
         sm.executeUpdate(sql2);
         sm.executeUpdate(sql3);
         }catch(SQLException e){
             
         }
     }
    
}
