/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Chu Ai Duc
 */
public class MyConnect {

    private static String DB_URL = "jdbc:mysql://localhost:3306/web2";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";
    
    
    public Connection getcn() {
       Connection conn = null;
        try {   //Database url

            //Load JDBC           
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Ketnoivoi database
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
