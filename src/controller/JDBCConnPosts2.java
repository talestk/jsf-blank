/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.util.List;
 
public class JDBCConnPosts2 {
//    List<PostsArray> listOfPosts = new ArrayList<PostsArray>();
    private static int balance;
    private static String title;
    private static String post;
    private static Date date;
    private static String name;
    
 
	public JDBCConnPosts2() throws SQLException {
                
		System.out.println("-------- MySQL JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("com.mysql.jdbc.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
                PreparedStatement ps = null;
                String query = "SELECT * FROM posts ORDER BY id DESC limit 2;";
                ResultSet rs = null;
 
		try {
                    connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ttakemiya",
							"tales", "testing");
                    ps = connection.prepareStatement(query);
                    //ps.setString(1, id);
                    rs = ps.executeQuery();
                        
                    
                    while(rs.next()) {  // process results one row at a time
                        // settting variables for storing table contents
                        String newTitle = rs.getString(4);
                        Date newDate = rs.getDate(3);
                        String newPost = rs.getString(2);
                        String newName = rs.getString(1);
//                        PostsArray ob = new PostsArray(newName, newPost, newDate, newTitle);
//                        listOfPosts.add(ob);
                        
                        
                        //PostsArray list = new PostsList(newName, newPost, newDate, newTitle);
                        
                       // setBalance(newBalance);
                        setTitle(newTitle);
                        setPost(newPost);
                        setDate(newDate);
                        setName(newName);

                    
                }
 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
                
                connection.close();
		if (connection != null) {
			System.out.println("Connection from Post2 Done!");
		} else {
			System.out.println("Failed to make connection!");
		}
                
	}
        
        
      // SETTERS
    
      // GETTERS


    private void setTitle(String title) {
        JDBCConnPosts2.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    private void setPost(String post) {
        JDBCConnPosts2.post = post;
    }
    
    public String getPost() {
        return post;
    }

    private void setDate(Date newDate) {
        JDBCConnPosts2.date = newDate;
    }
    
    public Date getDate() {
        return date;
    }
    
    private void setName(String newName) {
        JDBCConnPosts2.name = newName;
    }
    
    public String getName() {
        return name;
    }

}