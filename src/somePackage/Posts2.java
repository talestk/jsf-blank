/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package somePackage;

import java.sql.Date;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author talestk
 */
@ManagedBean
public class Posts2 {
    private static JDBCConnPosts2 posts;
    private static String title = null;
    private static String post = null;
    private static Date date = null;
    private static String name = null;
   
    
    public String setAllPosts(int number) throws SQLException {
        posts = new JDBCConnPosts2();
        
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
