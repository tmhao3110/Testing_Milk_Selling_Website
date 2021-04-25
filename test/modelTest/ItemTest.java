/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;

import model.GioHangModel;
import model.GioHangModel;
import model.SanPhamModel;
import model.SanPhamModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Minh Hao
 */
public class ItemTest {

    GioHangModel repo = new GioHangModel();

    public ItemTest() {
    }

    //TEST ADD PRODUCT
    @Test
    public void addToCart() {
        repo.clearAll();
        repo.addtoCart("SP01");
        repo.addtoCart("SP02");
        assertEquals(true, repo.cart.containsKey("SP01") && repo.cart.containsKey("SP02"));
        repo.clearAll();
    }
    //TEST ADD NULL PRODUCT
    @Test
    public void testAddNull() {
        repo.clearAll();
        repo.addtoCart(null);
        repo.addtoCart("SP01");
        repo.addtoCart(null);
        assertTrue(repo.cart.size()==1&&repo.cart.containsKey("SP01"));
    }
    //TEST CHECK QUANTITY
    @Test
    public void addMultiple() {
        repo.clearAll();
        repo.addtoCart("SP01");
        repo.addtoCart("SP01");
        repo.addtoCart("SP01");
        repo.addtoCart("SP02");
        assertEquals(3, repo.cart.get("SP01").getSoLuong());
        assertEquals(1, repo.cart.get("SP02").getSoLuong());
        repo.clearAll();
    }
    //CHECK PRICES
    @Test
    public void testCheckPrice() {
        repo.clearAll();
        SanPhamModel repoSP = new SanPhamModel();
        repo.addtoCart("SP01");
        repo.addtoCart("SP01");
        repo.addtoCart("SP02");
        assertEquals(repoSP.getSPbyMaSP("SP01").getGiaSP() * repo.cart.get("SP01").getSoLuong()
                + repoSP.getSPbyMaSP("SP02").getGiaSP() * repo.cart.get("SP02").getSoLuong(),
                repo.tongtien());
        repo.clearAll();
    }
}
