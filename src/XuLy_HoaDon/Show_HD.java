/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy_HoaDon;

import XuLy_KH.KetNoi_CSDL;
import XuLy_NV.NhanVien;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author BiaGhi ^^
 */
public class Show_HD extends KetNoi_CSDL{
    public ArrayList<HoaDon> getListHD(){
        ArrayList <HoaDon> list =new ArrayList<>();
        String sql ="select *from dbo.HOADON ";
        try {
            Open();
            sm =cn.createStatement();
            rs=sm.executeQuery(sql);
            while(rs.next()){
                
                HoaDon hd =new HoaDon();
                hd.setMahoadon(rs.getString(1));
                hd.setManv(rs.getString(2));
                hd.setMakh(rs.getString(3));
                hd.setNgaymua(rs.getString(4));
                hd.setTongtien(rs.getString(5));
                list.add(hd);
                System.out.println("Lay danh sach thanh cong.");
             
            }
               Close();
        } catch (SQLException e) {
        }
        return list;
    }
    
    
}