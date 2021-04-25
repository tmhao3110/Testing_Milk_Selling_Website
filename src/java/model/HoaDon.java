/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author GATEWAY
 */
public class HoaDon {
    private int MaHD;
    private String NgayDH;

    public HoaDon(int MaHD, String NgayDH) {
        this.MaHD = MaHD;
        this.NgayDH = NgayDH;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getNgayDH() {
        return NgayDH;
    }

    public void setNgayDH(String NgayDH) {
        this.NgayDH = NgayDH;
    }
    
}
