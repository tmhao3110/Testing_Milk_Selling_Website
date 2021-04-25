/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;

import model.Account;
import model.AccountModel;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Minh Hao
 */
public class LoginTest {

    AccountModel model = new AccountModel();

    //TEST CHECK LOGIN SUCCESS
    @Test
    public void checkLoginSuccess() {
        String username = "minhhao";
        String password = "123";
        Account acc = new Account(username, password);
        int kq = model.checkLogin(acc);
        assertEquals(1, kq);
    }

    //  TEST INCORRECT PASSWORD
    @Test
    public void checkIncorrectPassword() {
        String username = "minhhao";
        String password = "minhhao";
        Account acc = new Account(username, password);
        int kq = model.checkLogin(acc);
        assertEquals(2, kq);
    }

    //TEST CHECK INVALID USERNAME
    @Test
    public void checkInvalidUsername() {
        String username = "chuduc";
        String password = "123";
        Account acc = new Account(username, password);
        int kq = model.checkLogin(acc);
        assertEquals(3, kq);
    }

}
