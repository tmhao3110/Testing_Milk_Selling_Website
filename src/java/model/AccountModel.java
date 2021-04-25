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
public class AccountModel {

    public AccountModel() {
    }

    public int checkLogin(Account acc) {
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;
        }
        try {
            String sql = "Select * from account where username like ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, acc.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString(1).equals(acc.getUsername()) && rs.getString(2).equals(acc.getPassword())) {
                    cn.close();
                    return 1; //khớp tài khoản
                } else {
                    cn.close();
                    return 2; //sai mật khẩu
                }
            } else {
                cn.close();
                return 3; //không tồn tại username
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return 0;
    }

    public ArrayList getList() {
        ArrayList<Account> list = new ArrayList<>();
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return null;
        }
        try {
            String sql = "select * from account";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account nacc = new Account(rs.getString(1), rs.getString(2));
                list.add(nacc);
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int insertAccount(Account acc) throws SQLException {
        Connection cn = new MyConnect().getcn();
        int check = 0;
        if (cn == null) {
            return -1;
        }

        String sql = "INSERT INTO ACCOUNT VALUES (?,?)";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, acc.getUsername());
        ps.setString(2, acc.getPassword());
        check = ps.executeUpdate();
        return check;
    }

    public Account getAcc(String username) {
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return null;
        }
        Account acc = null;
        try {
            String sql = "Select * from account where username like ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                acc = new Account(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }

    public int updateAccount(Account acc) {
        Connection cn = new MyConnect().getcn();
        int check = 0;
        if (cn == null) {
            return -1;
        }
        try {
            String sql = "UPDATE ACCOUNT set password=? where username=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, acc.getPassword());
            ps.setString(2, acc.getUsername());
            check = ps.executeUpdate();
        } catch (Exception e) {
            int i=1;
        }
        return check;
    }

    public int deleteAccount(Account acc) {
        Connection cn = new MyConnect().getcn();
        int check = 0;
        if (cn == null) {
            return -1;
        }
        try {
            String sql = "DELETE from ACCOUNT where username=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, acc.getUsername());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
