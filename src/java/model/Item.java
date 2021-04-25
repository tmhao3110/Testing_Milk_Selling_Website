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
public class Item {
    private SanPham SP;
    private int SoLuong;

    public Item(SanPham SP, int SoLuong) {
        this.SP = SP;
        this.SoLuong = SoLuong;
    }

    public SanPham getSP() {
        return SP;
    }

    public void setSP(SanPham SP) {
        this.SP = SP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
}
