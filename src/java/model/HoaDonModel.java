/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.MyConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author GATEWAY
 */
public class HoaDonModel {

    public HoaDonModel() {
    }
    
    public int insertHD(){
        int check=0;
        Connection cn=new MyConnect().getcn();
        if(cn==null){
            return -1;
        }
        try{
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal=Calendar.getInstance();
            String ngayDH=formatter.format(cal.getTime());
            String sql="Insert Into HOADON values (default,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, ngayDH);
            check=ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return check;
    }
    public int getMaHDlastest(){
        int maHD=-1;
        Connection cn=new MyConnect().getcn();
        if(cn==null){
            return -1;
        }
        try{
            String sql="Select max(maHD) from HOADON";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                maHD=rs.getInt(1);
            }
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return maHD;
    }
}
