/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy_KH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KetNoi_CSDL {
    public Connection cn;
    public PreparedStatement ps;
    public ResultSet rs ;
    public Statement sm;
    
    public void Open(){
       
        try {
            String url="jdbc:sqlserver://;databaseName=QUANLYBANHANG";
            String name="sa";
            String password="123456";
            cn=DriverManager.getConnection(url, name, password);
            System.out.println("Ket noi ok");
        } catch (Exception e) {
            System.out.println("K ket noi");
        }
    }
    public void Close() throws SQLException{
        if(ps!= null)
            ps.close();
        if(rs !=null)
            rs.close();
        if(sm != null)
            sm.close();
    }
}
