/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import model.SanPham;
import model.SanPhamModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Minh Hao
 */
public class SanPhamTest {

    SanPhamModel model = new SanPhamModel();

    public SanPhamTest() {
    }

    //TEST ADD NEW PRODUCT
    @Test
    public void TestaddNewSP() throws SQLException {

        SanPham sp = new SanPham("SP04", "Sữa hộp 200ml", 20000, "suaHop_200ml.jpg", 2);
        model.deleteSP(sp.getMaSP());
        model.insertSP(sp);
        SanPham savedSP = model.getSPbyMaSP(sp.getMaSP());
        assertEquals("SP04", savedSP.getMaSP());
        assertEquals("Sữa hộp 200ml", savedSP.getTenSP());
        assertEquals(20000, savedSP.getGiaSP());
        assertEquals("suaHop_200ml.jpg", savedSP.getHinhSP());
        assertEquals(2, savedSP.getMaDM());
        model.deleteSP(sp.getMaSP());
    }

    //TEST UPDATE SP
    @Test
    public void TestupdateSP() throws SQLException {
        SanPham sp = new SanPham("SP04", "Sữa hộp 3L", 80000, "abc.jpg", 2);
        model.deleteSP(sp.getMaSP());
        model.insertSP(sp);
        SanPham spUpdate = new SanPham("SP04", "Sữa hộp 200ml", 90000, "suaHop_200ml.jpg", 1);
        model.updateSP(spUpdate);
        SanPham savedSP = model.getSPbyMaSP(spUpdate.getMaSP());
        assertEquals("SP04", savedSP.getMaSP());
        assertEquals("Sữa hộp 200ml", savedSP.getTenSP());
        assertEquals(90000, savedSP.getGiaSP());
        assertEquals("suaHop_200ml.jpg", savedSP.getHinhSP());
        assertEquals(1, savedSP.getMaDM());
        model.deleteSP(sp.getMaSP());
    }

    //TEST DELETE SP
    @Test
    public void TestdeleteSP() throws SQLException {
        SanPham sp = new SanPham("SP04", "Sữa hộp 3L", 80000, "suaHop_200ml.jpg", 2);
        model.insertSP(sp);
        model.deleteSP(sp.getMaSP());
        SanPham deletedSP = model.getSPbyMaSP(sp.getMaSP());
        assertNull(deletedSP);
    }

    //TEST BAT LOI RANG BUOC PRIMARY KEY & FOREIGN KEY & UNIQUE TEN SP
    @Test(expected = SQLIntegrityConstraintViolationException.class)
    public void TestSQLEx() throws SQLException {
        SanPham sp = new SanPham("SP02", "Sữa hộp 900 ml", 40000, "suaHop_900ml.jpg", 1);
        model.insertSP(sp);
    }

    //TEST BAT LOI TAO DOI TUONG SAN PHAM (GIA SAN PHAM >=500)
    @Test(expected = IllegalStateException.class)
    public void TestGiaSP() {
        new SanPham("SP04", "Sữa hộp 900 ml", 499, "suaHop_200ml.jpg", 2);
    }
}
