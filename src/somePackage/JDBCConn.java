/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package somePackage;

import java.sql.*;
 
public class JDBCConn {
    private static String name;
    private static String lName;
    private static int age;
    private static int id;
    private static float gpa;
    
 
	public JDBCConn(int idTable) throws SQLException {
 
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
 
		try {
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ttakemiya",
							"root", "testing");
                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id='"+idTable+"'");
                        while (rs.next()) { // process results one row at a time
                            // settting variables for storing table contents
                            int key = rs.getInt(1);
                            int age_new = rs.getInt(2);
                            String name_new = rs.getString(3);
                            String lName_new = rs.getString(4);
                            float gpa_new = rs.getFloat(5);
                            
                            // calling setters for variables
                            setId(key);
                            setAge(age_new);
                            setName(name_new);
                            setLastName(lName_new);
                            setGpa(gpa_new);
                            

                            System.out.println("key = " + key);
                            System.out.println("val = " + age_new);
                            
                        }
                      
                        
                        
 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
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
        
      private void setAge(int newAge) {
          age = newAge;
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