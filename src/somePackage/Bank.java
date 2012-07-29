/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package somePackage;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.*;
import sun.tools.tree.ThisExpression;

/**
 *
 * @author talestk
 */
@ManagedBean

public class Bank {
    private String account;
    
    public String getAccount() {
        return (account);
    }
    
    public void setAccount(String account) {
        this.account = account.trim();
    }
    
    public String showBalance() throws SQLException {
        setAll();
        return "balance";
    }
    
    public static JDBCConn info;
    public static int id, age;
    public static String name, lName;
    public static float gpa;
    
    public void setAll() throws SQLException {
        info = new JDBCConn(Integer.parseInt(account));
        id = info.getId();
        age = info.getAge();
        name = info.getName();
        lName = info.getLastName();
        gpa = info.getGpa();
    }
    
    public int getId() {
        return id;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLastName() {
        return lName;
    }
    
    public float getGpa() {
        return gpa;
    }
}
