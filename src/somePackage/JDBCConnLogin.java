/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package somePackage;

import java.sql.*;
 
public class JDBCConnLogin {
    private static String name;
    private static String lName;
    private static int balance;
    private static int id;
    private static float gpa;
    
 
	public String JDBCConnLogin(String id, String password) throws SQLException {
 
		System.out.println("-------- MySQL JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("com.mysql.jdbc.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return "error";
 
		}
 
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
 
		try {
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ttakemiya",
							"root", "");
                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id='"+id+"'");
                        while (rs.next()) { // process results one row at a time
                            // settting variables for storing table contents
                            String pass = rs.getString(2);
                            if (pass == null ? password != null : !pass.equals(password)) {
                               return "wrong-password"; 
                            } else {
                                int newBalance = rs.getInt(3);
                                setBalance(newBalance);
                            }
                            
                            
                        }
                        
                        
                      
                        
                        
 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return "error";
		}
                //connection.close();
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
                
	}
        
        
      // SETTERS
      private void setId(int newId) {
          id = newId;
      }
      public void setName(String newName) {
          name = newName;
      }  
        
      private void setLastName(String newLName) {
          lName = newLName;
      }

      private void setGpa(float gpa_new) {
          gpa = gpa_new;
      }
        

      // GETTERS
      public int getId() {
            return id;
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

    private void setBalance(int balance) {
        JDBCConnLogin.balance = balance;
    }
     
    public int getBalance() {
        return balance;
    }
}