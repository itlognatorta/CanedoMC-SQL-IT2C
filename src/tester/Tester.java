
package tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Tester {

    //Connection Method to SQLITE
public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:test.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID: ");
        int id = sc.nextInt();
        System.out.println("Enter First name: ");
        String fs = sc.next();
        System.out.println("Enter Last name: ");
        String ln = sc.next();
        System.out.println("Email: ");
        String em = sc.next();
        System.out.println("Status: ");
        String stat = sc.next();
        
        String sql = "INSERT INTO Students (S_id, S_Fname, S_lname, S_EMAIL, S_STATUS) VALUES (?, ?, ?, ?, ?)";
        
        try{
      
                Connection con = connectDB();
                PreparedStatement pst = con.prepareStatement (sql);
                pst.setInt(1, id);
                pst.setString (2, fs);
                pst.setString (3, ln);
                pst.setString (4, em);
                pst.setString (5, stat);
                pst.executeUpdate();
                System.out.println("Inserted Successful!");
                
        }catch (SQLException ex){
                System.out.println("Connection Error: " + ex.getMessage ());
        }
                
        
        
    }
    
}
