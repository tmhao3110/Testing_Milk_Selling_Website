/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Chu Ai Duc
 */
public class DanhMuc {
    private int MaDM;
    private String TenDM;

    public DanhMuc(int MaDM, String TenDM) {
        this.MaDM = MaDM;
        this.TenDM = TenDM;
    }

    public int getMaDM() {
        return MaDM;
    }

    public void setMaDM(int MaDM) {
        this.MaDM = MaDM;
    }

    public String getTenDM() {
        return TenDM;
    }

    public void setTenDM(String TenDM) {
        this.TenDM = TenDM;
    }
    
}
