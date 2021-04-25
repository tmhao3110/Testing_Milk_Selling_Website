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
public class SanPham {

    private String MaSP;
    private String TenSP;
    private int GiaSP;
    private String HinhSP;
    private int MaDM;

    public SanPham(String MaSP, String TenSP, int GiaSP, String HinhSP, int MaDM) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        if (GiaSP < 500) {
            throw new IllegalStateException("invalid Gia: " + GiaSP);
        } else {
            this.GiaSP = GiaSP;
        }

        this.HinhSP = HinhSP;
        this.MaDM = MaDM;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(int GiaSP) {
        this.GiaSP = GiaSP;
    }

    public String getHinhSP() {
        return HinhSP;
    }

    public void setHinhSP(String HinhSP) {
        this.HinhSP = HinhSP;
    }

    public int getMaDM() {
        return MaDM;
    }

    public void setMaDM(int MaDM) {
        this.MaDM = MaDM;
    }

    public String change() {
        if (this.MaDM == 1) {
            return "Sữa bịch";
        } else {
            return "Sữa hộp";
        }
    }

}
