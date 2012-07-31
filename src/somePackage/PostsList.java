/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package somePackage;

import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author talestk
 */
public class PostsList {
    private java.util.ArrayList<PostsDB> posts = new java.util.ArrayList<PostsDB>();
    
    public PostsList(String name, String post, Date date, String title) throws SQLException {
        PostsDB entryDB = new PostsDB(name, post, date, title);
        addPost(entryDB);
    }
    
    
    //adding a new post
    private void addPost(PostsDB newPost) {
        posts.add(newPost);
    }
    
    //this is to know how many posts on the list
    PostsDB get(int index) {
        return posts.get(index);
    }
    
}
