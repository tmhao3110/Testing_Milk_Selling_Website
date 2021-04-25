/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Chu Ai Duc
 */
public class GioHangModel {

    public HashMap<String, Item> cart;

    public GioHangModel() {
        cart = new HashMap<>();
    }

    public void addtoCart(String maSP) {
//        if(maSP==null||maSP.equalsIgnoreCase("")){
//            
//        }else{
//            if (cart.containsKey(maSP)) {
//                Item item = cart.get(maSP);
//                int count = item.getSoLuong();
//                count += 1;
//                item.setSoLuong(count);
//            } else {
//                SanPham newsp = new SanPhamModel().getSPbyMaSP(maSP);
//                if (newsp != null) {
//                    Item item = new Item(newsp, 1);
//                    cart.put(maSP, item);
//                }
//            }
//        }
        if (cart.containsKey(maSP)) {
            Item item = cart.get(maSP);
            int count = item.getSoLuong();
            count += 1;
            item.setSoLuong(count);
        } else {
            SanPham newsp = new SanPhamModel().getSPbyMaSP(maSP);
            if (newsp != null) {
                Item item = new Item(newsp, 1);
                cart.put(maSP, item);
            }
        }
    }

    public ArrayList<Item> getListItems() {
        ArrayList<Item> list = new ArrayList<>();
        for (Item i : cart.values()) {
            list.add(i);
        }
        return list;
    }

    public void clearAll() {
        cart.clear();
    }

    public void xoaSP(String maSP) {
        cart.remove(maSP);
    }

    public int tongtien() {
        int tongtien = 0;
        for (Item i : cart.values()) {
            tongtien += i.getSP().getGiaSP() * i.getSoLuong();
        }
        return tongtien;
    }

}
