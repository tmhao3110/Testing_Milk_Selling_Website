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
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY
 */
public class SanPhamModel {

    public SanPhamModel() {
    }

    public ArrayList<SanPham> getList() {
        ArrayList<SanPham> list = new ArrayList<>();
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return null;
        }
        try {
            String sql = "Select * from SANPHAM";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham newsp = new SanPham(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5)
                );
                list.add(newsp);
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int insertSP(SanPham sp) throws SQLException {
        int check = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;
        }
        String sql = "Insert into Sanpham values (?,?,?,?,?)";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, sp.getMaSP());
        ps.setString(2, sp.getTenSP());
        ps.setInt(3, sp.getGiaSP());
        ps.setString(4, sp.getHinhSP());
        ps.setInt(5, sp.getMaDM());
        check = ps.executeUpdate();
        return check;
    }

    public int deleteSP(String masp) {
        int check = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;
        }
        try {
            String sql = "Delete from sanpham where MaSP=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, masp);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public SanPham getSPbyMaSP(String masp) {
        SanPham newsp = null;
        for (int i = 0; i < getList().size(); i++) {
            if (getList().get(i).getMaSP().equalsIgnoreCase(masp)) {
                return getList().get(i);
            }
        }
        return newsp;
    }

    public int updateSP(SanPham sp) {
        int check = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;
        }
        try {
            String sql = "Update sanpham set Tensp=?, DonGia=?, Hinh=?, MaDM=? where MaSP=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setInt(2, sp.getGiaSP());
            ps.setString(3, sp.getHinhSP());
            ps.setInt(4, sp.getMaDM());
            ps.setString(5, sp.getMaSP());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
