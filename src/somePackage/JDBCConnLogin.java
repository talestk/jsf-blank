/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package somePackage;

import java.sql.*;
 
public class JDBCConnLogin {
    private static String password;
    private static int balance;
    
 
	public JDBCConnLogin(String id) throws SQLException {
 
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
                String query = "SELECT * FROM users WHERE id = ?";
                ResultSet rs = null;
 
		try {
                    connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ttakemiya",
							"tales", "testing");
                    ps = connection.prepareStatement(query);
                    ps.setString(1, id);
                    rs = ps.executeQuery();
                        
                    while (rs.next()) { // process results one row at a time
                        // settting variables for storing table contents
                        String pass = rs.getString(2);
                        int newBalance = rs.getInt(3);
                        setBalance(newBalance);
                        setPassword(pass);

                    }
                        
                        
                      
                        
                        
 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
                
                connection.close();
		if (connection != null) {
			System.out.println("Connection from Login Done!");
		} else {
			System.out.println("Failed to make connection!");
		}
                
	}
        
        
      // SETTERS

    private void setBalance(int balance) {
        JDBCConnLogin.balance = balance;
    }
    
      // GETTERS
     
    public int getBalance() {
        return balance;
    }

    private void setPassword(String pass) {
        JDBCConnLogin.password = pass;
    }
    
    public String getPassword() {
        return password;
    }

}