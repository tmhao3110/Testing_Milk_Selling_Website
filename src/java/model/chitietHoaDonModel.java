/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.MyConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author GATEWAY
 */
public class chitietHoaDonModel {

    public chitietHoaDonModel() {
    }
    public int insertCTHD(chitietHoaDon ct){
        int check=0;
        Connection cn=new MyConnect().getcn();
        if(cn==null){
            return -1;
        }
        try{
            String sql="Insert into CHITIETHOADON values (?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, ct.getMaHD());
            ps.setString(2, ct.getMaSP());
            ps.setInt(3, ct.getSoLuong());
            check=ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return check;
    }
}
