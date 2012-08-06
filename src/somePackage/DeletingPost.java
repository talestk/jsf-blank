/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package somePackage;

import java.sql.SQLException;
import javax.faces.bean.*;

/**
 *
 * @author talestk
 */
@ManagedBean
public class DeletingPost {
    public void setDelete() {
        
    }
    public void getDelete() {
        
    }
    
    private static JDBCConnPosts posts;
    private static JDBCConnPostsDelete postDelete;
    
    public String deletePost() throws SQLException {
        
        postDelete = new JDBCConnPostsDelete();
        posts = new JDBCConnPosts();
        posts.getDate();
        return postDelete.getConfirmation();
    }
}
