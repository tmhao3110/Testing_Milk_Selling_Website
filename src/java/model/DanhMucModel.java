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
import java.util.ArrayList;

/**
 *
 * @author Chu Ai Duc
 */
public class DanhMucModel {

    public DanhMucModel() {
    }
    public ArrayList getList(){
        ArrayList<DanhMuc> list =new ArrayList<>();
        Connection cn=new MyConnect().getcn();
        if(cn==null){
            return null;
        }
        try{
            String sql="Select * from danhmuc";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                DanhMuc danhmuc=new DanhMuc(rs.getInt(1),rs.getString(2));
                list.add(danhmuc);
            }
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
