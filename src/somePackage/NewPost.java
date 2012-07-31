/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package somePackage;

import java.sql.Date;
import java.sql.SQLException;
import javax.faces.bean.*;

/**
 *
 * @author talestk
 */
@ManagedBean
public class NewPost {
    private String name;
    private String post;
    private String title;
    private Date date;
    
    public void setName(String name) {
        //JDBCConnPosts newName = new JDBCConnPosts();
        //this.name = newName.getName();
        this.name = name;
    }
    
    public String getName() {
        return(name);
    }
    
    public void setPost(String post) {
        this.post = post;
    }
    
    public String getPost() {
        return(post);
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Date getDate() {
        return(date);
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return(title);
    }
    
    public void setConnection() throws SQLException {
        PostsList list = new PostsList(name, post, date, title);
    }
}
