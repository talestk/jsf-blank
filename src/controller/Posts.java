/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author talestk
 */
@ManagedBean
@SessionScoped
public class Posts implements Serializable{
    private static JDBCConnPosts posts;
    private static String title = null;
    private static String post = null;
    private static Date date = null;
    private static String name = null;
    private static int id;
    private static JsoupHtmlParser parser = new JsoupHtmlParser();
    
    public String setAllPosts(int number) throws SQLException {
        posts = new JDBCConnPosts();
        
        id = posts.getId();
        
        switch(number) {
            case 1:
                title = posts.getTitle();
                return title;
            case 2:
                post = posts.getPost();
                return post;
            case 3:
                date = posts.getDate();
                return "date";
            case 4:
                name = posts.getName();
                return name;
            case 5:
                return "posts.getId()";
                
        }
        
        return "Couldn't find DB!";
    }
    
    public String getTitle() throws SQLException {
        title = setAllPosts(1);
        return title;
    }
    
    public String getPost() throws SQLException {
        post = setAllPosts(2);
        return post;
    }
    
    public Date getDate() throws SQLException {
        setAllPosts(3);
        return date;
    }
    
    public String getName() throws SQLException {
        name = setAllPosts(4);
        return name;
    }
    
    
}
