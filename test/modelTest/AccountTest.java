/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import model.Account;
import model.AccountModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Minh Hao
 */
public class AccountTest {

    AccountModel model = new AccountModel();

    public AccountTest() {
    }

    // TEST ADD NEW ACCOUNT
    @Test
    public void addNewAccount() throws SQLException {
        AccountModel model = new AccountModel();
        Account acc = new Account("chuduc", "123");
        model.deleteAccount(acc);
        model.insertAccount(acc);
        Account savedAccount = model.getAcc(acc.getUsername());
        assertEquals("chuduc", savedAccount.getUsername());
        assertEquals("123", savedAccount.getPassword());
        model.deleteAccount(acc);
    }

    //TEST UPDATE ACCOUNT
    @Test
    public void updateAccount() {
        try {
            Account acc = new Account("nhuttruong", "123");
            model.deleteAccount(acc);
            model.insertAccount(acc);
            Account accUpdatePassword = new Account("nhuttruong", "123456");
            model.updateAccount(accUpdatePassword);
            Account saveAccount = model.getAcc(accUpdatePassword.getUsername());
            assertEquals("nhuttruong", saveAccount.getUsername());
            assertEquals("123456", saveAccount.getPassword());
            Account accUpdateNullPassword = new Account("minhhao", null);
            model.updateAccount(accUpdateNullPassword);
            Account savedAccount = model.getAcc(accUpdatePassword.getUsername());
            assertEquals("nhuttruong", savedAccount.getUsername());
            assertEquals("123456", savedAccount.getPassword());
        } catch (SQLException e) {
            assertEquals(com.mysql.cj.jdbc.exceptions.SQLError.class, e.getClass());
        } finally {
            model.deleteAccount(model.getAcc("nhuttruong"));
        }
    }

    //TEST DELETE ACCOUNT
    @Test
    public void deleteUser() throws SQLException {
        AccountModel model = new AccountModel();
        Account acc = new Account("nhuttruong", "123");
        model.deleteAccount(acc);
        model.insertAccount(acc);
        model.deleteAccount(acc);
        Account deleteAccount = model.getAcc(acc.getUsername());
        assertNull(deleteAccount);
    }

    //TEST BẮT LỖI RÀNG BUỘC PRIMARY KEY
    @Test(expected = SQLIntegrityConstraintViolationException.class)
    public void primaryKeyBinding() throws SQLException {
        Account acc = new Account("admin", "123");
        model.insertAccount(acc);
    }
}
