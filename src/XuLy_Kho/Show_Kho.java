/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy_Kho;

import XuLy_KH.KetNoi_CSDL;
import java.sql.SQLException;
import java.util.ArrayList;


public class Show_Kho extends KetNoi_CSDL{
    
    public ArrayList<MatHang> getList(){
        ArrayList <MatHang> list =new ArrayList<>();
        String sql ="select *from dbo.KHOHANG ";
        try {
            Open();
            sm =cn.createStatement();
            rs=sm.executeQuery(sql);
            while(rs.next()){
                
                MatHang mh =new MatHang();
                mh.setMaHH(rs.getString(1));
                mh.setTen(rs.getString(2));
                mh.setLoai(rs.getString(3));
                mh.setDvt(rs.getString(4));
                mh.setSoluong(rs.getInt(5));
                mh.setDongia(rs.getInt(6));
                list.add(mh);
                
                System.out.println("Lay danh sach thanh cong.");
             
            }
               Close();
        } catch (SQLException e) {
        }
        return list;
    }
    
    }
    public int Xoa_Kho(String ms){
       
        int count;
        String sql ="delete  from dbo.KHOHANG where MAHH=?";
        try {
            Open();
            ps=cn.prepareStatement(sql);
            ps.setString(1,ms);
            count =ps.executeUpdate();
            Close();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
