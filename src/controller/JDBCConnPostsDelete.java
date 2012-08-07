/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;

/**
 *
 * @author talestk
 */
class JDBCConnPostsDelete {

    public JDBCConnPostsDelete() throws SQLException {
        
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
                String query = "DELETE FROM posts ORDER BY id DESC LIMIT 1;";
                int updateQuery = 0;
                ResultSet rs = null;
 
		try {
                    connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ttakemiya",
							"tales", "testing");
                    ps = connection.prepareStatement(query);
                    //ps.setInt(1, toDelete);
                  
                    ps.executeUpdate();
            
//                    while (rs.next()) { // process results one row at a time
//                        // settting variables for storing table contents
//                        String newTitle = rs.getString(4);
//                        String newDate = rs.getString(3);
//                        String newPost = rs.getString(2);
//                        String newName = rs.getString(1);
//                        
//                       // setBalance(newBalance);
//
//
//                    }
                        
 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
                
                connection.close();
		if (connection != null) {
			System.out.println("Connection from Delete Done!!");
		} else {
			System.out.println("Failed to make connection!");
		}
        
    }

    String getConfirmation() {
        return "page-a";
    }
    
}
