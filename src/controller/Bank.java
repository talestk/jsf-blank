/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author talestk
 */
@ManagedBean
@SessionScoped
public class Bank implements Serializable{
    private String account =  null;
    private String password = null;
    
    public String getCheck() {
        return "login.jsf";
    }
    
    public String getPassword() {
        return (password);
    }
    
    public void setPassword(String password) {
        this.password = password.trim();
    }
    
    public String getAccount() {
        return (account);
    }
    
    public void setAccount(String account) {
        this.account = account.trim();
    }
    
    public String showBalance() throws SQLException {
        return setAll();
    }
    
    private static JDBCConnLogin login;
    private static int balance;
    
    public String setAll() throws SQLException {
        login = new JDBCConnLogin(account);
        balance = login.getBalance();
        if (login.getPassword() == null ? password != null : !login.getPassword().equals(password)) {
            return "wrongPassword";
        }
        return "balance";
    }

    
    public int getBalance() {
        return balance;
    }
    
//    public String wrongPassword() {
//        return "wrongPassword";
//    }
}
